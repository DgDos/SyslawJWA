/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Demanda;
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
public class DemandaDAO {

    private Connection connection;

    public DemandaDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public ArrayList<Demanda> getAllDemandasById(int id_usuario) throws SQLException {
        ArrayList<Demanda> demandas = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from demanda where delete=1 and id_usuario=" + id_usuario);
        while (rs.next()) {
            Demanda d = new Demanda();
            d.setId_demanda(rs.getInt("id_demanda"));
            d.setId_usuario(rs.getInt("id_usuario"));
            d.setTitulo(rs.getString("titulo"));
            d.setPorcentaje(rs.getFloat("porcentaje"));
            d.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
            d.setFecha_modificacion(rs.getTimestamp("fecha_modificacion"));
            d.setFecha_autoguardado(rs.getTimestamp("fecha_autoguardado"));
            demandas.add(d);
        }
        return demandas;
    }

    public ArrayList<Demanda> getAllDemandasByIdAyudante(int id_ayudante) throws SQLException {
        ArrayList<Demanda> demandas = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from demanda where delete=1 and id_ayudante=" + id_ayudante);
        while (rs.next()) {
            Demanda d = new Demanda();
            d.setId_demanda(rs.getInt("id_demanda"));
            d.setId_usuario(rs.getInt("id_usuario"));
            d.setTitulo(rs.getString("titulo"));
            d.setPorcentaje(rs.getFloat("porcentaje"));
            d.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
            d.setFecha_modificacion(rs.getTimestamp("fecha_modificacion"));
            d.setFecha_autoguardado(rs.getTimestamp("fecha_autoguardado"));
            demandas.add(d);
        }
        return demandas;
    }

