package ca.sheridancollege.project;

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
