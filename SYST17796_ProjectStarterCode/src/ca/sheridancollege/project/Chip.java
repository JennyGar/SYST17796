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

public class Chip {

    public enum Value {
        ONE,
        FIVE,
        TEN,
        TWENTY_FIVE,
        ONE_HUNDRED,
        FIVE_HUNDRED,
        ONE_THOUSAND,
        FIVE_THOUSAND
    }
    private final Value value;

    /**
     *
     * @param gVal
     */
    public Chip(Value gVal) {
        value = gVal;
    }

    public Value getValue() {
        return this.value;
    }
    
    public String toString() {
        return "Chip";
    }

}
