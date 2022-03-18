/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import interfaces.ListenerInterface;
import interfaces.MyListener;
import interfaces.MyListenerCommande;
import interfaces.MylistenerComment;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Rate;
import model.commentaire;
import org.controlsfx.control.Rating;
import model.post;
import services.PostService;
import services.ServiceCommande;
import services.ServiceCommentaire;
import services.ServiceRate;
/**
 * FXML Controller class
 *
 * @author ouni
 */
public class CommentsController implements Initializable {

    @FXML
    private VBox chosenProductCard;
    @FXML
    private Label fruitNameLable;
    @FXML
    private Label date;
    @FXML
    private ImageView prodImage;
    @FXML
    private Label postText;
    @FXML
    private ScrollPane scroll;
    @FXML
    private AnchorPane rateAnchor;
    @FXML
    private VBox comments;
    private post post;
    private List<commentaire> list;
    private MylistenerComment supprimer;
    private MylistenerComment modifier;
    private ListenerInterface listener;
    @FXML
    private TextField texComment;
    private Rating rate;
    @FXML
    private Label rateMoy;
    private String format = "0.0";
    private NumberFormat formatter = new DecimalFormat(format);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    this.rate = new Rating(5);
        
    this.rate.setOnMouseClicked((event) -> {
        System.out.println((int)rate.getRating());
        
        Rate r = new Rate((int)(rate.getRating()), this.post.getId_post(),0);
        (new ServiceRate()).ajouetrRate(r);
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
         ServiceRate sr = new ServiceRate();
         int rateValue=0;
        if (sr.afficherReclamation().get(this.post)!=null)
        {
                    rateValue = Math.round(sr.afficherReclamation().get(this.post)) ;

        }
       
        System.out.println(sr.afficherReclamation().get(this.post));
        this.rate.setRating(rateValue);
         this.rateMoy.setText(formatter.format(rateValue));
       
        
        
       
        
        
    });
       
       
       
        
                
    
    }    

    public void setData(post forum){
        this.post = forum;
        
        System.out.println(forum.getImage());
        rateAnchor.getChildren().add(rate);
        ServiceRate sr = new ServiceRate();
        int rateValue=0;
        if (sr.afficherReclamation().get(this.post)!=null)
        {
                    rateValue = Math.round(sr.afficherReclamation().get(this.post)) ;

        }
       
        System.out.println(sr.afficherReclamation().get(this.post));
        this.rate.setRating(rateValue);
         this.rateMoy.setText(formatter.format(rateValue));
        
               if(this.post != null){
        this.prodImage.setVisible(false);
                   System.out.println(post+"init");    
                  ServiceCommentaire sc = new ServiceCommentaire();
        this.list = sc.getComments(this.post.getId_post());
        System.out.println(list);
      this.list = sc.getComments(this.post.getId_post());
        list.forEach((t) -> {
            try {
                FXMLLoader fXMLLoader = new FXMLLoader();
                fXMLLoader.setLocation(getClass().getResource("/post/itemComment.fxml"));
                 
                AnchorPane pane = fXMLLoader.load();
                this.supprimer = new MylistenerComment() {
                    @Override
                    public void onClickListenerCommande(commentaire comment) {
                        
                        delete(t);
                        
                      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
                this.modifier = new MylistenerComment() {
                    @Override
                    public void onClickListenerCommande(commentaire comment) {
                        update(t);
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
                ItemCommentController itemCommentController = fXMLLoader.getController();
                itemCommentController.setData(t,supprimer,modifier);
                comments.getChildren().add(pane);
                
                  
                
                
                
            } catch (IOException ex) {
                Logger.getLogger(CommentsController.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
            
            
            
        });

            
            
        }
       
      
        
        
        
        
        
        
    }
    public void refresh(){
        this.comments.getChildren().clear();
                System.out.println(post+"init");    
                  ServiceCommentaire sc = new ServiceCommentaire();
        this.list = sc.getComments(this.post.getId_post());
        System.out.println(list);
      this.list = sc.getComments(this.post.getId_post());
        list.forEach((t) -> {
            try {
                FXMLLoader fXMLLoader = new FXMLLoader();
                fXMLLoader.setLocation(getClass().getResource("/post/itemComment.fxml"));
                 
                AnchorPane pane = fXMLLoader.load();
                this.supprimer = new MylistenerComment() {
                    @Override
                    public void onClickListenerCommande(commentaire comment) {
                        
                        delete(t);
                        
                      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
                this.modifier = new MylistenerComment() {
                    @Override
                    public void onClickListenerCommande(commentaire comment) {
                        update(t);
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
                ItemCommentController itemCommentController = fXMLLoader.getController();
                itemCommentController.setData(t,supprimer,modifier);
                comments.getChildren().add(pane);
                
                  
                
                
                
            } catch (IOException ex) {
                Logger.getLogger(CommentsController.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
            
            
            
        });

        
    }
    
    private void delete(commentaire c){
        this.comments.getChildren().clear();
        (new ServiceCommentaire()).SupprimerParID(c.getId_com());
        refresh();
        
        
    }
    private void update(commentaire c){
         try {
            FXMLLoader fXMLLoader = new FXMLLoader();
            this.listener = new ListenerInterface() {
                @Override
                public void onClickListener() {
                    refresh();
              //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
             fXMLLoader.setLocation(getClass().getResource("/post/modifierCommentaire.fxml"));
            AnchorPane anchorpane =  fXMLLoader.load();
            ModifierCommentaireController controller = fXMLLoader.getController();
            controller.setData(c,this.listener);
            Scene scene = new Scene(anchorpane);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setOnCloseRequest((ev) -> {
                System.out.println("close");
               refresh();
            });
            stage.show();
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(ForumsController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
        
    }

    @FXML
    private void addComment(ActionEvent event) {
    if(this.texComment.getText().isEmpty()){
        this.texComment.setText("you have to fill this input");
        
        
        
    }
    else{
        commentaire c = new commentaire(0, this.texComment.getText(), piproject.Piproject.userId, this.post.getId_post());
        (new ServiceCommentaire()).ajoutercommentaire(c);
        refresh();
    }
    
    }

    
        
        
        
    
    
}
