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
public class RecruitMember extends Menu{
    
    public RecruitMember(String title, String menuDescription) {
        super(title, menuDescription);
    }

    
    public void execute(Guild guild) {
        super.options = new ArrayList<>(Arrays.asList("Retour", "Recruter un aventurier", "Recruter un employé", "Voir état de la guilde"));
        super.showMenu();
        this.runOption(super.getChoice(),guild);
    }

    public void runOption(int choice, Guild guild) {
        switch (choice) {
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("Recruter un aventurier");
                break;
            case 2:
                System.out.println("Recruter un employé");
                break;
            default:
                this.execute(guild);
                break;
        }
    }

}
