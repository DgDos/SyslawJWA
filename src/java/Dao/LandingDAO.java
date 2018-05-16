/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Landing;
import Util.DbUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FiJus
 */
public class LandingDAO {
    private Connection connection;

    public LandingDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public boolean addLangind(Landing lan) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into landing(nombre,correo,beta) values (?,?,?)");
            preparedStatement.setString(1, lan.getNombre());
            preparedStatement.setString(2, lan.getCorreo());
            preparedStatement.setBoolean(3, lan.isBeta());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LandingDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public ArrayList<Landing> getAllLandings() throws SQLException {
        ArrayList<Landing> landings=new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from landing");
        while(rs.next()){
            Landing l=new Landing();
            l.setNombre(rs.getString("nombre"));
            l.setCorreo(rs.getString("correo"));
            l.setBeta(rs.getBoolean("beta"));
            landings.add(l);
        }
        return landings;
    }
}
