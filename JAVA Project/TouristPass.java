
/**
 * Write a description of class TouristPass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TouristPass extends Pass
{
    // instance variables - replace the example below with your own
    private int LRating;
    private int Credits;
    private int JPoints;
    private String Citizenship;
    /**
     * Constructor for objects of class TouristPass
     */
    public TouristPass(int id, String n, int c, String Ci)
    {
        // initialise instance variables
        super(id,n,8,c);
        Citizenship = Ci;
        Credits = c;
        JPoints = 0;
        LRating = 8;
    }
    public String getcitizenship(){
        return Citizenship;
    }
    @Override
    public int getCredits()
    {
        return Credits;
    }
    @Override
    public int getPoints(){
       return JPoints;
    }
    @Override
    public int getRating(){
        return LRating;
    }
    @Override
    public void Useferry(){
        if(Credits >= 4){
            Credits = Credits - 4;
            JPoints++;
        }
    }
    @Override
    public void addcredits(int amount){
        Credits = Credits + amount;
    }
    // @Override
     public String toString() {
        return "\n\n\n**************** Tourist Pass *****************\n"+
        super.toString() + "Citizenship: "  + getcitizenship();
    }
}
