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
        super.title = "Commencer";
        super.menuDescription = "Bienvenue dans le jeu de gestion de guilde";
        super.options = new ArrayList<>(Arrays.asList("Retour", "Recruter un aventurier (50 crédits)", "Recruter un employé (50 crédits)", "Imprimer une mission", "Se présenter"));
        super.showMenu();
        this.runOption(super.getChoice(), guild, gm);
    }

    public void runOption(int choice, Guild guild, GuildMaster gm) {
        switch (choice) {
            case 0:
                break;
            case 1:
            case 2:
                gm.recruitMember(choice, guild);
                break;
            case 3:
                gm.talk();
                super.getAMission(guild);
                break;
            case 4:
                gm.talk();
                Menu.waitForInput();
            default:
                this.execute(guild);
                break;
        }

        Menu.menus.get("Gestion de Guilde").execute(guild);
    }
}
