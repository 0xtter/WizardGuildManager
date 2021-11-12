/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;
import fichier.Abilities;
import fichier.MagicType;
import fichier.Mission;
import fichier.Tier;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.util.ArrayList;
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
    public String Path = "C:\\Users\\ybert\\Desktop\\Java";
    public static boolean creationFile(String name) throws IOException {  //création du fichier avec le nom en argument
        File myFile = new File(Path + "\\Display",name + ".txt");
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
     * Ask for a name to create a file and verify if it already exist, if yes it ask for another name
     * @throws IOException
     */
    public static void newFile(String path) throws IOException //creation d'un nouveau ficier en demandant le nom en scanner
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
    public static List<String> readTxt(String filePath) //met toutes les données du txt dans une liste
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
     *
     * @param fileName
     * @return Mission that is described in the txt
     */
    public static Mission extractMissionFromTxt(String fileName) //ajoute le contenue du fichier txt dans une class mission
    {
        List <String> insideFile = Collections.emptyList(); 
        insideFile = readTxt(fileName);
        String entitled = new String(insideFile.get(0));
        MagicType affinity = setMagicType(insideFile.get(2));      
        Tier difficulty = setTier(insideFile.get(1));
        Abilities aptitude = new Abilities (Integer.valueOf(insideFile.get(3)),Integer.valueOf(insideFile.get(4)),Integer.valueOf(insideFile.get(5)),Integer.valueOf(insideFile.get(6)),Integer.valueOf(insideFile.get(7)));
        String description = new String(insideFile.get(8));
        Integer reward = Integer.valueOf(insideFile.get(9));
        Mission mission = new Mission(entitled, difficulty, affinity, aptitude, description, reward);
        return mission;
    }
    static Scanner keyboard = new Scanner(System.in);
    
    public static ArrayList<String> getAllFile(String repository) //ajoute tous les noms des txt présents dans le fichier mission
    {
        ArrayList<String> txtList = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(repository)))
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

    
    public static ArrayList<Mission> createListMission(String repositoryPath) //met les missions dans une liste
    {
      ArrayList<Mission> missions = new ArrayList<>(); 
      ArrayList<String> txtList = new ArrayList<>();
      txtList = getAllFile(repositoryPath);
      for (int i = 0; i < txtList.size(); i++)
      {
          
          missions.add(extractMissionFromTxt(repository + "\\" + txtList.get(i)));
          
      }
      
      return missions;
    }
    
    
    public static void createMissionFile(Mission mission) throws IOException //creation d'un fichier txt affichant la mission souhaitée
    {
        String fileName = new String (mission.getEntitled() + ".txt");
        File myFile = new File (Path + "\\Display", fileName);
        if (myFile.exists())
        {
            return;
        }
        creationFile(mission.getEntitled());
        
        
        try
        {
            FileWriter fw = new FileWriter(Path + "\\Display\\" + fileName,true);
            fw.write("The Mission is entitled " + mission.getEntitled() + "\n\n");           
            fw.write("In what consist the mission ?\n");
            fw.write(" " + mission.getDescription() + "\n");
            fw.close();
        }
        catch(IOException ioe)
        {
            System.out.println("error");
        }
    }
    

}
