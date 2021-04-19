/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.child;

import ca.sheridancollege.project.parent.Card;

/**
 *
 * @author Jennifer
 */
public class BJCard extends Card{

 
 public enum Suit{HEARTS,CLUBS,SPADES,DIAMONDS};
 public enum Value{ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
 private final Suit suit;
 private final Value value;
 
 public BJCard(Suit s, Value gVal)
 {
 suit = s;
 value= gVal;
 }
public Value getValue() {
return this.value;
}
public Suit getSuit() {
return this.suit;
}

 @Override
 public String toString() {
    return getValue().toString() + " of " + getSuit().toString();
}

}

