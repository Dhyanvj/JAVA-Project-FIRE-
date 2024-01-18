import java.util.*;
/**
 * Write a description of class ResortUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResortUI
{  
    private Scanner reader = new Scanner(System.in);
    private FIRE fortunate = new Resort("Fortunate Islands");
    
    private void runUI()
    {   
        int choice = getOption();        
        while (choice != 0)
        {            
            // process choice
            if      (choice == 1){listAllResort();}
            else if (choice == 2){listAllPasses();}
            else if (choice == 3){listOneIsland();}
            else if (choice == 4){findLocationOfPass();}
            else if (choice == 5){tryTravel();}
            else if (choice == 6){travelNow();}
            else if (choice == 7){viewPass();}
            else if (choice == 8){updateCredits();}                        
            else if (choice == 9){convertPts();}

            // output menu & get choice
            
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }
    
    private int getOption()
    {
        System.out.println("What would you like to do ?");
        System.out.println("0. Quit");
        System.out.println("1. List all resort details");
        System.out.println("2. List all passes on all islands");
        System.out.println("3. List all passes on one island");
        System.out.println("4. Find location of pass");
        System.out.println("5. Say if pass can move by ferry");
        System.out.println("6. Move a pass by ferry");
        System.out.println("7. View pass");
        System.out.println("8. Top up credits");
        System.out.println("9. Convert points to credits ");

        System.out.println("Enter your choice");
        // read choice
        int option = reader.nextInt();
        reader.nextLine();
        return option;
    }
    
    // This one has been done for you 
    private void listAllResort()
    {
        System.out.println(fortunate.toString());
    }
    
    // provide the code here  
    private void listAllPasses()
    {
        System.out.println(fortunate.getAllPassesOnAllIslands());
    }
   
    // provide the code here 
    private void listOneIsland()
    {
        System.out.println("Enter name of Island");
        String i = reader.nextLine();
        System.out.println(fortunate.getAllPassesOnIsland(i));
    }
       
    // This one has been done for you
    private void findLocationOfPass()
    {
        System.out.println("Enter pass id");
        int trav = reader.nextInt();
        String ww = fortunate.findPassLocation(trav);
        if(ww != null)
        {
            System.out.println(ww);
        }
        else
        {
            System.out.println("No such pass");
        }
    }
    
    // This one has been done for you 
    private void tryTravel()
    {
        System.out.println("Enter pass id");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter ferry code");
        String ferry = reader.nextLine();
        System.out.println(fortunate.canTravel(trav,ferry));
    }
    
    // provide the code here
    private void travelNow()
    {
        System.out.println("Enter pass Id");
        int Travel = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter ferry Code");
        String Ferry = reader.nextLine();
        System.out.println(fortunate.travel(Travel, Ferry));
    }
    
    // This one has been done for you
    private void viewPass()
    {
        System.out.println("Enter pass ID number");
        int cId = reader.nextInt();
        System.out.println(fortunate.viewAPass(cId));
    }
     
    // provide the code here
    private void updateCredits()
    {
        System.out.println("Enter pass Id");
        int id = reader.nextInt();
        reader.nextLine();
        if(fortunate.viewAPass(id).equals(""))
        {
            System.out.println(
            "#############################################\n"+
            "#########   Transaction Failed!!!    ########\n"+
            "#############################################\n"+
            "\n\nThere is no pass with id: "+id+
            "\nPlease Try Again!!!"
            
            );
        }
        else
        {
        System.out.println("Enter number of credits you want to TopUp:");
        int credits = reader.nextInt();
        String BeforeTopUp = fortunate.viewAPass(id);
        fortunate.topUpCredits(id,credits);
        System.out.println(
            "#############################################\n"+
            "#######   Transaction Successfull!!!    #####\n"+
            "#############################################\n"+
            "Before TopUp Person's Informations\n"+
            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
            BeforeTopUp+
            "\n\nAfter TopUp Person's Informations\n"+
            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
            fortunate.viewAPass(id)+
            
            "\n\nThank You!!!"
            
            );
        }
    }
         
    // This one has been done for you
    private void convertPts()
    {
        System.out.println("Enter pass ID number");
        int cId = reader.nextInt();
        fortunate.convertPoints(cId);
    }   
    
    public static void main(String[] args)
    {
        ResortUI xx = new ResortUI();
        xx.runUI();
    }
    
}
