/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import interfaces.MyListener;
import interfaces.MyListenerForum;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.post;
import model.user;


/**
 * FXML Controller class
 *
 * @author ouni
 */
public class ItemforumsController implements Initializable {

    @FXML
    private Label image;
    @FXML
    private Label username;
    @FXML
    private Label date;
    private post post;
    private MyListenerForum delete;
    private MyListenerForum update;
    @FXML
    private Button onSupprimerForum;
    @FXML
    private Button onModifierForum;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
            this.onSupprimerForum.setOnAction((event) -> {
               
               delete.onClickListenerCommande(post);
            });
            this.onModifierForum.setOnAction((event) -> {
               update.onClickListenerCommande(post);
            });
    
    
    }
    public void setData(user u,post p,MyListenerForum delete,MyListenerForum update){
        if(p.getId_user()!=piproject.Piproject.userId){
            
        this.onModifierForum.setVisible(false);
        this.onSupprimerForum.setVisible(false);
        }
        this.post = p;
        this.image.setText(u.getNom());
        this.username.setText(p.getPost());
        this.date.setText(p.getDate_post());
        this.delete = delete;
        this.update = update;
        
        
        
        
        
        
        
        
        
    }
    
    
}
