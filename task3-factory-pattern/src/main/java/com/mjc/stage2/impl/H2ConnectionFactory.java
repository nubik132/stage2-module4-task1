package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        Properties properties = new Properties();
        try {
            properties.load(H2ConnectionFactory.class.getClassLoader().getResourceAsStream("h2database.properties"));
        } catch (Exception e){
            throw new RuntimeException();
        }

        String url = properties.getProperty("db_url");

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return connection;
    }
    // Write your code here!
}

