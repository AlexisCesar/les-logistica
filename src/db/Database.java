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
        String url = "jdbc:mysql://localhost:3306/loja"; //Nome da base de dados
        String user = "root"; //nome do usuário do MySQL
        String password = "root"; //senha do MySQL

        Connection conexao = null;
        
        conexao = DriverManager.getConnection(url, user, password);
        
        return conexao;
    }
    
}
