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
public enum CardSuit {
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs"),
    SPADES("Spades");
    
    private final String suitName;
    
    CardSuit(String suitName) {
        this.suitName = suitName;
    }
    
    @Override
    public String toString() {
        return suitName;
    }
}
