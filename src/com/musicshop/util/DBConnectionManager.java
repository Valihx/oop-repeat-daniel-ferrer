package com.musicshop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    // mySql data
    private static final String DB_URL = "jdbc:mysql://localhost:3306/music_shop_db";
    private static final String USER = "root"; // IMPORTANT: Change this to your MySQL username
    private static final String PASSWORD = "password"; // IMPORTANT: Change this to your MySQL password


    public static Connection getConnection() throws SQLException {
        // This single line uses the driver we added to connect to the database
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}