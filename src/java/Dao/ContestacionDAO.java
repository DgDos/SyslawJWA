/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Contestacion;
import Model.Demanda;
import Model.Estadisticas;
import Model.Usuario;
import Util.DbUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author FiJus
 */
public class ContestacionDAO {

    private Connection connection;

    public ContestacionDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public ArrayList<Contestacion> getAllContestacionById(String id_usuario) throws SQLException {
        ArrayList<Contestacion> contestaciones = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from contestacion where delete=1 and id_usuario=" + id_usuario);
        while (rs.next()) {
            Contestacion c = new Contestacion();
            c.setId_demanda(rs.getInt("id_demanda"));
            c.setId_usuario(rs.getString("id_usuario"));
            c.setTitulo(rs.getString("titulo"));
            c.setPorcentaje(rs.getFloat("porcentaje"));
            c.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
            c.setFecha_modificacion(rs.getTimestamp("fecha_modificacion"));
            c.setFecha_autoguardado(rs.getTimestamp("fecha_autoguardado"));
            contestaciones.add(c);
        }
        return contestaciones;
    }

    public ArrayList<Contestacion> getAllContestacionByIdAyudante(int id_ayudante) throws SQLException {
        ArrayList<Contestacion> contestaciones = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from contestacion where delete=1 and id_ayudante=" + id_ayudante);
        while (rs.next()) {
            Contestacion d = new Contestacion();
            d.setId_demanda(rs.getInt("id_demanda"));
            d.setId_usuario(rs.getString("id_usuario"));
            d.setTitulo(rs.getString("titulo"));
            d.setPorcentaje(rs.getFloat("porcentaje"));
            d.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
            d.setFecha_modificacion(rs.getTimestamp("fecha_modificacion"));
            d.setFecha_autoguardado(rs.getTimestamp("fecha_autoguardado"));
            contestaciones.add(d);
        }
        return contestaciones;
    }

