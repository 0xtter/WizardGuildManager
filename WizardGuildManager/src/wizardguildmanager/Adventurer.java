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
public class Adventurer extends Member{
    private Tier tier;
    private Integer experience;
    private Abilities abilities;
    private MagicType magicType;
    
    public Adventurer(Tier tier, Integer experience,  Abilities abilities, String name, Boolean gender, Integer age, Personality personality, Integer memberTag, MagicType magicType) {
        super(name, gender, age, personality, memberTag);
        this.tier = tier;
        this.experience = experience;
        this.abilities = abilities;
        this.magicType = magicType;
    }
    
    @Override
    public void talk()
    {
        System.out.println("Salut ! Je suis " + this.getName() + ", je suis de rang " + this.getTier().toString(this.getTier()) + ". Je maîtrise la magie "+ this.getMagicType().toString(this.getMagicType()) + " et voici mes commpétences :\n" + this.abilities.toString());
    }
    public Tier getTier() {
        return tier;
    }

    public Integer getExperience() {
        return experience;
    }

    public ArrayList<Adventurer> getFriends() {
        return friends;
    }

    public Abilities getAbilities() {
        return abilities;
    }



    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }



    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }


    public void levelUP() {
        System.out.println("to complete");
    }
    public void goOnMission() {
        System.out.println("to complete");
    }
    public MagicType getMagicType() {
        return magicType;
    }

    public void setMagicType(MagicType magicType) {
        this.magicType = magicType;
    }
}
