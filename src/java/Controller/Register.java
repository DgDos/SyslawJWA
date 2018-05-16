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
            Gson gson = new Gson();
            if (request.getParameter("documento") != null) {
                String documento = request.getParameter("documento");
                UsuarioDAO u = new UsuarioDAO();
                out.print(gson.toJson(!u.isUserDoc(documento)));
            } else if (request.getParameter("correo") != null) {
                String correo = request.getParameter("correo");
                UsuarioDAO u = new UsuarioDAO();
                out.print(gson.toJson(!u.isUserCorreo(correo)));
            } else {
                out.print(gson.toJson(false));
            }

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
            int tipo_documento = Integer.parseInt(request.getParameter("tipo_documento"));
            int tipo_usuario = Integer.parseInt(request.getParameter("tipo_usuario"));
            String documento = request.getParameter("documento");
            String ciudad = request.getParameter("ciudad");
            String direccion = request.getParameter("direccion");
            String correo = request.getParameter("correo");
            String pass = request.getParameter("pass");
            Encription e = new Encription();
            Usuario user = new Usuario(documento, nombre, ciudad, direccion, correo, tipo_usuario, tipo_documento);
            UsuarioDAO u = new UsuarioDAO();
            if (tipo_usuario == 1) {
                u.addUsuarioDemandante(user, e.encription(pass));
            } else {
                String tarjeta = request.getParameter("tarjeta");
                user.setTarjeta(tarjeta);
                u.addUsuarioAbogado(user, e.encription(pass));
            }
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
