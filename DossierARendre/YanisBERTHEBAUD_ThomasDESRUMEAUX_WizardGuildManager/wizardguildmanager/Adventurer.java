/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;

import java.util.Scanner;

/**
 *
 * @author ybert
 */
public class Adventurer extends Member {

    private Tier tier;
    private Integer experience;
    private Abilities abilities;
    private MagicType magicType;

    /**
     * Constructor
     *
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
    public Adventurer(Tier tier, Integer experience, Abilities abilities, String name, Boolean gender, Integer age, Personality personality, Integer memberTag, MagicType magicType) {
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
    public void talk() {
        System.out.println("Salut ! Je suis " + this.getName() + ", je suis un aventurier de rang " + this.getTier().toString() + " avec actuellement " + this.getExperience() + "/1000 d'experience pour monter de Tier." + "\nJe maîtrise la magie de type " + this.getMagicType().toString() + " et voici mes commpétences :\n" + this.abilities.toString());
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
     *
     * @param tier
     */
    public void setTier(Tier tier) {
        this.tier = tier;
    }

    /**
     * set the experience of the adventurer
     *
     * @param experience
     */
    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    /**
     * set the abilities of the adventurer
     *
     * @param abilities
     */
    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }

    /**
     * check if the experience is enough to up the tier of the adventurer and do
     * it if it's the case
     *
     * @param exp
     */
    public void levelUP(Integer exp) {
        Scanner keyboard = new Scanner(System.in);
        this.experience = this.experience + exp;
        if (this.tier.equals(Tier.S)) {
            System.out.println("Tier max atteint, vous ne pouvez plus augmenter !");
        } else {
            if (this.experience >= 1000) {
                this.tier = Tier.tierUp(tier);
                System.out.println("Félicitation! Vous avez été promu au tier " + this.getTier() + " !");
                this.experience = this.experience - 1000;
                Integer point = 2;
                Integer choice = -1;
                while (!point.equals(0)) {
                    do {
                        try {
                            System.out.print("\nVous avez " + point + " points d'abilité à donner à votre mage, quelle abilité voulez vous augmenter ? Force(1) Endurance(2) Sagesse(3) Intelligence(4) Charme(5)");
                            choice = Integer.parseInt(keyboard.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Veuillez entrer un entier positif entre 1 et 5");
                        }
                    } while (!(choice > 0 && choice < 6));
                    Integer number = -1;
                    do {
                        try {
                            System.out.print("\nDe combien souhaitez vous l'augmenter ? (Il vous reste " + point + " points) ");
                            number = Integer.parseInt(keyboard.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Veuillez entrer un entier positif ");
                        }
                    } while (!(number > 0 && number <= point));
                    switch (choice) {
                        case 1 ->
                            this.getAbilities().setStrength(this.getAbilities().getStrength() + number);
                        case 2 ->
                            this.getAbilities().setEndurance(this.getAbilities().getEndurance() + number);
                        case 3 ->
                            this.getAbilities().setWidsom(this.getAbilities().getWidsom() + number);
                        case 4 ->
                            this.getAbilities().setIntelligence(this.getAbilities().getIntelligence() + number);
                        case 5 ->
                            this.getAbilities().setCharm(this.getAbilities().getCharm() + number);
                    }
                    point = point - number;
                }
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
     *
     * @param magicType
     */
    public void setMagicType(MagicType magicType) {
        this.magicType = magicType;
    }

    /**
     * The adventurer go on mission, this function manage the success or not of
     * the mission and give the reward and level up the adventurer in case of
     * succeed, else the guild lose money
     *
     * @param mission
     * @param guild
     */
    public void goOnMission(Mission mission, Guild guild) {
        Integer proba = mission.probaCalculation(this);
        boolean succeedeed = Mission.success(proba);
        if (succeedeed == true) {
            int xpEarned = 100 + (100 - proba) * 10;
            System.out.println("La mission est un succès félicitation ! Vous avez gagné " + mission.getReward() + " pièces d'or et vous avez gagné " + (xpEarned) + " points d'expérience !");
            guild.setMoney(guild.getMoney() + mission.getReward());
            this.levelUP(xpEarned);
        } else {
            guild.setMoney(guild.getMoney() - (Integer) (mission.getReward() / 5));
            System.out.println("Malheureusement vous avez échoué, cette mission n'était pas faite pour vous, vous perdez " + ((Integer) (mission.getReward() / 5)) + " pièces d'or");
        }
    }
}
