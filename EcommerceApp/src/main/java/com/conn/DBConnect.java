package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    private static Connection conn = null; // this is null conn 

    public static Connection getConn() {
        try {
            Class.forName("org.sqlite.JDBC");  // Correct driver
            String dbPath = "./mydatabase.db"; // Or absolute path if using Docker
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            System.out.println("✅ Database connected successfully: " + dbPath);
        } catch (Exception e) {
            System.out.println("❌ Failed to connect to SQLite DB:");
            e.printStackTrace();
        }
        return conn;
    }
}
