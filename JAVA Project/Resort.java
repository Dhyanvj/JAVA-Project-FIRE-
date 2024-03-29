import java.util.*;

/**This class implements the FIRE interface
 *
 * @author A.A.Marczyk 
 * @version 05/11/22
 **/
public class Resort implements FIRE   // do not change this header
{

    private String location;
    // Other fields (including collections)
    //private String Name;
    private ArrayList<Island> allIslands = new ArrayList<Island>();
    private ArrayList<Pass> allPasses = new ArrayList<Pass>();
    private ArrayList<Ferry> allFerries = new ArrayList<Ferry>();

    /** constructor
     * Some code has been provided 
     */
    public Resort(String loc) 
    {
        location = loc;
        loadIslandsAndFerries();
        loadPasses();
        // Ensure all passes are added to Base Island
        for (int indx = 0; indx < allPasses.size(); indx++) {
            Pass temp = allPasses.get(indx);
            allIslands.get(0).enter(temp);
        }
        // you may do this here or in one of the above method
    }
    
    /**
     * Returns information about the resort including its location/name and all
     * passes currently on each island, or "No passes" (if no pass on that island
     * @return all of the details of all islands including location 
     * and all passes currently on each island, or "No passes" if island has no passes
     */
    public String toString()
    {
        String s = "";
        for(int i=0; i<allIslands.size(); i++)
        {
            Island island = allIslands.get(i);
            if(island.getIslandNo()==0)
            {
                s = s + "Resort Location:\n" + location + "\n***This is the Base Island***\n" + island;
            }
            else
            {
                s = s + "\n" + island;
            }
        }
        return s;
    }

    /**Returns a String representation of all the passes on all islands
     * with "No passes" if there are no passes on an island
     * @return a String representation of all passes on all islands
     **/
    public String getAllPassesOnAllIslands()
    {
        String s = "\nLocation of Passes\n";
        for (Island island : allIslands)
        {
        // Taking all passes on each island from Island class.
        ArrayList<Pass> PassOnEachIsland = new ArrayList<Pass>();
        PassOnEachIsland = island.getPassList();
        if(PassOnEachIsland.size() == 0)
        {
            s = s + "\n\nNo Passes on " + island.getName() + " island";
        }
        else
        {
            // Coverting ArrayList to String
            for (Pass pass : PassOnEachIsland){
                s = s + pass;
            }
        }
        }
        return s;
    } 
 
    /**Returns the name of the island which contains the specified pass or "Not found"
     * @param cd -the id of the pass
     * @return the name of the Island which contains the pass, or "Not found"
     **/
    public String findPassLocation(int cd)
    {
        Pass p = getPass(cd);
        if (p != null)
        {
            for (Island island : allIslands){
                if (island.checkPass(cd)){
                    return "Island Name: " + island.getName();
                }
            }
        }
        return "Not found";
    }
    
    /**Returns details of the pass with the specified id or "Not found"
     * @param cd - the id of the pass
     * @return the details of the pass, or "Not found"
     **/
    public String viewAPass(int cd)
    {
        for (Pass pp: allPasses)
        {
            if (pp.getpassId() == cd)
            {
                return pp.toString();
            }
        }
        return "Not found";
    }
    
    /** Given the name of a island, returns the island id number
     * or -1 if island does not exist
     * @param isl is the name of island
     * @return id number of island
     */
    public int getIslandNumber(String isl)
    {
        for (int index = 0; index < allIslands.size(); index++){
            Island I = allIslands.get(index);
            String Iname = I.getName();
            if(isl.equals(Iname))
            {
                return I.getIslandNo();
            }
        }
        return -1;
    }
                
    /**Returns a String representation of all passes on a specified island
     * @param isl - the name of the island
     * @return a String representation of all passes on specified island
     **/
    public String getAllPassesOnIsland(String isl)
    {
        String s = "\nPasses on \n";
        Island i = getIsland(isl);
        if(i != null)
        {
            s = s + "\n_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n"+
                    "_-_-_-_-_-_-Island Informations_-_-_-_-_-_-_\n"+
                    "_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n"+
                    i;
        }
        else
        {
            s = s + "\n_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n"+
                    "There Is No Island With Name :"+isl+
                    "\n_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n";       
        }
        //for(Pass p : i.getPassList())
        //{
        //   s = s + "\n" + i.getName() + "\n" + " " + p + "\n";
        //}
        return s;
    } 

    
     /**Returns true if a Pass is allowed to journey using a ferry, false otherwise
     * A journey can be made if:  
     * the rating of the pass >= the rating of the destination island
     * AND the destination island is not full
     * AND the pass has sufficient credits (a journey costs 3 credits)
     * AND the pass is currently in the source island 
     * AND the pass id and ferry code represent objects in the system
     * @param cdId is the id of the pass requesting the move
     * @param ferCode is the code of the ferry journey by which the pass wants to move
     * @return true if the pass is allowed on the ferry journey, false otherwise 
     **/
    public boolean canTravel(int cdId, String ferCode)
    {   
        Ferry f = getFerry(ferCode);
        Pass p = getPass(cdId);
        if(f != null && p != null && f.canPassTravel(p)){
            return true;
        }
        else {
            return false;
        }
    }     

