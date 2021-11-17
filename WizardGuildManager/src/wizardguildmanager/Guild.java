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
public class Guild {

    private String name;
    private String slogan;
    private Boolean typeOfGuild;
    public static ArrayList<Member> members;
    private ArrayList<Mission> availableMissions;
    private int money;

    public Guild(String name, String slogan, Boolean typeOfGuild) {
        this.name = name;
        this.slogan = slogan;
        this.typeOfGuild = typeOfGuild;
    }

    public String getName() {
        return name;
    }

    public String getSlogan() {
        return slogan;
    }

    public Boolean getTypeOfGuild() {
        return typeOfGuild;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public Integer getNumberOfMembers() {
        return this.members.size();
    }

    public ArrayList<Mission> getAvailableMissions() {
        return availableMissions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public void setTypeOfGuild(Boolean typeOfGuild) {
        this.typeOfGuild = typeOfGuild;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public void setAvailableMissions(ArrayList<Mission> availableMissions) {
        this.availableMissions = availableMissions;
    }

    public void addMember(Member member) {
        this.members.add(member);
    }

    public void removeMember(Member member) {
        this.members.remove(member);
    }

    public void addMission(Mission mission) {
        this.availableMissions.add(mission);
    }

    public void removeMission(Mission mission) {
        this.availableMissions.remove(mission);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "------------" + name + "------------" + "\nLe slogan est '" + slogan + "'\nC'est une guilde " + (typeOfGuild? "officielle" : "clandestine") + "\nLes missions disponibles sont les suivantes : " + availableMissions + "\nVous possédez " + money + " crédits";
    }

}
