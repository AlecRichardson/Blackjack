/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awrnndfinalproject;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.Image;

/**
 *
 * @author Alec Richardson <your.name at your.org>
 */
public class Deck extends Abstract implements java.io.Serializable {
    transient private int cardsLeft = 52;
    transient private ArrayList<String> cards = new ArrayList<>();
    private int Chips; 
    
    public int getCardsLeft(){
        return cardsLeft;
    }
    
    public Deck(){
            cards.add("2C");
            cards.add("2D");
            cards.add("2H");
            cards.add("2S");
            
            cards.add("3C");
            cards.add("3D");
            cards.add("3H");
            cards.add("3S");
            
            cards.add("4C");
            cards.add("4D");
            cards.add("4H");
            cards.add("4S");
            
            cards.add("5C");
            cards.add("5D");
            cards.add("5H");
            cards.add("5S");
            
            cards.add("6C");
            cards.add("6D");
            cards.add("6H");
            cards.add("6S");
            
            cards.add("7C");
            cards.add("7D");
            cards.add("7H");
            cards.add("7S");
            
            cards.add("8C");
            cards.add("8D");
            cards.add("8H");
            cards.add("8S");
            
            cards.add("9C");
            cards.add("9D");
            cards.add("9H");
            cards.add("9S");
            
            cards.add("10C");
            cards.add("10D");
            cards.add("10H");
            cards.add("10S");
            
            cards.add("10JC");
            cards.add("10JD");
            cards.add("10JH");
            cards.add("10JS");
            
            cards.add("10QC");
            cards.add("10QD");
            cards.add("10QH");
            cards.add("10QS");
            
            cards.add("10KC");
            cards.add("10KD");
            cards.add("10KH");
            cards.add("10KS");
            
            cards.add("11AC");
            cards.add("11AD");
            cards.add("11AH");
            cards.add("11AS");
            
    }
    
    
    
    public String getCard(){
        Random rand = new Random();
        int value = rand.nextInt(cardsLeft--);
        String drawnCard = cards.get(value);
        cards.remove(value);
        return drawnCard;
    }

     @Override
    public void setChips(int chips){
        this.Chips = chips;
    }
    @Override
    public void addChips(){
    Chips += 100;
}
    @Override
    public void removeChips(){
        Chips -=100;
    }
    
    @Override
    public String getChips(){
        return Integer.toString(Chips);
    }
    
    @Override
    public int getChipsAsInt(){
        return this.Chips;
    }
}
