/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;

/**
 *
 * @author ybert
 */
public enum Tier {
    S,
    A,
    B,
    C;

    /**
     *
     * @param tier
     * @return the tier in String
     */
    public String toString(Tier tier) 
    {
        return switch (tier) 
        {
             case S -> "S";
             case A -> "A";
             case B -> "B";
             case C -> "C";
             default -> "C";
        }; 
    }

    /**
     *
     * @param tier
     * @return the tier in Integer (1 is the higher S and it deacrease linearly)
     */
    public static Integer toInteger(Tier tier)
    {
        return switch (tier) 
        {
             case S -> 1;
             case A -> 2;
             case B -> 3;
             case C -> 4;
        };         
    }

    /**
     *
     * @param tier
     * @return the superior tier of the tier in argument
     */
    public static Tier tierUp(Tier tier)
    {
        Integer tierInt = Tier.toInteger(tier);
        switch(tierInt)
        {
            case 2 -> {
                return S;
            }
            case 3 -> {
                return A;
            }
            case 4 -> {
                return B;
            }
            default -> {
                return tier;
            }
        }
    }
}


