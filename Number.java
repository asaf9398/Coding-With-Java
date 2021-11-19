import java.util.Scanner;
 
public class Number
{
    public static void main (String[]args)
    {
    /*This program will get a 4 digit number and the user will be able to run several options on in.
    In case that the number does not have 4 digits an error message will appear and the program will be closed*/
    Scanner scanner = new Scanner(System.in);//creating a scanner to enter user's input
    System.out.println ("Please enter a 4 digit number ");//requesting from the user to enter a number
    int num=scanner.nextInt();//reading the input from the user
    if((num>999&&num<10000)||(num<-999&&num>-10000))//checking that num has 4 digits
    {
        System.out.println ("1. Reverse sign.");//describing option number 1
        System.out.println ("2. Reverse number.");//describing option number 2
        System.out.println ("3. Reverse sign and number.");//describing option number 3
        System.out.println ("Please choose an option: ");//requesting from the user to enter an option number
        int option=scanner.nextInt();//reading the input from the user
        if(option==1||option==2||option==3)
        {
            if(option==1)//happens when the user choose option number 1
            {
                //reversing the number's sign
                num=num*-1;//reversing number's sign by multipling by -1
                System.out.println(num);//printing the number after change
            }
            if(option==2)//happens when the user choose option number 2
            {
            //reversing the number
            int newNum=num%10*1000;//creating new variable to calculate the new number, and adding the last numebr 
            num/=10;//deleting the last number
            newNum+=num%10*100;//adding current last numebr 
            num/=10;//deleting the last number
            newNum+=num%10*10;//adding current last numebr 
            num/=10;//deleting the last number
            newNum+=num%10;//adding current last numebr 
            num/=10;//deleting the last number
            num=newNum;//insering newNum to the num variable - the original variable
            System.out.println(num);//printing the number after change
            }
            if(option==3)//happens when the user choose option number 3
            {
            //reversing the number and sign
            int newNum=num%10*1000;//creating new variable to calculate the new number, and adding the last numebr 
            num/=10;//deleting the last number
            newNum+=num%10*100;//adding current last numebr 
            num/=10;//deleting the last number
            newNum+=num%10*10;//adding current last numebr 
            num/=10;//deleting the last number
            newNum+=num%10;//adding current last numebr 
            num/=10;//deleting the last number
            num=newNum;//insering newNum to the num variable - the original variable
            num=num*-1;//reversing number's sign by multipling by -1
            System.out.println(num);//printing the number after change
            }
        }
        else
        {
        System.out.println("Illegal option – you must choose 1, 2 or 3");//if option is not 1/2/3 an error displays on the screen 
        }
    }
    else
    {
        System.out.println("Illegal number – you must enter a 4 digit number");//error message appears - num does not have 4 digits
    }
    }// end of method main
    
    
}//end of class Number
