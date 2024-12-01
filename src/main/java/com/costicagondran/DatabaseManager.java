package com.costicagondran;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseManager {

    private Properties props = new Properties();
    private Connection connection;

    public DatabaseManager(String user, String password) {
        this.props.setProperty("user", user);
        this.props.setProperty("password", password);
    }

    public String getUser() {
        return this.props.getProperty("user");
    }

    public void connect() {
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://pedago.univ-avignon.fr:5432/etd", props);
            this.connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public void query() {

        try {
            Statement statement = this.connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM AVION LIMIT 1");

            while (result.next()) {

                String nom_avion = result.getString("nomav");
                String locav = result.getString("locav");
                int num_avion = result.getInt("numav");
                int cap_avion = result.getInt("capav");

                System.out.println("Nom avion: " + nom_avion);
                System.out.println("Localisation Avion: " + locav);
                System.out.println("Numéro d'avion: " + num_avion);
                System.out.println("Capacité avion: " + cap_avion);
            }

            result.close();

            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
