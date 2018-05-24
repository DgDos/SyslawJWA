/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Demanda;
import Model.Estadisticas;
import Model.Estados;
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
public class DemandaDAO {

    private Connection connection;

    public DemandaDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public ArrayList<Demanda> getAllDemandasByState(String id_usuario, int state) throws SQLException {
        ArrayList<Demanda> demandas = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from demanda where delete=1 and id_usuario='" + id_usuario + "' and estado=" + state);
        while (rs.next()) {
            Demanda d = new Demanda();
            d.setId_demanda(rs.getInt("id_demanda"));
            d.setId_usuario(rs.getString("id_usuario"));
            d.setTitulo(rs.getString("titulo"));
            d.setPorcentaje(rs.getFloat("porcentaje"));
            d.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
            d.setFecha_modificacion(rs.getTimestamp("fecha_modificacion"));
            d.setFecha_autoguardado(rs.getTimestamp("fecha_autoguardado"));
            d.setId_ayudante(rs.getString("id_ayudante"));
            d.setEstado(rs.getInt("estado"));
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
            d.setId_usuario(rs.getString("id_usuario"));
            UsuarioDAO u = new UsuarioDAO();
            int test = rs.getInt("id_ayudante");
            if (test != 0) {
                d.setId_ayudante(u.getNameAyudante(rs.getString("id_ayudante")));
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
            d.setDem_id(rs.getString("dem_id"));
            d.setDem_id_tipo(rs.getInt("dem_id_tipo"));
            d.setComentarios_usuario(rs.getString("comentarios_usuario"));
            d.setComentarios_abogado(rs.getString("comentarios_abogado"));
            d.setEstado(rs.getInt("estado"));
        }
        return d;
    }

    public void addDemanda(String titulo, Usuario user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into demanda(id_usuario,titulo,juez_nombre,dte_nom,dte_ciudad,dte_id_tipo,dte_id,dte_rep_tiene,dte_rep_nom,dte_rep_id_tipo,dte_rep_id,dte_apo_tiene,dte_apo_nom,dte_apo_id_tipo,dte_apo_id,dte_apo_tar_pro,dte_dir_not,dte_email,dem_nom,dem_ciu,dem_rep_tiene,dem_rep_nom,dem_apo_tiene,dem_apo_nom,dem_dir_not,dem_email,pretensiones,hechos,depende_cumplimiento,tengo_pruebas,pruebas,estaba_obligado,fundamentos,anexos,solicito_cautelares,cautelares_que_solicita,porcentaje,fecha_creacion,fecha_modificacion,delete,estado,dem_id,dem_id_tipo,comentarios_usuario,comentarios_abogado) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1,?,?,?,?,?)");
        preparedStatement.setString(1, user.getDocumento());
        preparedStatement.setString(2, titulo);
        preparedStatement.setString(4, user.getNombre());
        preparedStatement.setString(5, user.getCiudad());
        preparedStatement.setInt(6, user.getTipo_id());
        preparedStatement.setString(7, user.getDocumento());
        preparedStatement.setString(17, user.getDireccion());
        preparedStatement.setString(18, user.getCorreo());
        preparedStatement.setInt(40, 1);
        float valor = ((7 * 100) / 37);
        for (int i = 3; i < 45; i++) {
            if (i == 10 || i == 14 || i == 42) {
                preparedStatement.setInt(i, -1);
            } else {
                if (i == 8 || i == 12 || i == 21 || i == 23 || i == 29 || i == 30 || i == 32 || i == 35) {
                    preparedStatement.setBoolean(i, false);
                } else {
                    if (i == 37) {
                        preparedStatement.setFloat(i, valor);
                    } else {
                        if (i == 38 || i == 39) {
                            preparedStatement.setTimestamp(38, new Timestamp(System.currentTimeMillis()));
                            preparedStatement.setTimestamp(39, new Timestamp(System.currentTimeMillis()));
                        } else {
                            if (i != 4 && i != 5 && i != 6 && i != 7 && i != 17 && i != 18 && i != 40) {
                                preparedStatement.setString(i, "");
                            }
                        }
                    }
                }
            }
        }
        preparedStatement.executeUpdate();
    }

