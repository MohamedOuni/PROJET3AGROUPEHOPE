/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Ipost;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.post;
import util.maConnexion;


/**
 *
 * @author ouni
 */

public class ServicePost implements Ipost {
    
    //var
    Connection cnx = maConnexion.getInstance().getCnx();

    
    @Override
    public void ajouterpost(post p) {
        String request = "INSERT INTO `post`( `post`,`date_post`,`like_nbr`, `id_user`) VALUES ('"+p.getPost()+"','"+p.getDate_post()+"','"+p.getLike_nbr()+"','"+p.getId_user()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("post ajoutee avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    

    @Override
    public void SupprimerParID(int id_post){
    try{
    String query="DELETE FROM `post` WHERE id_post="+id_post;
    Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Done post bien supprime ");
    }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }
    
    
    };
    @Override
        public void Modifierpost (post p){
        try{
        
       String query="UPDATE `post` SET `post`='"+p.getPost()+"',`date_post`='"+p.getDate_post()+"'  WHERE id_post="+p.getId_post()+"";
        Statement st = cnx.createStatement();
        st.executeUpdate(query);
        System.out.println("Done post bien modifier ");
        }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }     
        }

    @Override
    public List<post> afficherpost() {
          List<post> post = new ArrayList<>();
        
        String query = "SELECT * FROM post";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                post.add(new post(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5) ));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
          return post;
    }


  

}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

