/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager.MenuManager;

import java.util.ArrayList;
import java.util.Arrays;
import wizardguildmanager.Employee;
import wizardguildmanager.Guild;

/**
 *
 * @author DESRUMEAUX Thomas
 */
public class EmployeeMenu extends Menu {

    public EmployeeMenu(String title, String menuDescription) {
        super(title, menuDescription);
    }

    public void execute(Guild guild, Employee emp) {
        super.options = new ArrayList<>(Arrays.asList("Retour","Imprimer une mission"));
        super.showMenu();
        this.runOption(super.getChoice(), guild, emp);
    }

    public void runOption(int choice, Guild guild, Employee emp) {
        switch (choice) {
            case 0:
                Menu.menus.get("Gestion de Guilde").execute(guild);
                break;
            case 1:
                emp.talk();
                emp.writeMissionManuscript(super.getAMission(guild)); 
                Menu.menus.get("Gestion de Guilde").execute(guild);
                break;
            default:
                this.execute(guild);
                break;
        }
    }
}
