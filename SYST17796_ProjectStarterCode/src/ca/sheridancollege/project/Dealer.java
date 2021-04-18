/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author Timothy Quan
 */
public class Dealer {
    
    private static Dealer dealer = null;
    private final String dealerID = "AI Dealer";
    private Hand hand;
    
    private Dealer() {
    }
    
    /**
     * @return the dealerID
     */
    public String getDealerID() 
    {
        return this.dealerID;
    }
    
    public Hand getHand() {
        return this.hand;
    }
    
    public static Dealer getInstance() {
        if (dealer==null) {
            dealer = new Dealer();
        }
        return dealer;
    }
    
}
