/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piproject;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Commande;
import model.Livraison;
import model.Panier;
import model.commentaire;
import model.user;
import services.PostService;
import services.ServiceCommande;
import services.ServiceLivraison;
import services.ServicePanier;
import model.post;
import services.ServiceCommentaire;
import services.ServiceRate;
import services.serviceProduit;
import com.github.javafaker.Faker;
/**
 *
 * @author ouni
 */
public class Piproject extends Application {
    public static int userId=18;
    public static String nom="";
    public static float price=0;
    public static String dest="";
    @Override
    public void start(Stage primaryStage) {
            /*Button btn = new Button();
            btn.setText("Say 'Hello World'");
            btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            System.out.println("Hello World!");
            }
            });*/
            
            //System.out.println((new ServicePost()).afficherpost());
    
            Parent root;
    try {
        
        
                root = FXMLLoader.load(getClass().getResource("/back/dashboard.fxml"));
             Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
             
                     
                Stage stage = new Stage();
             stage.initModality(Modality.WINDOW_MODAL);
                
                stage.setTitle("initial login");
                Scene scene = new Scene(root);
               
                stage.setScene(scene);
               stage.showAndWait();
               
        } catch (IOException ex) {
            ex.getMessage();
        }
    
    }
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
