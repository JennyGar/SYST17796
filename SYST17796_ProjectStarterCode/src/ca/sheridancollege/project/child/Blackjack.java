/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.child;

import ca.sheridancollege.project.parent.Game;
import java.util.Collections;

/**
 *
 * @author Timothy Quan
 */
public class Blackjack extends Game {
    
    private JavaDeck cardDeck;
    private JavaHand dealerHand;

    public Blackjack(String givenName) {
        super(givenName);
    }
    
    public JavaDeck getJavaDeck() {
        return this.cardDeck;
    }
    
     public JavaHand getHand() {
        return this.dealerHand;
    }
    
    public void play() {
        this.cardDeck = new JavaDeck();
        cardDeck.shuffle();
        dealerHand = new JavaHand(2);
        dealerHand.DiscardHand();
        addDealerCard();
    }
    
    public void addDealerCard() {
        dealerHand.addCard(cardDeck.rCard());
    }
    
    public boolean isAlreadyRegistered(BlackjackPlayer player) {
        return getPlayers().contains(player);
    }
    
    public void registerPlayer(BlackjackPlayer player) {
        getPlayers().add(player);
    }
    
    public void dealerTurn() {
        boolean dealerContinue = false;
        do {
            for (int i = 0; i < this.getPlayers().size(); i++) {
                BlackjackPlayer player = (BlackjackPlayer) this.getPlayers().get(i);
                if (this.getHand().addCards() < player.getHand().addCards() && this.getHand().addCards() < 21 && player.getHand().addCards() <= 21) {
                    dealerContinue = true;
                    break;
                } else if (this.getHand().addCards() >= player.getHand().addCards() || this.getHand().addCards() == 21) {
                    dealerContinue = false;
                }
            }
            if (dealerContinue == true) {
                addDealerCard();
                System.out.println("Dealer has: " + this.getHand().toString());
                System.out.println("Card Score: " + this.getHand().addCards());
                System.out.println("");
            }
        } while(dealerContinue == true && this.getHand().addCards() < 21);
    }
    
    public void declareWinner(int playerNum) {
        BlackjackPlayer player = (BlackjackPlayer) this.getPlayers().get(playerNum);
        if ((player.getHand().addCards() > this.getHand().addCards()) && player.getHand().addCards() < 22 && this.getHand().addCards() < 22) {
            winBet(playerNum);
            System.out.print(player.getPlayerID() + ", you won!");
        } else if (this.getHand().addCards() == 21) {
            loseBet(playerNum);
            System.out.print(player.getPlayerID() + ", you lost!");
        } else if (player.getHand().addCards() > 21) {
            loseBet(playerNum);
            System.out.print(player.getPlayerID() + ", you lost!");
        } else if (player.getHand().addCards() <= 21 && this.getHand().addCards() > 21) {
            winBet(playerNum);
            System.out.print(player.getPlayerID() + ", you won!");
        } else if ((player.getHand().addCards() > this.getHand().addCards()) && player.getHand().addCards() < 22 && this.getHand().addCards() < 22) {
            loseBet(playerNum);
            System.out.print(player.getPlayerID() + ", you lost!");
        } else {
            loseBet(playerNum);
            System.out.print(player.getPlayerID() + ", you lost!");
        }
    }
    
    public void winBet(int playerNum) {
        BlackjackPlayer player = (BlackjackPlayer) this.getPlayers().get(playerNum);
        player.getChips().addAll(player.getChipsBet());
        Collections.sort(player.getChips());
    }
    
    public void loseBet(int playerNum) {
        BlackjackPlayer player = (BlackjackPlayer) this.getPlayers().get(playerNum);
        for (int i = 0; i < player.getChipsBet().size(); i++) {
            player.getChips().remove(player.getChipsBet().get(i));
        }
        Collections.sort(player.getChips());
    }
    
}
