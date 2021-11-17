/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;
import java.io.IOException;
import static wizardguildmanager.GuildMaster.keyboard;
/**
 *
 * @author DESRUMEAUX Thomas
 */
public class WizardGuildManager {

    /**
     * ask for the user to enter the different abilities
     * @return an object abilities
     */
    public static Abilities pointAbility()
    {
        Integer point = 10;
        Integer strength = -1;
        Integer intelligence = -1;
        Integer widsom = -1;
        Integer endurance = -1;
        Integer charm = -1;
        do {
            try {
                System.out.println("Combien de point voulez-vous attribuer en force (entre 0 et 5) sachant qu'il vous reste ?" + point +" points");
                strength = Integer.parseInt(keyboard.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("Veuillez entrer un entier positif entre 0 et 5");
            }
        } while ((strength < 0 || strength > 5 || (point - strength) < 0));
        point = point - strength;
        do {
            try {
                System.out.println("Combien de point voulez-vous attribuer en intelligence (entre 0 et 5) sachant qu'il vous reste ?" + point +" points");
                intelligence = Integer.parseInt(keyboard.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("Veuillez entrer un entier positif entre 0 et 5");
            }
        } while ((intelligence < 0 || intelligence > 5 || (point - intelligence) < 0));
        point = point - intelligence;
        if (point.equals(0))
        {
            widsom =0;
            endurance = 0;
            charm = 0;
        }
        else
        {
            do {
                try {
                    System.out.println("Combien de point voulez-vous attribuer en sagesse (entre 0 et 5) sachant qu'il vous reste ?" + point +" points");
                    widsom = Integer.parseInt(keyboard.nextLine());
                }
                catch(NumberFormatException e){
                    System.out.println("Veuillez entrer un entier positif entre 0 et 5");
                }
            } while ((widsom < 0 || widsom > 5 || (point - widsom) < 0));
            point = point - widsom;
            if (point.equals(0))
                {
                    endurance = 0;
                    charm = 0;
                }
            else
            {
                do {
                    try {
                        System.out.println("Combien de point voulez-vous attribuer en endurance (entre 0 et 5) sachant qu'il vous reste ?" + point +" points");
                        endurance = Integer.parseInt(keyboard.nextLine());
                    }
                    catch(NumberFormatException e){
                        System.out.println("Veuillez entrer un entier positif entre 0 et 5");
                    }
                } while ((endurance < 0 || endurance > 5 || (point - endurance) < 0));
                point = point - endurance;
            }
            charm = point;
        }
        Abilities ability = new Abilities(strength, intelligence, widsom, endurance, charm);
        return ability;
    }
    
    /**
     *
     * @param mission
     * @param adventurer
     * @return calculate the proba in successing the mission with the characteristic of the adventurer ans what it's needed in the mission
     */
    public static Integer probaCalculation(Mission mission, Adventurer adventurer)
    {
        Integer proba = 100;
        Integer DifficultyInt =  mission.getDifficulty().ordinal() + 1;
        Integer TierInt = adventurer.getTier().ordinal() + 1;
        if (TierInt < DifficultyInt) proba = proba - (DifficultyInt - TierInt) * 15;
        if (adventurer.getAbilities().getStrength() < mission.getAptitudesNeeded().getStrength()) proba = proba - (mission.getAptitudesNeeded().getStrength() - adventurer.getAbilities().getStrength()) * 5;
        if (adventurer.getAbilities().getIntelligence()< mission.getAptitudesNeeded().getIntelligence()) proba = proba - (mission.getAptitudesNeeded().getIntelligence() - adventurer.getAbilities().getIntelligence()) * 5;
        if (adventurer.getAbilities().getEndurance()< mission.getAptitudesNeeded().getEndurance()) proba = proba - (mission.getAptitudesNeeded().getEndurance() - adventurer.getAbilities().getEndurance()) * 5;
        if (adventurer.getAbilities().getWidsom()< mission.getAptitudesNeeded().getWidsom()) proba = proba - (mission.getAptitudesNeeded().getWidsom() - adventurer.getAbilities().getWidsom()) * 5;  
        if (adventurer.getAbilities().getCharm()< mission.getAptitudesNeeded().getCharm()) proba = proba - (mission.getAptitudesNeeded().getCharm() - adventurer.getAbilities().getCharm()) * 5;
        if (! mission.getAffinity().equals(adventurer.getMagicType())) proba = proba - 25;
        
        if (proba < 0) return 0;
        else return proba;
    }
    
    /**
     *
     * @param proba
     * @return true with the probability of proba%, else it's false
     */
    public static boolean success(Integer proba)
    {
        int nombreAleatoire = 0 + (int)(Math.random() * ((100 - 0) + 1));
        Integer nombre = (Integer)nombreAleatoire;
        return (proba >= nombre);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String name = "michel";
        boolean gender = true;
        Integer age = 30;
        Personality personality = Personality.rdPersonality();
        Integer tag = 0;
        Tier tier = Tier.A;
        Integer exp = 0;
        Abilities ability = new Abilities(1,2,2,2,2);
        MagicType magic = MagicType.FIRE;
        Adventurer michel = new Adventurer(tier, exp, ability, name, gender,age, personality,tag,magic);
        
        String entitled = "salut";
        Tier difficulty = Tier.A;
        MagicType affinity = MagicType.ICE;
        Abilities aptitudesNeeded = new Abilities(2,2,2,2,2);
        String description = "desc";
        Integer reward = 400;
        Mission mission = new Mission(entitled,difficulty,  affinity, aptitudesNeeded,  description,  reward);
//        GuildMaster master = new GuildMaster(name, gender, age, personality, tag);
//        ArrayList<Member> members = new ArrayList<>();
//        members.add(master);
//        ArrayList<Mission> missions = new ArrayList<>();
//        Guild guild = new Guild ("Guild", "slogan", true, members, 1, missions, 400);
//        //(GuildMaster)(guild.getMembers().get(0)).recruitMember(1, guild);
//        GuildMaster maitre = (GuildMaster) guild.getMembers().get(0);
//        maitre.recruitMember(1, guild);
//        System.out.println(guild.getMembers().toString());
      Tier tier2 = Tier.A;
        System.out.println(tier2.ordinal());
       
    }  
}
