/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Admin
 * @modifier Quoc Thang Lam, Kaur Navjot, Dhanoa Gunoordeep Kaur 
 */
public class PlayingCard extends Card {
    private CardSuit suit;
    private CardRank rank;
    
    public PlayingCard(CardSuit suit, CardRank rank){
        this.suit = suit;
        this.rank = rank;
    }
    
    public CardSuit getSuit(){
        return suit;
    }
    
    public CardRank getRank(){
        return rank;
    }
    
    public int getValue(){
        return rank.getValue();
    }
    
    public boolean isAce(){
        return rank == CardRank.ACE;
    }
    
    @Override
    public String toString(){
        return  rank + " of " + suit; 
    }
}
