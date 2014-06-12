/**
Calvin Kwan
CS240
Project 3 - Stack Application
*/	
import java.util.Scanner;

public class ConversionTest
{
    public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
        
      System.out.print("Enter expression (Hit Enter to Exit): ");
      String input = kb.nextLine();  
      
      while(!input.equals(""))
      {
          String prefix = "";
          String postfix = "";
          Conversion infix = new Conversion(input);
          
          System.out.println("Infix is " + input);
          boolean correct = infix.chkInput(input);          
          
          postfix = infix.toPostfix();     
          if (!postfix.equals("?") && correct)
            System.out.println("Postfix is " + postfix);
               
          prefix = infix.toPrefix();
          if (!prefix.equals("?") && correct)
            System.out.println("Prefix is " + prefix);      
            
          if(postfix.equals("?") || prefix.equals("?"))
            System.out.println("unmatched parentheses");    
            
          if(postfix.equals("?") || prefix.equals("?") || !correct)
            System.out.println("Original expression is unbalanced.");     
            
         System.out.print("\nEnter expression (Hit Enter to Exit): ");
         input = kb.nextLine();
      }
      System.exit(0);
   }
}