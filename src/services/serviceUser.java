/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import util.maConnexion;
import interfaces.Iuser;
import model.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khouloud
 */
public class serviceUser implements Iuser{

    //var
    Connection cnx = maConnexion.getInstance().getCnx();
   
 
    @Override
     public void ajouterUser(user u) {
        
        String request = "INSERT INTO `user`(`nom`, `prenom`, `email`, `password`,`role`) VALUES ( '"+u.getNom()+"','"+u.getPrenom()+"','"+u.getEmail()+"','"+u.getPassword()+"','"+u.getRole()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("user ajoutee avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void modifierUser(user u) {
         try{
        
       String query="UPDATE `user` SET `nom`='"+u.getNom()
               +"',`prenom`='"+u.getPrenom()
               +"',`email`='"+u.getEmail()
               +"',`password`='"+u.getPassword()
               +"' WHERE id_user="+u.getId_user();
        Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Done. user bien modifier ");
        }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }     
    }

    @Override
    public List<user> afficherUser() {
      List<user> users = new ArrayList<>();
        
        String query = "SELECT * FROM user";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
               users.add(new user(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(4),rs.getString(5) ));
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return users;
    
    }

    @Override
    public void supprimerUser(int id) {
       
        try{
    String query="DELETE FROM user WHERE id_user="+id;
    Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Done user bien supprime ");
    }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }
    }
}
    
