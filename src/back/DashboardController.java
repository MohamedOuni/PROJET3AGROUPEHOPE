/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.BiConsumer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import services.ServiceRate;

/**
 * FXML Controller class
 *
 * @author ouni
 */
public class DashboardController implements Initializable {

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
    private void onForums(ActionEvent event) {
          try {
            base.getChildren().clear();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/back/commandes.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            base.getChildren().add(anchorPane);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
          //  Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onLivrasons(ActionEvent event) {
               try {
            base.getChildren().clear();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/back/livraison.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            base.getChildren().add(anchorPane);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
          //  Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void viewRates(ActionEvent event) {
        this.base.getChildren().clear();
        
        ObservableList<PieChart.Data> pcd  = FXCollections.observableArrayList();
               ( new ServiceRate()).getRatesByuser().forEach(new BiConsumer<String, Integer>() {
                    @Override
                    public void accept(String t, Integer u) {
                        pcd.add(new PieChart.Data(t,u));
                    }
                });
//           ObservableList<PieChart.Data> pcd = FXCollections.observableArrayList(
//           new PieChart.Data("Happy",23),
//           new PieChart.Data("Sad", 25),
//           new PieChart.Data("No emotions", 10),
//           new PieChart.Data("Confused", 15));
           PieChart pc = new PieChart(pcd);
           this.base.getChildren().add(pc);
        
    }
    
    
}
