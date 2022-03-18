/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.function.BiConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import org.controlsfx.control.Rating;
import services.ServiceRate;





/**
 * FXML Controller class
 *
 * @author ouni
 */
public class TestController implements Initializable {

    @FXML
    private Button choosefile;
    @FXML
    private TextArea field;
    private ImageView display;
    @FXML
    private AnchorPane node;
    private Rating rateSystem;
    @FXML
    private Rating rate;
    @FXML
    private AnchorPane chartsPlace;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Service
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
           this.chartsPlace.getChildren().add(pc);
        
        
        
        
        
        
        
            
        

// TODO
    }
            


            

    
}
