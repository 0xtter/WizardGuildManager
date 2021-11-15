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
public enum Personality {
    HYPERACTIVE,
    WISE,
    OPTIMISTIC,
    PEACFUL,
    SELFISH;
    
    /**
     *
     * @return a random personality
     */
    public static Personality rdPersonality()
    {
        int nombreAleatoire = 1 + (int)(Math.random() * ((5 - 1) + 1));
        return switch (nombreAleatoire) {
            case 1 -> HYPERACTIVE;
            case 2 -> WISE;
            case 3 -> OPTIMISTIC;
            case 4 -> PEACFUL;
            case 5 -> SELFISH;
            default -> WISE;
        };
    }
}
