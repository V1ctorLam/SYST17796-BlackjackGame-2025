/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Admin
 * @modifier Quoc Thang Lam, Kaur Navjot, Dhanoa Gunoordeep Kaur 
 */
public class Hand {
    private ArrayList<PlayingCard> cards;
    
    public Hand(){
        this.cards = new ArrayList<>();
    }
    
    public void addCard(PlayingCard card){
        if(card != null){
            cards.add(card);
        }
    }
    
    public ArrayList<PlayingCard> getCards(){
        return cards;
    }
    
    public int getTotalValue(){
        int total = 0;
        int aceCount = 0;
        
        for (PlayingCard card: cards){
            total += card.getValue();
            if (card.isAce()){
                aceCount++;
            }
        }
        
        while(total > 21 && aceCount > 0){
            total -= 10;
            aceCount--;
        }
        
        return total;
    }
    
    public boolean isBust(){
        return getTotalValue()>21;
    }
    
    public boolean isBlackjack(){
        return cards.size()== 2 && getTotalValue() == 21;
    }
    
    public void clear(){
        cards.clear();
    }
    
    public String toString(boolean hideFirstCard){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cards.size(); i++){
            if(i == 0 && hideFirstCard){
                sb.append("[Hidden Card]");
            } else {
                sb.append(cards.get(i).toString());
            }
            if (i < cards.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
    
    @Override
    public String toString(){
        return toString(false);
    }
}
