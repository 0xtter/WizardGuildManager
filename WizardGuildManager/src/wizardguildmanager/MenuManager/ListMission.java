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
        newList.add("Quitter");
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
                System.exit(0);
                break;
            case 1:
                System.out.println("Mission 1");
                break;
            case 2:
                System.out.println("Mission 2");
                break;
            case 3:
                System.out.println("Mission 3");
                break;
            default:
                this.execute(guild);
                break;
        }
    }
}
