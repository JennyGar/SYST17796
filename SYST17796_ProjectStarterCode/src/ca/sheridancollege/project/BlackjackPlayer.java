/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author teddy
 */
public class BlackjackPlayer extends Player {
    
    private ArrayList <Chip> chips;
    
    public BlackjackPlayer() {
        super("DefaultID");
    }
    
    public BlackjackPlayer(String name) {
        super(name);
    }
    
    public ArrayList <Chip> getChips() 
    {
        return chips;
    }
    
    public void play() {
        
    }
    
    
}
