/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager.MenuManager;

import java.util.ArrayList;
import java.util.Arrays;
import wizardguildmanager.Adventurer;
import wizardguildmanager.Guild;

/**
 *
 * @author DESRUMEAUX Thomas
 */
public class AdventurerMenu extends Menu {

    public AdventurerMenu(String title, String menuDescription) {
        super(title, menuDescription);
    }

    public void execute(Guild guild, Adventurer adv) {
        super.title = "Aventurier";
        super.menuDescription = "Que doit faire l'aventurier?";
        super.options = new ArrayList<>(Arrays.asList("Retour", "Partir en mission", "Se présenter"));
        super.showMenu();
        this.runOption(super.getChoice(), guild, adv);
    }

    public void runOption(int choice, Guild guild, Adventurer adv) {
        switch (choice) {
            case 0:
                break;
            case 1:
                adv.goOnMission(super.getAMission(guild), guild);
                break;
            case 2:
                adv.talk();
                Menu.waitForInput();
                break;
            default:
                this.execute(guild);
                break;
        }
        Menu.menus.get("Gestion de Guilde").execute(guild);
    }
}
