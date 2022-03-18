/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back;

import interfaces.MyListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.Livraison;
import Livraison.ModifierLivraisonController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ouni
 */
public class ItemLivraisonController implements Initializable {

    @FXML
    private Label destination;
    @FXML
    private Label date;
    @FXML
    private Label etat;
    private Livraison livraison;
    private MyListener supprimer;
    private MyListener modifier;
    private MyListener refresh; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    public void setData(Livraison livraison,MyListener modifier,MyListener supprimer,MyListener refersh ){
        this.modifier = modifier;
        this.supprimer = supprimer;
        this.livraison = livraison;
        this.refresh = refersh;
        this.destination.setText(livraison.getDestination());
        this.etat.setText(livraison.getEtat());
        this.date.setText(livraison.getDate());
      
      
        
        
    }

    @FXML
    private void modifierLivraison(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Livraison/modifierLivraison.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            
            ModifierLivraisonController itemController = fxmlLoader.getController();
            
          
//        FXMLLoader fxmlLoader = new My
            itemController.setData(livraison,refresh);
            Scene scene = new Scene(anchorPane);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        
            
            
        } catch (IOException ex) {
            Logger.getLogger(ItemLivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }

    @FXML
    private void supprimerLivraison(ActionEvent event) {
       supprimer.onClickListener(livraison);
    }
    
    
}
