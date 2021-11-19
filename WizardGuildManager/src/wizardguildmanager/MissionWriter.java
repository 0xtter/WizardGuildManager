/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import wizardguildmanager.File.Fichier;

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
        File myFile = new File("src/wizardguildmanager/Display", fileName);
        if (myFile.exists()) {
            Fichier.openFile("src/wizardguildmanager/Display/" + mission.getEntitled() + ".txt");
            return;
        }
        Fichier.creationFile(mission.getEntitled());

        try {
            FileWriter fw = new FileWriter("src/wizardguildmanager/Display/" + fileName, true);
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

        Fichier.openFile("src/wizardguildmanager/Display/" + mission.getEntitled() + ".txt");

    }

}
