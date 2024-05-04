package com.example.examences3.database;


import java.sql.*;
import java.util.*;

    public class ConexionMySql {

        private static String user;
        private static String password;
        private static int port;
        private static String host;
        private static String nameDatabase;
        private static Connection cnn;

        public ConexionMySql(){
            this.user = "root";
            password = "";
            port = 3306;
            host = "localhost";
            nameDatabase = "courses";
        }

        public static Connection getConnection() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                cnn = DriverManager.getConnection(
                        "jdbc:mysql://" + host + ":" + port + "/" + nameDatabase, user, password
                );
                System.out.println("Successful connection");
                return cnn;
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("An error occurred during the connection");
                throw new RuntimeException(e);
            }
        }
    }
