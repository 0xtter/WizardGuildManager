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
public class Abilities {
    private Integer strength;
    private Integer intelligence;
    private Integer widsom;
    private Integer endurance;
    private Integer charm;

    public Abilities(Integer strength, Integer intelligence, Integer widsom, Integer endurance, Integer charm) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.widsom = widsom;
        this.endurance = endurance;
        this.charm = charm;
    }

    public Integer getStrength() {
        return strength;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public Integer getWidsom() {
        return widsom;
    }

    public Integer getEndurance() {
        return endurance;
    }

    public Integer getCharm() {
        return charm;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public void setWidsom(Integer widsom) {
        this.widsom = widsom;
    }

    public void setEndurance(Integer endurance) {
        this.endurance = endurance;
    }

    public void setCharm(Integer charm) {
        this.charm = charm;
    }
    
    
}