/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADM
 */
public class Database {
    
    public Connection getConnection()throws SQLException {
        String url = "jdbc:hsqldb:hsql://localhost/logistica";
        String user = "SA";
        String password = "";

        Connection conexao = DriverManager.getConnection(url, user, password);
        
        return conexao;
    }
}
