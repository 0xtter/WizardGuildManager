/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;

import java.util.ArrayList;

/**
 *
 * @author ybert
 */
public class Mage extends Adventurer{
    private MagicType magicType;

    public Mage(MagicType magicType, Tier tier, Integer experience, ArrayList<Adventurer> friends, Abilities abilities, ArrayList<Mission> missions, String name, Boolean gender, Integer age, Personality personality, Integer memberTag) {
        super(tier, experience, friends, abilities, missions, name, gender, age, personality, memberTag);
        this.magicType = magicType;
    }

    public MagicType getMagicType() {
        return magicType;
    }

    public void setMagicType(MagicType magicType) {
        this.magicType = magicType;
    }
    
}
