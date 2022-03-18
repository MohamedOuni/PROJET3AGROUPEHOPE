/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Produit;
import util.maConnexion;

/**
 *
 * @author rania
 */
public class serviceProduit {
    
    //var
    Connection cnx = maConnexion.getInstance().getCnx();


   
    public void ajouterProduit(Produit p) {
    
        
        String request = "INSERT INTO produit(`nom_produit`, `quantite`, `prix`, `categorie`) VALUES ('"+p.getNom_produit()+"','"+p.getQuantite()+"','"+p.getPrix()+"','"+p.getCategorie()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("Produit ajouté avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }


    public List<Produit> afficherProduit() {
        List<Produit> produit = new ArrayList<>();
        
        String query = "SELECT * FROM produit";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                produit.add(new Produit(rs.getInt("id_produit"), rs.getString(2), rs.getInt("quantite"), rs.getFloat("prix"), rs.getString(5)));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return produit;
    }
   
    public void suppProduit(Produit p) {
        
         try (PreparedStatement ps = cnx.prepareStatement("DELETE FROM produit WHERE  nom_produit = ?")
) {
    ps.setString(1,p.getNom_produit());

    if (ps.executeUpdate() > 0)
        System.out.println("produit with N_prod = "+p+" SUPPRIME.");
    else
        System.out.println("Produit non trouvé.");
}       catch (SQLException ex) {
          ex.printStackTrace();        }    }
    
    /**
     *
     * @param p
     */
    public void Modifierproduit (Produit p){
        try{
        
       String query="UPDATE `produit` SET `Nom_produit`='"+p.getNom_produit()
               
               +"',`quantite`='"+p.getQuantite()
               +"',`prix`='"+p.getPrix()
               +"',`categorie`='"+p.getCategorie()
               +"' WHERE `id_produit`="+p.getId_produit();
        Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Produit bien modifié ");
        }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }     
        }
}
