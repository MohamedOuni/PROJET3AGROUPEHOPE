/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back;

import interfaces.MyListener;
import interfaces.MyListenerCommande;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Livraison;
import services.ServiceLivraison;
import model.Commande;
import services.ServiceCommande;
/**
 * FXML Controller class
 *
 * @author ouni
 */
public class CommandesController implements Initializable {

    @FXML
    private VBox livraisons;
    private MyListenerCommande supprimer;
    private MyListenerCommande modifier;
    private MyListenerCommande referesh;
        

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          List<Commande> list = (new ServiceCommande()).afficherCommande();
        if (!list.isEmpty()){
                supprimer = new MyListenerCommande() {
                    @Override
                    public void onClickListenerCommande(Commande liv) {
                        deleteCommande(liv);
                      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
               
                         referesh = new MyListenerCommande() {
                    @Override
                    public void onClickListenerCommande(Commande liv) {
                        modifierCommande(liv);
                     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
               
            };


            
        }
            list.forEach((t) -> {
                try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/back/itemCommande.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            
            ItemCommandeController itemController = fxmlLoader.getController();
            itemController.setData(t,supprimer,referesh);
            livraisons.getChildren().add(anchorPane);
        } catch (IOException ex) {
                    System.out.println(ex.getMessage());
       //     Logger.getLogger(LivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
                
                
                
            });
      
  
    }
    public void refesh(){
                  List<Commande> list = (new ServiceCommande()).afficherCommande();
        if (!list.isEmpty()){
                supprimer = new MyListenerCommande() {
                    @Override
                    public void onClickListenerCommande(Commande liv) {
                        deleteCommande(liv);
                      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
               
                         referesh = new MyListenerCommande() {
                    @Override
                    public void onClickListenerCommande(Commande liv) {
                        modifierCommande(liv);
                     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
               
            };


            
        }
            list.forEach((t) -> {
                try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/back/itemCommande.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            
            ItemCommandeController itemController = fxmlLoader.getController();
            itemController.setData(t,supprimer,referesh);
            livraisons.getChildren().add(anchorPane);
        } catch (IOException ex) {
                    System.out.println(ex.getMessage());
       //     Logger.getLogger(LivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
                
                
                
            });

        
        
    }
    public void deleteCommande(Commande c){
        System.out.println("supp");
        (new ServiceCommande()).supprimerCommande(c);
        livraisons.getChildren().clear();
        refesh();
    }
     public void modifierCommande(Commande c){
         System.out.println("modif");  
        livraisons.getChildren().clear();
    
         refesh();
        
    }
    
    
    
}
