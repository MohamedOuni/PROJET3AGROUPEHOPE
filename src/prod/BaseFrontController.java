/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ouni
 */
public class BaseFrontController implements Initializable {

    @FXML
    private AnchorPane base;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getProduit(ActionEvent event) {
          try {
            base.getChildren().clear();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/prod/market.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            base.getChildren().add(anchorPane);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
          //  Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
@FXML
    private void getPanier(ActionEvent event) {
        try {
            base.getChildren().clear();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/cart/cart.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            base.getChildren().add(anchorPane);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
          //  Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
       
       
     
    }

    @FXML
    private void getCommandes(ActionEvent event) {
    }

    @FXML
    private void getForum(ActionEvent event) {
            try {
            base.getChildren().clear();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/post/forums.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            base.getChildren().add(anchorPane);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
          //  Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    
}
