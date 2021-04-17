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
public class Blackjack extends Game {
    
    private Dealer dealer;

    public Blackjack(String givenName) {
        super(givenName);
    }
    
    
    public void play() {
        
    }
    
    public boolean isAlreadyRegistered(BlackjackPlayer player) {
        return getPlayers().contains(player);
    }
    
    public void registerPlayer(BlackjackPlayer player) {
        getPlayers().add(player);
    }
    
}
