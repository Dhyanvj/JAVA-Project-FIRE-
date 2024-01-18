
/**
 * Write a description of class EmployeePass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EmployeePass extends Pass
{
    // instance variables - replace the example below with your own
    private int LRating;
    private int Credits;
    private int EmployeeNumber;
    private String JobDescription;
    private int JPoints;
    /**
     * Constructor for objects of class BusinessPass
     */
    public EmployeePass(int id, String n, int empNo, String JD)
    {
        // initialise instance variables
        super(id,n,10,0);
        EmployeeNumber = empNo;
        JobDescription = JD;
        JPoints = 0;
        Credits = 0;
        LRating = 10;
    }
    @Override
    public void Useferry()
    {
        // put your code here
        JPoints++;
    }
    @Override
    public int getPoints(){
       return JPoints;
    }
    public int getEmployeeNumber(){
        return EmployeeNumber;
    }
    @Override
    public int getCredits(){
        return Credits;
    }
    @Override
    public int getRating(){
        return LRating;
    }
    public String getJobDescription(){
        return JobDescription;
    }
    @Override
    public void addcredits(int amount){
        Credits = Credits + amount;
    }
    // Passing the Employee to Pass to check is the pass is an employee or not.
    public boolean IsEmployee(){
        return true;
    }
    @Override
     public String toString() {
        return "\n\n\n**************** Employee Pass *****************\n"+
        super.toString() + "Employee Number: " + getEmployeeNumber() + 
        "\nJob Description: " + getJobDescription();
    }
}
