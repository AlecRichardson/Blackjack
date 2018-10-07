/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awrnndfinalproject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Alec Richardson <your.name at your.org>
 */
public class Page2Controller extends Switchable implements Initializable, PropertyChangeListener {
    
    
    
    @FXML
    public Text myCard1; 
    @FXML
    public Text myCard2;
    @FXML
    public Text myCard3; 
    @FXML
    public Text myCard4;
    @FXML
    public Text myCard5; 
    @FXML
    public Text myCard6;
    
    @FXML
    public Text dealerCard1;
    @FXML
    public Text dealerCard2;
    @FXML
    public Text dealerCard3;  
    @FXML
    public Text dealerCard4;
    @FXML
    public Text dealerCard5;
    @FXML
    public Text dealerCard6;
    
    @FXML
    public ImageView dealerCardImage1;
    @FXML
    public ImageView dealerCardImage2;
    @FXML
    public ImageView dealerCardImage3;
    @FXML
    public ImageView dealerCardImage4;
    @FXML
    public ImageView dealerCardImage5;
    @FXML
    public ImageView dealerCardImage6;
    
    @FXML
    public ImageView myCardImage1;
    @FXML
    public ImageView myCardImage2;
    @FXML
    public ImageView myCardImage3;
    @FXML
    public ImageView myCardImage4;
    @FXML
    public ImageView myCardImage5;
    @FXML
    public ImageView myCardImage6;

    
   
    
    @FXML
    public Text myCardValueText;
    @FXML
    public Text dealerCardValueText;
    
    @FXML
    public Text chipsText;
    
