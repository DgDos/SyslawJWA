package Util;

import java.io.IOException;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static Connection CONNECTION = null;

    public static Connection getConnection() throws SQLException, ClassNotFoundException, IOException {

        // Datos de conexión a base de datos remota de PostgreSQL
        String host = "ec2-107-22-168-211.compute-1.amazonaws.com";
        String database = "d4j0i17pqpsrb9";
        String user = "rusrlnugfaivdj";
        String pass = "5e01e803f8a05c577a8e109a44c84801f6681d1e4e64ce1853300a456297eccc";
        String port = "5432";

        /*
        // Datos de conexión a base de datos local de PostgreSQL
        String host = "localhost";
        String database = "usalaba1";
        String user = "root";
        String pass = "root";
        String port = "5432";
         */
        if (CONNECTION == null) {

            // Intentar conectar a traves de conexion automatica de Heroku
            URI dbUri;
            try {
                dbUri = new URI(System.getenv("DATABASE_URL"));
            } catch (Exception ex) {
                dbUri = null;
            }

            // Caso de que este almacenado en Heroku
            if (dbUri != null) {
                String username = dbUri.getUserInfo().split(":")[0];
                String password = dbUri.getUserInfo().split(":")[1];
                String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

                try {
                    CONNECTION = DriverManager.getConnection(dbUrl, username, password);
                } catch (SQLException e) {
                    System.out.println("Conexion falló conectando a traves de Heroku");
                    e.printStackTrace();
                }

            } else {
                // Caso de que esté usandose de forma local sea con Maven o con Java Web App
                Class.forName("org.postgresql.Driver");
                String dbUrl = "jdbc:postgresql://" + host + ':' + port + "/" + database + "?user=" + user + "&password=" + pass + "&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
                try {
                    CONNECTION = DriverManager.getConnection(dbUrl);
                } catch (SQLException e) {
                    System.out.println("Conexion fallo por metodo de Maven Local");
                    System.out.println("Intentando conectar por Driver JDBC PostreSQL");
                }

            }
        }

        System.out.println("Connection Succesful!");
        return CONNECTION;
    }

    public static void closeConnection() throws SQLException {
        try {
            if (CONNECTION != null) {
                CONNECTION.close();
                CONNECTION = null;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }

    }

}
