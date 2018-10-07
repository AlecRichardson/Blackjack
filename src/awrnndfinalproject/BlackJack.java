/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awrnndfinalproject;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

/**
 *
 * @author Alec Richardson <your.name at your.org>
 */
public class BlackJack extends Deck implements java.io.Serializable{
    transient protected Deck deck;
    transient private int countMyHits;
    transient private int countDealerHits;
    transient private int myCardValue;
    transient private int dealerCardValue;
    transient private boolean stand;
    transient private boolean cardsDelt;
    transient Alert alert = new Alert(AlertType.INFORMATION);
    
    protected BlackJack(){
        deck = new Deck();
        countMyHits = 0;
        countDealerHits = 0;
        myCardValue = 0;
        dealerCardValue = 0;
        stand = false;
        cardsDelt = false;
    }
    
   

    public int getCountMyHits() {
        return countMyHits;
    }

    public void setCountMyHits(int countMyHits) {
        this.countMyHits = countMyHits;
    }

    public int getCountDealerHits() {
        return countDealerHits;
    }

    public void setCountDealerHits(int countDealerHits) {
        this.countDealerHits = countDealerHits;
    }

    public int getMyCardValue() {
        return myCardValue;
    }

    public void setMyCardValue(int myCardValue) {
        this.myCardValue = myCardValue;
    }

    public int getDealerCardValue() {
        return dealerCardValue;
    }

    public void setDealerCardValue(int dealerCardValue) {
        this.dealerCardValue = dealerCardValue;
    }

    public boolean isStand() {
        return stand;
    }

    public void setStand(boolean stand) {
        this.stand = stand;
    }

    public boolean isCardsDelt() {
        return cardsDelt;
    }
    

    public void setCardsDelt(boolean cardsDelt) {
        this.cardsDelt = cardsDelt;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }
    protected void handleWinOrLost(){
        System.out.println("winorlost called");
        if(dealerCardValue == myCardValue){
            firePropertyChange("flipDealerCard", 1000, 1001);
            alert.setTitle("Stale mate.");
            alert.setHeaderText("You've tied!");
            alert.setContentText("You're bet is returned to your wallet!");
            alert.showAndWait();
            firePropertyChange("updateChips", 1000, getChipsAsInt());
        }else  if(myCardValue == 21){
           firePropertyChange("flipDealerCard", 1000, 1001);
           alert.setTitle("Congratulations!");
           alert.setHeaderText("You've Won!");
           alert.setContentText("100 chips have been added to your wallet!");
           alert.showAndWait();
           firePropertyChange("updateChips", getChipsAsInt(), getChipsAsInt() + 100);
        } else if(dealerCardValue == 21){
            firePropertyChange("flipDealerCard", 1000, 1001);
           alert.setTitle("Unfortunate!");
           alert.setHeaderText("You've Lost.");
           alert.setContentText("100 chips has been deducted from your wallet!");
           alert.showAndWait();
           firePropertyChange("updateChips", getChipsAsInt(), getChipsAsInt() - 100);
        } else if(myCardValue > 21){
            firePropertyChange("flipDealerCard", 1000, 1001);
           alert.setTitle("Unfortunate!");
           alert.setHeaderText("You've Lost.");
           alert.setContentText("100 chips have been deducted from your wallet!");
           alert.showAndWait();
           firePropertyChange("updateChips", getChipsAsInt(), getChipsAsInt() - 100);
        }  else if(dealerCardValue > 21){
            firePropertyChange("flipDealerCard", 1000, 1001);
           alert.setTitle("Congratulations!");
           alert.setHeaderText("You've Won!");
           alert.setContentText("100 Chips has been added to your wallet!");
           alert.showAndWait();
           firePropertyChange("updateChips", getChipsAsInt(), getChipsAsInt() + 100);
    } else if(dealerCardValue > myCardValue && stand == true){
           firePropertyChange("flipDealerCard", 1000, 1001);
           alert.setTitle("Unfortunate!");
           alert.setHeaderText("You've Lost.");
           alert.setContentText("100 chips has been deducted from your wallet!");
           alert.showAndWait();
           firePropertyChange("updateChips", getChipsAsInt(), getChipsAsInt() - 100);
        } 
    } 
    public Image getCardImage(String card){
        System.out.println(card);
        Image image;
        if("dealer".equals(card)){
            image = new Image(this.getClass().getResourceAsStream("/cards/purple_back.png"));
        }else{
        image  = new Image(this.getClass().getResourceAsStream("/cards/" + card + ".png"));
        }
        return image;
    }
    protected int convertCard(Text card){
        String cardValue = (String) card.getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(cardValue);
}
}
