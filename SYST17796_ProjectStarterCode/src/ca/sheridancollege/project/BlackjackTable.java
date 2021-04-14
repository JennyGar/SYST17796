/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author teddy
 */
public class BlackjackTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("****Welcome to Blackjack****");
        
        BlackjackPlayer player = new BlackjackPlayer();
        Blackjack blackjack = new Blackjack("Blackjack");
        
        Scanner scanner = new Scanner(System.in);
        
        boolean uniqueID = false;
        do {
            System.out.println("Enter a unique player ID");
            String id = scanner.nextLine();
            player.setPlayerID(id);
            
            
            boolean alreadyRegistered = blackjack.isAlreadyRegistered(player);
            if (alreadyRegistered == true) {
                System.out.println("That player ID is already taken");
            } else {
                blackjack.registerPlayer(player);
                uniqueID = true;
            }
        } while (uniqueID == false);
        
        
        
        
    }
    
}
