import java.util.Scanner;
 
public class HeartRate
{
    public static void main (String[]args)
    {
    //This program will calculate a valid range of a heart rate for a specific person(while exercising) by using his age.
    final int CONST = 220;//this is a variable that describes the limit for calculation
    Scanner scanner = new Scanner(System.in);//creating a scanner to enter user's input
    System.out.println ("This program calculates your " + "target heart rate while exercising ");//message for the user
    System.out.print("Enter your age: ");//message for the user, asking for an input
    int age=scanner.nextInt();//reading the input from the user
    System.out.println("Your estimated target heart rate zone is "+(int)((CONST-age)*0.65)+" – "+(int)((CONST-age)*0.85)+" beats per minute.");//message for the user with the outcome
    }// end of method main
    
    
}//end of class HeartRate
