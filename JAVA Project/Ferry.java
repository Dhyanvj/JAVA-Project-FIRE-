
/**
 * A ferry provides a one-way journey between two islands. It
 * has a ferry code and information about both the source and
 * the destination island
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ferry
{
    // Fields
    private String FerryCode;
    private Island Source;
    private Island Destination;
    // Constructors
    public Ferry (String fc, Island s, Island d){
        // Initialise instance variables
        FerryCode = fc;
        Source = s;
        Destination = d;
    }
    // This method return the Ferry Code.
    public String getFerryCode(){
        return FerryCode;
    }
    // This method return the Source Island.
    public Island getSource(){
        return Source;
    }
    // This methos return the Destination Island.
    public Island getDestination(){
        return Destination;
    }
    // This method returns a Boolean saying if a Pass, given as a parameter, can travel on the ferry .
    public boolean canPassTravel(Pass p){
        {
        int PassRating = p.getRating();
        int PassCredit = p.getCredits();
        int PassId = p.getpassId();
        // Checking if the Pass is not an Employee then do the following.
        if(p.IsEmployee() == false){
            if (PassRating >= Destination.getRating() 
            && PassCredit >= 3
            && Destination.checkCapacity1() 
            && Source.checkPass(PassId))
            {
                return true;
            }
        
            else 
            {
                return false;
            }
        }
        // If it is an Employee then do the following.
        else {
            if (Destination.checkCapacity1() 
            && Source.checkPass(PassId))
            {
                return true;
            }
        
            else 
            {
                return false;
            }
        }
    }
    }
    // This method process a Pass travelling to the destination island:
    // if the pass meets the conditions, remove it from the source island, 
    //  add it to the destination island, 
    //  and update information on the Pass, 
    //  and return a suitable message.
    // if it does not meet one of the conditions, 
    //  return an appropriate message and do NOT move it.
    public String movePass(Pass p){
      if (p.IsEmployee() == false){
          if(p.getCredits() < 3){
              return "The pass does not have enough credits";
          }
          else if(p.getRating() < Destination.getRating()){
              return "The Pass's luxury rating is lower than the rating of the destination island";
          }
          else if(!Destination.checkCapacity1()){
              return "The arrival of the Pass would exceed the maximum capacity of the destination island";
          }
          else if(!Source.checkPass(p.getpassId())){
              return "The Pass is not listed in the source island for the ferry";
          }
          else
          {
            Destination.enter(p);
            Source.leave(p);
            p.Useferry();
            return ("\n\n"+
                     "Updated Pass Information\n"+
                     "\n"+
                     p.toString()+
                     "\n---------------------------------------------------------\n"+
                     "Moved from:"+ Source.getName()+
                     "\nSettled in:"+ Destination.getName())+
                     "\nUsed Ferry:"+ getFerryCode();
          }
      }
      // This is moving the Employee Pass which have zero credits and highest rating.
      else
      {
          if(!Destination.checkCapacity1()){
              return "The arrival of the Employee Pass would exceed the maximum capacity of the destination island";
          }
          else if(!Source.checkPass(p.getpassId())){
              return "The Employee Pass is not listed in the source island for the ferry";
          }
          else 
          {
            Destination.enter(p);
            Source.leave(p);
            p.Useferry();
            return ("\n\n"+
                     "Updated Pass Information\n"+
                     "\n"+
                     p.toString()+
                     "\n---------------------------------------------------------\n"+
                     "Moved from:"+ Source.getName()+
                     "\nSettled in:"+ Destination.getName())+
                     "\nUsed Ferry:"+ getFerryCode();
          }
      }
    }
    // This method returns a String representation of an object of that class including , room details and list of Passes .
    public String toString(){
      String s = "";
      s = s + "Ferry Code" + getFerryCode() + "\n Source Island" + getSource()
      +"\nDestination Island: " + getDestination() + "This Ferry Used by the passes: ";
      return s;
    }
}    
