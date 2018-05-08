/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.UsuarioDAO;
import Util.Encription;
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
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setAttribute("usuario", null);
        request.getSession().setAttribute("demanda", null);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String user = request.getParameter("correo");
            String pass = request.getParameter("pass");
            Encription e=new Encription();
            UsuarioDAO u = new UsuarioDAO();
            if (u.isUser(user, e.encription(pass))) {
                request.getSession().setAttribute("usuario", u.getUsuario(user));
                out.print("si");
            } else {
                out.print("no");
            }
        } catch (NoSuchAlgorithmException | SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    
}
