/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Commande;
import util.maConnexion;
import interfaces.Icommande;
import java.sql.Date;

/**
 *
 * @author bureau
 */
public class ServiceCommande implements Icommande{
    
    //var
    Connection cnx = maConnexion.getInstance().getCnx();
    
    
    
    public void modifierCommande(Commande c) {
     try{
        String req = "UPDATE `commande` SET            `tel`='" +  +c.getTel()
                                                   + "',`adresse`='" + c.getAdresse()
                                                   + "',`methode_pay`='" + c.getMethode_pay()
                                                   + "' where id_cmd=" + c.getId_cmd() ;   
          Statement ps = cnx.createStatement();
    ps.executeUpdate(req);
        System.out.println("Done! Commande bien modifiée ");
        }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }       }


    public void supprimerCommande(Commande c) {
     
     try (PreparedStatement ps = cnx.prepareStatement("DELETE FROM commande WHERE  id_cmd = ?")
) {
    ps.setInt(1,c.getId_cmd());

    if (ps.executeUpdate() > 0)
        System.out.println("stock with id_cmd = "+c+" deleted successfully.");
    else
        System.out.println("Record not found.");
}       catch (SQLException ex) {
          ex.printStackTrace();        }   

    
     }
    


    @Override
    public void ajouterCommande(Commande c) {
        
        String request = "INSERT INTO `commande`(`tel`, `montant_tot`, `adresse`,`date_cmd`,`method_pay`,`expidition`,`id_user`,`id_panier`) VALUES ('"+c.getTel()+"',"+c.getMontant_tot()+",'"+c.getAdresse()+"'"+c.getDate_cmd()+"',"+c.getMethode_pay()+",'"+c.getExpidition()+"')"+c.getId_user()+"',"+c.getId_produit()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("Commande ajoutee avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public List<Commande> afficherCommande() {
        List<Commande> commandes = new ArrayList<>();
        
        String query = "SELECT * FROM commande";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
               commandes.add(new Commande(rs.getInt("id_cmd"),rs.getInt("tel"), rs.getDouble("montant_tot"), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt("id_user"),rs.getInt("id_produit")));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return commandes;
    }

    @Override
    public void ajouterCommande2(Commande c) {
        
        String Req = "INSERT INTO `commande`(`tel`, `montant_tot`, `adresse`,`date_cmd`,`methode_pay`,`expidition`,`id_user`,`id_produit`) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setInt(1, c.getTel());
            ps.setDouble(2, c.getMontant_tot());
            ps.setString(3, c.getAdresse());
            ps.setString(4,c.getDate_cmd());
            ps.setString(5, c.getMethode_pay());
            ps.setString(6, c.getExpidition());
            ps.setInt(7, c.getId_user());
            ps.setInt(8, c.getId_produit());
            ps.execute();
            System.out.println(" Commande ajoutée avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
