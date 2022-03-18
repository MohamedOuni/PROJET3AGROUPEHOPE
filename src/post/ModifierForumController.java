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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.post;
import services.PostService;

/**
 * FXML Controller class
 *
 * @author ouni
 */
public class ModifierForumController implements Initializable {

    @FXML
    private Label labelAlert;
    @FXML
    private Button conCreateForm;
    @FXML
    private TextField image;
    @FXML
    private Button onImportImage;
    @FXML
    private TextArea textPost;
    private post post;
    private ListenerInterface listener;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.conCreateForm.setOnAction((event) -> {
          if(this.textPost.getText().isEmpty()){
              labelAlert.setText("you have the text input");
              
          }
          else{
                    if(this.image.getText()==null){
              post.setImage("");
                  
                  
              }
              else{
              post.setImage(this.image.getText());
                  
              }
              post.setPost(this.textPost.getText());
              System.out.println(this.textPost.getText());
              (new PostService()).Modifierpost(post);
              Stage stage = (Stage)this.image.getScene().getWindow();
              this.listener.onClickListener();
              stage.close();
              
              
          }
       });
// TODO
    }    
    public void setData(post p ,ListenerInterface listerener){
        this.post = p;
        this.image.setText(p.getImage());
        this.textPost.setText(p.getPost());
        this.listener= listerener;
        
        
        
    }
    
    
    
}
