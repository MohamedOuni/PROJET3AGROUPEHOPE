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


/**
 *
 * @author ouni
 */
public class TECHGATE_PIDEV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServiceCommentaire s=new ServiceCommentaire();
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
        
        

        
        
        
        
    }
    
}
