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
public class Deck extends GroupOfCards{
    
    public Deck(){
        super(52);
        initializeDeck();
    }
    
    private void initializeDeck(){
        ArrayList<Card> cards = new ArrayList<>();
        for (CardSuit suit : CardSuit.values()){
            for (CardRank rank : CardRank.values()){
                cards.add(new PlayingCard(suit, rank));
            }
        }
        setCards(cards);
    }
    
    public PlayingCard dealCard(){
        if(getCards() != null && !getCards().isEmpty()){
            return (PlayingCard) getCards().remove(0);
        }
        return null;
    }
    
    public boolean hasCards(){
        return getCards() != null && !getCards().isEmpty();
    }
}
