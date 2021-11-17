/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager.MenuManager;

import java.util.ArrayList;
import wizardguildmanager.Guild;
import wizardguildmanager.Mission;

/**
 *
 * @author DESRUMEAUX Thomas
 */
public class ListMission extends Menu {

    public ListMission(String title, String menuDescription) {
        super(title, menuDescription);
    }

    @Override
    public void execute(Guild guild) {
        ArrayList<String> newList = new ArrayList<>();
        newList.add("Retour");
        for (Mission mission : guild.getAvailableMissions()) {
            newList.add(mission.getEntitled());
        }
        super.options = newList;
        super.showMenu();
        this.runOption(super.getChoice(), guild);
    }

    private void runOption(int choice, Guild guild) {
        switch (choice) {
            case 0:
                Menu.menus.get("Gestion de Guilde").execute(guild);
                break;
            default:
                if (choice >= 0 && choice <= guild.getAvailableMissions().size()) {
                    System.out.println("Lancer affichage des missions de Yanis");
                } else {
                    this.execute(guild);
                }
                break;
        }
    }
}
