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
public class Adventurer extends Menu {

    public Adventurer(String title, String menuDescription) {
        super(title, menuDescription);
    }

    public void execute(Guild guild) {
        super.options = new ArrayList<>(Arrays.asList("Retour", "Parler à un donneur de mission"));
        this.runOption(super.getChoice(), guild);
    }

    public void runOption(int choice, Guild guild) {
        switch (choice) {
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("Parler à un donneur de mission");
                break;
            default:
                this.execute(guild);
                break;
        }
    }
}
