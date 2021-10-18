/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author ybert
 */
public class Mission {
    private Tier difficulty;
    private ArrayList <MagicType> affinity;
    private ArrayList <Abilities> aptitudesNeeded;
    private String description;

    public Mission(Tier difficulty, ArrayList<MagicType> affinity, ArrayList<Abilities> aptitudesNeeded, String description) {
        this.difficulty = difficulty;
        this.affinity = affinity;
        this.aptitudesNeeded = aptitudesNeeded;
        this.description = description;
    }

    public Tier getDifficulty() {
        return difficulty;
    }

    public ArrayList<MagicType> getAffinity() {
        return affinity;
    }

    public ArrayList<Abilities> getAptitudesNeeded() {
        return aptitudesNeeded;
    }

    public String getDescription() {
        return description;
    }

    public void setDifficulty(Tier difficulty) {
        this.difficulty = difficulty;
    }

    public void setAffinity(ArrayList<MagicType> affinity) {
        this.affinity = affinity;
    }

    public void setAptitudesNeeded(ArrayList<Abilities> aptitudesNeeded) {
        this.aptitudesNeeded = aptitudesNeeded;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}