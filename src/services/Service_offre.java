/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IOffre;
import model.Offre;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.maConnexion;

/**
 *
 * @author BEN CHEIKH RABIE
 */
public class Service_offre implements IOffre {
    //var
    Connection cnx = maConnexion.getInstance().getCnx();
    
    public void ajouterOffre(Offre o) {
        
        String query = "INSERT INTO `offre`(`id_offre`, `prc`, `id_produit`, `date_debut`, `date_fin`) VALUES ('"+o.getId_offre()+"','"+o.getPrc()+"','"+o.getId_prod() +"','"+o.getDate_debut()+"','"+o.getDate_fin()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Offre ajoutee avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    
    public void SupprimerOffre(int id_offre){
        String query="DELETE FROM `offre` WHERE id_offre="+id_offre;
         try{      
           Statement st = cnx.createStatement();
           st.executeUpdate(query);
           System.out.println("Offre bien supprime ");
             }catch(SQLException e){
        System.out.println(e.getMessage());
            } 
    }
    
    
     public void ModifierOffre (int prc,String db,String df,int id_prod, int id_offre){
        try{
            String query="UPDATE `offre` SET `prc`='"+prc
               +"',`date_debut`='"+db
               +"',`date_fin`='"+df
               +"',`id_produit`='"+id_prod
             //  +"',`id_offre`='"+o.getId_offre()
               +"' WHERE id_offre="+id_offre;
        Statement st = cnx.createStatement();
        st.executeUpdate(query);
        System.out.println("Offre bien modifier ");
        }catch(SQLException e){
        System.out.println(e.getMessage());
    
        }
     }
    
    
    public List<Offre> afficherOffre() {
        List<Offre> offres = new ArrayList<>();
        
        String query = "SELECT * FROM offre";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                offres.add(new Offre(rs.getInt("id_offre"), rs.getInt("prc"), rs.getInt("id_produit"), rs.getString(4), rs.getString(5)));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return offres;
    }
    
}
