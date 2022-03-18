/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Livraison;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import model.Livraison;
import services.ServiceLivraison;

/**
 * FXML Controller class
 *
 * @author ouni
 */
public class AjouterLivraisonController implements Initializable {

    @FXML
    private Label username;
    @FXML
    private Label prixTot;
    @FXML
    private AnchorPane livpdfImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       username.setText(piproject.Piproject.nom);
       prixTot.setText(piproject.Piproject.price+"");
       
       
       
       
    }  
    
    
    

    @FXML
    private void onContinuer(ActionEvent event) {
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDateTime now = LocalDateTime.now();
                
           
        String date = now.toString();
        (new ServiceLivraison()).ajouter(new Livraison(0, piproject.Piproject.dest, date.substring(0, 10), "en attente"));
        Stage stage = (Stage)username.getScene().getWindow();
        stage.close();
        
        
        
        
    }

    @FXML
    private void onPdf(ActionEvent event) {
        try {
            Image image = livpdfImage.snapshot(null, null);
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
            File outputFile = new File("file.png");
            ImageIO.write(bufferedImage, "png", outputFile);
            Document document = new Document();
           
            PdfWriter.getInstance(document, new FileOutputStream("sample1.pdf"));
        document.open();
        com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance("file.png");
        document.add(img);
        document.close();
        System.out.println("Done");
            
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());  
        //    Logger.getLogger(AjouterLivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                         

        
        
        
        
        
        
    }
   
    
}
