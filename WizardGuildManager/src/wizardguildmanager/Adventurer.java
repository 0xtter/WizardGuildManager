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
    private ArrayList <Adventurer> friends;
    private Abilities abilities;
    private ArrayList <Mission> missions;

    public Adventurer(Tier tier, Integer experience, ArrayList<Adventurer> friends, Abilities abilities, ArrayList<Mission> missions, String name, Boolean gender, Integer age, Personality personality, Integer memberTag) {
        super(name, gender, age, personality, memberTag);
        this.tier = tier;
        this.experience = experience;
        this.friends = friends;
        this.abilities = abilities;
        this.missions = missions;
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

    public ArrayList<Mission> getMissions() {
        return missions;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void setFriends(ArrayList<Adventurer> friends) {
        this.friends = friends;
    }

    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }

    public void setMissions(ArrayList<Mission> missions) {
        this.missions = missions;
    }
    public void addFriend(Adventurer adventurer) {
        this.friends.add(adventurer);
    }
    public void levelUP() {
        System.out.println("to complete");
    }
    public void goOnMission() {
        System.out.println("to complete");
    }
}
