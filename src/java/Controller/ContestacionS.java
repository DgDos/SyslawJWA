/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.ContestacionDAO;
import Dao.DemandaDAO;
import Model.Contestacion;
import Model.Demanda;
import Model.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FiJus
 */
public class ContestacionS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String opcion = request.getParameter("opcion");
            if (opcion.equalsIgnoreCase("allMe")) {
                ContestacionDAO d = new ContestacionDAO();
                Usuario user=(Usuario)request.getSession().getAttribute("usuario");
                ArrayList<Contestacion> contestaciones = d.getAllContestacionById(user.getDocumento());
                Gson gson = new Gson();
                out.println(gson.toJson(contestaciones));
            }
            if (opcion.equalsIgnoreCase("allHelp")) {
                ContestacionDAO d = new ContestacionDAO();
                Usuario user=(Usuario)request.getSession().getAttribute("usuario");
                ArrayList<Contestacion> contestaciones = d.getAllContestacionById(user.getDocumento());
                Gson gson = new Gson();
                out.println(gson.toJson(contestaciones));
            }
            if (opcion.equalsIgnoreCase("one")) {
                int id_contestacion = Integer.parseInt(request.getParameter("id_contestacion"));
                ContestacionDAO d = new ContestacionDAO();
                Contestacion contestacion=d.getContestacionById(id_contestacion);
                Gson gson = new Gson();
                out.println(gson.toJson(contestacion));
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(ContestacionS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String opcion = request.getParameter("opcion");
            Gson gson = new Gson();
            if (opcion.equalsIgnoreCase("create")) {
                ContestacionDAO d = new ContestacionDAO();
                DemandaDAO dem=new DemandaDAO();
                int id_demanda = Integer.parseInt(request.getParameter("id_demanda"));
                Demanda demanda=dem.getDemandaById(id_demanda);
                Usuario user=(Usuario)request.getSession().getAttribute("usuario");
                d.addContestacion( user, demanda);
                dem.endFinish(id_demanda);
                out.print(gson.toJson(true));
            }
            if (opcion.equalsIgnoreCase("update")) {
                Contestacion d = new Contestacion();
                if (request.getParameter("id_ayudante") != null && !request.getParameter("id_ayudante").equals("")) {
                    d.setId_ayudante(request.getParameter("id_ayudante"));
                }else{
                    d.setId_ayudante("");
                }
                d.setId_contestacion(Integer.parseInt(request.getParameter("id_contestacion")));
                d.setNombre_demandado(request.getParameter("nombre_demandado"));
                d.setDocumento_demandado(request.getParameter("documento_demandado"));
                if (request.getParameter("tipo_documento_demandado") != null) {
                    d.setTipo_documento_demandado(Integer.parseInt(request.getParameter("tipo_documento_demandado")));
                }
                d.setNombre_representante_legal(request.getParameter("nombre_representante_legal"));
                d.setDomicilio_representante_legal(request.getParameter("domicilio_representante_legal"));
                d.setDocumento_representante_legal(request.getParameter("documento_representante_legal"));
                
                if (request.getParameter("tipo_documento_representante") != null) {
                    d.setTipo_documento_representante(Integer.parseInt(request.getParameter("tipo_documento_representante")));
                }
                d.setDdo_apo_nom(request.getParameter("ddo_apo_nom"));
                d.setDdo_apo_dir(request.getParameter("ddo_apo_dir"));
                d.setDdo_apo_id(request.getParameter("ddo_apo_id"));
            
                if (request.getParameter("ddo_apo_id_tipo") != null) {
                    d.setDdo_apo_id_tipo(Integer.parseInt(request.getParameter("ddo_apo_id_tipo")));
                }
                 d.setDdo_apo_tar_pro(request.getParameter("ddo_apo_tar_pro"));
                 d.setDireccion_notificaciones(request.getParameter("direccion_notificaciones"));
                 d.setEmail(request.getParameter("email"));

                if (request.getParameter("pretenciones") != null) {
                    d.setPretenciones(Boolean.parseBoolean(request.getParameter("pretenciones")));
                } else {
                    d.setPretenciones(false);
                }
                d.setHechos_admitidos(request.getParameter("hechos_admitidos"));
                d.setHechos_negados(request.getParameter("hechos_negados"));
                d.setExplicacion_negados(request.getParameter("explicacion_negados"));
                d.setHechos_no_constan(request.getParameter("hechos_no_constan"));
                d.setExplicacion_no_constan(request.getParameter("explicacion_no_constan"));
                d.setExcepciones(request.getParameter("excepciones"));
                d.setPruebas(request.getParameter("pruebas"));
                
                if (request.getParameter("porcentaje") != null) {
                    d.setPorcentaje(Float.parseFloat(request.getParameter("porcentaje")));
                } 
                d.setProceso(request.getParameter("proceso"));
                d.setContra(request.getParameter("contra"));
                d.setCiudad_demandado(request.getParameter("ciudad_demandado"));
                d.setReconocimiento(request.getParameter("reconocimiento"));
                d.setAnexos(request.getParameter("anexos"));
                if (request.getParameter("retencion") != null) {
                    d.setRetencion(Boolean.parseBoolean(request.getParameter("retencion")));
                } else {
                    d.setRetencion(false);
                }
                if (request.getParameter("ddo_apo_tiene") != null) {
                    d.setDdo_apo_tiene(Boolean.parseBoolean(request.getParameter("ddo_apo_tiene")));
                } else {
                    d.setDdo_apo_tiene(false);
                }
                System.out.println(d.toString());
                
                ContestacionDAO de = new ContestacionDAO(); 
                de.updateContestacion(d);
                out.print(gson.toJson(true));
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(ContestacionS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
