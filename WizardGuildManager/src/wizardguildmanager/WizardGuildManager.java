/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import wizardguildmanager.file.*;
import static wizardguildmanager.GuildMaster.keyboard;
/**
 *
 * @author DESRUMEAUX Thomas
 */
public class WizardGuildManager {
    public static Boolean isAnInt(Integer number)
    {
        try 
        {
            number = keyboard.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Vous n'avez pas entré un entier");
            return false;
        }
        return true;
    }
    public static Integer pointAbility(Integer point, Integer ability)
    {
        while (isAnInt(ability) != true)
        {
            System.out.println("Combien de point voulez-vous attribuer (entre 0 et 5) sachant qu'il vous reste ?" + point +" points");
        }
        while (ability < 0 || ability > 5 || (point - ability) < 0)
        {            
            System.out.println("Le chiffre entré n'est pas bon");
            System.out.println("Combien de point voulez-vous attribuer (entre 0 et 5) sachant qu'il vous reste ?" + point +" points");
            while (isAnInt(ability) != true)
            {
            System.out.println("Combien de point voulez-vous attribuer (entre 0 et 5) sachant qu'il vous reste ?" + point +" points");
            }               
        }
        point = point - ability;
        return ability;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        
 
    
    
    }
}
