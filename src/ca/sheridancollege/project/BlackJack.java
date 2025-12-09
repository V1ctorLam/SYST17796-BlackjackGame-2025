/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Admin
 * @modifier Quoc Thang Lam, Kaur Navjot, Dhanoa Gunoordeep Kaur 
 */
public class BlackJack extends Game {
    private Deck deck;
    private BlackjackPlayer player;
    private Dealer dealer;
    private Scanner scanner;
    
    public BlackJack(String playerName){
        super("Blackjack");
        this.deck = new Deck();
        this.player = new BlackjackPlayer(playerName);
        this.dealer = new Dealer();
        this.scanner = new Scanner(System.in);
    }
    
    @Override
    public void play(){
        boolean playAgain = true;
        
        System.out.println("=================================");
        System.out.println("          Blackjack Game");
        System.out.println("          GAME STARTS!!!");        
        System.out.println("=================================\n");

        while (playAgain){
            playRound();
            
            System.out.print("\nPlay another round? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }
        
        System.out.println("\nThanks for playing Blackjack!");
    }

    private void playRound() {
        deck = new Deck();
        deck.shuffle();
        player.resetHand();
        dealer.resetHand();
        
        System.out.println("\n--- New Round ---");

        dealInitialCards();

        displayHands(true);

        if (player.getHand().isBlackjack()) {
            System.out.println("\n*** BLACKJACK! ***");
            if (dealer.getHand().isBlackjack()) {
                System.out.println("Dealer also has Blackjack. Push (Tie)!");
            } else {
                System.out.println(player.getName() + " wins with Blackjack!");
            }
            return;
        }

        playerTurn();

        if (player.getHand().isBust()) {
            System.out.println("\n" + player.getName() + " busts! Dealer wins.");
            return;
        }
        
        dealerTurn();
        
        declareWinner();
    }
    
    private void dealInitialCards() {
        player.getHand().addCard(deck.dealCard());
        dealer.getHand().addCard(deck.dealCard());
        player.getHand().addCard(deck.dealCard());
        dealer.getHand().addCard(deck.dealCard());
    }
    
    private void playerTurn() {
        boolean standing = false;
        
        while (!standing && !player.getHand().isBust()) {
            System.out.print("\nWould you like to (H)it or (S)tand? ");
            String choice = scanner.nextLine().trim().toLowerCase();
            
            if (choice.equals("h") || choice.equals("hit")) {
                PlayingCard card = deck.dealCard();
                player.getHand().addCard(card);
                System.out.println("\n" + player.getName() + " hits and receives: " + card);
                
                displayHands(true);
                
                if (player.getHand().isBust()) {
                    System.out.println("\n" + player.getName() + "'s hand value: " + 
                                     player.getHand().getTotalValue());
                }
            } 

            else if (choice.equals("s") || choice.equals("stand")) {
                standing = true;
                System.out.println("\n" + player.getName() + " stands with " + 
                                 player.getHand().getTotalValue());
            } 

            else {
                System.out.println("Invalid choice. Please enter H or S.");
            }
        }
    }
    
    private void dealerTurn() {
        System.out.println("\n--- Dealer's Turn ---");
        System.out.println("Dealer reveals hidden card...");
        displayHands(false);

        while (dealer.shouldHit()) {
            PlayingCard card = deck.dealCard();
            dealer.getHand().addCard(card);
            System.out.println("\nDealer hits and receives: " + card);
            System.out.println("Dealer's hand: " + dealer.getHand().toString());
            System.out.println("Dealer's total: " + dealer.getHand().getTotalValue());
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        if (!dealer.getHand().isBust()) {
            System.out.println("\nDealer stands with " + dealer.getHand().getTotalValue());
        } else {
            System.out.println("\nDealer busts with " + dealer.getHand().getTotalValue());
        }
    }

    private void displayHands(boolean hideDealerCard) {
        System.out.println("\n" + player.getName() + "'s hand: " + 
                         player.getHand().toString());
        System.out.println(player.getName() + "'s total: " + 
                         player.getHand().getTotalValue());
        
        if (hideDealerCard) {
            System.out.println("\nDealer's hand: [Hidden Card], " + 
                             dealer.showUpCard());
            System.out.println("Dealer's visible card value: " + 
                             dealer.getHand().getCards().get(0).getValue());
        } else {
            System.out.println("\nDealer's hand: " + dealer.getHand().toString());
            System.out.println("Dealer's total: " + dealer.getHand().getTotalValue());
        }
    }

    @Override
    public void declareWinner() {
        System.out.println("\n=================================");
        System.out.println("         FINAL RESULTS");
        System.out.println("=================================");
        
        int playerTotal = player.getHand().getTotalValue();
        int dealerTotal = dealer.getHand().getTotalValue();
        
        System.out.println(player.getName() + "'s final hand: " + 
                         player.getHand().toString());
        System.out.println(player.getName() + "'s total: " + playerTotal);
        
        System.out.println("\nDealer's final hand: " + dealer.getHand().toString());
        System.out.println("Dealer's total: " + dealerTotal);
        
        System.out.println("\n---------------------------------");
        
        if (dealer.getHand().isBust()) {
            System.out.println("*** " + player.getName() + " WINS! ***");
            System.out.println("Reason: Dealer busted");
        } else if (playerTotal > dealerTotal) {
            System.out.println("*** " + player.getName() + " WINS! ***");
            System.out.println("Reason: Higher score (" + playerTotal + " vs " + dealerTotal + ")");
        } else if (playerTotal < dealerTotal) {
            System.out.println("*** DEALER WINS! ***");
            System.out.println("Reason: Higher score (" + dealerTotal + " vs " + playerTotal + ")");
        } else {
            System.out.println("*** PUSH (TIE) ***");
            System.out.println("Reason: Both have " + playerTotal);
        }
        
        System.out.println("=================================");
    }
}
