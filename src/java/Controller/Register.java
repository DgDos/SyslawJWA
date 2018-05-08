/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.UsuarioDAO;
import Model.Usuario;
import Util.Encription;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
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
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String correo = request.getParameter("correo");
            UsuarioDAO u = new UsuarioDAO();
            Gson gson = new Gson();
            out.print(gson.toJson(!u.isUser(correo)));
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String nombre = request.getParameter("nombre");
            int tipo_documento=Integer.parseInt(request.getParameter("tipo_documento"));
            String documento=request.getParameter("documento");
            String ciudad=request.getParameter("ciudad");
            String direccion=request.getParameter("direccion");
            String correo = request.getParameter("correo");
            String pass = request.getParameter("pass");
            Encription e = new Encription();
            Usuario user=new Usuario(documento, nombre, ciudad, direccion, correo, 1, tipo_documento);
            UsuarioDAO u = new UsuarioDAO();
            u.addUsuario(user, e.encription(pass));
            
            try (PrintWriter out = response.getWriter()) {
                Gson gson = new Gson();
                out.print(gson.toJson(true));
            }
            
        } catch (SQLException | URISyntaxException | ClassNotFoundException | NoSuchAlgorithmException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            try (PrintWriter out = response.getWriter()) {
                Gson gson = new Gson();
                out.print(gson.toJson(false));
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
