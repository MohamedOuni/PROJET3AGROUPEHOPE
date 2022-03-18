/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back;

import interfaces.MyListener;
import interfaces.MyListenerCommande;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Livraison;
import model.Commande;
import services.ServiceCommande;
import services.ServiceLivraison;
/**
 * FXML Controller class
 *
 * @author ouni
 */
public class ModifierCommnadeController implements Initializable {

    @FXML
    private TextField destination;
    @FXML
    private DatePicker date;
        Commande commande;
    MyListenerCommande refresh;
    @FXML
    private TextField tel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }
         public void setData(Commande l,MyListenerCommande refresh){
                   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDateTime now = LocalDateTime.now();
                
           
        String date = now.toString();
       
        this.commande  =l;
        this.refresh = refresh;
        this.destination.setText(l.getAdresse());
        this.date.setValue(now.toLocalDate());
        this.tel.setText(l.getTel()+"");
        
        
    }   
    

    @FXML
    private void modifer(ActionEvent event) {
           if(destination.getText().isEmpty() || tel.getText().isEmpty()){
            destination.setText("you have to fill this input");
            tel.setText("you have to fill this input");
            
            
        }
      
        else{
            this.commande.setAdresse(this.destination.getText());
            this.commande.setDate_cmd(this.date.getValue().toString());
            this.commande.setTel(Integer.parseInt(this.tel.getText()));
            (new ServiceCommande()).modifierCommande(this.commande);
            Stage stage = (Stage)this.destination.getScene().getWindow();
            stage.close();
            refresh.onClickListenerCommande(commande);
                    
              
            
            
     }
    }
      
    
    
    
    
    
}