    /**Returns the result of a pass requesting to journey by Ferry.
     * A journey will be successful if:  
     * the luxury rating of the pass  >= the luxury rating of the destination island
     * AND the destination island is not full
     * AND the pass has sufficient credits
     * AND the pass is currently in the source island
     * AND both the pass id and the ferry code is on the system
     * If the ferry journey can be made, the pass is removed from the source island,
     * added to the destination island and a suitable message returned. Pass 
     * information should be updated (A journey costs 3 credits and journey points incremented by 1)
     * If the ferry journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param pPassId is the id of the pass requesting the move
     * @param ferCode is the code of the ferry by which the pass wants to travel
     * @return a String giving the result of the request 
     **/
    public String travel(int pPassId, String ferCode )
    {   //other checks optional
        //Modify here left for Employee Pass
        String s = "";
        Pass p = getPass(pPassId);
        Ferry f = getFerry(ferCode);
        if (p == null && f != null)
        {
            return "\nThere is no Pass with Id number: " + pPassId;
        }
        else if (f != null && p == null)
        {
            return "\nThere is no Ferry with Code: " + ferCode;
        }
        else if(f == null && p == null)
        {
            return ("\nThere is no Ferry with Code: " + ferCode +
            "\nAnd There is no  Pass with Id number: " + pPassId);
        }
        else if (f.canPassTravel(p) == true)
        {
            s = s + f.movePass(p);
        }
        else if (f.canPassTravel(p) == false)
        {
            s = s + f.movePass(p);
        }
        return s;
    } 
         
    /** Allows credits to be added to a pass.
     *  @param id the id of the pass toping up their credits
     *  @param creds the number of credits to be added to pass 
     */
    public void topUpCredits(int id, int creds)
    {
        for(Pass P : allPasses){
            if(P.getpassId() == id){
                P.addcredits(creds);
                break;
            }
        }
    }
    
    /** Converts a pass's journey points into credits
     * @param id the id of the pass whose points are to be converted
     */
    public void convertPoints(int id)  
    {
        for(Pass P : allPasses){
            if(P.getpassId() == id){
                P.convertPoints();
            }
        }
    } 

    //***************private methods**************
    private void loadPasses()
    {
        Pass p1 = new Pass(1000, "Lynn", 5, 10);
        Pass p2 = new Pass(1001, "May", 3, 30);
        Pass p3 = new Pass(1002, "Nils", 10, 0);
        Pass p4 = new Pass(1003, "Olek", 1, 12);
        Pass p5 = new Pass(1004, "Pan", 3, 3);
        Pass p6 = new Pass(1005, "Quin", 1, 30);
        Pass p7 = new Pass(1006, "Raj", 4, 5);
        Pass p8 = new Pass(1007, "Sol", 7, 20);
        Pass p9 = new Pass(1008, "Tel", 6, 30);
        
        allPasses.add(p1);
        allPasses.add(p2);
        allPasses.add(p3);
        allPasses.add(p4);
        allPasses.add(p5);
        allPasses.add(p6);
        allPasses.add(p7);
        allPasses.add(p8);
        allPasses.add(p9);
        
        // Inheritance
        EmployeePass EP = new EmployeePass(1010, "Jolly", 1111, "Chef");
        allPasses.add(EP);
        
        BusinessPass BP=new BusinessPass(9090, "Neha");
        allPasses.add(BP);
        
        TouristPass TP=new TouristPass(2002, "Numan", 7, "United Kingdom");
        allPasses.add(TP);
    }
    
    private void loadIslandsAndFerries()
    {
        Island i1 = new Island(0, "Base", 0, 100);
        allIslands.add(i1);
        Island i2 = new Island(1, "Yorkie", 1, 100);
        allIslands.add(i2);
        Island i3 = new Island(2, "Bounty", 3, 10);
        allIslands.add(i3);
        Island i4 = new Island(3, "Twirl", 5, 2);
        allIslands.add(i4);
        Island i5 = new Island(4, "Aero", 1, 1);
        allIslands.add(i5);
        
        //i1.setPassList(allPasses);
        
        Island Base1 = getIsland("Base");
        Island Yorkie2 = getIsland("Yorkie");
        Island Bounty3 = getIsland("Bounty");
        Island Twirl4 = getIsland("Twirl");
        Island Aero5 = getIsland("Aero");
        
        Ferry f1 = new Ferry("ABC1", Base1, Yorkie2);
        Ferry f2 = new Ferry("BCD2", Yorkie2, Base1);
        Ferry f3 = new Ferry("CDE3", Yorkie2, Bounty3);
        Ferry f4 = new Ferry("GHJ6", Yorkie2, Aero5);
        Ferry f5 = new Ferry("JKL8", Bounty3, Twirl4);
        Ferry f6 = new Ferry("DEF4", Bounty3, Yorkie2);
        Ferry f7 = new Ferry("EFG5", Twirl4, Yorkie2);
        Ferry f8 = new Ferry("HJK7", Aero5, Yorkie2);
        
        allFerries.add(f1);
        allFerries.add(f2);
        allFerries.add(f3);
        allFerries.add(f4);
        allFerries.add(f5);
        allFerries.add(f6);
        allFerries.add(f7);
        allFerries.add(f8);
    }
  
    /** Returns the pass with the pass id specified by the parameter
     * @param id pass id
     * @return the pass with the specified name
     **/
    private Pass getPass(int id)
    {
        for(Pass pass : allPasses){
            if(pass.getpassId() == id){
                return pass;
            }
        }
        return null;
    }
    
    
    /** Returns the island with the name specified by the parameter
     * @param islandName the island name
     * @return the island with the specified name
     **/
    private Island getIsland(String islandName)
    {
        for(Island island : allIslands)
        {
            if(island.getName().equals(islandName))
            {
                return island;
            }
        }
        return null;
    } 
    
    /** Returns the ferry with the ferry code specified by the parameter
     * @param fer the ferry code
     * @return the island with the specified name
     **/
    private Ferry getFerry(String fer)
    {
        for(Ferry temp: allFerries)
        {
            String code = temp.getFerryCode();
            if(code.equals(fer))
            {
                return temp;
            }
        }
        return null;
    }
}