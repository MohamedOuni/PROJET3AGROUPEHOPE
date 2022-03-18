/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shipping;

import Livraison.AjouterLivraisonController;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Commande;
import services.ServiceCommande;
import services.ServicePanier;


/**
 * FXML Controller class
 *
 * @author ouni
 */
public class CommandesController implements Initializable {

    @FXML
    private Label username;
    @FXML
    private Label prixTot;
    @FXML
    private Label alertLabel;
    @FXML
    private TextField destination;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setData();
        this.alertLabel.setVisible(false);
      
    }    
    public void setData(){
        this.username.setText(piproject.Piproject.nom);
         this.prixTot.setText(piproject.Piproject.price+"");
        
        
    }

    @FXML
    private void onPasserCommande(ActionEvent event) {
        if(!this.destination.getText().isEmpty()){
              DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
                LocalDateTime now = LocalDateTime.now();
                
                
               // Commande commande = new Commande
                        //    (int id_cmd, int tel, double montant_tot, String adresse, String date_cmd, String methode_pay, String expidition, int id_user, int id_produit)
            Commande commande = new Commande(0,0, piproject.Piproject.price, "", now.toString(), "", now.toString(), piproject.Piproject.userId, 3);
                (new ServicePanier()).deletePanier(piproject.Piproject.userId,0);
            
                (new ServiceCommande()).ajouterCommande2(commande);
                Stage stage = (Stage)this.alertLabel.getScene().getWindow();
                stage.close();
                
            
        }
        else{
            this.alertLabel.setVisible(true);
            this.alertLabel.setText("! vous devez remplir ce champs");
            
        }
        
        
        
    }

    @FXML
    private void onLivrason(ActionEvent event) {
        if(!this.destination.getText().isEmpty()){
            try {  
                piproject.Piproject.dest = this.destination.getText();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDateTime now = LocalDateTime.now();
                
                
                // Commande commande = new Commande
                //    (int id_cmd, int tel, double montant_tot, String adresse, String date_cmd, String methode_pay, String expidition, int id_user, int id_produit)
                Commande commande = new Commande(0,0, piproject.Piproject.price, "", now.toString(), "", now.toString(), piproject.Piproject.userId, 3);
                (new ServicePanier()).deletePanier(piproject.Piproject.userId,0);
            
                (new ServiceCommande()).ajouterCommande2(commande);
                FXMLLoader fXMLLoader = new FXMLLoader();
                AnchorPane  root = fXMLLoader.load(getClass().getResource("/Livraison/ajouterLivraison.fxml"));
                AjouterLivraisonController commandesController = fXMLLoader.getController();
                
                
                
                
                
                
                Stage stage = new Stage();
                stage.setTitle("");
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                 
                stage.setOnCloseRequest((e) -> {
                        Stage stag = (Stage)destination.getScene().getWindow();
                        stage.close();
                    
                });
            } catch (IOException ex) {
                Logger.getLogger(CommandesController.class.getName()).log(Level.SEVERE, null, ex);
            }
     
            
        }
        else{
            this.alertLabel.setVisible(true);
            this.alertLabel.setText("! vous devez remplir ce champs");
            
        }
    }
    
}
