package com.example.Lab11.DataBase;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;


public class DataBase {

    static Connection connection;

    public DataBase() throws SQLException {
        String address = "jdbc:postgresql://localhost:5432/JavaLab11";
        connection = DriverManager.getConnection(address,"postgres","STUDENT");
    }

    public Connection getConnection() {
        return connection;
    }
}
