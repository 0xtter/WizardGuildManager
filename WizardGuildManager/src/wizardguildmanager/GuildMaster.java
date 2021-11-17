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
public class GuildMaster extends Member{

    /**
     * Constructor
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
    public void talk()
    {
        System.out.println("Bonjour, je suis " + this.getName() + " le maître de cette guilde, et je suis là pour tous vous protéger !");
    }

    /**
     * Ask for the characteristic of an adventurer or an emplyee depending "choice" (1 for adventurer, 2 for employee) and add this member to the guild
     * @param choice
     * @param guild
     */
    public void recruitMember(int choice, Guild guild) {
        Boolean gender;
        System.out.println("Quel nom voulez vous donner à votre mage ?");
        String name = keyboard.nextLine();
        Integer genderType = -1;
        do {
            try {
                System.out.println("Quel est le sexe de votre mage ?\n0) Homme\n2) Femme\n(entrez '0' ou '1'");
                genderType = Integer.parseInt(keyboard.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("Veuillez entrer le nombre 0) ou 1)");
            }
        } while (!(genderType == 1 || genderType == 0));
        gender = (genderType.equals(1));
        Integer age = -1;
        do {
            try {
                System.out.println("Quel est l'âge de votre mage ?");
                age = Integer.parseInt(keyboard.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("Veuillez entrer un entier positif");
            }
        } while (!(age > 0));
        Personality personality = Personality.rdPersonality();
        Integer tag = guild.getNumberOfMembers();        
        switch(choice)
        {
            case 1 -> {
                System.out.println("Vous avez 10 points d'abilité à répartir");
                Abilities ability = Abilities.pointAbility();
                System.out.println("Quel type de magie votre mage maîtrise ?\n1) Fire\n2) Ice\n3) Thunder\n4) Water\n5) Summoner\nentrez 1, 2, 3, 4 ou 5");
                Integer magicNumber = -1;
                do {
                    try {
                        System.out.println("Quel type de magie votre mage maîtrise ?\n1) Fire\n2) Ice\n3) Thunder\n4) Water\n5) Summoner\nentrez 1, 2, 3, 4 ou 5");
                        magicNumber = Integer.parseInt(keyboard.nextLine());
                    }
                    catch(NumberFormatException e){
                        System.out.println("Veuillez entrer un entier positif entre 1 et 5");
                    }
                } while (magicNumber < 0 && magicNumber > 6);
                MagicType magicType = null;
                switch (magicNumber)
                {
                    case 1 -> magicType = MagicType.FIRE;
                    case 2 -> magicType = MagicType.ICE;
                    case 3 -> magicType = MagicType.THUNDER;
                    case 4 -> magicType = MagicType.WATER;
                    case 5 -> magicType = MagicType.SUMMONER;
                }
                Integer exp = 0;
                Adventurer adventurer = new Adventurer(Tier.C, exp, ability, name, gender, age, personality, tag, magicType); 
                guild.addMember(adventurer);
            }

                
            case 2 -> {
                System.out.println("Quel est le Job du membre ?\n1) serveur\n2) chanteur\n3) barman\nentrez 1, 2, 3");
                Integer jobNumber = -1;
                do {
                    try {
                        System.out.println("Quel est le Job du membre ?\n1) serveur\n2) chanteur\n3) barman\nentrez 1, 2, 3");
                        jobNumber = Integer.parseInt(keyboard.nextLine());
                    }
                    catch(NumberFormatException e){
                        System.out.println("Veuillez entrer un entier positif entre 1 et 3");
                    }
                } while (jobNumber < 0 && jobNumber > 4);
                Job job = null;
                switch (jobNumber)
                {
                    case 1 -> job = Job.WAITER;
                    case 2 -> job = Job.SINGER;
                    case 3 -> job = Job.BARTENDER;
                }
                Employee employee = new Employee(job, name, gender, age, personality, tag);
                guild.addMember(employee);
            }
        }
    }
}
