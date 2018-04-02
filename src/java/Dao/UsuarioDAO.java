/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Usuario;
import Util.DbUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author FiJus
 */
public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public void addUsuario(Usuario u, String pass) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into usuario(nombre,correo,password,tipo_usuario) values (?,?,?,?)");
        preparedStatement.setString(1, u.getNombre());
        preparedStatement.setString(2, u.getCorreo());
        preparedStatement.setString(3, pass);
        preparedStatement.setInt(4, u.getTipo_usuario());
        preparedStatement.executeUpdate();
    }

    public boolean isUser(String correo, String pass) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from usuario where correo='" + correo + "' and password='" + pass + "'");
        while (rs.next()) {
            return true;
        }
        return false;
    }

    public boolean isUser(String correo) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from usuario where correo='" + correo + "'");
        while (rs.next()) {
            return true;
        }
        return false;
    }

    public Usuario getUsuario(String correo) throws SQLException {
        Usuario user = new Usuario();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from usuario where correo='" + correo + "'");
        while (rs.next()) {
            user.setId_usuario(rs.getInt("id_usuario"));
            user.setCorreo(correo);
            user.setNombre(rs.getString("nombre"));
            user.setTipo_usuario(rs.getInt("tipo_usuario"));
        }
        return user;
    }

    public String getNameAyudante(int id_usuario) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select correo from usuario where delete=1 and id_usuario=" + id_usuario);
        while (rs.next()) {
            return rs.getString("correo");
        }
        return "";
    }

    public int getIdAyudante(String correo) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select id_usuario from usuario where delete=1 and correo=" + correo);
        while (rs.next()) {
            return rs.getInt("id_usuario");
        }
        return 0;
    }

}
