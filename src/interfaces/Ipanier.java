/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.Panier;


/**
 *
 * @author rania
 */
public interface Ipanier {
    public void ajouterpanier(Panier s);
      public List<Panier> afficherpanier();
      public void modifierpanier(Panier s);
      public void supppanier(Panier s);
      
}