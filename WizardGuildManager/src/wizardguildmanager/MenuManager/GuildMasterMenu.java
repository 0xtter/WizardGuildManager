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

    /**
     *
     * @param guild
     * @param gm
     */
    public void execute(Guild guild, GuildMaster gm) {
        super.title = "Maitre de guilde";
        super.menuDescription = "Que doit faire le maitre de guilde?";
        super.options = new ArrayList<>(Arrays.asList("Retour", "Recruter un aventurier (50 pièces d'or)", "Recruter un employé (50 pièces d'or)", "Imprimer une mission", "Se présenter"));
        super.showMenu();
        this.runOption(super.getChoice(), guild, gm);
    }

    /**
     *
     * @param choice
     * @param guild
     * @param gm
     */
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
                gm.writeMissionManuscript(super.getAMission(guild));
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
