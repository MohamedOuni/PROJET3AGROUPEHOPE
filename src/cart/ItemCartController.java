/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.Panier;
import model.Produit;

/**
 * FXML Controller class
 *
 * @author ouni
 */
public class ItemCartController implements Initializable {

    @FXML
    private Label labelName;
    @FXML
    private ImageView minus;
    @FXML
    private Label quatity;
    @FXML
    private ImageView plus;
    private Panier panier;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData(Produit p ,int quantity){
       // this.panier
        this.labelName.setText(p.getNom_produit());
        this.quatity.setText(quantity+"");
     
        
        
    }
    
}
