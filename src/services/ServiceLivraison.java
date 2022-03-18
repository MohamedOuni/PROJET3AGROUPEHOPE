/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import model.Livraison;
import util.maConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author user
 */
public class ServiceLivraison {
    Connection cnx = maConnexion.getInstance().getCnx();

   
 
   
    
    
    
    
    
 public void ajouter(Livraison l) {
        try {
            String requete = "INSERT INTO livraison (etat,destination,date) VALUES ('" + l.getEtat()+ "','" + l.getDestination()+ "', '"+ l.getDate()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Livraison ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    public void supprimer(Livraison l) {
        try {
            String requete = "DELETE FROM livraison WHERE id=" + l.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("livraison supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    public void modifier(Livraison l) {
        try {
            String requete = "UPDATE livraison SET date='" + l.getDate() + "',etat='" + l.getEtat()+ "', destination ='"+l.getDestination()+"' WHERE id=" + l.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Livraison modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Livraison> afficher() {
        List<Livraison> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM livraison";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                list.add(new Livraison(rs.getInt(1),rs.getString(3), rs.getDate(2).toString(),rs.getString(4)));
               // list.add(new Livreur(rs.getInt(1), rs.getString(2), rs.getString("prenom")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
    
    
    
    
    
}
