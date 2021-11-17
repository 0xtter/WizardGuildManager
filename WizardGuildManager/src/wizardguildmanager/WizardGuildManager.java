/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardguildmanager;
import java.io.IOException;
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
        //ArrayList<Mission> missions = new ArrayList<>();
//        Guild guild = new Guild ("Guild", "slogan", true, members, 1, missions, 400);
//        //(GuildMaster)(guild.getMembers().get(0)).recruitMember(1, guild);
//        GuildMaster maitre = (GuildMaster) guild.getMembers().get(0);
//        maitre.recruitMember(1, guild);
//        System.out.println(guild.getMembers().toString());
 
        

	
        
	

       
    }  
}