    public void updateDemanda(Demanda d) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("update demanda set titulo=?,juez_nombre=?,dte_nom=?,dte_ciudad=?,dte_id_tipo=?,dte_id=?,dte_rep_tiene=?,dte_rep_nom=?,dte_rep_id_tipo=?,dte_rep_id=?,dte_apo_tiene=?,dte_apo_nom=?,dte_apo_id_tipo=?,dte_apo_id=?,dte_apo_tar_pro=?,dte_dir_not=?,dte_email=?,dem_nom=?,dem_ciu=?,dem_rep_tiene=?,dem_rep_nom=?,dem_apo_tiene=?,dem_apo_nom=?,dem_dir_not=?,dem_email=?,pretensiones=?,hechos=?,depende_cumplimiento=?,tengo_pruebas=?,pruebas=?,estaba_obligado=?,fundamentos=?,anexos=?,solicito_cautelares=?,cautelares_que_solicita=?,porcentaje=?,fecha_modificacion=?,dem_id=?,dem_id_tipo=?,comentarios_abogado=?,comentarios_usuario=? where id_demanda=" + d.getId_demanda());
        preparedStatement.setString(1, d.getTitulo());
        preparedStatement.setString(2, d.getJuez_nombre());
        preparedStatement.setString(3, d.getDte_nom());
        preparedStatement.setString(4, d.getDte_ciudad());
        preparedStatement.setInt(5, d.getDte_id_tipo());
        preparedStatement.setString(6, d.getDte_id());
        preparedStatement.setBoolean(7, false);
        preparedStatement.setString(8, "");
        preparedStatement.setInt(9, -1);
        preparedStatement.setString(10, "");
        preparedStatement.setBoolean(11, d.getDte_apo_tiene());
        preparedStatement.setString(12, d.getDte_apo_nom());
        preparedStatement.setInt(13, d.getDte_apo_id_tipo());
        preparedStatement.setString(14, d.getDte_apo_id());
        preparedStatement.setString(15, d.getDte_apo_tar_pro());
        preparedStatement.setString(16, d.getDte_dir_not());
        preparedStatement.setString(17, d.getDte_email());
        preparedStatement.setString(18, d.getDem_nom());
        preparedStatement.setString(19, d.getDem_ciu());
        preparedStatement.setBoolean(20, false);
        preparedStatement.setString(21, "");
        preparedStatement.setBoolean(22, false);
        preparedStatement.setString(23, "");
        preparedStatement.setString(24, d.getDem_dir_not());
        preparedStatement.setString(25, d.getDem_email());
        preparedStatement.setString(26, d.getPretensiones());
        preparedStatement.setString(27, d.getHechos());
        preparedStatement.setBoolean(28, d.getDepende_cumplimiento());
        preparedStatement.setBoolean(29, d.getTengo_pruebas());
        preparedStatement.setString(30, d.getPruebas());
        preparedStatement.setBoolean(31, false);
        preparedStatement.setString(32, d.getFundamentos());
        preparedStatement.setString(33, d.getAnexos());
        preparedStatement.setBoolean(34, d.getSolicito_cautelares());
        preparedStatement.setString(35, d.getCautelares_que_solicita());
        preparedStatement.setFloat(36, d.getPorcentaje());
        preparedStatement.setTimestamp(37, new Timestamp(System.currentTimeMillis()));
        preparedStatement.setString(38, d.getDem_id());
        preparedStatement.setInt(39, d.getDem_id_tipo());
        preparedStatement.setString(40, d.getComentarios_abogado());
        preparedStatement.setString(41, d.getComentarios_usuario());
        preparedStatement.executeUpdate();
    }

    public ArrayList<Estadisticas> getDemandadosVeces() throws SQLException {
        ArrayList<Estadisticas> estadisticas = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select dem_nom,COUNT(dem_nom) as veces from demanda where delete=1 group by dem_nom ");
        while (rs.next()) {
            Estadisticas e = new Estadisticas();
            e.setId_usuario(rs.getString("dem_nom"));
            e.setVeces(rs.getInt("veces"));
            estadisticas.add(e);
        }
        return estadisticas;
    }

    public boolean endState(int id_demanda, int nextState) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("update demanda set estado=? where id_demanda=?");
        preparedStatement.setInt(1, nextState);
        preparedStatement.setInt(2, id_demanda);
        preparedStatement.executeUpdate();
        return true;
    }

    public boolean pickIt(int id_demanda, Usuario user) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("update demanda set id_ayudante=?,estado=3 where id_demanda=?");
        preparedStatement.setString(1, user.getDocumento());
        preparedStatement.setInt(2, id_demanda);
        preparedStatement.executeUpdate();
        return true;
    }

    public Demanda getDemandaHelpInfo(String id_ayudante) throws SQLException {
        Demanda d = new Demanda();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from demanda where delete=1 and id_ayudante='" + id_ayudante + "'");
        while (rs.next()) {
            d.setId_demanda(rs.getInt("id_demanda"));
            d.setId_usuario(rs.getString("id_usuario"));
            d.setTitulo(rs.getString("titulo"));
            d.setPorcentaje(rs.getFloat("porcentaje"));
            d.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
            d.setFecha_modificacion(rs.getTimestamp("fecha_modificacion"));
            d.setFecha_autoguardado(rs.getTimestamp("fecha_autoguardado"));
            d.setEstado(rs.getInt("estado"));
        }
        return d;
    }

    public Demanda getDemandaHelp(int id_demanda, String documento) throws SQLException {
        Demanda d = new Demanda();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from demanda where delete=1 and id_demanda=" + id_demanda + " and id_ayudante='" + documento + "'");
        while (rs.next()) {
            d.setId_demanda(rs.getInt("id_demanda"));
            d.setId_usuario(rs.getString("id_usuario"));
            d.setId_ayudante(rs.getString("id_ayudante"));
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
            d.setDem_id(rs.getString("dem_id"));
            d.setDem_id_tipo(rs.getInt("dem_id_tipo"));
            d.setComentarios_usuario(rs.getString("comentarios_usuario"));
            d.setComentarios_abogado(rs.getString("comentarios_abogado"));
            d.setEstado(rs.getInt("estado"));
        }
        return d;
    }

    public ArrayList<Demanda> getPoolDemandas() throws SQLException {
        ArrayList<Demanda> demandas = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from demanda where delete=1 and estado=2");
        while (rs.next()) {
            Demanda d = new Demanda();
            d.setId_demanda(rs.getInt("id_demanda"));
            d.setId_usuario(rs.getString("id_usuario"));
            d.setTitulo(rs.getString("titulo"));
            d.setPorcentaje(rs.getFloat("porcentaje"));
            d.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
            d.setFecha_modificacion(rs.getTimestamp("fecha_modificacion"));
            d.setFecha_autoguardado(rs.getTimestamp("fecha_autoguardado"));
            d.setEstado(rs.getInt("estado"));
            demandas.add(d);
        }
        return demandas;
    }

    public ArrayList<Estados> states(String id_demandante) throws SQLException {
        ArrayList<Estados> estados = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs;
        if (id_demandante.equals("")) {
            rs = statement.executeQuery("select COUNT(demanda.id_demanda) AS cuenta,estado from demanda group by estado");
        } else {
            rs = statement.executeQuery("select COUNT(demanda.id_demanda) AS cuenta,estado from demanda where id_usuario='" + id_demandante + "' group by estado");
        }
        while (rs.next()) {
            Estados e = new Estados();
            e.setCuenta(rs.getInt("cuenta"));
            e.setEstado(rs.getString("estado"));
            estados.add(e);
        }
        return estados;
    }
}
