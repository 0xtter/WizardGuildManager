/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import static wizardguildmanager.GuildMaster.keyboard;
import static wizardguildmanager.File.Fichier.createListMission;

/**
 *
 * @author ybert
 */
public class Guild {

    private String name;
    private String slogan;
    private Boolean typeOfGuild;
    private ArrayList<Member> members;
    private ArrayList<Mission> availableMissions;
    private int money;

    public Guild(String name, String slogan, Boolean typeOfGuild) {
        this.name = name;
        this.slogan = slogan;
        this.typeOfGuild = typeOfGuild;
    }

    public Guild(){}

    public static Guild createGuild() {
        Scanner keyboard = new Scanner(System.in);
        Guild guild = new Guild();
        GuildMaster gm = new GuildMaster("Nom du Maitre de Guilde", true, 0, Personality.OPTIMISTIC, 1);
        try {
            System.out.print("\nEntrez le nom de la guilde que vous souhaitez créer :");
            guild.setName(keyboard.nextLine());

            System.out.print("\nEntrez le slogan de la guilde " + guild.getName() + "?");
            guild.setSlogan(keyboard.nextLine());

            Integer guildType = -1;
            do {
                try {
                    System.out.print("\nLa guilde " + guild.getName() + " est-elle une guilde officielle(1) ou clandestine(0)?");
                    guildType = Integer.parseInt(keyboard.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Veuillez entrer le nombre 0 ou 1");
                }
            } while (!(guildType == 1 || guildType == 0));

            guild.setTypeOfGuild((guildType == 1) ? Boolean.TRUE : Boolean.FALSE);
            guild.setAvailableMissions(createListMission());
            guild.setMembers(new ArrayList<>());
            guild.setMoney(300);
            System.out.println("\n" + guild.toString() + "\n");
            //Création du Guild Master

            gm = createGuildMaster(guild);
            guild.addMember(gm);
        } catch (InputMismatchException e) {
            System.out.println("Une erreur a eu lieu lors de la création de la guilde... Veuillez réessayer");
            keyboard = new Scanner(System.in); //On reset le buffer d'entrée pour éviter toute nouvelle erreur suite à une ancienne entrée
            Guild.createGuild();
        }
        return guild;
    }

    private static GuildMaster createGuildMaster(Guild guild) {

        Boolean gender;
        System.out.print("\nQuel nom voulez vous donner à votre Maître de guilde ?");
        String name = keyboard.nextLine();
        Integer genderType = -1;
        do {
            try {
                System.out.print("\nEst-ce que votre mage est un Homme(0) Femme(1)");
                genderType = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer le nombre 0 ou 1");
            }
        } while (!(genderType == 1 || genderType == 0));
        gender = (genderType.equals(1));
        Integer age = -1;
        do {
            try {
                System.out.print("\nQuel est l'âge du Maître de guilde?");
                age = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un entier positif");
            }
        } while (!(age > 0));
        Personality personality = Personality.rdPersonality();
        return new GuildMaster(name, gender, age, personality, 0);
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
        String str;
        str = "------------" + this.name + "------------" + "\nLe slogan est '" + this.slogan + "'\nC'est une guilde " + (this.typeOfGuild ? "officielle" : "clandestine") + "\nLes missions disponibles sont les suivantes : |";
        for (Mission mission : this.availableMissions) {
            str += "|" + mission.getEntitled() + "|";
        }
        str += "\nVotre guilde est composée de " + this.getNumberOfMembers() + " membres";
        str += "\nVous possédez " + this.money + " pièces d'or";

        return str;
    }

}
