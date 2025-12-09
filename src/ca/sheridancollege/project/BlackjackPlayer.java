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
public class BlackjackPlayer extends Player {
    private Hand hand;
    
    public BlackjackPlayer(String name){
        super(name);
        this.hand = new Hand();
    }
    
    public Hand getHand(){
        return hand;
    }
    
    public void resetHand(){
        hand.clear();
    }
    
    @Override
    public void play(){}
}
