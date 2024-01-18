
/**
 * Write a description of class BusinessPass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BusinessPass extends Pass
{
    // instance variables - replace the example below with your own
    private int LRating;
    private int Credits;
    private int JPoints;
    private int LoyaltyPoints;
    /**
     * Constructor for objects of class BusinessPass
     */
    public BusinessPass(int id, String n)
    {
        // initialise instance variables
        super(id,n,8,30);
        LoyaltyPoints = 20;
        Credits = 30;
        LRating = 8;
        JPoints = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    @Override
    public void Useferry()
    {
       // put your code here
       if (Credits >= 3){
           Credits = Credits - 3;
           LoyaltyPoints = LoyaltyPoints + 2;
       }
    }
    // Converting Loyalty Points into Credits
    public void convertLPoints()
    {
        if (LoyaltyPoints > 4) {
        Credits += LoyaltyPoints/3;
        LoyaltyPoints = LoyaltyPoints % 5;
        }
    }
    @Override
    public int getCredits(){
        return Credits;
    }
    @Override
    public int getPoints(){
        return JPoints;
    }
    public int getLoyaltyPoints(){
        return LoyaltyPoints;
    }
    @Override
    public int getRating(){
        return LRating;
    }
    @Override
    public void addcredits(int amount){
        Credits = Credits + amount;
    }
    // @Override
     public String toString() {
        return "\n\n\n**************** Business Pass *****************\n"+
        super.toString() + "Loyalty Points: " + getLoyaltyPoints();
    }
}
