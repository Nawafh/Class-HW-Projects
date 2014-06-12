/**
Project 2- Graph data Structure
Date created: 05/13/2011
Author: Calvin Kwan
**/
import java.util.Scanner;
import java.io.*;

public class DigraphTest
{
	public static void main(String[]args) throws Exception
	{
		String from;
		String to;
		Digraph path = new Digraph();
		Scanner kb = new Scanner(System.in);

		path.read(); 

        System.out.println("\n\nc - City Information");
        System.out.println("f - Find a Path Between Two Cities");
        System.out.println("i - Insert a Road");  
        System.out.println("d - Delete a Road");  	  
        System.out.println("e - Exit the program");

        System.out.print("\nCommand? ");
        String command = kb.nextLine();
        command = command.toLowerCase();
	
        while(!command.equals("e")) //while command not equals to e (exit)
        {
           if(command.equals("c") || command.equals("f") || command.equals("i") || command.equals("d"))
           {            
              if(command.equals("c")) // c for City Info
              {
			  	 System.out.print("Enter 2-Character City Code: ");
				 String cityCode = kb.nextLine();
				 path.FindCityInfo(cityCode);	
              }
			
			  if(command.equals("f")) // f for Find a Path Between 2 Cities
			  {
				 System.out.print("Enter From(2-Character City Code): ");
				 from = kb.nextLine();
				 System.out.print("Enter To(2-Character City Code): ");
				 to =  kb.nextLine();
				 path.createMinCostMatrix();
				 path.findPath(from, to);				
			 }
			
			 if(command.equals("i")) // i for Inserting a Road
			 {
				 System.out.print("Enter From(2-Character City Code): ");
				 from = kb.nextLine();
				 System.out.print("Enter To(2-Character City Code): ");
				 to =  kb.nextLine();
				 System.out.print("Enter Distance(At most 3 digits): ");
				 int distance = kb.nextInt();
				 path.insertConnection(from, to, distance);
			 }
			
			 if(command.equals("d")) // d for deleting a Road
			 {
			 	System.out.print("Enter From(2-Character City Code): ");
				from = kb.nextLine();
				System.out.print("Enter To(2-Character City Code): ");
				to =  kb.nextLine();
				path.deleteConnection(from, to);
			 }      
          }
		 
          System.out.print("\n\nCommand? ");
          command = kb.nextLine();
          command = command.toLowerCase();        
        }
		path.listCityData();		  		
		path.outputAdjMatrix();
		path.outputTransMatrix();
		path.outputCostMatrix();	  
		
		path.listCityConnections();
	}
}