/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod;

import interfaces.MyListener;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import model.Panier;
import model.Produit;
import services.ServicePanier;
import services.serviceProduit;

/**
 * FXML Controller class
 *
 * @author ouni
 */
public class MarketController implements Initializable {

    @FXML
    private Label fruitNameLable;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private VBox chosenProductCard;
    @FXML
    private Label PriceLabel;
    @FXML
    private ImageView prodImage;
    private serviceProduit service;
    private MyListener myListener;
    private Produit produit;
    @FXML
    private ComboBox<Integer> quantuty;
    @FXML
    private Button click;
    @FXML
    private AnchorPane front_base;
    @FXML
    private Button getForum;
    private AnchorPane oldAnchorPane;
    @FXML
    private HBox navbar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.navbar.setVisible(false);
        getForum.setOnAction((event) -> {
                   try {
            front_base.getChildren().clear();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/post/forums.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            front_base.getChildren().add(anchorPane);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
          //  Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        });
        click.setOnAction((event) -> {
         System.out.println("click");
            System.out.println(quantuty.getSelectionModel().getSelectedItem());
            Panier p;
            if(quantuty.getSelectionModel().getSelectedItem()==null){
                       p = new Panier(this.produit.getID(),piproject.Piproject.userId,1 );

            }
            else{
                        p = new Panier(this.produit.getID(),piproject.Piproject.userId,quantuty.getSelectionModel().getSelectedItem());

            }
        
       (new ServicePanier()).ajouterpanier(p);
        System.out.println("ajouter");
            
        });
        
        
       service = new serviceProduit();
        List<Produit> list = service.afficherProduit();
         if (list.size() > 0) {
             this.produit=list.get(0);
             setChosenProduit();
        
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < list.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/prod/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
            
                ItemController itemController = fxmlLoader.getController();
                itemController.setData(list.get(i));
                
                
                if (column == 3) {
                    column = 0;
                    row++;
                }
           

                grid.add(anchorPane, column++, row); //(child,column,row)
                Produit p= list.get(i);
                anchorPane.setOnMouseClicked((event) -> {
                   produit = p;
                   setChosenProduit();
                });

                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        
        public void setChosenProduit(){
            this.PriceLabel.setText(this.produit.getPrix()+"");
            this.fruitNameLable.setText(this.produit.getNom_produit());
            
            ObservableList<Integer> items = FXCollections.observableArrayList(
              
                );
            for(int i=0;i<this.produit.quantite;i++){
                items.add(i);
                
            }
             quantuty.setItems(items);
            
            
        }
        
        
        
        
    void refresh(){
        
        
        
        
        
    }    

    @FXML
    private void getProduit(ActionEvent event) {
        front_base.getChildren().clear();
        refresh();
        
        
        
        
        
    }

    @FXML
    private void getPanier(ActionEvent event) {
        try {
            front_base.getChildren().clear();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/cart/cart.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            front_base.getChildren().add(anchorPane);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
          //  Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
       
       
     
    }

    @FXML
    private void getCommandes(ActionEvent event) {
    }

   
    
}
