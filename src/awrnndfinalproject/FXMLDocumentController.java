/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awrnndfinalproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Alec Richardson <your.name at your.org>
 */
public class FXMLDocumentController extends Switchable implements Initializable {
    private Stage stage;
    
    @FXML
    public Button newGame;
    
    @FXML
    public Button loadGame;
    
//    @FXML
//    public Button about;
    
    @FXML
    public ImageView welcomeImage;
    
    private BlackJack blackjack = new BlackJack();
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private Image image  = new Image(this.getClass().getResourceAsStream("aces.png"));
    
    @FXML
    public void about(ActionEvent event){
        alert.setTitle("About.");
        alert.setHeaderText("Blackjack");
        alert.setContentText("This application serves the purpose to gamble virtual chips in the famous casino game Blackjack. "
                + "Aces are always 11, you can't split, you can't double, and you can't surrender. Get over it.\n Created by Alec Richardson \n Pawprint: awrnnd\n "
                + "Student id: 14295160\n");
        alert.showAndWait();
    }
    @FXML
    public void handleOpen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            FileInputStream fileIn; 
            try {
                fileIn = new FileInputStream(file.getPath());
                ObjectInputStream in = new ObjectInputStream(fileIn); 
                
                blackjack = (BlackJack) in.readObject();
                
                in.close(); 
                fileIn.close(); 
                Switchable.switchTo("Page2");
                loadChips(blackjack);
                
                
            } catch (FileNotFoundException ex) {
                String message = "File not found exception occured while opening " + file.getPath(); 
                displayExceptionAlert(message, ex); 
                
            } catch (IOException ex) {
                String message = "IO exception occured while opening " + file.getPath(); 
                displayExceptionAlert(message, ex);
                
            } catch (ClassNotFoundException ex) {
                String message = "Class not found exception occured while opening " + file.getPath(); 
                displayExceptionAlert(message, ex); 
            }
            
            
            
        }
    }
    private void loadChips(BlackJack blackjack) {
        Page2Controller controller = (Page2Controller)getControllerByName("Page2");
          controller.blackjack.setChips(blackjack.getChipsAsInt());
          controller.chipsText.setText(blackjack.getChips());
    }
    @FXML
    private void handleNewGame(ActionEvent event) {
        Switchable.switchTo("Page2");
        Page2Controller controller = (Page2Controller)getControllerByName("Page2");
        controller.blackjack.setChips(500);
        controller.chipsText.setText("500");
         
    }
    
    private void displayExceptionAlert(String message, Exception ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText("Exception!");
        alert.setContentText(message);

        // Create expandable Exception.
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        // Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }     
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        welcomeImage.setImage(image);
    }    
    
}
