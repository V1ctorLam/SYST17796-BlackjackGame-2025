/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("          BLACKJACK GAME");
        System.out.println("=================================");
        System.out.print("\nEnter your name: ");
        String playerName = scanner.nextLine().trim();

        // Handle empty name (USE CASE 4 - Alternative Flow)
        if (playerName.isEmpty()) {
            playerName = "Player";
            System.out.println("Using default name: Player");
        }

        // Create and start game
        BlackJack game = new BlackJack(playerName);
        game.play();

        scanner.close();
    }
}
