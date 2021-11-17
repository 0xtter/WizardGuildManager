/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ybert
 */
public interface MissionWriter {

    //à compléter avec la fonction suggestAMission
    /**
     * Create a txt in the repository Display that show the Mission in argument
     *
     * @param mission
     * @throws IOException
     */
    default void writeMissionManuscript(Mission mission) throws IOException {
        String fileName = mission.getEntitled() + ".txt";
        File myFile = new File("./Display", fileName);
        if (myFile.exists()) {
            openFile("./Display/" + mission.getEntitled() + ".txt");
            return;
        }
        creationFile(mission.getEntitled());

        try {
            FileWriter fw = new FileWriter("./Display/" + fileName, true);
            fw.write("INTITULE DE LA MISSION -> " + mission.getEntitled().toUpperCase() + "\n\n");
            fw.write("En quoi consiste la mission ? ?\n");
            fw.write("  " + mission.getDescription() + "\n\n");
            fw.write("Le rang conseillé pour réaliser cette mission est le rang " + mission.getDifficulty().toString() + " ou plus\n\n");
            fw.write("Vous aurez besoin d'avoir ces compétences :\n\n" + mission.getAptitudesNeeded().toString() + "\n\n");
            fw.write("La récompense en cas de réussite s'élève à " + mission.getReward().toString() + " pièces d'or\n\n");
            fw.write("Vous devrez maîtriser cette magie : " + mission.getAffinity().toString());
            fw.close();
        } catch (IOException ioe) {
            System.out.println("error");
        }

        openFile("./Display/" + mission.getEntitled() + ".txt");

    }

    /**
     * Open the file located at pathFile
     *
     * @param pathFile
     */
    private static void openFile(String pathFile) {
        try {
            //constructor of file class having file as argument  
            File file = new File(pathFile);
            if (!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
            {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) //checks file exists or not  
            {
                desktop.open(file);              //opens the specified file  
            }
        } catch (IOException e) {
            System.out.println("error");
        }
    }
        /**
     * Create the file named "name" if it doesn't exist yet
     *
     * @param name
     * @return true if the file is created and false if the file already exist
     * @throws IOException
     */

    private static boolean creationFile(String name) throws IOException {
        File myFile = new File("./Display", name + ".txt");
        if (myFile.createNewFile()) {
            System.out.println("File has been correctly created");
            return true;
        } else {
            System.out.println("File already exist");
            return false;
        }
    }
}
