/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager.MenuManager;

import java.util.ArrayList;
import java.util.Arrays;
import wizardguildmanager.Adventurer;
import wizardguildmanager.Employee;
import wizardguildmanager.Guild;
import wizardguildmanager.GuildMaster;
import wizardguildmanager.Member;

/**
 *
 * @author DESRUMEAUX Thomas
 */
public class GuildManager extends Menu {

    public GuildManager(String title, String menuDescription) {
        super(title, menuDescription);
    }

    @Override
    public void execute(Guild guild) {
        super.title = "Commencer";
        super.menuDescription = "Bienvenue dans le jeu de gestion de guilde";
        super.options = new ArrayList<>(Arrays.asList("Quitter", "Contrôler un membre", "Voir état de la guilde"));
        super.showMenu();
        this.runOption(super.getChoice(), guild);
    }

    /**
     *
     * @param choice
     * @param guild
     */
    public void runOption(int choice, Guild guild) {
        switch (choice) {
            case 0:
                System.exit(0);
                break;
            case 1:
                Member member1 = super.getAMember(guild, new ArrayList(Arrays.asList("Adventurer", "Employee", "GuildMaster", "Member")));
                switch (member1.getClass().getSimpleName()) {
                    case "Adventurer":
                        ((AdventurerMenu) Menu.menus.get("Aventurier")).execute(guild, (Adventurer) member1);
                        break;
                    case "GuildMaster":
                        ((GuildMasterMenu) Menu.menus.get("Maitre de guilde")).execute(guild, (GuildMaster) member1);
                        break;

                    case "Employee":
                        ((EmployeeMenu) Menu.menus.get("Employé")).execute(guild, (Employee) member1);
                        break;
                    default:
                        Menu.menus.get("Gestion de Guilde").execute(guild);
                        break;
                }
                break;
            case 2:
                System.out.println("\n" + guild.toString() + "\n");
                Menu.waitForInput();
                Menu.menus.get("Gestion de Guilde").execute(guild);
                break;
            default:
                this.execute(guild);
                break;
        }
    }
}
