/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hskme.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;

/**
 *
 * @author root
 */
public abstract class Connector {
    
    protected Connection connection = null;
    
    public void connectionJDBC() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/HSKme?user=root&password=ca83dxmy");
        
    }
    
    public IDatabaseConnection getConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/HSKme?user=root&password");
        IDatabaseConnection cx = new DatabaseConnection(connection);
        return cx;
        
    }
    
}