    public Demanda getDemandaById(int id_demanda) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        Demanda d = new Demanda();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from demanda where delete=1 and id_demanda=" + id_demanda);
        while (rs.next()) {
            d.setId_demanda(rs.getInt("id_demanda"));
            d.setId_usuario(rs.getInt("id_usuario"));
            UsuarioDAO u = new UsuarioDAO();
            int test = rs.getInt("id_ayudante");
            if (test != 0) {
                d.setId_ayudante(u.getNameAyudante(rs.getInt("id_ayudante")));
            }
            d.setTitulo(rs.getString("titulo"));
            d.setJuez_nombre(rs.getString("juez_nombre"));
            d.setDte_nom(rs.getString("dte_nom"));
            d.setDte_ciudad(rs.getString("dte_ciudad"));
            d.setDte_id_tipo(rs.getInt("dte_id_tipo"));
            d.setDte_id(rs.getString("dte_id"));
            d.setDte_rep_tiene(rs.getBoolean("dte_rep_tiene"));
            d.setDte_rep_nom(rs.getString("dte_rep_nom"));
            d.setDte_rep_id_tipo(rs.getInt("dte_rep_id_tipo"));
            d.setDte_rep_id(rs.getString("dte_rep_id"));
            d.setDte_apo_tiene(rs.getBoolean("dte_apo_tiene"));
            d.setDte_apo_nom(rs.getString("dte_apo_nom"));
            d.setDte_apo_id_tipo(rs.getInt("dte_apo_id_tipo"));
            d.setDte_apo_id(rs.getString("dte_apo_id"));
            d.setDte_apo_tar_pro(rs.getString("dte_apo_tar_pro"));
            d.setDte_dir_not(rs.getString("dte_dir_not"));
            d.setDte_email(rs.getString("dte_email"));
            d.setDem_nom(rs.getString("dem_nom"));
            d.setDem_ciu(rs.getString("dem_ciu"));
            d.setDem_rep_tiene(rs.getBoolean("dem_rep_tiene"));
            d.setDem_rep_nom(rs.getString("dem_rep_nom"));
            d.setDem_apo_tiene(rs.getBoolean("dem_apo_tiene"));
            d.setDem_apo_nom(rs.getString("dem_apo_nom"));
            d.setDem_dir_not(rs.getString("dem_dir_not"));
            d.setDem_email(rs.getString("dem_email"));
            d.setPretensiones(rs.getString("pretensiones"));
            d.setHechos(rs.getString("hechos"));
            d.setDepende_cumplimiento(rs.getBoolean("depende_cumplimiento"));
            d.setTengo_pruebas(rs.getBoolean("tengo_pruebas"));
            d.setPruebas(rs.getString("pruebas"));
            d.setEstaba_obligado(rs.getBoolean("estaba_obligado"));
            d.setFundamentos(rs.getString("fundamentos"));
            d.setAnexos(rs.getString("anexos"));
            d.setSolicito_cautelares(rs.getBoolean("solicito_cautelares"));
            d.setCautelares_que_solicita(rs.getString("cautelares_que_solicita"));
            d.setPorcentaje(rs.getFloat("porcentaje"));
            d.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
            d.setFecha_modificacion(rs.getTimestamp("fecha_modificacion"));
            d.setFecha_autoguardado(rs.getTimestamp("fecha_autoguardado"));
            d.setId_autoguardado(rs.getInt("id_autoguardado"));
        }
        return d;
    }

    public void addDemanda(String titulo, int id_usuario) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into demanda(id_usuario,titulo,juez_nombre,dte_nom,dte_ciudad,dte_id_tipo,dte_id,dte_rep_tiene,dte_rep_nom,dte_rep_id_tipo,dte_rep_id,dte_apo_tiene,dte_apo_nom,dte_apo_id_tipo,dte_apo_id,dte_apo_tar_pro,dte_dir_not,dte_email,dem_nom,dem_ciu,dem_rep_tiene,dem_rep_nom,dem_apo_tiene,dem_apo_nom,dem_dir_not,dem_email,pretensiones,hechos,depende_cumplimiento,tengo_pruebas,pruebas,estaba_obligado,fundamentos,anexos,solicito_cautelares,cautelares_que_solicita,porcentaje,fecha_creacion,fecha_modificacion,delete) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)");
        preparedStatement.setInt(1, id_usuario);
        preparedStatement.setString(2, titulo);
        for (int i = 3; i < 38; i++) {
            if (i == 6 || i == 10 || i == 14) {
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
        preparedStatement.setTimestamp(38, new Timestamp(System.currentTimeMillis()));
        preparedStatement.setTimestamp(39, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
    }

    public void updateDemanda(Demanda d) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        PreparedStatement preparedStatement;
        if (d.getId_ayudante().equals("")) {
            preparedStatement = connection.prepareStatement("update demanda set titulo=?,juez_nombre=?,dte_nom=?,dte_ciudad=?,dte_id_tipo=?,dte_id=?,dte_rep_tiene=?,dte_rep_nom=?,dte_rep_id_tipo=?,dte_rep_id=?,dte_apo_tiene=?,dte_apo_nom=?,dte_apo_id_tipo=?,dte_apo_id=?,dte_apo_tar_pro=?,dte_dir_not=?,dte_email=?,dem_nom=?,dem_ciu=?,dem_rep_tiene=?,dem_rep_nom=?,dem_apo_tiene=?,dem_apo_nom=?,dem_dir_not=?,dem_email=?,pretensiones=?,hechos=?,depende_cumplimiento=?,tengo_pruebas=?,pruebas=?,estaba_obligado=?,fundamentos=?,anexos=?,solicito_cautelares=?,cautelares_que_solicita=?,porcentaje=?,fecha_modificacion=? where id_demanda=" + d.getId_demanda());
        } else {
            preparedStatement = connection.prepareStatement("update demanda set titulo=?,juez_nombre=?,dte_nom=?,dte_ciudad=?,dte_id_tipo=?,dte_id=?,dte_rep_tiene=?,dte_rep_nom=?,dte_rep_id_tipo=?,dte_rep_id=?,dte_apo_tiene=?,dte_apo_nom=?,dte_apo_id_tipo=?,dte_apo_id=?,dte_apo_tar_pro=?,dte_dir_not=?,dte_email=?,dem_nom=?,dem_ciu=?,dem_rep_tiene=?,dem_rep_nom=?,dem_apo_tiene=?,dem_apo_nom=?,dem_dir_not=?,dem_email=?,pretensiones=?,hechos=?,depende_cumplimiento=?,tengo_pruebas=?,pruebas=?,estaba_obligado=?,fundamentos=?,anexos=?,solicito_cautelares=?,cautelares_que_solicita=?,porcentaje=?,fecha_modificacion=?,id_ayudante=? where id_demanda=" + d.getId_demanda());
        }
        preparedStatement.setString(1, d.getTitulo());
        preparedStatement.setString(2, d.getJuez_nombre());
        preparedStatement.setString(3, d.getDte_nom());
        preparedStatement.setString(4, d.getDte_ciudad());
        preparedStatement.setInt(5, d.getDte_id_tipo());
        preparedStatement.setString(6, d.getDte_id());
        preparedStatement.setBoolean(7, d.getDte_rep_tiene());
        preparedStatement.setString(8, d.getDte_rep_nom());
        preparedStatement.setInt(9, d.getDte_rep_id_tipo());
        preparedStatement.setString(10, d.getDte_rep_id());
        preparedStatement.setBoolean(11, d.getDte_apo_tiene());
        preparedStatement.setString(12, d.getDte_apo_nom());
        preparedStatement.setInt(13, d.getDte_apo_id_tipo());
        preparedStatement.setString(14, d.getDte_apo_id());
        preparedStatement.setString(15, d.getDte_apo_tar_pro());
        preparedStatement.setString(16, d.getDte_dir_not());
        preparedStatement.setString(17, d.getDte_email());
        preparedStatement.setString(18, d.getDem_nom());
        preparedStatement.setString(19, d.getDem_ciu());
        preparedStatement.setBoolean(20, d.getDem_rep_tiene());
        preparedStatement.setString(21, d.getDem_rep_nom());
        preparedStatement.setBoolean(22, d.getDem_apo_tiene());
        preparedStatement.setString(23, d.getDem_apo_nom());
        preparedStatement.setString(24, d.getDem_dir_not());
        preparedStatement.setString(25, d.getDem_email());
        preparedStatement.setString(26, d.getPretensiones());
        preparedStatement.setString(27, d.getHechos());
        preparedStatement.setBoolean(28, d.getDepende_cumplimiento());
        preparedStatement.setBoolean(29, d.getTengo_pruebas());
        preparedStatement.setString(30, d.getPruebas());
        preparedStatement.setBoolean(31, d.getEstaba_obligado());
        preparedStatement.setString(32, d.getFundamentos());
        preparedStatement.setString(33, d.getAnexos());
        preparedStatement.setBoolean(34, d.getSolicito_cautelares());
        preparedStatement.setString(35, d.getCautelares_que_solicita());
        preparedStatement.setFloat(36, d.getPorcentaje());
        preparedStatement.setTimestamp(37, new Timestamp(System.currentTimeMillis()));
        if (!d.getId_ayudante().equals("")) {
            UsuarioDAO u = new UsuarioDAO();
            preparedStatement.setInt(38, u.getIdAyudante(d.getId_ayudante()));
        }
        preparedStatement.executeUpdate();
    }

}
