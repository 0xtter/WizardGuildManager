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

}


