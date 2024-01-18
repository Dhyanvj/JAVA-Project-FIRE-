import java.util.*;
/**
 * Write a description of class PassTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PassTester
{
    public static void main(String[] args)
    {
        // Write your test here
        Pass Person1 = new Pass(123, "Dhyan", 5, 10);
        System.out.println("Id of Person 1: " + Person1.getpassId());
        System.out.println("Name of Person 1: " + Person1.getName());
        System.out.println("Luxury Rating of Person 1: " + Person1.getRating());
        System.out.println("Journey Credits of Person 1: " + Person1.getCredits()+"\n");
        
        System.out.println("#############Add 5 Credits##############");
        Person1.addcredits(5);
        System.out.println("Journey Credits of Person 1 is " + Person1.getCredits()+"\n");
        
        System.out.println("#############Deduct 3 Credits###########");
        Person1.deductcredits(3);
        System.out.println("Journey Credits of Person 1 is " + Person1.getCredits()+"\n");
        
        System.out.println("#############Using The Ferry############");
        // Use of Ferry will Deduct 3 Credits and Add 1 Journey Points.
        Person1.Useferry();
        System.out.println("Journey Credits of Person 1 after using the ferry for the first time: " + Person1.getCredits());
        System.out.println("Journey Points of Person 1 after using the ferry for the first time: " + Person1.getPoints()+"\n");
        
        System.out.println("############# Convert Points only if the Journey Points is greater than 4 #############");
        // This method will convert Journey Points into Credits only if the Journey Points is greater than 4.
        Person1.convertPoints();
        System.out.println("Journey Credits of Person 1: " + Person1.getCredits());
        System.out.println("Journey Points of Person 1: " + Person1.getPoints()+"\n");
        
        System.out.println("All Details of Person 1: " + "\n" + " " + Person1.toString());
    }
}
