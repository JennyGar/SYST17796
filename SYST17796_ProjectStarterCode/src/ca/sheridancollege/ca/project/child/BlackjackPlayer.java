/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.ca.project.child;

import ca.sheridancollege.project.parent.Player;
import java.util.ArrayList;

/**
 *
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
    
    public BlackjackPlayer(String name) {
        super(name);
    }
    
    public ArrayList <Chip> getChips() 
    {
        return this.chips;
    }
    
    public int getTimesPlayed() {
        return this.timesPlayed;
    }
    
    public ArrayList <Chip> getChipsBet() 
    {
        return this.chipsBet;
    }
    
    public JavaHand getHand() {
        return this.playerHand;
    }
    
    public void play() {
        if (this.timesPlayed == 0) {
            initializeChips();
        }
        displayChips();
        this.timesPlayed++;
        
    }
    
    public void initializeHand() {
        playerHand = new JavaHand(2);
        playerHand.DiscardHand();
    }
    
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
    
    public int cashOut() {
        int winnings = 0;
        for (int i = 0; i < this.chips.size(); i++) {
            winnings += chips.get(i).getValue();
        }
        return winnings;
    }
    
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
