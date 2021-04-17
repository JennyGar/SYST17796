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
public enum Chip {

    FIVE_HUNDRED(500),
    ONE_HUNDRED(100),
    TWENTY_FIVE(25),
    TEN(10),
    FIVE(5),
    ONE(1);

    private int value;

    private Chip(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
}
