/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import interfaces.MylistenerComment;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.commentaire;
import model.user;
import services.serviceUser;

/**
 * FXML Controller class
 *
 * @author ouni
 */
public class ItemCommentController implements Initializable {

    @FXML
    private Label username;
    @FXML
    private Label text;
    private commentaire comment;
    private MylistenerComment delete;
    private MylistenerComment update;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.supprimer.setOnAction((event) -> {
            this.delete.onClickListenerCommande(comment);
        });
        this.modifier.setOnAction((event) -> {
            this.update.onClickListenerCommande(comment);
            
        });
                
        // TODO
    }    
    public void setData(commentaire c,MylistenerComment supprimer,MylistenerComment modifier ){
        
        List<user> list = (new serviceUser()).afficherUser();
        String username = list.stream().filter((t) -> {
            //return false; //To change body of generated lambdas, choose Tools | Templates.
        return t.getId_user()==c.getId_user();
        }).findFirst().orElse(new user("", " ","", "","")).getNom();
        this.username.setText(username);
        this.text.setText(c.getComment());
        System.out.println(list);
        this.comment  = c;
        this.update = modifier;
        this.delete = supprimer;
        
        
    }
    
    
}
