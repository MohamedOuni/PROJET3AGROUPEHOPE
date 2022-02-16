/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.commentaire;

/**
 *
 * @author ouni
 */
public interface Icommentaire {
 //Add
    public void ajoutercommentaire(commentaire c);
    
    //List
    public List<commentaire> affichercommentaire(); 
    //delete
    public void SupprimerParID(int id);
    // Edit 

    /**
     *
     * @param 
     */
    public void Modifiercommentaire (commentaire c);
}