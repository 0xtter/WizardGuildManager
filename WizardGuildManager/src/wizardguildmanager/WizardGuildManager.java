/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import wizardguildmanager.MenuManager.*;

/**
 *
 * @author DESRUMEAUX Thomas
 */
public class WizardGuildManager {

    /**
     * @param args the command line arguments
     */
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        //Guild guild = new Guild("Nom de Guilde", "Slogan de la Guilde yaay!",true);
        //System.out.println(guild.getClass().getName());
        Menu.createMenu();
        Menu.menus.get("e");
        //Guild guild = Menu.createGuild();
        
        Start start = (Start)(Menu.menus.get("Commencer"));
        Guild guild = start.execute();
        
        guild.addMember(new Member("Michel", true, 64, Personality.OPTIMISTIC, 1));
        
        guild.addMember(new Employee(Job.WAITER,"Michel", true, 64, Personality.OPTIMISTIC, 1));
        guild.addMember(new Adventurer(Tier.S,0,new ArrayList<>(),new Abilities(50,50,50,50,50),new Mission(),"Michel", true, 64, Personality.OPTIMISTIC,0, MagicType.FIRE));
        guild.addMember(new Member("Michel", true, 64, Personality.OPTIMISTIC, 1));
        guild.addMember(new Member("Michel", true, 64, Personality.OPTIMISTIC, 1));
        
        Menu.menus.get("Gestion de Guilde").execute(guild);
    }
}
