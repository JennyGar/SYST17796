/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author Jennifer
 */
public class JavaDeck extends GroupOfCards {

    public JavaDeck() {
        super(52);  
        addFull();
    }
    
    public void resetDeck() {
        super.showCards().clear();
        addFull();
    }
    
    private void addFull() {
        for (BJCard.Suit suit: BJCard.Suit.values()) {
            for (BJCard.Value value: BJCard.Value.values()) {
                BJCard C1 = new BJCard(suit,value);
                addCard(C1);
            }
        }
    }
    
    public Card rCard() {
        return super.showCards().remove(super.showCards().size()-1);
    }
    
}