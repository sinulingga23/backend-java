package org.sinulingga.db;


import org.sinulingga.config.Config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {

    private static ConnectionDB connectionDB = new ConnectionDB();
    private Connection connection;

    private ConnectionDB() {
        createConnection();
    }

    private void createConnection() {
        try {
            Properties properties = Config.getPropertiesProject("/application.properties");

            String host = properties.getProperty("db.host");
            String port = properties.getProperty("db.port");
            String databaseName = properties.getProperty("db.name");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");
            String sslMode = properties.getProperty("ssl.mode");
            String url = String.format("jdbc:postgresql://%s:%s/%s?user=%s&password=%s&ssl=%s",
                    host, port, databaseName, user, password, sslMode);

            this.connection = DriverManager.getConnection(url);
        } catch (IOException | SQLException e) {
            System.out.println("Error at " + ConnectionDB.class.getSimpleName() + ". Error: " + e.getMessage());
            e.getStackTrace();
        }
    }

    public static Connection getConnection() {
        return connectionDB.connection;
    }
}
