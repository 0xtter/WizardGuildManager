/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;

import java.util.Scanner;
import static wizardguildmanager.WizardGuildManager.isAnInt;
import static wizardguildmanager.WizardGuildManager.pointAbility;


/**
 *
 * @author ybert
 */
public class GuildMaster extends Member{

    public GuildMaster(String name, Boolean gender, Integer age, Personality personality, Integer memberTag) {
        super(name, gender, age, personality, memberTag);
    }
    static Scanner keyboard = new Scanner(System.in);
    @Override
    public void talk()
    {
        System.out.println("Bonjour, je suis " + this.getName() + " le maître de cette guilde, et je suis là pour tous vous protéger !");
    }
    public void recruitMember(int choice, Guild guild) {
        Boolean gender;
        System.out.println("Quel nom voulez vous donner à votre mage ?");
        String name = keyboard.nextLine();
        System.out.println("Quel est le sexe de votre mage ?\n1) Homme\n2) Femme\n(entrez '1' ou '2'");
        Integer number = 0;
        while (isAnInt(number) != true)
        {
            System.out.println("Quel est le sexe de votre mage ?\n1) Homme\n2) Femme\n(entrez '1' ou '2'");
        }
        while(!(number.equals(1)) || !(number.equals(2)))
        {
            System.out.println("Vous n'avez pas entré 1 ou 2");
            System.out.println("Quel est le sexe de votre mage ?\n1) Homme\n2) Femme\n(entrez '1' ou '2'");
            while (isAnInt(number) != true)
            {
            System.out.println("Quel est le sexe de votre mage ?\n1) Homme\n2) Femme\n(entrez '1' ou '2'");
            }
        }
        gender = (number.equals(1));
        Integer age = 0;
        System.out.println("Quel est l'âge de votre mage ?");
        while (isAnInt(age) != true)
        {
            System.out.println("Quel est l'âge de votre mage ?");
        }
        Personality personality = Personality.rdPersonality();
        Integer tag = guild.getNumberOfMembers();        
        switch(choice)
        {
            case 1:
                System.out.println("Vous avez 10 points d'abilité à répartir");
                Integer point = 10;
                Integer strength = 0;
                Integer intelligence = 0;
                Integer widsom = 0;
                Integer endurance = 0;
                Integer charm = 0;
                System.out.println("Combien voulez-vous attribuer en force ? (entre 0 et 5) sachant qu'il vous reste " + point + " points");
                strength = pointAbility(point, strength);
                System.out.println("Combien voulez-vous attribuer en intelligence ? (entre 0 et 5) sachant qu'il vous reste " + point + " points");
                intelligence = pointAbility(point, intelligence);
                if (point.equals(0))
                {
                    widsom =0;
                    endurance = 0;
                    charm = 0;
                }
                System.out.println("Combien voulez-vous attribuer en Sagesse ? (entre 0 et 5) sachant qu'il vous reste " + point + " points");
                widsom = pointAbility(point, widsom);
                if (point.equals(0))
                {
                    endurance = 0;
                    charm = 0;
                }
                System.out.println("Combien voulez-vous attribuer en endurance ? (entre 0 et 5) sachant qu'il vous reste " + point + " points");
                widsom = pointAbility(point, endurance);
                if (point.equals(0))
                {
                    charm = 0;
                }
                charm = point;
                Abilities ability = new Abilities(strength, intelligence, widsom, endurance, charm);
                System.out.println("Quel type de magie votre mage maîtrise ?");
                System.out.println("1) Fire");
                System.out.println("2) Ice");
                System.out.println("3) Thunder");
                System.out.println("4) Water");
                System.out.println("5) Summoner");
                System.out.println("entrez 1, 2, 3, 4 ou 5");
                while (isAnInt(number) != true)
                {
                    System.out.println("Quel type de magie votre mage maîtrise ?");
                    System.out.println("1) Fire");
                    System.out.println("2) Ice");
                    System.out.println("3) Thunder");
                    System.out.println("4) Water");
                    System.out.println("5) Summoner");
                }
                while(number < 1 || number > 5)
                {
                    System.out.println("Vous n'avez pas entré un chiffre correct");
                    System.out.println("Quel type de magie votre mage maîtrise ?");
                    System.out.println("1) Fire");
                    System.out.println("2) Ice");
                    System.out.println("3) Thunder");
                    System.out.println("4) Water");
                    System.out.println("5) Summoner");
                    while (isAnInt(number) != true)
                    {
                    System.out.println("Quel type de magie votre mage maîtrise ?");
                    System.out.println("1) Fire");
                    System.out.println("2) Ice");
                    System.out.println("3) Thunder");
                    System.out.println("4) Water");
                    System.out.println("5) Summoner");
                    }
                }
                MagicType magicType = null;
                switch (number)
                {
                    case 1: magicType = MagicType.FIRE;
                    case 2: magicType = MagicType.ICE;
                    case 3: magicType = MagicType.THUNDER;
                    case 4: magicType = MagicType.WATER;
                    case 5: magicType = MagicType.SUMMONER;
                }
                Integer exp = 0;
                Adventurer adventurer = new Adventurer(Tier.C, exp, ability, name, gender, age, personality, tag, magicType); 
                guild.addMember(adventurer);
                
            case 2:
                System.out.println("Quel est le Job du membre ?");
                System.out.println("1) serveur");
                System.out.println("2) chanteur");
                System.out.println("3) barman");
                System.out.println("entrez 1, 2, 3");
                while (isAnInt(number) != true)
                {
                System.out.println("Quel est le Job du membre ?");
                System.out.println("1) serveur");
                System.out.println("2) chanteur");
                System.out.println("3) barman");
                System.out.println("entrez 1, 2, 3");
                }
                while(number < 1 || number > 3)
                {
                System.out.println("Quel est le Job du membre ?");
                System.out.println("1) serveur");
                System.out.println("2) chanteur");
                System.out.println("3) barman");
                System.out.println("entrez 1, 2, 3");
                    while (isAnInt(number) != true)
                    {
                System.out.println("Quel est le Job du membre ?");
                System.out.println("1) serveur");
                System.out.println("2) chanteur");
                System.out.println("3) barman");
                System.out.println("entrez 1, 2, 3");
                    }
                }
                Job job = null;
                switch (number)
                {
                    case 1: job = Job.WAITER;
                    case 2: job = Job.SINGER;
                    case 3: job = Job.BARTENDER;
                }
                Employee employee = new Employee(job, name, gender, age, personality, tag);
                guild.addMember(employee);
        }
    }
}
