/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager.MenuManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import wizardguildmanager.Guild;
import wizardguildmanager.GuildMaster;
import wizardguildmanager.Member;
import wizardguildmanager.Mission;
import wizardguildmanager.Personality;

/**
 *
 * @author DESRUMEAUX Thomas
 */
public class Menu {

    public static Map<String, Menu> menus = new HashMap<String, Menu>();
    private String title;
    public String menuDescription;
    public ArrayList<String> options = new ArrayList<>();
    private final int menuWidth = 50;
    private final String menuCharacter = "-";
    static Scanner keyboard = new Scanner(System.in);

    public Menu(String title, String menuDescription) {
        this.title = title;
        this.menuDescription = menuDescription;
        menus.put(title, this);
    }

    /**
     * Create the menu of the Guild Manager
     */
    public static void createMenu() {
        new Start("Commencer", "Bienvenue dans le jeu de gestion de guilde");
        new GuildManager("Gestion de Guilde", "Choisissez un action à effectuer");
        new ListMember("Liste des membres", "Quel membre choisissez-vous?");
        new AdventurerMenu("Aventurier", "Que doit faire l'aventurier?");
        new GuildMasterMenu("Maitre de guilde", "Que doit faire le maitre de guilde?");
        new EmployeeMenu("Employé", "Que doit faire l'employé?");
        new ListMission("Liste des missions", "Quelle mission voulez vous consulter?");
    }

    private void showTitle() {
        System.out.println(menuCharacter.repeat((int) Math.floor((menuWidth - this.title.length()) / 2)) + this.title + menuCharacter.repeat((int) Math.ceil((menuWidth - this.title.length()) / 2)));
        System.out.println(" ".repeat((int) Math.floor((menuWidth - this.menuDescription.length()) / 2)) + this.menuDescription);
        System.out.println("");
    }

    private void showInput() {
        System.out.println(menuCharacter.repeat(menuWidth));
    }

    private void showOptions() {
        for (int i = 0; i < this.options.size(); i++) {
            System.out.printf("%2d ", i);
            System.out.println(this.options.get(i));
        }
    }

    public void showMenu() {
        System.out.println("");
        this.showTitle();
        this.showOptions();
        this.showInput();
        System.out.println("");
    }

    public int getChoice() {
        try {
            keyboard = new Scanner(System.in);
            System.out.print("Entrez votre choix : ");
            int choice = keyboard.nextInt();
            return choice;
        } catch (Exception e) {
            System.out.println("Veuillez entrer un nombre entier correct");
            return this.getChoice();
        }
    }

    public Member getAMember(Guild guild, ArrayList<String> types) {
        this.title = "Liste des membres";
        this.menuDescription = "Veuillez selectionner un membre";
        this.options = new ArrayList<>();
        ArrayList<Member> members = new ArrayList<>();
        for (Member member : guild.getMembers()) {
            if (types.contains(member.getClass().getSimpleName())) {
                this.options.add(member.getName() + " (" + member.getClass().getSimpleName() + ")");
                members.add(member);
            }
        }
        this.showMenu();
        int input = this.getChoice();

        if (input >= 0 && input < members.size()) {
            return members.get(input);
        } else {
            return this.getAMember(guild, types);
        }

    }

    public Mission getAMission(Guild guild) {
        this.title = "Liste des missions";
        this.menuDescription = "Veuillez selectionner une mission";
        this.options = new ArrayList<>();
        ArrayList<Mission> missions = new ArrayList<>();
        for (Mission mission : guild.getAvailableMissions()) {
            this.options.add(mission.getEntitled() + " (" + mission.getDifficulty() + ")");
            missions.add(mission);
        }
        this.showMenu();
        int input = this.getChoice();
        if (input >= 0 && input < missions.size()) {
            return missions.get(input);
        } else {
            return getAMission(guild);
        }
    }

    private static GuildMaster createGuildMaster(Guild guild) {

        Boolean gender;
        System.out.println("Quel nom voulez vous donner à votre Maître de guilde ?");
        String name = keyboard.nextLine();
        Integer genderType = -1;
        do {
            try {
                System.out.println("Quel est le sexe de votre Maître de guilde ?\n0) Homme\n1) Femme\n(entrez '0' ou '1')");
                genderType = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer le nombre 0 ou 1");
            }
        } while (!(genderType == 1 || genderType == 0));
        gender = (genderType.equals(1));
        Integer age = -1;
        do {
            try {
                System.out.println("Quel est l'âge du Maître de guilde?");
                age = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un entier positif");
            }
        } while (!(age > 0));
        Personality personality = Personality.rdPersonality();
        return new GuildMaster(name, gender, age, personality, 0);
    }

    public static Guild createGuild() {
        keyboard = new Scanner(System.in);
        Guild guild = new Guild("Nom de la Guilde", "Slogan de la guilde", true);
        GuildMaster gm = new GuildMaster("Nom du Maitre de Guilde", true, 0, Personality.OPTIMISTIC, 0);
        try {
            System.out.println("Entrez le nom de la guilde que vous souhaitez créer :");
            guild.setName(keyboard.nextLine());

            System.out.println("Entrez le slogan de la guilde : " + guild.getName());
            guild.setSlogan(keyboard.nextLine());

            Integer guildType = -1;
            do {
                try {
                    System.out.print("La guilde " + guild.getName() + " est-elle une guilde officielle(1) ou clandestine(0)?");
                    guildType = Integer.parseInt(keyboard.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Veuillez entrer le nombre 0 ou 1");
                }
            } while (!(guildType == 1 || guildType == 0));

            guild.setTypeOfGuild((guildType == 1) ? Boolean.TRUE : Boolean.FALSE);
            guild.setAvailableMissions(new ArrayList<>());
            guild.setMembers(new ArrayList<>());
            guild.setMoney(300);
            System.out.println("\n" + guild.toString() + "\n");
            //Création du Guild Master

            gm = createGuildMaster(guild);
            guild.addMember(gm);
        } catch (InputMismatchException e) {
            System.out.println("Une erreur a eu lieu lors de la création de la guilde... Veuillez réessayer");
            keyboard = new Scanner(System.in); //On reset le buffer d'entrée pour éviter toute nouvelle erreur suite à une ancienne entrée
            Menu.createGuild();
        }
        return guild;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu{title=").append(title);
        sb.append(", menuDescription=").append(menuDescription);
        sb.append(", options=").append(options);
        sb.append('}');
        return sb.toString();
    }

    public void execute(Guild guild) {
        System.out.println("Fonction non implémentée");
    }
}