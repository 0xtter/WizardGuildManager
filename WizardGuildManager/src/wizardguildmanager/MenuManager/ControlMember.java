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
public class ControlMember extends Menu {

    public ControlMember(String title, String menuDescription) {
        super(title, menuDescription);

    }

    @Override
    public void execute(Guild guild) {
        super.options = new ArrayList<>(Arrays.asList("Retour", "Maitre de guilde", "Aventurier", "Employé"));
        super.showMenu();
        this.runOption(super.getChoice(), guild);
    }

    public void runOption(int choice, Guild guild) {
        switch (choice) {
            case 0:
                Menu.menus.get("Gestion de Guilde").execute(guild);
                break;
            case 1:
                System.out.println("Maitre de guilde");
                break;
            case 2:
                System.out.println("Aventurier");
                break;
            case 3:
                System.out.println("Employé");
                break;
            default:
                this.execute(guild);
                break;
        }
    }
}
