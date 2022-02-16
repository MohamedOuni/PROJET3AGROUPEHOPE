/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.post;

/**
 *
 * @author ouni
 */
public interface Ipost {
    
 //Add
    public void ajouterpost(post p);
    
    //List
    public List<post> afficherpost(); 
    //delete
    public void SupprimerParID(int id_post);
    // Edit 

    /**
     *
     * @param p
     */
    public void Modifierpost (post p);
}

