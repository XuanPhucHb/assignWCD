package com.sem4.wcd.assign.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

    private static final String DATABASE_URL_FORMAT = "jdbc:mysql://%s:%d/%s?useUnicode=true&contentEncoding=UTF-8";
    private static final String DATABASE_SERVER = "127.0.0.1";
    private static final int DATABASE_PORT = 3306;
    private static final String DATABASE_NAME = "nxp";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PWD = "";
    private static Connection cnn;

    public static Connection getConnection() {
        try {
            if (cnn == null || cnn.isClosed()) {
                Class.forName("com.mysql.jdbc.Driver");
                cnn = DriverManager.getConnection(
                        String.format(DATABASE_URL_FORMAT, DATABASE_SERVER, DATABASE_PORT, DATABASE_NAME),
                        DATABASE_USER,
                        DATABASE_PWD);
                System.out.println("Connect success!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return cnn;
    }
}
