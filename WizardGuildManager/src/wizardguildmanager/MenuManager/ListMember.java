/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager.MenuManager;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public void execute(Guild guild) {
        this.menuDescription = "Quel membre choisissez-vous?";
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
            default:
                if (choice >= 0 && choice <= guild.getMembers().size()) {
                    switch (guild.getMembers().get(choice-1).getClass().toString()) {
                        case "GuildMaster":
                            break;
                        case "Employee":
                            System.out.println("Employee");
                            break;
                        case "Adventurer":
                            
                            break;
                        default:
                            System.out.println(guild.getMembers().get(choice).getClass().getSimpleName());
                            this.execute(guild);
                            break;
                    }
                    //1Member
                    System.out.println(guild.getMembers().get(choice).getName());
                } else {
                    this.execute(guild);
                }
                break;
        }
    }
}
