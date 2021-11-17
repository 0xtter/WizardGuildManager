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
    private String entitled;
    private Tier difficulty;
    private MagicType affinity;
    private Abilities aptitudesNeeded;
    private String description;
    private Integer reward;

    public Mission(String entitled, Tier difficulty, MagicType affinity, Abilities aptitudesNeeded, String description, Integer reward) {
        this.entitled = entitled;
        this.difficulty = difficulty;
        this.affinity = affinity;
        this.aptitudesNeeded = aptitudesNeeded;
        this.description = description;
        this.reward = reward;
    }
    public Mission(){
        System.out.println("created mission");
    }

    public String getEntitled() {
        return entitled;
    }

    public void setEntitled(String entitled) {
        this.entitled = entitled;
    }


    public Tier getDifficulty() {
        return difficulty;
    }

    public MagicType getAffinity() {
        return affinity;
    }

    public Abilities getAptitudesNeeded() {
        return aptitudesNeeded;
    }

    public String getDescription() {
        return description;
    }

    public Integer getReward() {
        return reward;
    }

    public void setDifficulty(Tier difficulty) {
        this.difficulty = difficulty;
    }

    public void setAffinity(MagicType affinity) {
        this.affinity = affinity;
    }

    public void setAptitudesNeeded(Abilities aptitudesNeeded) {
        this.aptitudesNeeded = aptitudesNeeded;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReward(Integer reward) {
        this.reward = reward;
    }
}