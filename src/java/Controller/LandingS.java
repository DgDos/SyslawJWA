/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.LandingDAO;
import Model.Landing;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.SQLException;
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
public class LandingS extends HttpServlet {

     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            LandingDAO l=new LandingDAO();
            Gson g=new Gson();
            out.print(g.toJson(l.getAllLandings()));
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(LandingS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            LandingDAO l=new LandingDAO();
            Gson g=new Gson();
            out.print(g.toJson(l.addLangind(new Landing(request.getParameter("nombre"), request.getParameter("correo"), request.getParameter("beta").equals("true")))));
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(LandingS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
