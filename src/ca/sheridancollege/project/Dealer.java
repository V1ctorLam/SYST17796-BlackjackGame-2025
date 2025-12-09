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
public class Dealer extends BlackjackPlayer{
    public Dealer(){
        super("Dealer");
    }
    
    public boolean shouldHit(){
        return getHand().getTotalValue() < 17;
    }
    
    public String showUpCard(){
        if (getHand().getCards().isEmpty()){
            return "No cards";
        }
        return getHand().getCards().get(0).toString();
    }
}
