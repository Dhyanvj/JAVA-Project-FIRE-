

/**
 * A Pass has an id number, name, a luxury rating,
 * number of credits and journey points
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pass 
{
   // Fields
   private int passId;
   private String Name;
   private int LRating;
   private int Credits;
   private int JPoints;
   // Constructor
   public Pass(int id, String n, int r, int c)
    {
        // initialise instance variables
        passId = id;
        Name = n;
        if (r > 0 && r < 11) {
            LRating = r;
        }
        else {
            throw new IllegalArgumentException("Invalid cents value: " + r);
        }
        Credits = c; 
        JPoints = 0;
    }
   // Methods
   // This method return the Pass ID Number.
   public int getpassId(){
        return passId;
    }
   // This method return the Pass Name.
   public String getName(){ 
        return Name;
    }
   // This method return the Pass Luxury Rating.
   public int getRating(){
        return LRating;
    }
   // This method return the Pass Credits.
   public int getCredits(){
       return Credits;
    }
   // This method return the Pass Journey Points.
   public int getPoints(){
       return JPoints;
   }
   // This method Add Credits.
   public void addcredits(int amount){
        Credits = Credits + amount;
    }
   // This method Deduct Credits.
   public void deductcredits(int amount){
        Credits = Credits - amount;
    }
   // This method deduct 3 credits and add 1 journey points whenever a ferry is used.
   public void Useferry(){
    if ((Credits - 3) >= 0){ 
       Credits = Credits - 3;
       JPoints = JPoints + 1;
    }
    }
   // This method converts journey points to credits.
   public void convertPoints(){
       if (JPoints > 4) {
        Credits += JPoints/5;
        JPoints = JPoints % 5;
    }
   }
   // This method return all relevant information about the Pass.
   public String toString(){
        return "\nThe Pass Id number: " + getpassId() + "\nPerson's Name: " 
        + getName() + "\nA Luxury Rating: " + getRating() + "\nNumber of Credits: " 
        + getCredits() + "\nJourney Points: " + getPoints() + "\n";
    }
   // Extra method for allowing employee to travel all passes. 
   public boolean IsEmployee(){
        return false;
    }
}