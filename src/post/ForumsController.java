/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;


import interfaces.ListenerInterface;
import interfaces.MyListenerForum;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.post;
import model.user;
import services.PostService;


/**
 * FXML Controller class
 *
 * @author ouni
 */
public class ForumsController implements Initializable {

    @FXML
    private VBox forms;
    private MyListenerForum supprimer;
    private MyListenerForum modifier;
    private ListenerInterface listener;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        HashMap<user,List<post>> list=(new PostService()).getAllForums();
        if(!list.isEmpty()){
            
        list.forEach((t, u) -> {
           u.forEach((m) -> {
               try {
                   FXMLLoader fxmlLoader = new FXMLLoader();
                   fxmlLoader.setLocation(getClass().getResource("/post/itemforums.fxml"));
                   AnchorPane anchorPane = fxmlLoader.load();
                   supprimer  = new MyListenerForum() {
                       @Override
                       public void onClickListenerCommande(post comment) {
                           delete(comment);
                                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                       }
                   };
                   modifier = new MyListenerForum() {
                       @Override
                       public void onClickListenerCommande(post comment) {
                           update(comment);
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                       }
                   };
                   ItemforumsController itemController = fxmlLoader.getController();
                   itemController.setData(t,m,supprimer,modifier);
                   forms.getChildren().add(anchorPane);
                              anchorPane.setOnMouseClicked((event) -> {
                    getCommentaires(m); 
                   });
             
               } catch (IOException ex) {
                  // Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
               }
               
               
           });
        });    
            
        } 
        
        
    }    
    public void getCommentaires(post post){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/post/comments.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            
            CommentsController commentController = fxmlLoader.getController();
            
            commentController.setData(post);
            Scene scene  = new Scene(anchorPane);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
            
            
            
            
 //           comme
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
          //  Logger.getLogger(ForumsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void refresh(){
        forms.getChildren().clear();
        
        HashMap<user,List<post>> list=(new PostService()).getAllForums();
        if(!list.isEmpty()){
            
        list.forEach((t, u) -> {
           u.forEach((m) -> {
               try {
                   FXMLLoader fxmlLoader = new FXMLLoader();
                   fxmlLoader.setLocation(getClass().getResource("/post/itemforums.fxml"));
                   AnchorPane anchorPane = fxmlLoader.load();
                   supprimer  = new MyListenerForum() {
                       @Override
                       public void onClickListenerCommande(post comment) {
                           delete(comment);
                                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                       }
                   };
                   modifier = new MyListenerForum() {
                       @Override
                       public void onClickListenerCommande(post comment) {
                           update(comment);
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                       }
                   };
                   ItemforumsController itemController = fxmlLoader.getController();
                   itemController.setData(t,m,supprimer,modifier);
                   forms.getChildren().add(anchorPane);
                              anchorPane.setOnMouseClicked((event) -> {
                    getCommentaires(m); 
                   });
             
               } catch (IOException ex) {
                  // Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
               }
               
               
           });
        });    
            
        }     
        
        
    }
    @FXML
    private void ajouterForum(ActionEvent event) {
               
    
        try {
            AnchorPane  root = FXMLLoader.load(getClass().getResource("/post/ajouterForum.fxml"));
            Stage stage = new Stage();
            stage.setTitle("ajouter forum");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest((e) -> {
            refresh();
            });
            
        } catch (IOException ex) {
            Logger.getLogger(ForumsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
                
                
    }
    
    private void delete(post p){
        
        (new PostService()).SupprimerParID(p.getId_post());
        refresh();
    }
    private void update(post p){
        System.out.println("update"+p);
        try {
            this.listener = new ListenerInterface() {
                @Override
                public void onClickListener() {
                    refresh();
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            FXMLLoader fXMLLoader = new FXMLLoader();
             fXMLLoader.setLocation(getClass().getResource("/post/modifierForum.fxml"));
            AnchorPane anchorpane =  fXMLLoader.load();
            ModifierForumController controller = fXMLLoader.getController();
            controller.setData(p,this.listener);
            Scene scene = new Scene(anchorpane);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest((event) -> {
                
               refresh();
            });
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(ForumsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
