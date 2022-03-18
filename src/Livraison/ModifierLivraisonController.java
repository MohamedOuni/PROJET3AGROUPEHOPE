/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Livraison;

import interfaces.MyListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Livraison;
import services.ServiceLivraison;
/**
 * FXML Controller class
 *
 * @author ouni
 */
public class ModifierLivraisonController implements Initializable {

    @FXML
    private TextField destination;
    @FXML
    private ComboBox<String> etat;
    Livraison livraison;
    MyListener refresh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<String> items = FXCollections.observableArrayList(
              
                );
         items.add("en ettente");
         items.add("livré");
         etat.setItems(items);
    }    
    public void setData(Livraison l,MyListener refresh){
        this.livraison  =l;
        this.refresh = refresh;
        this.destination.setText(l.getDestination());
        this.etat.setValue("en attente");
        
        
    }

    @FXML
    private void modifer(ActionEvent event) {
        if(destination.getText().isEmpty()){
            destination.setText("you have to fill this input");
            
            
        }
        else{
            this.livraison.setDestination(this.destination.getText());
            this.livraison.setEtat(this.etat.getSelectionModel().getSelectedItem());
            (new ServiceLivraison()).modifier(livraison);
            Stage stage = (Stage)this.destination.getScene().getWindow();
            stage.close();
            refresh.onClickListener(livraison);
                    
                   
            
            
        }
        
        
        
    }
}
