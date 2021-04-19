/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.child;

import ca.sheridancollege.project.parent.Card;
import ca.sheridancollege.project.parent.GroupOfCards;

/**
 * Deck class for blackjack with a default constructor to make a regular deck of 52 cards. 
 * @author Jennifer
 */
public class JavaDeck extends GroupOfCards {


    public JavaDeck() {
        super(52);  
        addFull();
    }
    
    
    // removes all cards and adds back 52 returning deck to original status after being constructed.  
    public void resetDeck() {
        super.showCards().clear();
        addFull();
    }
    
    // adds a card of each possible value & suit combination.
   
    private void addFull() {
        for (BJCard.Suit suit: BJCard.Suit.values()) {
            for (BJCard.Value value: BJCard.Value.values()) {
                BJCard C1 = new BJCard(suit,value);
                addCard(C1);
            }
        }
    }
    
    /**
     * 
     * @return a card from the deck after removing it.
     */
    public Card rCard() {
        return super.showCards().remove(super.showCards().size()-1);
    }
    
}