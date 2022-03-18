/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back;

import interfaces.MyListener;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Livraison;
import services.ServiceLivraison;


/**
 * FXML Controller class
 *
 * @author ouni
 */
public class LivraisonController implements Initializable {

    @FXML
    private VBox livraisons;
    private MyListener supprimer;
    private MyListener modifier;
    private MyListener referesh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Livraison> list = (new ServiceLivraison()).afficher();
        if (!list.isEmpty()){
                supprimer = new MyListener() {
                @Override
                public void onClickListener(Livraison l) {
                    deleteLivraison(l);
                }
            };
               
                         referesh = new MyListener() {
                @Override
                public void onClickListener(Livraison l) {
                    modifierLivraison(l);
                }
            };


            
        }
            list.forEach((t) -> {
                try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/back/itemLivraison.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            
            ItemLivraisonController itemController = fxmlLoader.getController();
            itemController.setData(t,modifier,supprimer,referesh);
            livraisons.getChildren().add(anchorPane);
        } catch (IOException ex) {
                    System.out.println(ex.getMessage());
       //     Logger.getLogger(LivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
                
                
                
            });
            
    
    
    }    
    private void refresh(){
        livraisons.getChildren().clear();
              List<Livraison> list = (new ServiceLivraison()).afficher();
        if (!list.isEmpty()){
                supprimer = new MyListener() {
                @Override
                public void onClickListener(Livraison l) {
                    deleteLivraison(l);
                }
            };
               
                   referesh = new MyListener() {
                @Override
                public void onClickListener(Livraison l) {
                    modifierLivraison(l);
                }
            };

            
        }
            list.forEach((t) -> {
                try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/back/itemLivraison.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            
            ItemLivraisonController itemController = fxmlLoader.getController();
            itemController.setData(t,modifier,supprimer,referesh);
            livraisons.getChildren().add(anchorPane);
        } catch (IOException ex) {
                    System.out.println(ex.getMessage());
       //     Logger.getLogger(LivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
                
                
                
            });
    }
    public void deleteLivraison(Livraison l){
        (new ServiceLivraison()).supprimer(l);
        refresh();
//(new ServiceLivraison()).supprimer(l);
        //refresh
        
    }
    public void modifierLivraison(Livraison l){
        System.out.println("modif");
        refresh();
        
    }
    
}