    @FXML
    public Button Deal;
    @FXML
    public Button hit;
    @FXML
    public Button stand;
 
    
    public BlackJack blackjack;
    private Stage stage;
    private BlackJack blackjacksave;
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        blackjack = new BlackJack();
        chipsText.setText(blackjack.getChips());
        blackjack.addPropertyChangeListener(this);
        
    }  
   
    
    
   
    @FXML
    public void dealCards(ActionEvent event){
        if(blackjack.isCardsDelt() == false){
        blackjack.setCardsDelt(true);
        myCard1.setText(blackjack.deck.getCard());
        myCard2.setText(blackjack.deck.getCard());
        
        dealerCard1.setText(blackjack.deck.getCard());
        dealerCard2.setText(blackjack.deck.getCard());
        
        
        dealerCardImage1.setImage(blackjack.getCardImage(dealerCard1.getText()));
        dealerCardImage2.setImage(blackjack.getCardImage("dealer"));

        myCardImage1.setImage(blackjack.getCardImage(myCard1.getText()));
        myCardImage2.setImage(blackjack.getCardImage(myCard2.getText()));

        int value = blackjack.convertCard(myCard1);
        int value2 = blackjack.convertCard(myCard2);
        blackjack.setMyCardValue(value + value2);
        myCardValueText.setText(Integer.toString(blackjack.getMyCardValue()));
        
        value = blackjack.convertCard(dealerCard1);
        value2 = blackjack.convertCard(dealerCard2);
        blackjack.setDealerCardValue(value + value2) ;
        dealerCardValueText.setText(Integer.toString(value));
        blackjack.handleWinOrLost();
        }
    }
    
    @FXML
    public void hit(ActionEvent event){
        if(blackjack.isCardsDelt() == true){
        switch(blackjack.getCountMyHits()){
            case 0: myCard3.setText(blackjack.deck.getCard());
                    int value = blackjack.convertCard(myCard3);
                    blackjack.setMyCardValue(value + blackjack.getMyCardValue());
                    myCardValueText.setText(Integer.toString(blackjack.getMyCardValue()));
                    myCardImage3.setImage(blackjack.getCardImage(myCard3.getText()));
                    blackjack.handleWinOrLost();
                    blackjack.setCountMyHits(blackjack.getCountMyHits() + 1);
                    break;
            case 1: myCard4.setText(blackjack.deck.getCard());
                    value = blackjack.convertCard(myCard4);
                    blackjack.setMyCardValue(value + blackjack.getMyCardValue());
                    myCardValueText.setText(Integer.toString(blackjack.getMyCardValue()));
                    myCardImage4.setImage(blackjack.getCardImage(myCard4.getText()));
                    blackjack.handleWinOrLost();
                    blackjack.setCountMyHits(blackjack.getCountMyHits() + 1);
                    break;
            case 2: myCard5.setText(blackjack.deck.getCard());
                    value = blackjack.convertCard(myCard5);
                    blackjack.setMyCardValue(value + blackjack.getMyCardValue());
                    myCardValueText.setText(Integer.toString(blackjack.getMyCardValue()));
                    myCardImage5.setImage(blackjack.getCardImage(myCard5.getText()));
                    blackjack.handleWinOrLost();
                    blackjack.setCountMyHits(blackjack.getCountMyHits() + 1);
                    break;
            case 3: myCard6.setText(blackjack.deck.getCard());
                    value = blackjack.convertCard(myCard6);
                    blackjack.setMyCardValue(value + blackjack.getMyCardValue());
                    myCardValueText.setText(Integer.toString(blackjack.getMyCardValue()));
                    myCardImage6.setImage(blackjack.getCardImage(myCard6.getText()));
                    blackjack.handleWinOrLost();
                    blackjack.setCountMyHits(0);
                    break;
        }
      } 
    }
  
    @FXML
    public void stand(ActionEvent event){
        System.out.println(blackjack.getCountDealerHits());
        if(blackjack.isCardsDelt() == true){
            blackjack.setStand(true);
        System.out.println("my card value: " + blackjack.getMyCardValue() + ", dealer card value: " + blackjack.getDealerCardValue() );
        if(blackjack.getDealerCardValue() > blackjack.getMyCardValue()){
            blackjack.handleWinOrLost();
            return;
        }
        while(blackjack.getMyCardValue() > blackjack.getDealerCardValue() || blackjack.getDealerCardValue() < 17 ){
          switch(blackjack.getCountDealerHits()){
            case 0: dealerCard3.setText(blackjack.deck.getCard());
                    int value = blackjack.convertCard(dealerCard3);
                    blackjack.setDealerCardValue(value + blackjack.getDealerCardValue());
                    dealerCardValueText.setText(Integer.toString(blackjack.getDealerCardValue()));
                    dealerCardImage3.setImage(blackjack.getCardImage(dealerCard3.getText()));
                    blackjack.setCountDealerHits(blackjack.getCountDealerHits() + 1);
                    blackjack.handleWinOrLost();
                    break;
            case 1: dealerCard4.setText(blackjack.deck.getCard());
                    value = blackjack.convertCard(dealerCard4);
                    blackjack.setDealerCardValue(value + blackjack.getDealerCardValue());
                    dealerCardValueText.setText(Integer.toString(blackjack.getDealerCardValue()));
                    dealerCardImage4.setImage(blackjack.getCardImage(dealerCard4.getText()));
                    blackjack.setCountDealerHits(blackjack.getCountDealerHits() + 1);
                    blackjack.handleWinOrLost();
                    break;
            case 2: dealerCard5.setText(blackjack.deck.getCard());
                    value = blackjack.convertCard(dealerCard5);
                    blackjack.setDealerCardValue(value + blackjack.getDealerCardValue());
                    dealerCardValueText.setText(Integer.toString(blackjack.getDealerCardValue()));
                    dealerCardImage5.setImage(blackjack.getCardImage(dealerCard5.getText()));
                    blackjack.setCountDealerHits(blackjack.getCountDealerHits() + 1);
                    blackjack.handleWinOrLost();
                    break;
            case 3: dealerCard6.setText(blackjack.deck.getCard());
                    value = blackjack.convertCard(dealerCard6);
                    blackjack.setDealerCardValue(value + blackjack.getDealerCardValue());
                    dealerCardValueText.setText(Integer.toString(blackjack.getDealerCardValue()));
                    dealerCardImage6.setImage(blackjack.getCardImage(dealerCard6.getText()));
                    blackjack.setCountDealerHits(0);
                    blackjack.handleWinOrLost();
                    break;
            }
        
        }
        }
    }
   @FXML
    public void handleSave(ActionEvent event) throws IOException {
        blackjacksave = createBlackJackFromData();
        
        if(blackjacksave == null){
            return; 
        }
        
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            
            try {
                FileOutputStream fileOut = new FileOutputStream(file.getPath());
                ObjectOutputStream out = new ObjectOutputStream(fileOut); 
                
                out.writeObject(blackjacksave);
                out.close(); 
                fileOut.close(); 
                
            } catch (FileNotFoundException ex) {
                String message = "File not found exception occured while saving to " + file.getPath(); 
                displayExceptionAlert(message, ex); 
                
            } catch (IOException ex) {
                String message = "IOException occured while saving to " + file.getPath();
                displayExceptionAlert(message, ex);
                
            }
        }        
    }
    
    private BlackJack createBlackJackFromData() {
        BlackJack b = new BlackJack();
        
        b.setChips(blackjack.getChipsAsInt());
      

        return b;
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
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("updateChips")){
            blackjack.setChips((int) evt.getNewValue());
            String newChipAmount = blackjack.getChips();
            chipsText.setText(newChipAmount);
            
            blackjack.setCardsDelt(false);
            blackjack.setStand(false);
            blackjack.deck = new Deck();
            
            blackjack.setCountMyHits(0);
            blackjack.setCountDealerHits(0);
            
            myCard1.setText("");
            myCard2.setText("");
            myCard3.setText("");
            myCard4.setText("");
            myCard5.setText("");
            myCard6.setText("");
            myCardValueText.setText("");
            
            dealerCard1.setText("");
            dealerCard2.setText("");
            dealerCard3.setText("");
            dealerCard4.setText("");
            dealerCard5.setText("");
            dealerCard6.setText("");
            dealerCardValueText.setText("");
            
            dealerCardImage1.setImage(null);
            dealerCardImage2.setImage(null);
            dealerCardImage3.setImage(null);
            dealerCardImage4.setImage(null);
            dealerCardImage5.setImage(null);
            dealerCardImage6.setImage(null);
            
            myCardImage1.setImage(null);
            myCardImage2.setImage(null);
            myCardImage3.setImage(null);
            myCardImage4.setImage(null);
            myCardImage5.setImage(null);
            myCardImage6.setImage(null);
            
            System.out.println("reset");

    } else if(evt.getPropertyName().equals("flipDealerCard")){
        
            dealerCardValueText.setText(Integer.toString(blackjack.getDealerCardValue()));
            dealerCardImage2.setImage(blackjack.getCardImage(dealerCard2.getText()));
            System.out.println("Flipped dealers card.");
    }
    }

    
    
}
