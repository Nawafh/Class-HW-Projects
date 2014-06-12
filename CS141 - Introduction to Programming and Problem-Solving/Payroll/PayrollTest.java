import java.util.Scanner;
import java.util.*;
public class PayrollTest
{
   public static void main(String[]args)
   {  
      Scanner kb = new Scanner(System.in);
      
      System.out.print("enter employee name: ");
      String name = kb.nextLine();
      int number = 0;
	  double payRate = 0.00;
	  double hoursWorked = 0;
      boolean valid = false;
      do
      {
         valid = true;
         try
         {
            System.out.print("enter employee id: ");
            number = kb.nextInt();
         }
         catch (InputMismatchException e)
         {
            valid = false;
            kb.nextLine();
            System.out.println("ERROR: enter an integer");
         }
      } while (!valid);
      
      do
      {
         valid = true;
         try
         {
            System.out.print("enter hourly pay rate: ");
            payRate = kb.nextDouble();
         }
         catch (InputMismatchException e)
         {
            valid = false;
            kb.nextLine();
            System.out.println("ERROR: enter an integer");
         }
      } while (!valid);
      
      do
      {
         valid = true;
         try
         {
            System.out.print("enter number of hours worked: ");
            hoursWorked = kb.nextDouble();
         }
         catch (InputMismatchException e)
         {
            valid = false;
            kb.nextLine();
            System.out.println("ERROR: enter an integer");
         }
      } while (!valid);
    

      try
      {
         Payroll p = new Payroll();
         p.setName(name);
         p.setID(number);
         p.setPayRate(payRate);
         p.setHoursWorked(hoursWorked);
         
         System.out.println(p.getName());
         System.out.println(p.getID());
         System.out.println(p.getPayRate());
         System.out.println(p.getHoursWorked());
         System.out.println(p.getGrossPay());         
      }
      catch (InvalidNameException e)
      {
         System.out.println(e.getMessage());
      }
      catch (InvalidIDException e)
      {
         System.out.println(e.getMessage());
      }
      catch (InvalidHourlyRateException e)
      {
         System.out.println(e.getMessage());
      }
      catch (InvalidHoursException e)
      {
         System.out.println(e.getMessage());
      }
   }
}