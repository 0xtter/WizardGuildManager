/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager.file;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
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
     * Create the file named "name" if it doesn't exist yet
     * @param name
     * @return true if the file is created and false if the file already exist
     * @throws IOException
     */
    public static String filePath = "C:\\Users\\ybert\\Desktop\\Java";
    public static boolean creationFile(String name) throws IOException {  
        File myFile = new File(filePath + "\\Display",name + ".txt");
        if(myFile.createNewFile()) 
        {
            System.out.println("File has been correctly created");
            return true;
        }
        else 
        {
            System.out.println("File already exist");
            return false;
        }
    }

    /**
     * Ask for a name to create a file in the repository in path and verify if it already exist, if yes it ask for another name
     * @throws IOException
     */
    public static void newFile(String path) throws IOException 
    {
        
        System.out.println("entrez le nom du fichier");
        String fileName = keyboard.nextLine();
        
        while (creationFile(path + "\\" + fileName + ".txt") == false)
        {
            System.out.println("ce fichier existe déjà, veuillez entrer un nouveau nom");
            fileName = keyboard.nextLine();
        }
    }
    
    /**
     * Put all the content of the TXT on a list and return it
     * @param filePath
     * @return
     */
    public static List<String> readTxt(String filePath) 
    {
           List <String> insideFile = Collections.emptyList();          
           try 
           {
               insideFile = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
           }
           catch(IOException e)
           {
               System.out.println("Problem with the file reading");
           }
           return insideFile;
    }
    
    /**
     * 
     * @param affinity
     * @return MagicType that correspond to the string affinity and put FIRE by default if afinity correspond to no one
     */
    public static MagicType setMagicType(String affinity) //assigne un magictype de l'enum
    {
        return switch (affinity) {
            case "FIRE" -> MagicType.FIRE;
            case "ICE" -> MagicType.ICE;
            case "THUNDER" -> MagicType.THUNDER;
            case "WATER" -> MagicType.WATER;
            case "SUMMONER" -> MagicType.SUMMONER;
            default -> MagicType.FIRE;
        };               
    }

    /**
     *
     * @param difficulty
     * @return Tier that correspond to the string difficulty and put C by default if difficulty correspond to no one
     */
    public static Tier setTier(String difficulty) //assigne un tier de l'enum tier
    {
        return switch (difficulty) {
            case "S" -> Tier.S;
            case "A" -> Tier.A;
            case "B" -> Tier.B;
            case "C" -> Tier.C;
            default -> Tier.C;
        };               
}

    /**
     * take the content of the file in argument and put create a Mission with the content
     * @param fileName
     * @return Mission that is described in the txt
     */
    public static Mission extractMissionFromTxt(String fileName) 
    {
        List <String> insideFile = Collections.emptyList(); 
        insideFile = readTxt(fileName);
        String entitled = insideFile.get(0);
        MagicType affinity = setMagicType(insideFile.get(2));      
        Tier difficulty = setTier(insideFile.get(1));
        Abilities aptitude = new Abilities (Integer.valueOf(insideFile.get(3)),Integer.valueOf(insideFile.get(4)),Integer.valueOf(insideFile.get(5)),Integer.valueOf(insideFile.get(6)),Integer.valueOf(insideFile.get(7)));
        String description = insideFile.get(8);
        Integer reward = Integer.valueOf(insideFile.get(9));
        Mission mission = new Mission(entitled, difficulty, affinity, aptitude, description, reward);
        return mission;
    }
    static Scanner keyboard = new Scanner(System.in);
    
    /**
     *
     * @param repository
     * @return ArrayList<String> with all files in the repository in argument 
     */
    public static ArrayList<String> getAllFile(String repositoryPath) 
    {
        ArrayList<String> txtList = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(repositoryPath)))
        {
            for (Path file: stream) {
                txtList.add(file.getFileName().toString());
            }
        }
        catch (IOException | DirectoryIteratorException ex) 
        {
            System.out.println("problem");
        }
        return txtList;
    }

    /**
     *
     * @param repositoryPath
     * @return ArrayList<Mission> with all the content of txt in the repository
     */
    public static ArrayList<Mission> createListMission(String repositoryPath) //met les missions dans une liste
    {
      ArrayList<Mission> missions = new ArrayList<>(); 
      ArrayList<String> txtList = new ArrayList<>();
      txtList = getAllFile(repositoryPath);
      for (int i = 0; i < txtList.size(); i++)
      {
          
          missions.add(extractMissionFromTxt(repositoryPath + "\\" + txtList.get(i)));
          
      }
      
      return missions;
    }
    public static void openFile(String pathFile)
    {
        try  
        {  
            //constructor of file class having file as argument  
            File file = new File(pathFile);   
            if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
            {  
            System.out.println("not supported");  
            return;  
            }  
            Desktop desktop = Desktop.getDesktop();  
            if(file.exists())         //checks file exists or not  
            desktop.open(file);              //opens the specified file  
        }  
        catch(IOException e)  
        {  
                System.out.println("error");  
        }         
    }
    /**
     *Create a txt in the repository Display that show the Mission in argument
     * @param mission
     * @throws IOException
     */
    public static void createMissionFile(Mission mission) throws IOException 
    {
        String fileName = mission.getEntitled() + ".txt";
        File myFile = new File (filePath + "\\Display", fileName);
        if (myFile.exists())
        {
            openFile(filePath + "\\Display\\" + mission.getEntitled() + ".txt");
            return;
        }
        creationFile(mission.getEntitled());
        
        
        try
        {
            FileWriter fw = new FileWriter(filePath + "\\Display\\" + fileName,true);
            fw.write("INTITULE DE LA MISSION -> " + mission.getEntitled().toUpperCase() + "\n\n");           
            fw.write("En quoi consiste la mission ? ?\n");
            fw.write("  " + mission.getDescription() + "\n\n");
            fw.write ("Le rang conseillé pour réaliser cette mission est le rang " + mission.getDifficulty().toString(mission.getDifficulty()) + " ou plus\n\n");
            fw.write("Vous aurez besoin d'avoir ces compétences :\n\n" + mission.getAptitudesNeeded().toString() + "\n\n");
            fw.write("La récompense en cas de réussite s'élève à " + mission.getReward().toString() + " pièces d'or\n\n");
            fw.close();
        }
        catch(IOException ioe)
        {
            System.out.println("error");
        }
        
        openFile(filePath + "\\Display\\" + mission.getEntitled() + ".txt");

    }         
    
    

}