    public Contestacion getContestacionById(int id_contestacion) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        Contestacion d = new Contestacion();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from contestacion where delete=1 and id_contestacion=" + id_contestacion);
        while (rs.next()) {
            d.setId_demanda(rs.getInt("id_demanda"));
            d.setId_usuario(rs.getString("id_usuario"));
            UsuarioDAO u = new UsuarioDAO();
            int test = rs.getInt("id_ayudante");
            if (test != 0) {
                d.setId_ayudante(u.getNameAyudante(rs.getString("id_ayudante")));
            }
            
         d.setId_contestacion(rs.getInt("id_contestacion"));
         d.setNombre_demandado(rs.getString("nombre_demandado"));
         d.setDocumento_demandado(rs.getString("documente_demandado"));
         d.setTipo_documento_demandado(rs.getInt("tipo_documento_demandado"));
         d.setNombre_representante_legal(rs.getString("nombre_representante_legal"));
         d.setDomicilio_representante_legal(rs.getString("domicilio_representante_legal"));
         d.setDocumento_representante_legal(rs.getString("documento_representante_legal"));
         d.setTipo_documento_representante(rs.getInt("tipo_documento_representante"));
         d.setNombre_apoderado(rs.getString("nombre_apoderado"));
         d.setDomicilio_apoderado(rs.getString("domicilio_apoderado"));
         d.setDocumento_apoderado(rs.getString("documento_apoderado"));
         d.setTipo_documento_apoderado(rs.getInt("tipo_documento_apoderado"));
         d.setTarjeta_profesional_apoderado(rs.getString("tarjeta_profesional_apoderado"));
         d.setDireccion_notificaciones(rs.getString("direccion_notificaciones"));
         d.setEmail(rs.getString("email"));
         d.setPretenciones(rs.getBoolean("pretenciones"));
         d.setHechos_admitidos(rs.getString("hechos_admitidos"));
         d.setHechos_negados(rs.getString("hechos_negados"));
         d.setExplicacion_negados(rs.getString("explicacion_negados"));
         d.setHechos_no_constan(rs.getString("hechos_no_constan"));
         d.setExplicacion_no_constan(rs.getString("explicacion_no_constan"));
         d.setExcepciones(rs.getString("excepciones"));
         d.setPruebas(rs.getString("pruebas"));
         d.setPorcentaje(rs.getFloat("porcentaje"));
         d.setFecha_creacion(rs.getDate("fecha_creacion"));
         d.setFecha_modificacion(rs.getDate("fecha_modificacion"));
         d.setFecha_autoguardado(rs.getDate("fecha_autoguardado"));
         d.setId_autoguardado(rs.getInt("id_autoguardado"));
         d.setId_usuario(rs.getString("id_usuario"));
         d.setId_ayudante(rs.getString("id_ayudante"));
         d.setTitulo(rs.getString("titulo"));
         d.setDelete(rs.getInt("delete"));
     
        }
        return d;
    }

    public void addContestacion(String titulo, Usuario user, int id_demanda) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into contestacion(id_demanda,nombre_demandado,documento_demandado,tipo_documento_demandado,nombre_representante_legal,domicilio_representante_legal,documento_representante_legal,tipo_documento_representante,nombre_apoderado,domicilio_apoderado,documento_apoderado,tipo_documento_apoderado,tarjeta_profesional_apoderado,direccion_notificaciones,email,pretenciones,hechos_admitidos,hechos_negados,explicacion_negados,hechos_no_constan,explicacion_no_constan,excepciones,pruebas,porcentaje,fecha_creacion,fecha_modificacion,fecha_autoguardado,id_autoguardado,id_usuario,id_ayudante,titulo,delete) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)");
        preparedStatement.setInt(1, id_demanda);
        preparedStatement.setString(2, user.getNombre());
        preparedStatement.setString(3, user.getDocumento());
        preparedStatement.setInt(4, user.getTipo_id());
        preparedStatement.setTimestamp(25, new Timestamp(System.currentTimeMillis()));
        preparedStatement.setTimestamp(26, new Timestamp(System.currentTimeMillis()));
        preparedStatement.setString(31, titulo);
        
        
        for (int i = 5; i < 32; i++) {
            if (i == 8 || i == 12 || i == 28) {
                preparedStatement.setInt(i, -1);
            } else {
                if (i == 8 || i == 12 || i == 21 || i == 23 || i == 29 || i == 30 || i == 32 || i == 35) {
                    preparedStatement.setBoolean(i, false);
                } else {
                    if (i == 37) {
                        preparedStatement.setFloat(i, 0);
                    } else {
                        preparedStatement.setString(i, "");
                    }
                }
            }
        }
       
        preparedStatement.executeUpdate();
    }

    public void updateContestacion(Contestacion c) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        PreparedStatement preparedStatement;
        
        preparedStatement = connection.prepareStatement("update contestacion set id_demanda=?,nombre_demandado=?,documento_demandado=?,tipo_documento_demandado=?,nombre_representante_legal=?,domicilio_representante_legal=?,documento_representante_legal=?,tipo_documento_representante=?,nombre_apoderado=?,domicilio_apoderado=?,documento_apoderado=?,tipo_documento_apoderado=?,tarjeta_profesional_apoderado=?,direccion_notificaciones=?,email=?,pretenciones=?,hechos_admitidos=?,hechos_negados=?,explicacion_negados=?,hechos_no_constan=?,explicacion_no_constan=?,excepciones=?,pruebas=?,porcentaje=?,fecha_modificacion=? where id_demanda=" + c.getId_demanda());
        
        preparedStatement.setInt(1, c.getId_demanda());
        preparedStatement.setString(2, c.getNombre_demandado());
        preparedStatement.setString(3, c.getDocumento_demandado());
        preparedStatement.setInt(4, c.getTipo_documento_demandado());
        preparedStatement.setString(5, c.getNombre_representante_legal());
        preparedStatement.setString(6, c.getDomicilio_representante_legal());
        preparedStatement.setString(7, c.getDocumento_representante_legal());
        preparedStatement.setInt(8, c.getTipo_documento_representante());
        preparedStatement.setString(9, c.getNombre_apoderado());
        preparedStatement.setString(10, c.getDomicilio_apoderado());
        preparedStatement.setString(11, c.getDocumento_apoderado());
        preparedStatement.setInt(12, c.getTipo_documento_apoderado());
        preparedStatement.setString(13, c.getTarjeta_profesional_apoderado());
        preparedStatement.setString(14, c.getDireccion_notificaciones());
        preparedStatement.setString(15, c.getEmail());
        preparedStatement.setBoolean(16, c.isPretenciones());
        preparedStatement.setString(17, c.getHechos_admitidos());
        preparedStatement.setString(18, c.getHechos_negados());
        preparedStatement.setString(19, c.getExplicacion_negados());
        preparedStatement.setString(20, c.getHechos_no_constan());
        preparedStatement.setString(21, c.getExplicacion_no_constan());
        preparedStatement.setString(22, c.getExcepciones());
        preparedStatement.setString(23, c.getPruebas());
        preparedStatement.setFloat(24, c.getPorcentaje());
        preparedStatement.setTimestamp(25, new Timestamp(System.currentTimeMillis()));
        
   
       
        preparedStatement.executeUpdate();
    }


}
