
import java.util.*;
/**
 * Write a description of class Tester here.
 * 
 * @author 
 * @version 
 */
public class Tester 
{   
    private void doTest()
    {
        FIRE fortunate = new Resort("Fortunate Islands");
        Scanner enter = new Scanner(System.in);
        
        // Write all of your tests here
        //System.out.println(fortunate.toString());
        System.out.println("######################################## Test 1 ########################################");
        System.out.println("\nTest1: Expects--All the informations about the resort Fortunate Islands."+
        "\nInlcuding Island Informations and\nAll passes on each island and their informations.\n");
        System.out.println(fortunate.toString());
        System.out.println("\n\nTest1:Result is same as expectation.\n"+
        "So,the 'toString()' Method of Resort Class is working properly.\n");
        
        System.out.println("######################################## Test 2 ########################################");
        //Testing getAllPassesOnAllIslands() Method
        System.out.println("\nTest2: Expects-- Output All the Passes on All Islands");
        System.out.println(fortunate.getAllPassesOnAllIslands());
        System.out.println("\n\nTest2: Expectation and result is same so The method is working properly.\n");
        
        System.out.println("######################################## Test 3 ########################################");
        //Testing getAllPassesOnIsland(Str) Method
        System.out.println("\nTest3: Expects-- Output All the Passes on the Base Island ");
        System.out.println(fortunate.getAllPassesOnIsland("Base"));
        System.out.println("\n\nTest3: Expectation and result matches so the method is working.\n");
        
        System.out.println("######################################## Test 4 ########################################");
        //Testing findPassLocation(integer) Method
        System.out.println("\nTest4: Expects--The pass should be on the Base Island.\n");
        System.out.println(fortunate.findPassLocation(1000));
        System.out.println("\nTest4: Expectation and result is same so the method is working.\n");
        
        System.out.println("######################################## Test 5 ########################################");
        //Testing canTravel(int cdId, String ferCode) Method
        System.out.println("\nTest5: Expects--The pass should be 'true'.\n");
        System.out.println(fortunate.canTravel(1000,"ABC1"));
        System.out.println("\nTest5: Expectation and result matches so the method is working.\n");
        
        System.out.println("######################################## Test 6 ########################################");
        //Testing travel(int pPassId, String ferCode ) Method
        System.out.println("\nTest6: Expects--The pass should be Moved to 'Yorkie' Island");
        System.out.println(fortunate.travel(1000,"ABC1"));
        System.out.println("\nTest6: Expectation and result is same so the method is working.\n");
        
        System.out.println("######################################## Test 7 ########################################");
        //Testing Pass '1000' New location
        System.out.println("\nTest7: Expects--The pass should be on 'Yorkie' Island.\n");
        System.out.println(fortunate.findPassLocation(1000));
        System.out.println("\nTest7: Expectation and result is same so the method is working.\n");
        
        System.out.println("######################################## Test 8 ########################################");
        //Testing Pass '1000' Journey Point and viewPass(integer) method
        System.out.println("\nTest8: Expects--Should show all the informations about the pass"+
        " and the pass Journey Point should be into '1'"+
        " as he use of the ferry.\n");
        System.out.println(fortunate.viewAPass(1000));
        System.out.println("\nTest8: Expectation and the result matches so the method is working.\n");
        
        System.out.println("######################################## Test 9 ########################################");
         //Testing topUpCredits(int id, int creds) Method
        System.out.println("\nTest9: Expects--Should TopUp '20' credits to the pass");
        fortunate.topUpCredits(1000,20);
        //System.out.println("\nTest9: Expectation and result is same so the method is working.\n");
        
        System.out.println("\n######################################## Test 10 ########################################");
        //Pass Updated Informations
        System.out.println("\nTest10: Expects--Should show all the informations about the pass"+
        " and the pass Credits should be '27'"+
        " as he made a TopUp of 20 Credits\n");
        System.out.println(fortunate.viewAPass(1000));
        System.out.println("\nTest10: Expectation and result matches so the method is working.\n");
        
        System.out.println("######################################## Test 11 ########################################");
        //Testing convertPoints(int id) Method
        System.out.println("\nTest11: Expects--Mutator should Convert the points to credits'");
        fortunate.convertPoints(1000);
        //System.out.println("\nTest11: Expectation and result matches so the method is working.\n");
        
        System.out.println("\n######################################## Test 12 ########################################");
        //Pass Updated Informations
        System.out.println("\nTest12: Expects--Should show all the informations about the pass"+
        " The pass Credits should remain the same becuse Journey Points is less than 4 so it cannot be converted into credits'\n");
        System.out.println(fortunate.viewAPass(1000));
        System.out.println("\nTest12: Expectation and result matches so The method is working.\n");
                
        
    }
    
    // No need to change this
    public static void main(String[] args)
    {
        Tester xx = new Tester();
        xx.doTest();
    }
}
