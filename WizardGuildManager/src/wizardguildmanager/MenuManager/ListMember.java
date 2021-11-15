/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager.MenuManager;

import java.util.ArrayList;
import wizardguildmanager.Guild;
import wizardguildmanager.Member;

/**
 *
 * @author DESRUMEAUX Thomas
 */
public class ListMember extends Menu {

    public ListMember(String title, String menuDescription) {
        super(title, menuDescription);
    }

    public void execute(Guild guild) {
        ArrayList<String> newList = new ArrayList<>();
        newList.add("Retour");
        for (Member member : guild.getMembers()) {
            newList.add(member.getName() + " (" + member.getClass().getSimpleName() + ")");
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
            case 1:
                System.out.println("Aventurier 1");
                break;
            case 2:
                System.out.println("Aventurier 2");
                break;
            case 3:
                System.out.println("Aventurier 3");
                break;
            default:
                this.execute(guild);
                break;
        }
    }
}
