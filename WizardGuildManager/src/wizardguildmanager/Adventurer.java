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
public class Adventurer extends Member{
    private Tier tier;
    private Integer experience;
    private Abilities abilities;
    private MagicType magicType;
    
    /**
     * Constructor
     * @param tier
     * @param experience
     * @param abilities
     * @param name
     * @param gender
     * @param age
     * @param personality
     * @param memberTag
     * @param magicType
     */
    public Adventurer(Tier tier, Integer experience,  Abilities abilities, String name, Boolean gender, Integer age, Personality personality, Integer memberTag, MagicType magicType) {
        super(name, gender, age, personality, memberTag);
        this.tier = tier;
        this.experience = experience;
        this.abilities = abilities;
        this.magicType = magicType;
    }
    
    /**
     * the adventurer present himself
     */
    @Override
    public void talk()
    {
        System.out.println("Salut ! Je suis " + this.getName() + ", je suis de rang " + this.getTier().toString() + ". Je maîtrise la magie "+ this.getMagicType().toString() + " et voici mes commpétences :\n" + this.abilities.toString());
    }

    /**
     *
     * @return the tier of the adventurer
     */
    public Tier getTier() {
        return tier;
    }

    /**
     *
     * @return the experience of the adventurer
     */
    public Integer getExperience() {
        return experience;
    }

    /**
     * 
     * @return the abilities of the adventurer
     */
    public Abilities getAbilities() {
        return abilities;
    }

    /**
     * set the tier of the adventurer
     * @param tier
     */
    public void setTier(Tier tier) {
        this.tier = tier;
    }

    /**
     * set the experience of the adventurer
     * @param experience
     */
    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    /**
     * set the abilities of the adventurer
     * @param abilities
     */
    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }

    /**
     * check if the experience is enough to up the tier of the adventurer and do it if it's the case
     * @param exp
     */
    public void levelUP(Integer exp) {
        this.experience = this.experience + exp;
        if (this.tier.equals(Tier.S)) System.out.println("Tier max atteint, vous ne pouvez plus augmenter !");
        else
        {
            if (this.experience >= 1000) {
                this.tier = Tier.tierUp(tier);
                this.experience = this.experience - 1000;
            }
        }
    }

    /**
     * 
     * @return the magic type of the adventurer
     */
    public MagicType getMagicType() {
        return magicType;
    }

    /**
     * set the magic type of the adventurer
     * @param magicType
     */
    public void setMagicType(MagicType magicType) {
        this.magicType = magicType;
    }

    /**
     * The adventurer go on mission, this function manage the success or not of the mission and give the reward and level up the adventurer in case of succeed, else the guild lose money
     * @param mission
     * @param guild
     */
    public void goOnMission(Mission mission, Guild guild) {
        Integer proba = mission.probaCalculation(this);
        boolean succeedeed = Mission.success(proba);
        if (succeedeed == true)
        {
            System.out.println("La mission est un succès félicitation ! Vous avez gagné " + mission.getReward() + " pièces d'or et vous avez gagné " + (100 + 100 - proba) + " points d'expérience !");
            guild.setMoney(guild.getMoney() + mission.getReward());
            this.levelUP(100 + 100 - proba);
        }
        else
        {
            guild.setMoney(guild.getMoney() - (Integer)(mission.getReward()/5));
            System.out.println("Malheureusement vous avez échoué, cette mission n'était pas faite pour vous, vous perdez " + ((Integer)(mission.getReward()/5)) + " pièces d'or");
        }
        
    }
}
