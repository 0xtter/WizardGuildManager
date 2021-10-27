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
public class Guild {
    private String name;
    private String slogan;
    private Boolean typeOfGuild;
    private ArrayList <Member> members;
    private Integer numberOfMembers;
    private ArrayList <Mission> availableMissions;
    private int money;
    
    public Guild(String name, String slogan, Boolean typeOfGuild, ArrayList<Member> members, Integer numberOfMembers, ArrayList<Mission> availableMissions, int money) {
        this.name = name;
        this.slogan = slogan;
        this.typeOfGuild = typeOfGuild;
        this.members = members;
        this.numberOfMembers = numberOfMembers;
        this.availableMissions = availableMissions;
        this.money = money;
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
        return numberOfMembers;
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

    public void setNumberOfMembers(Integer numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
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
    
}
