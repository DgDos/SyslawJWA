/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Contestacion;
import Model.Demanda;
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
        ResultSet rs = statement.executeQuery("select * from contestacion where delete=1 and id_usuario='" + id_usuario + "'");
        while (rs.next()) {
            Contestacion c = new Contestacion();
            c.setId_contestacion(rs.getInt("id_contestacion"));
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
            d.setProceso(rs.getString("proceso"));
            d.setContra(rs.getString("contra"));
            d.setId_contestacion(rs.getInt("id_contestacion"));
            d.setId_demanda(rs.getInt("id_demanda"));
            d.setNombre_demandado(rs.getString("nombre_demandado"));
            d.setCiudad_demandado(rs.getString("ciudad_demandado"));
            d.setDocumento_demandado(rs.getString("documento_demandado"));
            d.setTipo_documento_demandado(rs.getInt("tipo_documento_demandado"));
            d.setNombre_representante_legal(rs.getString("nombre_representante_legal"));
            d.setDomicilio_representante_legal(rs.getString("domicilio_representante_legal"));
            d.setDocumento_representante_legal(rs.getString("documento_representante_legal"));
            d.setTipo_documento_representante(rs.getInt("tipo_documento_representante"));
            d.setDdo_apo_tiene(rs.getBoolean("ddo_apo_tiene"));
            d.setDdo_apo_nom(rs.getString("ddo_apo_nom"));
            d.setDdo_apo_dir(rs.getString("ddo_apo_dir"));
            d.setDdo_apo_id(rs.getString("ddo_apo_id"));
            d.setDdo_apo_id_tipo(rs.getInt("ddo_apo_id_tipo"));
            d.setDdo_apo_tar_pro(rs.getString("ddo_apo_id_tipo"));
            d.setDireccion_notificaciones(rs.getString("direccion_notificaciones"));
            d.setEmail(rs.getString("email"));
            d.setPretenciones(rs.getBoolean("pretenciones"));
            d.setHechos_admitidos(rs.getString("hechos_admitidos"));
            d.setHechos_negados(rs.getString("hechos_negados"));
            d.setExplicacion_negados(rs.getString("explicacion_negados"));
            d.setHechos_no_constan(rs.getString("hechos_no_constan"));
            d.setExplicacion_no_constan(rs.getString("explicacion_no_constan"));
            d.setExcepciones(rs.getString("excepciones"));
            d.setReconocimiento(rs.getString("reconocimiento"));
            d.setRetencion(rs.getBoolean("retencion"));
            d.setPruebas(rs.getString("pruebas"));
            d.setAnexos(rs.getString("anexos"));
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

    public void addContestacion(Usuario user, Demanda demanda) throws SQLException {//                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
        PreparedStatement preparedStatement = connection.prepareStatement("insert into contestacion(id_demanda,nombre_demandado,documento_demandado,tipo_documento_demandado,nombre_representante_legal,domicilio_representante_legal,documento_representante_legal,tipo_documento_representante,ddo_apo_nom,ddo_apo_dir,ddo_apo_id,ddo_apo_id_tipo,ddo_apo_tar_pro,direccion_notificaciones,email,pretenciones,hechos_admitidos,hechos_negados,explicacion_negados,hechos_no_constan,explicacion_no_constan,excepciones,pruebas,porcentaje,fecha_creacion,fecha_modificacion,id_usuario,titulo,proceso,contra,ciudad_demandado,reconocimiento,retencion,anexos,ddo_apo_tiene,delete) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)");
        preparedStatement.setInt(1, demanda.getId_demanda());
        preparedStatement.setString(2, user.getNombre());
        preparedStatement.setString(3, user.getDocumento());
        preparedStatement.setInt(4, user.getTipo_id());
        preparedStatement.setString(14, user.getDireccion());
        preparedStatement.setString(15, user.getCorreo());
        preparedStatement.setTimestamp(25, new Timestamp(System.currentTimeMillis()));
        preparedStatement.setTimestamp(26, new Timestamp(System.currentTimeMillis()));
        preparedStatement.setString(27, user.getDocumento());
        preparedStatement.setString(28, demanda.getTitulo());
        preparedStatement.setString(30, user.getNombre());
        preparedStatement.setString(31, user.getCiudad());
        for (int i = 5; i <= 35; i++) {
            if (i == 8 || i == 12) {
                preparedStatement.setInt(i, -1);
            } else {
                if (i == 16 || i == 33 || i==35) {
                    preparedStatement.setBoolean(i, false);
                } else {
                    if (i == 24) {
                        preparedStatement.setFloat(i, 0);
                    } else {
                        if (i != 14 && i != 15 && i != 25 && i != 26 && i != 27 && i != 28 && i != 31 && i != 30) {
                            preparedStatement.setString(i, "");
                        }
                    }
                }
            }
        }

        preparedStatement.executeUpdate();
    }

    public void updateContestacion(Contestacion c) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("update contestacion set nombre_demandado=?,documento_demandado=?,tipo_documento_demandado=?,nombre_representante_legal=?,domicilio_representante_legal=?,documento_representante_legal=?,tipo_documento_representante=?,ddo_apo_nom=?,ddo_apo_dir=?,ddo_apo_id=?,ddo_apo_id_tipo=?,ddo_apo_tar_pro=?,direccion_notificaciones=?,email=?,pretenciones=?,hechos_admitidos=?,hechos_negados=?,explicacion_negados=?,hechos_no_constan=?,explicacion_no_constan=?,excepciones=?,pruebas=?,porcentaje=?,fecha_modificacion=?,reconocimiento=?,retencion=?,anexos=?,ddo_apo_tiene=? where id_contestacion=" + c.getId_contestacion());
        preparedStatement.setString(1, c.getNombre_demandado());
        preparedStatement.setString(2, c.getDocumento_demandado());
        preparedStatement.setInt(3, c.getTipo_documento_demandado());
        preparedStatement.setString(4, c.getNombre_representante_legal());
        preparedStatement.setString(5, c.getDomicilio_representante_legal());
        preparedStatement.setString(6, c.getDocumento_representante_legal());
        preparedStatement.setInt(7, c.getTipo_documento_representante());
        preparedStatement.setString(8, c.getDdo_apo_nom());
        preparedStatement.setString(9, c.getDdo_apo_dir());
        preparedStatement.setString(10, c.getDdo_apo_id());
        preparedStatement.setInt(11, c.getDdo_apo_id_tipo());
        preparedStatement.setString(12, c.getDdo_apo_tar_pro());
        preparedStatement.setString(13, c.getDireccion_notificaciones());
        preparedStatement.setString(14, c.getEmail());
        preparedStatement.setBoolean(15, c.isPretenciones());
        preparedStatement.setString(16, c.getHechos_admitidos());
        preparedStatement.setString(17, c.getHechos_negados());
        preparedStatement.setString(18, c.getExplicacion_negados());
        preparedStatement.setString(19, c.getHechos_no_constan());
        preparedStatement.setString(20, c.getExplicacion_no_constan());
        preparedStatement.setString(21, c.getExcepciones());
        preparedStatement.setString(22, c.getPruebas());
        preparedStatement.setFloat(23, c.getPorcentaje());
        preparedStatement.setTimestamp(24, new Timestamp(System.currentTimeMillis()));
        preparedStatement.setString(25, c.getReconocimiento());
        preparedStatement.setBoolean(26, c.getRetencion());
        preparedStatement.setString(27, c.getAnexos());
        preparedStatement.setBoolean(28, c.getDdo_apo_tiene());
        preparedStatement.executeUpdate();
    }

}
