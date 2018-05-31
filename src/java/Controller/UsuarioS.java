/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.UsuarioDAO;
import Model.Usuario;
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
public class UsuarioS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String opcion = request.getParameter("opcion");
            Gson gson = new Gson();
            if (opcion.equalsIgnoreCase("existUser")) {
                UsuarioDAO u = new UsuarioDAO();
                String documento = request.getParameter("documento");
                Usuario user = u.existUser(documento);

                out.println(gson.toJson(user));
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson g=new Gson();
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        try{
            String opcion = request.getParameter("opcion");
            UsuarioDAO u = new UsuarioDAO();
            if (opcion.equals("addMoney")) {
                int cantidad = Integer.parseInt(request.getParameter("dinero"));
                user.setDinero(user.getDinero()+cantidad);
                request.getSession().setAttribute("usuario", user);
                out.println(u.updateMoney(user.getDocumento(), user.getDinero()));
            }
            if(opcion.equals("getMoney")){
                out.println(g.toJson(u.getMoney(user.getDocumento())));
            }
            if(opcion.equals("lessMoney")){
                
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioS.class.getName()).log(Level.SEVERE, null, ex);
            out.println(false);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
