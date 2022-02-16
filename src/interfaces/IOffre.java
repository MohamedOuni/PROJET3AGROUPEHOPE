/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import model.Offre;


/**
 *
 * @author BEN CHEIKH RABIE
 */
public interface IOffre {
    //Ajout
        public void ajouterOffre(Offre o);
       
    //delete
        public void SupprimerOffre(int id_offre);
     
    //Edit
        public void ModifierOffre(int prc,String db,String df,int id_prod, int id_offre);
    
        
        
      
}
