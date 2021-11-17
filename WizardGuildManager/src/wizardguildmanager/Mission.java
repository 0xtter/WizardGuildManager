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
public class Mission {
    private String entitled;
    private Tier difficulty;
    private MagicType affinity;
    private Abilities aptitudesNeeded;
    private String description;
    private Integer reward;

    /**
     * constructor
     * @param entitled
     * @param difficulty
     * @param affinity
     * @param aptitudesNeeded
     * @param description
     * @param reward
     */
    public Mission(String entitled, Tier difficulty, MagicType affinity, Abilities aptitudesNeeded, String description, Integer reward) {
        this.entitled = entitled;
        this.difficulty = difficulty;
        this.affinity = affinity;
        this.aptitudesNeeded = aptitudesNeeded;
        this.description = description;
        this.reward = reward;
    }

    /**
     *
     * @return the title of the mission
     */
    public String getEntitled() {
        return entitled;
    }

    /**
     * set the title of the mission
     * @param entitled 
     */
    public void setEntitled(String entitled) {
        this.entitled = entitled;
    }

    /**
     *
     * @return the difficulty of the mission
     */
    public Tier getDifficulty() {
        return difficulty;
    }

    /**
     *
     * @return the affinity of the mission
     */
    public MagicType getAffinity() {
        return affinity;
    }

    /**
     *
     * @return the aptitudes needed of the mission
     */
    public Abilities getAptitudesNeeded() {
        return aptitudesNeeded;
    }

    /**
     *
     * @return the description of the mission
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return the reward of the mission
     */
    public Integer getReward() {
        return reward;
    }

    /**
     * set the difficulty of the mission
     * @param difficulty
     */
    public void setDifficulty(Tier difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * set the affinity needed for the mission
     * @param affinity
     */
    public void setAffinity(MagicType affinity) {
        this.affinity = affinity;
    }

    /**
     * set the abilities needed for the mission
     * @param aptitudesNeeded
     */
    public void setAptitudesNeeded(Abilities aptitudesNeeded) {
        this.aptitudesNeeded = aptitudesNeeded;
    }

    /**
     * set the description of the mission
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * set the reward of the mission
     * @param reward
     */
    public void setReward(Integer reward) {
        this.reward = reward;
    }



}