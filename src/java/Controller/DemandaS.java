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
                //Usuario user=(Usuario)request.getSession().getAttribute("usuario");
                //ArrayList<Demanda> demandas=d.getAllDemandasById(user.getId_usuario());
                ArrayList<Demanda> demandas = d.getAllDemandasById(2);
                Gson gson = new Gson();
                out.println(gson.toJson(demandas));
            }
            if (opcion.equalsIgnoreCase("allHelp")) {
                DemandaDAO d = new DemandaDAO();
                //Usuario user=(Usuario)request.getSession().getAttribute("usuario");
                //ArrayList<Demanda> demandas=d.getAllDemandasById(user.getId_usuario());
                ArrayList<Demanda> demandas = d.getAllDemandasByIdAyudante(2);
                Gson gson = new Gson();
                out.println(gson.toJson(demandas));
            }
            if (opcion.equalsIgnoreCase("one")) {
                int id_demanda = Integer.parseInt(request.getParameter("id_demanda"));
                DemandaDAO d = new DemandaDAO();
                //Usuario user=(Usuario)request.getSession().getAttribute("usuario");
                //Demanda demanda=d.getDemandaByUserAndId(user.getId_usuario(), id_demanda);
                Demanda demanda = d.getDemandaByUserAndId(2, id_demanda);
                request.getSession().setAttribute("demanda", demanda);
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
            if (opcion.equalsIgnoreCase("create")) {
                DemandaDAO d = new DemandaDAO();
                String titulo=request.getParameter("titulo");
                //Usuario user=(Usuario)request.getSession().getAttribute("usuario");
                //d.addDemanda(titulo,user.getId_usuario());
                d.addDemanda(titulo,2);
                request.getSession().setAttribute("demanda", d.getDemandaByUserAndId(0, 0));
            }
            if(opcion.equalsIgnoreCase("update")){
                
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
