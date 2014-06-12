//Calvin Kwan
//Project #1 - Random Name Selector
//Due 1/18/2011

import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class nameselector
{
   public static void main(String[]args) throws IOException
   {      
      final int CLASS_SIZE = 40;
      String student [] = new String[CLASS_SIZE]; 
      int callCount [] = new int[CLASS_SIZE];

      //calls read method
      read(student, callCount);
 
       System.out.println("\nNumber of students in class: " + numberStudent(student, CLASS_SIZE));   
       
       //calls the random name method
       callName(student, callCount, numberStudent(student, CLASS_SIZE)); 
       
       //calls the command method 
       callCommand(student, callCount, CLASS_SIZE);
   } 
   
   //read method: allows the program to read the file and store into array
   public static void read(String student [], int callCount[]) throws IOException
   {         
         File myFile = new File ("name.txt");
         Scanner inputFile = new Scanner(myFile);
         
         int i = 0;
         String name;
         
         while (inputFile.hasNext())
         {
            name = inputFile.nextLine();
            student [i] = name;
            callCount [i] = 0;
            
            i = i+1; //inserts 1 name into each index
         }
         inputFile.close();  
   }
   
   //callCommand method: asks users to enter a command
   public static void callCommand(String student [], int callCount[], int CLASS_SIZE) throws IOException
   {
         Scanner kb = new Scanner(System.in); 
         
         System.out.print("\nCommand? ");
         String command = kb.nextLine();
         command = command.toLowerCase();
         
         if(command.equals("n") || command.equals("help") ||
            command.equals("list") || command.equals("exit"))
         {
         
            //this part is to tell the program to generator the next random name
            while(command.equals("n"))
            {
                callName(student, callCount, numberStudent(student, CLASS_SIZE));
                callCommand(student, callCount, CLASS_SIZE);
            }
            
            //this part helps user display the commands available
            while(command.equals("help"))
            {
            System.out.println("\nn - Next random name");
            System.out.println("exit - Exit the program");
            System.out.println("list - List all the unique names that have been called as well as the number of times");
            System.out.println("help - Display this message\n");
            
            callCommand(student, callCount, CLASS_SIZE);	
            }
            
            //this part lists all the names called and repetitions
            if(command.equals("list"))
            {
               int num = 0;
               for (int i = 0; i < CLASS_SIZE; i++)
               {
                  if(callCount[i] > 0)
                  System.out.println("\n" + ++num + ". " + student[i] + " (" + callCount[i] +")");
               }
                 callCommand(student, callCount, CLASS_SIZE);	           
            }         
            
            //this part does a summary and exits the program
            if(command.equals("exit"))
            {
               int total = 0;  
               int rep = 0;               
               for(int i = 0; i < CLASS_SIZE; i++)
               {
                  if(callCount[i] > 0)
                  {
                     total = total + callCount[i];
                  }
                  if(callCount[i] > 1)
                  {
                     rep++;
                  }
               }
               System.out.println("The program has generated " + total + " name(s) with " + rep + " repetition(s).");
               System.exit(0);
            }
         }
         
         //this part is to make sure the user enter 1 of the 4 commands available
         else
         {
            System.out.println("\nPlease choose one of the Following: ");
            
            System.out.println("\nn - Next random name");
            System.out.println("exit - Exit the program");
            System.out.println("list - List all the unique names"
                                    + " that have been called as well as" 
                                    +	" the number of times");
            System.out.println("help - Display this message\n");
            
            callCommand(student, callCount, CLASS_SIZE);            
         }
   }
   
   //numberStudent method: helps determine the total number of students in the class.
   public static int numberStudent(String student[], int CLASS_SIZE)
   {
      int count = 0;
      for (int i = 0; i < CLASS_SIZE; i++)
      {
         if(student[i] != null)
         {
            count++;
         }
      }
      return count;
   }
   
   //callName methid: this the part where the random name is generatored
   public static void callName(String student [], int callCount[], int numStudents)
   {
      Random randGen = new Random();
      int index = randGen.nextInt(numStudents);
      System.out.println("\n" + student[index]);
      ++callCount[index];
   }
}