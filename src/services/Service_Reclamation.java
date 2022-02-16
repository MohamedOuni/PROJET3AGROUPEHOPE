/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IReclamation;
import model.Reclamation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.maConnexion;

/**
 *
 * @author BEN CHEIKH RABIE
 */
public class Service_Reclamation implements IReclamation{
        //var
    Connection cnx = maConnexion.getInstance().getCnx();
    
    public void ajouterReclamation(Reclamation r) {
        
        String query = "INSERT INTO `reclamation`(`id_rec`, `nom`, `id_user`, `msg`) VALUES ('"+r.getId_rec()+"','"+r.getNom_client()+"',"+r.getId_user() +",'"+r.getMsg()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Reclamation ajoutee avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void SupprimerReclamation(int id_rec){
        String query="DELETE FROM `reclamation` WHERE id_rec="+id_rec;
         try{      
           Statement st = cnx.createStatement();
           st.executeUpdate(query);
           System.out.println("Reclamation bien supprime ");
             }catch(SQLException e){
        System.out.println(e.getMessage());
            } 
    }
    
    
     public void ModifierReclamation (Reclamation r){
        try{
            String query="UPDATE `reclamation` SET `msg`='"+r.getMsg() 
               +"',`id_rec`='"+r.getId_rec()
               +"',`nom`='"+r.getNom_client()
               +"',`id_user`='"+r.getId_user()
               +"',`msg`='"+r.getMsg()
               +"' WHERE id_rec="+r.getId_rec();
        Statement st = cnx.createStatement();
        st.executeUpdate(query);
        System.out.println("Reclamation bien modifier ");
        }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }  
   }
    
    
    
    
    public List<Reclamation> afficherReclamation() {
        List<Reclamation> reclamations = new ArrayList<>();
        
        String query = "SELECT * FROM reclamation";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                reclamations.add(new Reclamation(rs.getInt("id_rec"), rs.getString(2), rs.getInt("id_user"), rs.getString(4)));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return reclamations;
    }

    @Override
    public void ajouterReclation(Reclamation r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
