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

    
    /**
     *
     * @param mission
     * @param adventurer
     * @return calculate the proba in successing the mission with the characteristic of the adventurer ans what it's needed in the mission
     */
    public Integer probaCalculation(Adventurer adventurer)
    {
        Integer proba = 100;
        Integer DifficultyInt =  this.getDifficulty().ordinal() + 1;
        Integer TierInt = adventurer.getTier().ordinal() + 1;
        if (TierInt < DifficultyInt) proba = proba - (DifficultyInt - TierInt) * 15;
        if (adventurer.getAbilities().getStrength() < this.getAptitudesNeeded().getStrength()) proba = proba - (this.getAptitudesNeeded().getStrength() - adventurer.getAbilities().getStrength()) * 5;
        if (adventurer.getAbilities().getIntelligence()< this.getAptitudesNeeded().getIntelligence()) proba = proba - (this.getAptitudesNeeded().getIntelligence() - adventurer.getAbilities().getIntelligence()) * 5;
        if (adventurer.getAbilities().getEndurance()< this.getAptitudesNeeded().getEndurance()) proba = proba - (this.getAptitudesNeeded().getEndurance() - adventurer.getAbilities().getEndurance()) * 5;
        if (adventurer.getAbilities().getWidsom()< this.getAptitudesNeeded().getWidsom()) proba = proba - (this.getAptitudesNeeded().getWidsom() - adventurer.getAbilities().getWidsom()) * 5;  
        if (adventurer.getAbilities().getCharm()< this.getAptitudesNeeded().getCharm()) proba = proba - (this.getAptitudesNeeded().getCharm() - adventurer.getAbilities().getCharm()) * 5;
        if (! this.getAffinity().equals(adventurer.getMagicType())) proba = proba - 25;
        
        if (proba < 0) return 0;
        else return proba;
    }
    
    /**
     *
     * @param proba
     * @return true with the probability of proba%, else it's false
     */
    public static boolean success(Integer proba)
    {
        int nombreAleatoire = 0 + (int)(Math.random() * ((100 - 0) + 1));
        Integer nombre = (Integer)nombreAleatoire;
        return (proba >= nombre);
    }

}