/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back;

import Livraison.ModifierLivraisonController;
import interfaces.MyListener;
import interfaces.MyListenerCommande;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Commande;

/**
 * FXML Controller class
 *
 * @author ouni
 */
public class ItemCommandeController implements Initializable {

    @FXML
    private Label destination;
    @FXML
    private Label date;
   
        private Commande commande;
    private MyListenerCommande supprimer;
    private MyListenerCommande refresh; 
    @FXML
    private Label montant;
    @FXML
    private Label userId;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        public void setData(Commande c,MyListenerCommande supprimer,MyListenerCommande refersh ){
       
        this.supprimer = supprimer;
        this.commande =c;
        this.refresh = refersh;
        this.destination.setText(c.getAdresse());
        this.date.setText(c.getDate_cmd()+"");
        this.montant.setText(c.getMontant_tot()+"Dt");
        this.userId.setText(c.getId_user()+"");
        
        
        
    }

    

    @FXML
    private void modifierLivraison(ActionEvent event) {
           try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/back/ModifierCommnade.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            
            ModifierCommnadeController itemController = fxmlLoader.getController();
            
          
//        FXMLLoader fxmlLoader = new My
            itemController.setData(commande,refresh);
            Scene scene = new Scene(anchorPane);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        
            
            
        } catch (IOException ex) {
               System.out.println(ex.getMessage());
        //    Logger.getLogger(ItemLivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
        
    }

    @FXML
    private void supprimerLivraison(ActionEvent event) {
        this.supprimer.onClickListenerCommande(commande);
    }
    
}
