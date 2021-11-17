/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager.MenuManager;

import java.util.ArrayList;
import java.util.Arrays;
import wizardguildmanager.Guild;
import wizardguildmanager.GuildMaster;

/**
 *
 * @author DESRUMEAUX Thomas
 */
public class GuildMasterMenu extends Menu {

    public GuildMasterMenu(String title, String menuDescription) {
        super(title, menuDescription);
    }

    public void execute(Guild guild, GuildMaster gm) {
        super.options = new ArrayList<>(Arrays.asList("Retour", "Recruter un aventurier", "Recruter un employé", "Imprimer une mission"));
        super.showMenu();
        this.runOption(super.getChoice(), guild, gm);
    }

    public void runOption(int choice, Guild guild, GuildMaster gm) {
        switch (choice) {
            case 0:
                Menu.menus.get("Gestion de Guilde").execute(guild);
                break;
            case 1:
            case 2:
                System.out.println("Recruter un aventurier/employé");
                break;
            case 3:
                gm.talk();
                super.getAMission(guild);
                System.out.println("Print a mission");
                break;
            default:
                this.execute(guild);
                break;
        }
    }
}
