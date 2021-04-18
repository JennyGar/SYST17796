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
public class TesterClass {
    public static void main(String[] args) {
    BJCard C1 = new BJCard(BJCard.Suit.HEARTS, BJCard.Value.ACE);
    
    String S = C1.toString();
    
    System.out.println(S);
    
    
   JavaDeck N1 = new JavaDeck();
   N1.shuffle();
   JavaHand H1 = new JavaHand(2);
   
   H1.addCard(N1.rCard());
   H1.addCard(N1.rCard());
   H1.addCard(N1.rCard());
   
   System.out.println(H1.toString());
   System.out.println(H1.addCards());
   
   H1.DiscardHand();
   H1.addCard(N1.rCard());
   
   System.out.println(H1.toString());
}
}