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
    @Override
    public String toString(Tier this) 
    {
        return switch (this) 
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
     * @return the superior tier of the tier in argument
     */
    public static Tier tierUp(Tier tier)
    {
        Integer tierInt = tier.ordinal() + 1;
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
    
    /**
     *
     * @param difficulty
     * @return the tier that correspond to the string
     */
    public static Tier setTier(String difficulty) //assigne un tier de l'enum tier
    {
        return switch (difficulty) {
            case "S" -> Tier.S;
            case "A" -> Tier.A;
            case "B" -> Tier.B;
            case "C" -> Tier.C;
            default -> Tier.C;
        };               
}
}


