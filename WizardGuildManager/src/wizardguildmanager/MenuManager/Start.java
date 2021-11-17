package wizardguildmanager.MenuManager;

import java.util.ArrayList;
import java.util.Arrays;
import wizardguildmanager.Guild;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DESRUMEAUX Thomas
 */
public class Start extends Menu {

    public Start(String title, String menuDescription) {
        super(title, menuDescription);

    }

    public Guild execute() {
        super.options = new ArrayList<>(Arrays.asList("Quitter", "Créer une nouvelle partie"));
        super.showMenu();
        return this.runOption(super.getChoice());
    }

    private Guild runOption(int choice) {
        Guild guild = new Guild();
        switch (choice) {
            case 0:
                System.exit(0);
                break;
            case 1:
                guild = Guild.createGuild();
                break;
            default:
                guild = runOption(super.getChoice());
                break;

        }
        return guild;
    }
}
