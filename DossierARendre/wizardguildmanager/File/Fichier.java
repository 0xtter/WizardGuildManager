/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager.File;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import wizardguildmanager.Abilities;
import wizardguildmanager.MagicType;
import wizardguildmanager.Mission;
import wizardguildmanager.Tier;

/**
 *
 * @author ybert
 */
public class Fichier {

    /**
     * Put all the content of the TXT on a list and return it
     *
     * @param filePath
     * @return
     */
    private static List<String> readTxt(String filePath) {
        List<String> insideFile = Collections.emptyList();
        try {
            insideFile = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Problem with the file reading");
        }
        return insideFile;
    }

    /**
     * take the content of the file in argument and put create a Mission with
     * the content
     *
     * @param fileName
     * @return Mission that is described in the txt
     */
    private static Mission extractMissionFromTxt(String txtPath) {
        List<String> insideFile = Collections.emptyList();
        insideFile = readTxt(txtPath);
        String entitled = insideFile.get(0);
        MagicType affinity = MagicType.setMagicType(insideFile.get(2));
        Tier difficulty = Tier.setTier(insideFile.get(1));
        Abilities aptitude = new Abilities(Integer.valueOf(insideFile.get(3)), Integer.valueOf(insideFile.get(4)), Integer.valueOf(insideFile.get(5)), Integer.valueOf(insideFile.get(6)), Integer.valueOf(insideFile.get(7)));
        String description = insideFile.get(8);
        Integer reward = Integer.valueOf(insideFile.get(9));
        Mission mission = new Mission(entitled, difficulty, affinity, aptitude, description, reward);
        return mission;
    }
    static Scanner keyboard = new Scanner(System.in);

    /**
     *
     * @param repository
     * @return ArrayList<String> with all files name in the repository in
     * argument
     */
    private static ArrayList<String> getAllFile() {
        ArrayList<String> txtList = new ArrayList<>();
        try ( DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("src/wizardguildmanager/Mission"))) {
            for (Path file : stream) {
                txtList.add(file.getFileName().toString());
            }
        } catch (IOException | DirectoryIteratorException ex) {
            System.out.println("problem with getting the file");
        }
        return txtList;
    }

    /**
     * Open the file located at pathFile
     *
     * @param pathFile
     */
    public static void openFile(String pathFile) {
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
    public static boolean creationFile(String name) throws IOException {
        File myFile = new File("src/wizardguildmanager/Display/", name + ".txt");
        if (myFile.createNewFile()) {
            System.out.println("File has been correctly created");
            return true;
        } else {
            System.out.println("File already exist");
            return false;
        }
    }

    /**
     *
     *
     * @return ArrayList(Mission) with all the content of txt in the repository
     */
    public static ArrayList<Mission> createListMission() //met les missions dans une liste
    {
        ArrayList<Mission> missions = new ArrayList<>();
        ArrayList<String> txtList = new ArrayList<>();
        txtList = getAllFile();
        for (int i = 0; i < txtList.size(); i++) {
            missions.add(extractMissionFromTxt("src/wizardguildmanager/Mission/" + txtList.get(i)));
        }

        return missions;
    }

}
