package com.example.caree.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/caree";
    private static final String USER = "root";
    private static final String PASSWORD = "4900Mysql!";
    private static Connection INSTANCE;

    private ConnectionManager() {
    }
    public static Connection getINSTANCE() {
        if (INSTANCE == null) {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                INSTANCE = DriverManager.getConnection(URL_DATABASE, USER, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException();
            }
        }
        return INSTANCE;
    }
    public static void CloseConnection() throws SQLException {
        if (INSTANCE!= null && !INSTANCE.isClosed()) {
            INSTANCE.close();
        }
    }
}
