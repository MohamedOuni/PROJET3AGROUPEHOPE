/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.post;
import services.PostService;

/**
 * FXML Controller class
 *
 * @author ouni
 */
public class AjouterForumController implements Initializable {

    @FXML
    private Button conCreateForm;
    @FXML
    private Button onImportImage;
    @FXML
    private Label labelAlert;
    @FXML
    private TextField image;
    @FXML
    private TextArea textPost;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelAlert.setVisible(false);
        conCreateForm.setOnAction((event) -> {
            if(!textPost.getText().isEmpty()){
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
                LocalDateTime now = LocalDateTime.now();  
                    System.out.println(now);  
                    post post;
                    if(!image.getText().isEmpty()){
                    post = new post(0,textPost.getText(),now.toString(),piproject.Piproject.userId,image.getText());
                    
                        
                    }
                    else{
                         post = new post(0,textPost.getText(),now.toString(),piproject.Piproject.userId,"");
                
                    }
                    
                
                 
                (new PostService()).ajouterpost(post);
                
                
                
                
                
                
                
                
                
                
            }
              else{
                labelAlert.setVisible(true);
              labelAlert.setText("you have to write somtthing");
                        
               }
            
        });
        onImportImage.setOnAction((event) -> {
           FileChooser filechooser = new FileChooser();
               
                Stage stage = (Stage)this.image.getScene().getWindow();
                File file = filechooser.showOpenDialog(stage);
        
                if (file != null) {
                    String s= "";
              //      s= file.getAbsolutePath().split("\");
                   
                   System.out.println(file.getAbsoluteFile());
                   
                   image.setText(file.getAbsoluteFile().toString());
              
                
                }    
            
         
        });
        
        
        
        // TODO
    }    
    
}
