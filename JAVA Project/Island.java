import java.util.*;
/**
 * An island is part of a FIRE resort.Each island has a name,  a luxury rating
 * and a capacity which represents the maximum number of people(passes) who can be on the  
 * island at any one time. Each island must maintain a list of all people (passes)
 * currently on the island. These lists are updated whenever passes enter or leave 
 * an island,so that it is always possible to say which passes are on the island 
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Island 
{
    // Fields
    private int IslandNo;
    private String Name;
    private int Rating;
    private int Capacity;
    private ArrayList<Pass> allPass;
    // Constructor
    public Island(int id, String n, int r, int ca)
    {
        // initialise instance variables
        IslandNo = id;
        if (id == 0){
            Rating = 0;
        }
        else{
            Rating = r;
        }
        Name = n;
        Capacity = ca;
        allPass = new ArrayList<Pass>();
    }
    // This method return the Island Number.
    public int getIslandNo(){
        return IslandNo;
    }
    // This method return the Island Name.
    public String getName(){ 
        return Name;
    }
    // This method return the Island Luxury Rating.
    public int getRating(){
        return Rating;
    }
    // This method return the Island Capacity.
    public int getCapacity(){
        return Capacity;
    }
    // Extra Method
    public ArrayList<Pass> getPassList(){
        return allPass;
    }
    // This method takes a Pass as a parameter and adds it to the ArrayList.
    public void enter(Pass p){
        allPass.add(p);
    }
    // This method takes a Pass as a parameter, finds its position in the ArrayList and then removes using this position. 
    public void leave(Pass p){
        int pos = allPass.indexOf(p);
        if (pos >= 0){
            allPass.remove(pos);
        }
    }
    // This method says whether the island is full or not.
    public String checkCapacity(){
        if (allPass.size() >= Capacity){
            return "Full";
        }
        else {
            return "Still Has Capacity";
        }
    }
    // This method returns the list of all Passes currently on the island.
    public String getallPassesList(){
        String ss = "";
        if (allPass.size() > 0)
        {
            for(Pass temp: allPass)
            {
                ss = ss + "\n" + temp.toString() +
                "\n-----------------------------------------------\n";
            }
            return ss;
        }
        return "\nNo Passes on this island" + "!!!!!!!!!!!!!!!!!!!!!\n" ;
    }
    // This method find and returns details of one Pass in the island by taking its Id Number as parameter.
    public Pass findPassAtIsland(int IdNo){
        for(Pass pass : allPass)
        {
            if (pass.getpassId() == IdNo)
            {
                return pass;
            }
        }
        return null;
    }
    // This method check if the pass is on the island using its Id number as parameter and return a boolean
    public boolean checkPass(int IdNo){
        boolean Check = false;
        for(int indx=0; indx<allPass.size(); indx++)
        {
            Pass temp = allPass.get(indx);
            if (temp.getpassId() == IdNo)
            {
                Check = true;
                break;
            }
        }
        return Check;
    }
    // This method returns island details and a list of the Passes on the island.
    public String toString(){
         String ss="\nIsland Id:" + IslandNo + "\nIsland Name: " + Name 
                     + "\nCapacity: " + Capacity+"\nIsland Rating:"+ Rating;
                     if(allPass.size()!=0)
                     {
                         ss = ss + "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++"+
                     "\n++++++++++++All the passes in this Island:+++++++++++++" +                
                     "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ getallPassesList();
                     }
                     else{
                         ss = ss + getallPassesList();
                     }
                  return ss;    
    }
    // This method return a boolean when the island has reached its capacity.
    public boolean checkCapacity1(){
        if (allPass.size() >= Capacity){
            return false;
        }
        else {
            return true;
        }
    }
}
