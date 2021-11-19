/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager.MenuManager;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import wizardguildmanager.Guild;
import wizardguildmanager.Member;
import wizardguildmanager.Mission;

/**
 *
 * @author DESRUMEAUX Thomas
 */
public class Menu {

    public static Map<String, Menu> menus = new HashMap<String, Menu>();
    public String title;
    public String menuDescription;
    public ArrayList<String> options = new ArrayList<>();
    private static final int MENU_WIDTH = 50;
    private static final String MENU_CHARACTER = "-";
    static Scanner keyboard = new Scanner(System.in);

    /**
     * Constructor
     *
     * @param title
     * @param menuDescription
     */
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
        new AdventurerMenu("Aventurier", "Que doit faire l'aventurier?");
        new GuildMasterMenu("Maitre de guilde", "Que doit faire le maitre de guilde?");
        new EmployeeMenu("Employé", "Que doit faire l'employé?");
    }

    /**
     * Show the title of the Menu in the console
     */
    private void showTitle() {
        System.out.println(Menu.MENU_CHARACTER.repeat((int) Math.floor((Menu.MENU_WIDTH - this.title.length()) / 2)) + this.title + Menu.MENU_CHARACTER.repeat((int) Math.ceil((Menu.MENU_WIDTH - this.title.length()) / 2)));
        System.out.println(" ".repeat((int) Math.floor((Menu.MENU_WIDTH - this.menuDescription.length()) / 2)) + this.menuDescription);
        System.out.println("");
    }

    /**
     * Show the Inputs of the menu in the console
     */
    private void showInput() {
        System.out.println(Menu.MENU_CHARACTER.repeat(Menu.MENU_WIDTH));
    }

    /**
     * Wait until the user press Enter
     */
    public static void waitForInput() {
        try {
            System.out.print("Appuyez sur Entrer pour continuer...");
            keyboard = new Scanner(System.in);
            keyboard.nextLine();
        } catch (Exception e) {
            System.out.println("An Error has occured continuing the execution...");
        }
    }

    /**
     * Show the options of the actual menu in the console
     */
    private void showOptions() {
        for (int i = 0; i < this.options.size(); i++) {
            System.out.printf("%2d ", i);
            System.out.println(this.options.get(i));
        }
    }

    /**
     * Display the entire Menu
     */
    public void showMenu() {
        System.out.println("");
        this.showTitle();
        this.showOptions();
        this.showInput();
        System.out.println("");
    }

    /**
     * Return the choice in the Menu of the user
     *
     * @return choice
     */
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

    /**
     * Allow the user to select a member
     *
     * @param guild
     * @param types
     * @return Returns the selected member
     */
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

    /**
     * Allow the user to select a mission
     *
     * @param guild
     * @return Returns the selected mission
     */
    public Mission getAMission(Guild guild) {
        this.title = "Liste des missions";
        this.menuDescription = "Veuillez selectionner une mission";
        this.options = new ArrayList<>();
        ArrayList<Mission> missions = new ArrayList<>();
        for (Mission mission : guild.getAvailableMissions()) {
            this.options.add(mission.getEntitled() + " (difficulté " + mission.getDifficulty() + ")");
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu{title=").append(title);
        sb.append(", menuDescription=").append(menuDescription);
        sb.append(", options=").append(options);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Runs the menu to display it and to get input of the user
     *
     * @param guild
     */
    public void execute(Guild guild) {
        System.out.println("Fonction non implémentée");
    }
}
