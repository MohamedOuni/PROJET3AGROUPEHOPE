/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import interfaces.ListenerInterface;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.commentaire;
import services.ServiceCommande;
import services.ServiceCommentaire;

/**
 * FXML Controller class
 *
 * @author ouni
 */
public class ModifierCommentaireController implements Initializable {

    @FXML
    private Label labelAlert;
    @FXML
    private Button conCreateForm;
    @FXML
    private TextArea textPost;
    private commentaire comment;
    private ListenerInterface listener;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.conCreateForm.setOnAction((event) -> {
           if(textPost.getText().isEmpty()){
               labelAlert.setText("you have to fill this input");
               
           }
           else{
               this.comment.setComment(textPost.getText());
               System.out.println(comment);
               (new ServiceCommentaire()).Modifiercommentaire(comment);
               Stage stage = (Stage)this.textPost.getScene().getWindow();
               this.listener.onClickListener();
               stage.close();
           }
        });
                
        // TODO
    }
        public void setData(commentaire c,ListenerInterface listener){
            this.listener = listener;
            
            this.comment =c;

                this.textPost.setText(c.getComment());

        }    
        
    
}
