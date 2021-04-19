/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.child;

import ca.sheridancollege.project.parent.Player;
import java.util.ArrayList;

/**
 * Associates a deck, a hand, and chips to a single playerID.
 * Keeps track of the associated chips and has methods to add or remove them. 
 * @author Timothy Quan
 */
public class BlackjackPlayer extends Player {
    
    private ArrayList <Chip> chips;
    private int timesPlayed = 0;
    private ArrayList <Chip> chipsBet;
    private JavaHand playerHand;
    
    public BlackjackPlayer() {
        super("DefaultID");
    }
    
    /**
     * constructor modeled off parent constructor. 
     * @param name 
     */
    public BlackjackPlayer(String name) {
        super(name);
    }
    
    /**
     * 
     * @return chips arraylist
     */
    public ArrayList <Chip> getChips() 
    {
        return this.chips;
    }
    
    /**
     * 
     * @return timesplayed.
     */
    public int getTimesPlayed() {
        return this.timesPlayed;
    }
    
    /**
     * 
     * @return chipsbet arraylist.
     */
    public ArrayList <Chip> getChipsBet() 
    {
        return this.chipsBet;
    }
    
    /**
     * 
     * @return playerHand.
     */
    public JavaHand getHand() {
        return this.playerHand;
    }
    
    //checks games played, if no games have been played by player yet adds a fresh set of chips
    public void play() {
        if (this.timesPlayed == 0) {
            initializeChips();
        }
        displayChips();
        this.timesPlayed++;
        
    }
    
    //creates new blackjack hand
    public void initializeHand() {
        playerHand = new JavaHand(2);
        playerHand.DiscardHand();
    }
    
    //creates new set of chips with set number of amounts for each value
    public void initializeChips() {
        chips = new ArrayList();
        chips.add(Chip.FIVE_HUNDRED);
        for (int i = 0; i < 2; i++) {
            chips.add(Chip.ONE_HUNDRED);
        }
        for (int i = 0; i < 3; i++) {
            chips.add(Chip.TWENTY_FIVE);
        }
        for (int i = 0; i < 4; i++) {
            chips.add(Chip.TEN);
        }
        for (int i = 0; i < 5; i++) {
            chips.add(Chip.FIVE);
        }
        for (int i = 0; i < 10; i++) {
            chips.add(Chip.ONE);
        }
    }
    
    //prints owned chips (and values) to screen
    public void displayChips() {
        int[] chipCount = chipCount();
        
        System.out.print(getPlayerID() + ", you have " + chipCount[0] + " $500 Chips");
        System.out.print(", " + chipCount[1] + " $100 Chips");
        System.out.print(", " + chipCount[2] + " $25 Chips");
        System.out.print(", " + chipCount[3] + " $10 Chips");
        System.out.print(", " + chipCount[4] + " $5 Chips");
        System.out.println(" and " + chipCount[5] + " $1 Chips");
        System.out.println("Total: $" + cashOut());
    }
    /**
     * 
     * @return array of a number count for each chip value. 
     */
    public int[] chipCount() {
        int fiveHundredCount = 0;
        int oneHundredCount = 0;
        int twentyFiveCount = 0;
        int tenCount = 0;
        int fiveCount = 0;
        int oneCount = 0;
        for (int i = 0; i < this.chips.size(); i++) {
            if (this.chips.get(i) == Chip.FIVE_HUNDRED) {
                fiveHundredCount++;
            } else if (this.chips.get(i) == Chip.ONE_HUNDRED) {
                oneHundredCount++;
            } else if (this.chips.get(i) == Chip.TWENTY_FIVE) {
                twentyFiveCount++;
            } else if (this.chips.get(i) == Chip.TEN) {
                tenCount++;
            } else if (this.chips.get(i) == Chip.FIVE) {
                fiveCount++;
            } else if (this.chips.get(i) == Chip.ONE) {
                oneCount++;
            }
        }
        int[] chipCount = new int[]{fiveHundredCount, oneHundredCount, twentyFiveCount,tenCount, fiveCount, oneCount};
        return chipCount;
    }
    /**
     * takes in amount of chips for each type and adds them to their respective arrays to keep track
     * @param fiveHundred
     * @param oneHundred
     * @param twentyFive
     * @param ten
     * @param five
     * @param one 
     */
    public void bet(int fiveHundred, int oneHundred, int twentyFive, int ten, int five, int one) {
        chipsBet = new ArrayList();
        for (int i = 0; i < fiveHundred; i++) {
            chipsBet.add(Chip.FIVE_HUNDRED);
        }
        for (int i = 0; i < oneHundred; i++) {
            chipsBet.add(Chip.ONE_HUNDRED);
        }
        for (int i = 0; i < twentyFive; i++) {
            chipsBet.add(Chip.TWENTY_FIVE);
        }
        for (int i = 0; i < ten; i++) {
            chipsBet.add(Chip.TEN);
        }
        for (int i = 0; i < five; i++) {
            chipsBet.add(Chip.FIVE);
        }
        for (int i = 0; i < one; i++) {
            chipsBet.add(Chip.ONE);
        }
    }
    
    /**
     * 
     * @return numerical value of chips won after winning a game
     */
    public int cashOut() {
        int winnings = 0;
        for (int i = 0; i < this.chips.size(); i++) {
            winnings += chips.get(i).getValue();
        }
        return winnings;
    }
    
    /**
     * compares players to see if they are equal. 
     * @param other
     * @return 
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        
        if (other instanceof Player) {
            Player otherPlayer = (Player) other;
            return getPlayerID().equalsIgnoreCase(otherPlayer.getPlayerID());
        } else {
            return false;
        }
  
    }
    
    
}
