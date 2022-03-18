/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Rate;
import util.maConnexion;
import model.post;

/**
 *
 * @author ouni
 */
public class ServiceRate {
    Connection cnx;
    public ServiceRate() {
    cnx = maConnexion.getInstance().getCnx();
    
    }
    
     public void ajouetrRate (Rate r){
        try{
        
       String query="INSERT INTO `rate`( `postId`, `rateValue`) VALUES ("+r.getPostId()+","+r.getRateValue()+")";
            Statement st = cnx.createStatement();
        st.executeUpdate(query);
        System.out.println("Done post bien modifier ");
        }catch(Exception e){
        System.out.println(e.getMessage());
    
    }     
        }
     
     
      public HashMap<post,Float> afficherReclamation() {
          HashMap<post,Float> map = new HashMap();
        
        String query = "SELECT p.id_post,p.post,p.id_user,p.date,p.image,sum(r.rateValue)/count(*) as value FROM rate r inner join post p on p.id_post=r.postId group BY p.id_post";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                post p = new post(rs.getInt(1), rs.getString(2), rs.getDate(4).toString(),rs.getInt(3),rs.getString(5));
                Float rateValue;
                //reclamations.add(new Reclamation(rs.getInt("id_rec"), rs.getString(2), rs.getInt("id_user"), rs.getString(4)));
                rateValue = rs.getFloat(6);
                map.put(p, rateValue);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return map;
    }
 //select u.nom,sum(r.rateValue) from user u inner join post p on u.id_user = p.id_user inner join rate r on r.postId = p.id_post group by p.id_user;
 
       public HashMap<String,Integer> getRatesByuser() {
          HashMap<String,Integer> map = new HashMap();
        
        String query = "select u.nom,sum(r.rateValue) from user u inner join post p on u.id_user = p.id_user inner join rate r on r.postId = p.id_post group by p.id_user;";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int rateValue = Math.round(rs.getFloat(2));
                String username = rs.getString(1);
                
                //reclamations.add(new Reclamation(rs.getInt("id_rec"), rs.getString(2), rs.getInt("id_user"), rs.getString(4)));
                
                map.put(username, rateValue);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return map;
    }

    
    
    
    
    
}
