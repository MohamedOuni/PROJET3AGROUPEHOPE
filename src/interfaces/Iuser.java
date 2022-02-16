/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.List;
import model.user;

/**
 *
 * @author khouloud
 */
public interface Iuser {
    public void ajouterUser(user u);
     public List<user> afficherUser();
      public void supprimerUser( int id);
       public void modifierUser(user u);
    
}
