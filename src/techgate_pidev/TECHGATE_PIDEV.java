/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techgate_pidev;

import model.commentaire;
import model.post;
import services.ServicePost;
import services.ServiceCommentaire;
import model.Offre;
import model.Reclamation;
import Services.Service_Reclamation;
import Services.Service_offre;


/**
 *
 * @author ouni
 */
public class TECHGATE_PIDEV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /* ServiceCommentaire s=new ServiceCommentaire();
        commentaire c = new commentaire("ouniouni","mohamedmohamed",12,21);
       commentaire c1 = new commentaire(6,"mohamed","ouni");
        //s.ajoutercommentaire(c);
        //System.out.println(s.affichercommentaire());
        //s.SupprimerParID(6);
        //s.Modifiercommentaire(c1);
        ServicePost p=new ServicePost();
        post ps= new post("hi","hello",4,12);
        //post ps1 = new post(19,"ouni","mohamed",4);
        //p.ajouterpost(ps);
        //p.SupprimerParID(18);
        //p.Modifierpost(ps1);
        System.out.println(p.afficherpost());
       */
       
       
       
       
       // Rabie 
        //Reclamations//
        Reclamation r1 = new Reclamation(2, "ouni", 12, "mal services !!!!");
        
        //Service
        Service_Reclamation sp = new Service_Reclamation();
        
        //Ajouter
       // sp.ajouterReclamation(r1);
        
        //Afficher
       // System.out.println(sp.afficherReclamation());
        
        //Delete
        //sp.SupprimerReclamation(3);
       
       //Modifier 
      // sp.ModifierReclamation(r1); 
      
 /////////////////////////////////////////////////////////////////////////////////////////
      //offres//
        Offre o1 = new Offre(1, 50, 1, "15/02/2022","17/02/2022");
        Offre o4 = new Offre(4, 50, 1, "15/02/2022","17/02/2022");
        
      //Service
      Service_offre so = new Service_offre ();
      
      //Ajouter
     // so.ajouterOffre(o4);
     
     //Afficher 
     //  System.out.println(so.afficherOffre());
      
      //Delete 
    //  so.SupprimerOffre(1);
     
     //Edit
   //  so.ModifierOffre(40, "18/02/2022", "19/02/2022", 1, 1);
     
       
       
       

        
        
        
        
    }
    
}
