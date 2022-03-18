/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Icommentaire;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import model.commentaire;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import post.ForumsController;
import util.maConnexion;


/**
 *
 * @author ouni
 */
public class ServiceCommentaire {
//var
    Connection cnx = maConnexion.getInstance().getCnx();
    private String id_com;
    
    /**
     *
     * @param c
     */
    
    public void ajoutercommentaire(commentaire c) {
          if(c.getComment().contains("mauvais")|| c.getComment().contains("bonjour")||   c.getComment().contains("prix"))
        {
            System.out.println("votre commentaire n'est pas accépté");}
            else{
        
        String request = "INSERT INTO `commentaire`( `comment` ,  `id_user`, `id_post`) VALUES ('"+c.getComment()+"','"+c.getId_user()+"','"+c.getId_post()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("commentaire ajoutee avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    }
    
    public List<commentaire> affichercommentaire() {
        List<commentaire> commentaire = new ArrayList<>();
        
        String query = "SELECT * FROM commentaire";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
            commentaire.add(new commentaire(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4)));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return commentaire;
    }
    
    
    public void SupprimerParID(int id){
    try{
    String query="DELETE FROM `commentaire` WHERE id_com="+id;
    Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Done commentaire bien supprime ");
    }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }
    
    
    }
    
      public void Modifiercommentaire (commentaire c){
        try{
        
       String query="UPDATE `commentaire` SET `comment`='"+c.getComment()
               +"' WHERE id_com="+c.getId_com();
        Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Done commentaire bien modifier ");
        }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }    
      }
      public  List<commentaire> getComments(int post_id){
          
          List<commentaire> list = this.affichercommentaire();
          return list.stream().filter(t->t.getId_post()==post_id).collect(Collectors.toCollection(ArrayList<commentaire>::new));
      }
    
}
    
