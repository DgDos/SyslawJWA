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
            DemandaDAO d = new DemandaDAO();
            Usuario user = (Usuario) request.getSession().getAttribute("usuario");
            Gson gson = new Gson();
            String opcion = request.getParameter("opcion");
            //trae la lista de demandas dado un estado
            if (opcion.equalsIgnoreCase("state")) {
                int state = Integer.parseInt(request.getParameter("state"));
                ArrayList<Demanda> demandas = d.getAllDemandasByState(user.getDocumento(), state);
                out.println(gson.toJson(demandas));
            }
            //trae el pool de demandas
            if(opcion.equalsIgnoreCase("pool")){
                ArrayList<Demanda> demandas = d.getPoolDemandas();
                out.println(gson.toJson(demandas));
            }
            //trae la informacion de la demanda que esta ayudando a corregir el abogado
            if(opcion.equalsIgnoreCase("helpInfo")){
                Demanda demanda = d.getDemandaHelpInfo(user.getDocumento());
                out.println(gson.toJson(demanda));
            }
            //trae la demanda que esta ayudando a corregir el abogado
            if(opcion.equalsIgnoreCase("help")){
                int id_demanda=Integer.parseInt(request.getParameter("id_demanda"));
                Demanda demanda = d.getDemandaHelp(id_demanda,user.getDocumento());
                out.println(gson.toJson(demanda));
            }
            //trae la informacion de la demanda del usuario
            if (opcion.equalsIgnoreCase("one")) {
                int id_demanda = Integer.parseInt(request.getParameter("id_demanda"));
                Demanda demanda = d.getDemandaById(id_demanda);
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
            //crea la demanda y llena los datos iniciales
            if (opcion.equalsIgnoreCase("create")) {
                DemandaDAO d = new DemandaDAO();
                String titulo = request.getParameter("titulo");
                Usuario user = (Usuario) request.getSession().getAttribute("usuario");
                d.addDemanda(titulo, user);
                out.print(gson.toJson(true));
            }
            //actualiza la demanda BOTON SAVE
            if (opcion.equalsIgnoreCase("update")) {
                float conta=7;
                Demanda d = new Demanda();
                
                d.setTitulo(request.getParameter("titulo"));
                
                d.setJuez_nombre(request.getParameter("juez_nombre"));
                if(!d.getJuez_nombre().equals("")){
                    conta++;
                }
                
                d.setDte_nom(request.getParameter("dte_nom"));
                d.setDte_ciudad(request.getParameter("dte_ciudad"));
                d.setDte_dir_not(request.getParameter("dte_dir_not"));
                d.setDte_email(request.getParameter("dte_email"));
                if (request.getParameter("dte_id_tipo") != null) {
                    d.setDte_id_tipo(Integer.parseInt(request.getParameter("dte_id_tipo")));
                }
                d.setDte_id(request.getParameter("dte_id"));
                
                if (request.getParameter("dte_rep_tiene") != null) {
                    d.setDte_rep_tiene(Boolean.parseBoolean(request.getParameter("dte_rep_tiene")));
                    conta++;
                } else {
                    d.setDte_rep_tiene(false);
                }
                d.setDte_rep_nom("");
                if(!d.getDte_rep_nom().equals("")){
                    conta++;
                }
                d.setDte_rep_id_tipo(-1);  
                d.setDte_rep_id("");
                if(!d.getDte_rep_id().equals("")){
                    conta++;
                }
                
                if (request.getParameter("dte_apo_tiene") != null) {
                    d.setDte_apo_tiene(Boolean.parseBoolean(request.getParameter("dte_apo_tiene")));
                    conta++;
                } else {
                    d.setDte_apo_tiene(false);
                }
                d.setDte_apo_nom(request.getParameter("dte_apo_nom"));
                if(!d.getDte_apo_nom().equals("")){
                    conta++;
                }
                if (request.getParameter("dte_apo_id_tipo") != null) {
                    d.setDte_apo_id_tipo(Integer.parseInt(request.getParameter("dte_apo_id_tipo")));
                    conta++;
                }
                if (request.getParameter("dte_apo_id") != null && !request.getParameter("dte_apo_id").equals("")) {
                    d.setDte_apo_id(request.getParameter("dte_apo_id"));
                    conta++;
                }
                if (request.getParameter("dte_apo_tar_pro") != null) {
                    d.setDte_apo_tar_pro(request.getParameter("dte_apo_tar_pro"));
                    conta++;
                }
                if (request.getParameter("dem_id_tipo") != null) {
                    d.setDem_id_tipo(Integer.parseInt(request.getParameter("dem_id_tipo")));
                    conta++;
                }
                d.setDem_id(request.getParameter("dem_id"));
                if(!d.getDem_id().equals("")){
                    conta++;
                }
                d.setDem_nom(request.getParameter("dem_nom"));
                if(!d.getDem_nom().equals("")){
                    conta++;
                }
                d.setDem_ciu(request.getParameter("dem_ciu"));
                if(!d.getDem_ciu().equals("")){
                    conta++;
                }
                if (request.getParameter("dem_rep_tiene") != null) {
                    d.setDem_rep_tiene(Boolean.parseBoolean(request.getParameter("dem_rep_tiene")));
                    conta++;
                } else {
                    d.setDem_rep_tiene(false);
                }
                d.setDem_rep_nom("");
                if(!d.getDem_rep_nom().equals("")){
                    conta++;
                }
                if (request.getParameter("dem_apo_tiene") != null) {
                    d.setDem_apo_tiene(Boolean.parseBoolean(request.getParameter("dem_apo_tiene")));
                    conta++;
                } else {
                    d.setDem_apo_tiene(false);
                }
                d.setDem_apo_nom(request.getParameter("dem_apo_nom"));
                if(!d.getDem_apo_nom().equals("")){
                    conta++;
                }
                d.setDem_dir_not(request.getParameter("dem_dir_not"));
                if(!d.getDem_dir_not().equals("")){
                    conta++;
                }
                d.setDem_email(request.getParameter("dem_email"));
                if(!d.getDem_email().equals("")){
                    conta++;
                }
                d.setPretensiones(request.getParameter("pretensiones"));
                if(!d.getPretensiones().equals("")){
                    conta++;
                }
                d.setHechos(request.getParameter("hechos"));
                if(!d.getHechos().equals("")){
                    conta++;
                }
                if (request.getParameter("depende_cumplimiento") != null) {
                    d.setDepende_cumplimiento(Boolean.parseBoolean(request.getParameter("depende_cumplimiento")));
                    conta++;
                } else {
                    d.setDepende_cumplimiento(false);
                }
                if (request.getParameter("tengo_pruebas") != null) {
                    d.setTengo_pruebas(Boolean.parseBoolean(request.getParameter("tengo_pruebas")));
                    conta++;
                } else {
                    d.setTengo_pruebas(false);
                }
                d.setPruebas(request.getParameter("pruebas"));
                if(!d.getPruebas().equals("")){
                    conta++;
                }
                if (request.getParameter("estaba_obligado") != null) {
                    d.setEstaba_obligado(Boolean.parseBoolean(request.getParameter("estaba_obligado")));
                    conta++;
                } else {
                    d.setEstaba_obligado(false);
                }
                d.setFundamentos(request.getParameter("fundamentos"));
                if(!d.getFundamentos().equals("")){
                    conta++;
                }
                d.setAnexos("");
                if(!d.getAnexos().equals("")){
                    conta++;
                }
                if (request.getParameter("solicito_cautelares") != null) {
                    d.setSolicito_cautelares(Boolean.parseBoolean(request.getParameter("solicito_cautelares")));
                    conta++;
                } else {
                    d.setSolicito_cautelares(false);
                }
                d.setCautelares_que_solicita(request.getParameter("cautelares_que_solicita"));
                if(!d.getCautelares_que_solicita().equals("")){
                    conta++;
                }
                float valor=((conta*100)/32);
                d.setPorcentaje(valor);
                d.setId_demanda(Integer.parseInt(request.getParameter("id_demanda")));
                d.setComentarios_abogado(request.getParameter("com_abo"));
                d.setComentarios_usuario(request.getParameter("com_usu"));
                DemandaDAO de = new DemandaDAO();
                de.updateDemanda(d);
                out.print(gson.toJson(true));
            }
            //sirve para cuando el abogado escoja la demanda que quiere ayudar a corregir
            if(opcion.equalsIgnoreCase("pickFromPool")){
                DemandaDAO de = new DemandaDAO();
                int id_demanda = Integer.parseInt(request.getParameter("id_demanda"));
                Usuario user = (Usuario) request.getSession().getAttribute("usuario");
                out.print(gson.toJson(de.pickIt(id_demanda,user)));
            }
            //cambia de estado la demanda
            if (opcion.equalsIgnoreCase("endState")) {
                DemandaDAO de = new DemandaDAO(); 
                int id_demanda = Integer.parseInt(request.getParameter("id_demanda"));
                int state=Integer.parseInt(request.getParameter("state"));
                out.print(gson.toJson(de.endState(id_demanda, state)));
                
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
