/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.Ipanier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Panier;
import model.Produit;
import util.maConnexion;

/**
 *
 * @author rania
 */
public class ServicePanier implements Ipanier{
Connection cnx = maConnexion.getInstance().getCnx();
    @Override
    public void ajouterpanier(Panier s) {
        String req = "insert into panier(id_produit,id_user,quantite) values(?,?,?)";

          try {
            PreparedStatement ps = cnx.prepareStatement(req);         
    
    
            ps.setInt(1, s.getId_produit());
           
            ps.setInt(2, s.getId_user());
            ps.setInt(3, s.getQuantite());

            ps.execute();
            System.out.println(" produit ajoutee avec succes");
        } catch (SQLException ex) {
              System.out.println(ex.getMessage());
        }
    }
  
    @Override
    public void modifierpanier(Panier s) {
     try{
        String req = "UPDATE panier SET            `id_user`='" +  +s.getId_user()
                                               
                                                   + "',`quantite`='" + s.getQuantite()
                                                   + "' where id_produit=" + s.getId_produit() ;  
          Statement ps = cnx.createStatement();
    ps.executeUpdate(req);
        System.out.println("Panier bien modifier ");
        }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }       } 
    
    
    
    
    

    @Override
    public void supppanier(Panier s) {
     
     try (PreparedStatement ps = cnx.prepareStatement("DELETE FROM panier WHERE  id_produit = ?")
) {
    ps.setInt(1,s.getId_produit());

    if (ps.executeUpdate() > 0)
        System.out.println("stock with id_produit = "+s+" deleted successfully.");
    else
        System.out.println("Record not found.");
}       catch (SQLException ex) {
          ex.printStackTrace();        }   

    
    
    
    }

    @Override
    public List<Panier> afficherpanier() {
    List<Panier> pan = new ArrayList<>();
        
        String req = "SELECT * FROM panier";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                pan.add(new Panier(rs.getInt("id_produit"), rs.getInt(2), rs.getInt(3)));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return pan; }
     public HashMap<Produit,Integer> getFullCart(int user_id){
        HashMap<Produit,Integer> map = new HashMap();
         String req = "select p.nom_produit,p.id_produit,p.quantite as produit_quan,p.prix,p.categorie,pan.quantite as cart_quantity from produit p inner join panier pan on p.id_produit=pan.id_produit where pan.id_user="+user_id;
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Produit p = new Produit(rs.getInt("id_produit"), rs.getString("nom_produit"), rs.getInt("produit_quan"),rs.getFloat("prix"),rs.getString("categorie"));
                int quantity = rs.getInt("cart_quantity");
                if(map.containsKey(p)){
                    map.put(p,map.get(p)+ quantity);
                }
                else{
                    map.put(p,quantity);
                    
                }
                
            }
            return map;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return map;
       
        
        
        
        
    }
   public void updateCart(Panier p){
       String req2 = "delete from panier where id_user=? and id_produit=?";

        String req = "insert into panier(id_produit,id_user,quantite) values(?,?,?)";

          try {
            PreparedStatement ps = cnx.prepareStatement(req); 
            PreparedStatement ps2 = cnx.prepareStatement(req2);         
   
    
    
            ps.setInt(1, p.getId_produit());
           
            ps.setInt(2, p.getId_user());
            ps.setInt(3, p.getQuantite());

            ps.execute();
            
            ps2.execute();
            System.out.println(" panier modifier avec suscces");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
          
   }
   public void deletePanier(int user_id,int prod_id){
        String req2;
       if(prod_id == 0){
           
            try {
                req2 = "delete from panier where id_user=?";
                PreparedStatement ps2 = cnx.prepareStatement(req2);
                
                ps2.setInt(1, user_id);
                
                
                
                ps2.execute();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                //Logger.getLogger(ServicePanier.class.getName()).log(Level.SEVERE, null, ex);
            }
   
           
       }
       else{
            try {
                req2 = "delete from panier where id_user=? and id_produit=?";
                PreparedStatement ps2 = cnx.prepareStatement(req2);
                
                ps2.setInt(1, user_id);
                
                ps2.setInt(2, prod_id);
                
                
                ps2.execute();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                //Logger.getLogger(ServicePanier.class.getName()).log(Level.SEVERE, null, ex);
            }
   
       }
       System.out.println("deleted with success");
        
        
     
       
       
       
   }
   
   
}

  

