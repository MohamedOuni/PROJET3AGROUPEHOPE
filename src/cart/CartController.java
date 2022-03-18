/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.BiConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Commande;
import model.Produit;
import model.user;
import post.ForumsController;
import prod.ItemController;
import services.ServicePanier;
import services.serviceUser;
import shipping.CommandesController;

/**
 * FXML Controller class
 *
 * @author ouni
 */
public class CartController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private VBox products;
    private double prixTot;
    private String username ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        HashMap<Produit,Integer> panier = (new ServicePanier()).getFullCart(piproject.Piproject.userId);
        panier.forEach((t, u) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/cart/itemCart.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
            
                ItemCartController itemController = fxmlLoader.getController();
                itemController.setData(t,u);
                products.getChildren().add(anchorPane);
                
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
              //  Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
            
            
        
        });
        
        
        
           
        
        // TODO
    }   
    public void refresh(){
        this.products.getChildren().clear();
     
        
        
    }

    @FXML
    private void onPasserCommande(ActionEvent event) {
        HashMap<Produit,Integer> map = (new ServicePanier()).getFullCart(piproject.Piproject.userId);
        prixTot=0;
        map.forEach(new BiConsumer<Produit, Integer>() {
            @Override
            public void accept(Produit t, Integer u) {
                prixTot += t.getPrix()*u;
            }
        });
          try {
              List<user> list = (new serviceUser()).afficherUser();
              
              
              
              list.forEach((t) -> {
                  if(t.getId_user() == piproject.Piproject.userId){
                      username = t.getNom();
                      
                      
                  }
              });
                System.out.println(username);
       //       commandesController.setData(username, (float) prixTot);
            piproject.Piproject.nom = username;
            piproject.Piproject.price = (float) prixTot;
            
              
              FXMLLoader fXMLLoader = new FXMLLoader();
            AnchorPane  root = fXMLLoader.load(getClass().getResource("/shipping/commandes.fxml"));
              CommandesController commandesController = fXMLLoader.getController();
         
              
              
            
            
            
            Stage stage = new Stage();
            stage.setTitle("");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest((ev) -> {
                
                refresh();
            });
            
        } catch (IOException ex) {
            Logger.getLogger(ForumsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
      //  Commande c = new Commande(0,prixTot, adresse, date_cmd, methode_pay, expidition, 0, 0);
        
        
    
     
        
        
        
    }
    
}
