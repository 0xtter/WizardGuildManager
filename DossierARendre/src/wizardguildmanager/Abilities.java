/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;

import java.util.Objects;
import static wizardguildmanager.GuildMaster.keyboard;

/**
 *
 * @author ybert
 */
public class Abilities {

    private Integer strength;
    private Integer intelligence;
    private Integer widsom;
    private Integer endurance;
    private Integer charm;

    /**
     *
     * @param strength
     * @param intelligence
     * @param widsom
     * @param endurance
     * @param charm
     */
    public Abilities(Integer strength, Integer intelligence, Integer widsom, Integer endurance, Integer charm) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.widsom = widsom;
        this.endurance = endurance;
        this.charm = charm;
    }

    /**
     *
     * @return Returns the strength of the Adventurer
     */
    public Integer getStrength() {
        return strength;
    }

    /**
     *
     * @return Returns the intelligence of the Adventurer
     */
    public Integer getIntelligence() {
        return intelligence;
    }

    /**
     *
     * @return Returns the widsom of the Adventurer
     */
    public Integer getWidsom() {
        return widsom;
    }

    /**
     *
     * @return Returns the endurance of the Adventurer
     */
    public Integer getEndurance() {
        return endurance;
    }

    /**
     *
     * @return Returns the charm of the Adventurer
     */
    public Integer getCharm() {
        return charm;
    }

    /**
     *
     * @param strength Define the strength of the Adventurer
     */
    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    /**
     *
     * @param intelligence Define the intelligence of the Adventurer
     */
    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    /**
     *
     * @param widsom Define the widsom of the Adventurer
     */
    public void setWidsom(Integer widsom) {
        this.widsom = widsom;
    }

    /**
     *
     * @param endurance Define the endurance of the Adventurer
     */
    public void setEndurance(Integer endurance) {
        this.endurance = endurance;
    }

    /**
     *
     * @param charm Define the charm of the Adventurer
     */
    public void setCharm(Integer charm) {
        this.charm = charm;
    }

    @Override
    public String toString() {
        return "--------Aptitudes--------\nSéduction : " + this.charm + "\nIntelligence : " + this.intelligence + "\nEndurance : " + this.endurance + "\nForce : " + this.strength + "\nSagesse : " + this.widsom + "\n-------------------------"; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return Returns the copy of the Abilities
     * @throws CloneNotSupportedException
     */
    @Override
    protected Abilities clone() throws CloneNotSupportedException {
        return new Abilities(this.strength, this.intelligence, this.widsom, this.endurance, this.charm); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param abilities Compare Abilities with the given one
     * @return Returns True if the Abilities are the sames else returns False
     */
    public boolean equals(Abilities abilities) {
        return Objects.equals(abilities.endurance, this.endurance) && Objects.equals(abilities.intelligence, this.intelligence) && Objects.equals(abilities.strength, this.strength) && Objects.equals(abilities.widsom, this.widsom) && Objects.equals(abilities.charm, this.charm); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * ask for the user to enter the different abilities
     *
     * @return an object abilities
     */
    public static Abilities pointAbility() {
        Integer point = 10;
        Integer strength = -1;
        Integer intelligence = -1;
        Integer widsom = -1;
        Integer endurance = -1;
        Integer charm = -1;
        do {
            try {
                System.out.print("\nCombien de points voulez-vous attribuer en force (entre 0 et 5) sachant qu'il vous reste " + point + " points");
                strength = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un entier positif entre 0 et 5");
            }
        } while ((strength < 0 || strength > 5 || (point - strength) < 0));
        point = point - strength;
        do {
            try {
                System.out.print("\nCombien de points voulez-vous attribuer en intelligence (entre 0 et 5) sachant qu'il vous reste " + point + " points");
                intelligence = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un entier positif entre 0 et 5");
            }
        } while ((intelligence < 0 || intelligence > 5 || (point - intelligence) < 0));
        point = point - intelligence;
        if (point.equals(0)) {
            widsom = 0;
            endurance = 0;
            charm = 0;
        } else {
            do {
                try {
                    System.out.print("\nCombien de points voulez-vous attribuer en sagesse (entre 0 et 5) sachant qu'il vous reste " + point + " points");
                    widsom = Integer.parseInt(keyboard.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Veuillez entrer un entier positif entre 0 et 5");
                }
            } while ((widsom < 0 || widsom > 5 || (point - widsom) < 0));
            point = point - widsom;
            if (point.equals(0)) {
                endurance = 0;
                charm = 0;
            } else {
                do {
                    try {
                        System.out.print("\nCombien de points voulez-vous attribuer en endurance (entre 0 et 5) sachant qu'il vous reste " + point + " points");
                        endurance = Integer.parseInt(keyboard.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Veuillez entrer un entier positif entre 0 et 5");
                    }
                } while ((endurance < 0 || endurance > 5 || (point - endurance) < 0));
                point = point - endurance;
            }
            charm = point;
        }
        Abilities ability = new Abilities(strength, intelligence, widsom, endurance, charm);
        return ability;
    }
}
