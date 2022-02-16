/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techgate_pidev;

import services.ServicePanier;
import services.serviceProduit;
import model.Panier;
import model.Produit;
import model.commentaire;
import model.post;
import services.ServicePost;
import services.ServiceCommentaire;
import model.Offre;
import model.Reclamation;
import Services.Service_Reclamation;
import Services.Service_offre;
import model.Commande;
import services.ServiceCommande;


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
       // Reclamation r1 = new Reclamation(2, "ouni", 12, "mal services !!!!");
        
        //Service
       // Service_Reclamation sp = new Service_Reclamation();
        
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
       // Offre o1 = new Offre(1, 50, 1, "15/02/2022","17/02/2022");
       // Offre o4 = new Offre(4, 50, 1, "15/02/2022","17/02/2022");
        
      //Service
      //Service_offre so = new Service_offre ();
      
      //Ajouter
     // so.ajouterOffre(o4);
     
     //Afficher 
     //  System.out.println(so.afficherOffre());
      
      //Delete 
    //  so.SupprimerOffre(1);
     
     //Edit
   //  so.ModifierOffre(40, "18/02/2022", "19/02/2022", 1, 1);
   
   
   
   //wejdene
     //Commande
       // Commande c1 = new Commande(21456789,215,"22 rue el ghazela tunis","2022-02-16","en ligne","2022-02-22",12,12);
        //Commande c2 = new Commande(1,58137341,"sousse rue safsaf","a la livraison");
        //Service
        //Service
        //ServiceCommande sc = new ServiceCommande();
        
        //Ajouter
       // sc.ajouterCommande2(c1);
        
        //Afficher
        //System.out.println(sc.afficherCommande());
       //Delete 
       //sc.supprimerCommande(c2);
     
       //Edit
       //sc.modifierCommande(c2);
       
       
       
       //Rania
           serviceProduit sp = new serviceProduit();
        
        ServicePanier s= new ServicePanier();
        
          Panier s1 = new Panier(15,12,9999);
          Panier s3 = new Panier(15,12,299);
     
         //s.ajouterpanier(s1);
         //s.ajouterpanier(s3);
        
         //s.modifierpanier(s3);
        
      //s.supppanier(s1);
        
    
        
        //Afficher
        System.out.println( s. afficherpanier());
     
         

// TODO code application logic here
 //Produit
        Produit p12 = new Produit("produit1",30, 30f,"ranou" );
          Produit p2_m = new Produit(12,"TELE",111, 55,"ouni" );
        //Service
        
        //Ajouter
     
          //sp.ajouterProduit(p12);
        //sp.ajouterProduit(p2);
        
      
        
        //Afficher
       //System.out.println(sp.afficherProduit());
      
       //supprimer
     // sp.suppProduit(p2_m);
      
      //EDit
     // sp.Modifierproduit(p2_m);

       
       

        
        
        
        
    }
    
}
