/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager.MenuManager;

import java.util.ArrayList;
import java.util.Arrays;
import wizardguildmanager.Guild;

/**
 *
 * @author DESRUMEAUX Thomas
 */
public class GuildManager extends Menu {

    public GuildManager(String title, String menuDescription) {
        super(title, menuDescription);
    }

    public void execute(Guild guild) {
        super.options = new ArrayList<>(Arrays.asList("Quitter", "Contrôler un membre", "Consulter la liste des missions", "Voir état de la guilde"));
        super.showMenu();
        this.runOption(super.getChoice(),guild);
    }

    public void runOption(int choice, Guild guild) {
        switch (choice) {
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("Contrôler un membre");
                Menu.menus.get("Liste des membres").execute(guild);
                break;
            case 2:
                System.out.println("Consulter la liste des missions");
                Menu.menus.get("Liste des missions");
                break;
            case 3:
                System.out.println("Voir état de la guilde");
                System.out.println(guild.toString());
                break;
            default:
                this.execute(guild);
                break;
        }
    }
}
