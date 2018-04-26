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
        PreparedStatement preparedStatement = connection.prepareStatement("insert into usuario(documento,tipo_documento,nombre,ciudad,direccion,correo,password,tipo_usuario,delete) values (?,?,?,?,?,?,?,?,1)");
        preparedStatement.setString(1, u.getDocumento());
        preparedStatement.setInt(2, u.getTipo_id());
        preparedStatement.setString(3, u.getNombre());
        preparedStatement.setString(4, u.getCiudad());
        preparedStatement.setString(5, u.getDireccion());
        preparedStatement.setString(6, u.getCorreo());
        preparedStatement.setString(7, pass);
        preparedStatement.setInt(8, u.getTipo_usuario());
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
            user.setDocumento(rs.getString("documento"));
            user.setTipo_id(rs.getInt("tipo_documento"));
            user.setNombre(rs.getString("nombre"));
            user.setCiudad(rs.getString("ciudad"));
            user.setDireccion(rs.getString("direccion"));
            user.setCorreo(correo);
            user.setTipo_usuario(rs.getInt("tipo_usuario"));
        }
        return user;
    }

    public String getNameAyudante(String documento) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select correo from usuario where delete=1 and documento='" + documento+"'");
        while (rs.next()) {
            return rs.getString("correo");
        }
        return "";
    }

    public int getIdAyudante(String correo) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select documento from usuario where delete=1 and correo='" + correo+"'");
        while (rs.next()) {
            return rs.getInt("id_usuario");
        }
        return 0;
    }

    public Usuario existUser(String documento) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from usuario where delete=1 and documento='" + documento+"'");
        Usuario user=new Usuario();
        while(rs.next()){
            user.setDocumento(documento);
            user.setNombre(rs.getString("nombre"));
            user.setCiudad(rs.getString("ciudad"));
            user.setDireccion(rs.getString("direccion"));
            user.setCorreo(rs.getString("correo"));
            user.setTipo_id(rs.getInt("tipo_documento"));
            return user;
        }
        user.setDocumento(documento);
        user.setNombre("");
        user.setDireccion("");
        user.setCiudad("");
        user.setCorreo("");
        user.setTipo_id(-1);
        return user;
    }

}
