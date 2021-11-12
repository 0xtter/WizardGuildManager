/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;
import java.io.IOException;
import java.util.ArrayList;
import wizardguildmanager.file.*;
import java.awt.Desktop; 
import java.io.File;
/**
 *
 * @author DESRUMEAUX Thomas
 */
public class WizardGuildManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        System.out.println("slt");
        ArrayList<Mission> missions;
        missions = Fichier.createListMission(Fichier.filePath + "\\Mission");
        System.out.println(missions.get(0).getEntitled());
        Fichier.createMissionFile(missions.get(0));
        
        
 
    
    
    }
}
