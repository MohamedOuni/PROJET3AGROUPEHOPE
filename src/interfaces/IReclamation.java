/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import model.Reclamation;

/**
 *
 * @author BEN CHEIKH RABIE
 */
public interface IReclamation {
        //Ajout
        public void ajouterReclation(Reclamation r);
      
        //delete
        public void SupprimerReclamation(int id_rec);
        
        //Edit
        public void ModifierReclamation(Reclamation r);
    

}
