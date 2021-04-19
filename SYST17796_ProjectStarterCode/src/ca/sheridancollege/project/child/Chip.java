/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.child;

/**
 * 
 * @author Timothy Quan
 */
public enum Chip {

    FIVE_HUNDRED(500),
    ONE_HUNDRED(100),
    TWENTY_FIVE(25),
    TEN(10),
    FIVE(5),
    ONE(1);

    private int value;

    /**
     * Give chip enum a numeric value
     *
     * @param value the value of a chip  
     */
    private Chip(int value) {
        this.value = value;
    }

    /**
     * Returns value of chip enum
     *
     * @return chip value 
     */
    public int getValue() {
        return this.value;
    }
    
}
