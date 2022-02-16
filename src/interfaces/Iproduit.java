/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.Produit;

/**
 *
 * @author rania
 */
public interface Iproduit {
    //Add
    public void ajouterProduit(Produit p);
    
    //List
    public List<Produit> afficherProduit();
    
    //supprimer
    public void suppProduit(Produit p);
    //edit 
    public void Modifierproduit (Produit p);
}

