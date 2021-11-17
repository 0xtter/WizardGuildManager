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
    @Override
    public String toString(MagicType this) {
       return switch (this) {
            case FIRE -> "FIRE";
            case ICE -> "ICE";
            case THUNDER -> "THUNDER";
            case WATER -> "WATER";
            case SUMMONER -> "SUMMONER";
            default -> "FIRE";
        };
       
    }

    /**
     *
     * @param affinity
     * @return the magic type that correspond to the string
     */
    public static MagicType setMagicType(String affinity) //assigne un magictype de l'enum
    {
        return switch (affinity) {
            case "FIRE" -> MagicType.FIRE;
            case "ICE" -> MagicType.ICE;
            case "THUNDER" -> MagicType.THUNDER;
            case "WATER" -> MagicType.WATER;
            case "SUMMONER" -> MagicType.SUMMONER;
            default -> MagicType.FIRE;
        };               
    }
   
}
