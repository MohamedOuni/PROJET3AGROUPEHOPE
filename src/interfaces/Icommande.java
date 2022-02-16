/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.Commande;

/**
 *
 * @author bureau
 */
public interface Icommande {
    //Add
    public void ajouterCommande(Commande c);
    public void ajouterCommande2(Commande c);
    
    //List
    public List<Commande> afficherCommande();
}

