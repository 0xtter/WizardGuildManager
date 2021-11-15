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
public enum MagicType {
    FIRE,
    ICE,
    THUNDER,
    WATER,
    SUMMONER;
    
    /**
     *
     * @param magicType
     * @return the magicType in String
     */
    public String toString(MagicType magicType) {
       return switch (magicType) {
            case FIRE -> "FIRE";
            case ICE -> "ICE";
            case THUNDER -> "THUNDER";
            case WATER -> "WATER";
            case SUMMONER -> "SUMMONER";
            default -> "FIRE";
        };
       
    }
   
}
