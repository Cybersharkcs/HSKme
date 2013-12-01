/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hskme.dao;

import com.hskme.model.Utilisateur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class UtilisateurDaoJdbc extends Connector {
    
    private Statement statement;
    private ResultSet resultSet;
 
    public UtilisateurDaoJdbc(){
        try {
            connectionJDBC();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UtilisateurDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Utilisateur recupererInfosUtilisateur() throws SQLException{
        Utilisateur utilisateur = null;
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select email,password from utilisateur");
        while(resultSet.next()){
            utilisateur = new Utilisateur();
            utilisateur.setEmail(resultSet.getString(1));
            utilisateur.setPassword(resultSet.getString(2));
        }
        return utilisateur;
    }
}
