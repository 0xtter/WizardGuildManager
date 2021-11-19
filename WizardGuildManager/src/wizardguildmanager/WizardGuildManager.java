/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;

import java.io.IOException;
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
        Menu.createMenu();

        Guild guild = ((Start) Menu.menus.get("Commencer")).execute();

        Menu.menus.get("Gestion de Guilde").execute(guild);
    }
}
