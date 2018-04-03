/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DemandaDAO;
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
public class DemandaS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String opcion = request.getParameter("opcion");
            if (opcion.equalsIgnoreCase("allMe")) {
                DemandaDAO d = new DemandaDAO();
                Usuario user=(Usuario)request.getSession().getAttribute("usuario");
                ArrayList<Demanda> demandas=d.getAllDemandasById(user.getId_usuario());
                Gson gson = new Gson();
                out.println(gson.toJson(demandas));
            }
            if (opcion.equalsIgnoreCase("allHelp")) {
                DemandaDAO d = new DemandaDAO();
                Usuario user=(Usuario)request.getSession().getAttribute("usuario");
                ArrayList<Demanda> demandas=d.getAllDemandasById(user.getId_usuario());
                Gson gson = new Gson();
                out.println(gson.toJson(demandas));
            }
            if (opcion.equalsIgnoreCase("one")) {
                int id_demanda = Integer.parseInt(request.getParameter("id_demanda"));
                DemandaDAO d = new DemandaDAO();
                Demanda demanda=d.getDemandaById(id_demanda);
                Gson gson = new Gson();
                out.println(gson.toJson(demanda));
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(DemandaS.class.getName()).log(Level.SEVERE, null, ex);
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
                DemandaDAO d = new DemandaDAO();
                String titulo = request.getParameter("titulo");
                //Usuario user=(Usuario)request.getSession().getAttribute("usuario");
                //d.addDemanda(titulo,user.getId_usuario());
                d.addDemanda(titulo,1);
                out.print(gson.toJson(true));
            }
            if (opcion.equalsIgnoreCase("update")) {
                Demanda d = new Demanda();
                if (request.getParameter("id_ayudante") != null && !request.getParameter("id_ayudante").equals("")) {
                    d.setId_ayudante(request.getParameter("id_ayudante"));
                }else{
                    d.setId_ayudante("");
                }
                d.setTitulo(request.getParameter("titulo"));
                d.setJuez_nombre(request.getParameter("juez_nombre"));
                d.setDte_nom(request.getParameter("dte_nom"));
                d.setDte_ciudad(request.getParameter("dte_ciudad"));
                if (request.getParameter("dte_id_tipo") != null) {
                    d.setDte_id_tipo(Integer.parseInt(request.getParameter("dte_id_tipo")));
                }
                d.setDte_id(request.getParameter("dte_id"));

                if (request.getParameter("dte_rep_tiene") != null) {
                    d.setDte_rep_tiene(Boolean.parseBoolean(request.getParameter("dte_rep_tiene")));
                } else {
                    d.setDte_rep_tiene(false);
                }
                d.setDte_rep_nom(request.getParameter("dte_rep_nom"));
                if (request.getParameter("dte_rep_id_tipo") != null) {
                    d.setDte_rep_id_tipo(Integer.parseInt(request.getParameter("dte_rep_id_tipo")));
                }

                d.setDte_rep_id(request.getParameter("dte_rep_id"));

                if (request.getParameter("dte_apo_tiene") != null) {
                    d.setDte_apo_tiene(Boolean.parseBoolean(request.getParameter("dte_apo_tiene")));
                } else {
                    d.setDte_apo_tiene(false);
                }
                d.setDte_apo_nom(request.getParameter("dte_apo_nom"));
                if (request.getParameter("dte_apo_id_tipo") != null) {
                    d.setDte_apo_id_tipo(Integer.parseInt(request.getParameter("dte_apo_id_tipo")));
                }
                if (request.getParameter("dte_apo_id") != null && !request.getParameter("dte_apo_id").equals("")) {
                    d.setDte_apo_id(request.getParameter("dte_apo_id"));
                }
                if (request.getParameter("dte_apo_tar_pro") != null) {
                    d.setDte_apo_tar_pro(request.getParameter("dte_apo_tar_pro"));
                }
                d.setDte_dir_not(request.getParameter("dte_dir_not"));
                d.setDte_email(request.getParameter("dte_email"));
                d.setDem_nom(request.getParameter("dem_nom"));
                d.setDem_ciu(request.getParameter("dem_ciu"));
                if (request.getParameter("dem_rep_tiene") != null) {
                    d.setDem_rep_tiene(Boolean.parseBoolean(request.getParameter("dem_rep_tiene")));
                } else {
                    d.setDem_rep_tiene(false);
                }
                d.setDem_rep_nom(request.getParameter("dem_rep_nom"));
                if (request.getParameter("dem_apo_tiene") != null) {
                    d.setDem_apo_tiene(Boolean.parseBoolean(request.getParameter("dem_apo_tiene")));
                } else {
                    d.setDem_apo_tiene(false);
                }
                d.setDem_apo_nom(request.getParameter("dem_apo_nom"));
                d.setDem_dir_not(request.getParameter("dem_dir_not"));
                d.setDem_email(request.getParameter("dem_email"));
                d.setPretensiones(request.getParameter("pretensiones"));
                d.setHechos(request.getParameter("hechos"));
                if (request.getParameter("depende_cumplimiento") != null) {
                    d.setDepende_cumplimiento(Boolean.parseBoolean(request.getParameter("depende_cumplimiento")));
                } else {
                    d.setDepende_cumplimiento(false);
                }
                if (request.getParameter("tengo_pruebas") != null) {
                    d.setTengo_pruebas(Boolean.parseBoolean(request.getParameter("tengo_pruebas")));
                } else {
                    d.setTengo_pruebas(false);
                }
                d.setPruebas(request.getParameter("pruebas"));
                if (request.getParameter("estaba_obligado") != null) {
                    d.setEstaba_obligado(Boolean.parseBoolean(request.getParameter("estaba_obligado")));
                } else {
                    d.setEstaba_obligado(false);
                }
                d.setFundamentos(request.getParameter("fundamentos"));
                d.setAnexos(request.getParameter("anexos"));
                if (request.getParameter("solicito_cautelares") != null) {
                    d.setSolicito_cautelares(Boolean.parseBoolean(request.getParameter("solicito_cautelares")));
                } else {
                    d.setSolicito_cautelares(false);
                }

                d.setCautelares_que_solicita(request.getParameter("cautelares_que_solicita"));
                if (request.getParameter("porcentaje") != null) {
                    d.setPorcentaje(Float.parseFloat(request.getParameter("porcentaje")));
                }
                d.setId_demanda(Integer.parseInt(request.getParameter("id_demanda")));
                DemandaDAO de = new DemandaDAO(); 
                de.updateDemanda(d);
                out.print(gson.toJson(true));
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(DemandaS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
