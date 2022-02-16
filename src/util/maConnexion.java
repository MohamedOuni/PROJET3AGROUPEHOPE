/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ouni
 */
public class maConnexion {
    
 //DB
    final static String URL = "jdbc:mysql://127.0.0.1:3306/techgate";
    final static String USERNAME = "root";
    final static String PWD = "";
    
    //var
    //Singleton : 1
    static maConnexion instance = null;
    private Connection cnx;
    public maConnexion getcnx;
    
    //Constructeur
    //Singleton : 2 (private)
    private maConnexion() {
        try {
            cnx = DriverManager.getConnection(URL, USERNAME, PWD);
            System.out.println("Connexion etablie avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //Getters 
    public Connection getCnx() {
        return cnx;
    }
    //Singleton : 3
    public static maConnexion getInstance() {
        if (instance == null) {
            instance = new maConnexion();
        }
        return instance;
    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public PreparedStatement prepareStatement(String Req) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public maConnexion getcnx() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}

