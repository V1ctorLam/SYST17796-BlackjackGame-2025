# Blackjack Game

This is a simple console-based Blackjack game written in Java for the SYST 17796 project starter code. The game uses an object-oriented design with separate classes for the deck, cards, hand, player, dealer, and game logic.

## Features

- Console-based Blackjack gameplay
- Player name entry at startup
- Dealer logic with automatic hit/stand rules
- Blackjack and bust detection
- Card, hand, and deck modeling using classes

## Requirements

- Java Development Kit (JDK) 8 or later
- Apache Ant
- VS Code, NetBeans, or another Java IDE

## How To Run

This project uses Ant build files. From the project root, run:

```bash
ant -Dmain.class=ca.sheridancollege.project.Main run
```

If you are using NetBeans, make sure the main class is set to:

```text
ca.sheridancollege.project.Main
```

## Project Structure

```text
src/
  ca/sheridancollege/project/
    BlackJack.java
    BlackjackPlayer.java
    Card.java
    CardRank.java
    CardSuit.java
    Dealer.java
    Deck.java
    Game.java
    GroupOfCards.java
    Hand.java
    Main.java
    Player.java
    PlayingCard.java
build.xml
manifest.mf
```

## Notes

- The game starts from `Main.java`.
- `BlackJack` contains the main game flow.
- The project is designed as a classroom starter project, so the code is intentionally kept simple and easy to extend.