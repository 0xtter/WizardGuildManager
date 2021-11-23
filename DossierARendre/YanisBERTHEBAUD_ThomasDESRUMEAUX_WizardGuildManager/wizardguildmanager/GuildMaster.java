/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ybert
 */
public class GuildMaster extends Member implements MissionWriter {

    /**
     * Constructor
     *
     * @param name
     * @param gender
     * @param age
     * @param personality
     * @param memberTag
     */
    public GuildMaster(String name, Boolean gender, Integer age, Personality personality, Integer memberTag) {
        super(name, gender, age, personality, memberTag);
    }
    static Scanner keyboard = new Scanner(System.in);

    /**
     * The guild master present himself
     */
    @Override
    public void talk() {
        System.out.println("Bonjour, je suis " + this.getName() + " le maître de cette guilde, je suis là pour tous vous protéger !");
    }

    @Override
    public void writeMissionManuscript(Mission mission) {
        try {
            MissionWriter.super.writeMissionManuscript(mission);
        } catch (IOException ex) {
            System.out.println("Il n'y a plus d'encre!");
        }
    }

    /**
     * Ask for the characteristic of an adventurer or an emplyee depending
     * "choice" (1 for adventurer, 2 for employee) and add this member to the
     * guild
     *
     * @param choice
     * @param guild
     */
    public void recruitMember(int choice, Guild guild) {
        if (guild.getMoney() < 50) {
            System.out.println("Vous ne possedez pas assez de pièces d'or... Essayez donc de partir en mission pour vous en faire!");
            return;
        }
        Boolean gender;
        System.out.print("\nQuel nom voulez vous donner à votre membre ?");
        String name = keyboard.nextLine();
        Integer genderType = -1;
        do {
            try {
                System.out.print("\nEst-ce que votre membre est un Homme(0) Femme(1)");
                genderType = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Veuillez entrer le nombre 0) ou 1)");
            }
        } while (!(genderType == 1 || genderType == 0));
        gender = (genderType.equals(1));
        Integer age = -1;
        do {
            try {
                System.out.print("\nQuel est l'âge de votre membre ?");
                age = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("\nVeuillez entrer un entier positif");
            }
        } while (!(age > 0));
        Personality personality = Personality.rdPersonality();
        Integer tag = guild.getNumberOfMembers();
        switch (choice) {
            case 1 -> {
                System.out.println("\nVous avez 10 points d'abilité à répartir");
                Abilities ability = Abilities.pointAbility();
                Integer magicNumber = -1;
                do {
                    try {
                        System.out.print("\nQuel type de magie votre mage maîtrise ? Fire(1) Ice(2) Thunder(3) Water(4) Summoner(5) ");
                        magicNumber = Integer.parseInt(keyboard.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Veuillez entrer un entier positif entre 1 et 5");
                    }
                } while (!(magicNumber > 0 && magicNumber < 6));
                MagicType magicType = null;
                switch (magicNumber) {
                    case 1 ->
                        magicType = MagicType.FIRE;
                    case 2 ->
                        magicType = MagicType.ICE;
                    case 3 ->
                        magicType = MagicType.THUNDER;
                    case 4 ->
                        magicType = MagicType.WATER;
                    case 5 ->
                        magicType = MagicType.SUMMONER;
                }
                Integer exp = 0;
                Adventurer adventurer = new Adventurer(Tier.C, exp, ability, name, gender, age, personality, tag, magicType);
                guild.addMember(adventurer);
            }

            case 2 -> {
                Integer jobNumber = -1;
                do {
                    try {
                        System.out.print("\nCotre employé est-il un serveur,euse(1), un chanteur,euse(2)  ou un barman,maid(3)? ");
                        jobNumber = Integer.parseInt(keyboard.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Veuillez entrer un entier positif entre 1 et 3");
                    }
                } while (jobNumber < 0 || jobNumber > 4);
                Job job = null;
                switch (jobNumber) {
                    case 1 ->
                        job = Job.WAITER;
                    case 2 ->
                        job = Job.SINGER;
                    case 3 ->
                        job = Job.BARTENDER;
                }
                Employee employee = new Employee(job, name, gender, age, personality, tag);
                guild.addMember(employee);

            }
        }
        guild.setMoney(guild.getMoney() - 50);
    }
}
