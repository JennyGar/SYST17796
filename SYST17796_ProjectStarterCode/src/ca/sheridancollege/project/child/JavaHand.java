/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.child;

import ca.sheridancollege.project.parent.Card;
import ca.sheridancollege.project.parent.GroupOfCards;

/**
 * Class intended for a small amount of cards, with functionality to add the value of all of the cards. 
 * @author Jennifer
 */
public class JavaHand extends GroupOfCards {

    
    /**
     * 
     * @param givenSize 
     * Constructor 
     */
    public JavaHand(int givenSize) {
        super(givenSize);
    }

    /**
     * 
     * @return sums up value of hand based on blackjack values. 
     * Ace can be 1 or 11 depending on which one gets closer to 21 but does not cause the hand value to go over.
     * Number of aces are counted, and added last to deal with variance possibilities.
     */
    public int addCards() {
        int i = 0;
        int a = 0;
        for (Card card : super.showCards()) {
            BJCard C1 = (BJCard) card;
            if (C1.getValue() == BJCard.Value.TWO) 
                i += 2;           
            else if (C1.getValue() == BJCard.Value.THREE) 
                i += 3;
            else if (C1.getValue() == BJCard.Value.FOUR) 
                i += 4;
            else if (C1.getValue() == BJCard.Value.FIVE) 
                i += 5;
            else if (C1.getValue() == BJCard.Value.SIX) 
                i += 6;
            else if (C1.getValue() == BJCard.Value.SEVEN) 
                i += 7;
            else if (C1.getValue() == BJCard.Value.EIGHT) 
                i += 8;
            else if (C1.getValue() == BJCard.Value.NINE) 
                i += 9;
            else if (C1.getValue() == BJCard.Value.TEN) 
                i += 10;
            else if (C1.getValue() == BJCard.Value.JACK) 
                i += 10;
            else if (C1.getValue() == BJCard.Value.QUEEN) 
                i += 10;
            else if (C1.getValue() == BJCard.Value.KING) 
                i += 10;
            else 
                a += 1;
        } while (a>0) {
            if (i > 10) 
                i += 1;
            else
                i += 11;
            a--;
        }       
        return i;
        }
   
    // removes all cards in hand - keeps the hand array to add cards to it.

    public void DiscardHand() {
        super.showCards().clear();
    }
    /**
     * @return String listing the suit and value of each card in the hand.
     * 
     */
    @Override
    public String toString() {
        String printstuff = "";
        for(Card card : super.showCards()) {
            printstuff = printstuff + "\n" + card.toString();
        }
        return printstuff;
    }
}


//Take card from deck
//JavaHand.addCard(JavaDeck.rCard);