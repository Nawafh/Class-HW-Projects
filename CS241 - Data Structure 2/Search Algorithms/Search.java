/*
Calvin Kwan
CS241 - Project 3 Search Algorithms
*/
import java.io.*;
import java.util.Scanner;
import java.text.Format;
import java.util.Formatter;
public class Search
{
	public static void main(String[]args) throws IOException
	{
      final int AR_SIZE = 1000;
      int array [] = new int[AR_SIZE];
      int run [] = {15, 4455, 8191, 4000, 50};
      int i = 0;
      String line;
      String []store;
      int num = 8191;
      int key = 15;
      
      Search test = new Search(); 
      Hash<String,String> hashtbl = new Hash<String,String>(AR_SIZE);
      File myFile = new File ("numbers.dat");
      Scanner inputFile = new Scanner(myFile);
     
      while (inputFile.hasNext())
      {
         line = inputFile.nextLine();
         store = line.split("\\s+");
         for(int r=0; r<store.length; r++)
         {
            if(!(store[r].equals("")))
            {
               array[i++] = Integer.parseInt(store[r]);
               hashtbl.insert(store[r], store[r]);
            }
         }
      }
      inputFile.close(); 
      
      for(int t=0; t<5; t++)
         System.out.println("# of statements excecuted: " + test.linearSearch(array, run[t]) + "\n");
         
      for(int t=0; t<5; t++)      
         System.out.println("# of statements excecuted: " + test.binarySearch(array, run[t]) + "\n");
         
      for(int t=0; t<5; t++)
         System.out.println("# of statements excecuted: " + test.interpolationSearch(array, run[t]) + "\n");
         
      for(int t=0; t<5; t++)
         System.out.println("# of statements excecuted: " + hashtbl.get(Integer.toString(run[t])) + "\n");  
         
      test.BigOhStandard();
   }
   
   public void BigOhStandard()
   {
      int base = 2;
      int n = 1000;
      double logN = 0;
      double logLogN = 0;
         logN = logX(n, base);
         logLogN = logX(logN, base);
         System.out.println("Performance Metrics");
         System.out.println("                 O(n)   O(Log(n))    O(Log(Log(n)))     O(1)");
         System.out.print("When n = 1000    ");
         System.out.printf("%d     %5.3f         %5.3f            %d", n, logN, logLogN, 3);
   }
   
   public int linearSearch(int [] sorted, int toFind)
   {
      int i = 0;
      int k = 0;
      while(i < sorted.length)
      {
         if (sorted[i] == toFind)
            break;
         i++;
         k++;
      }
      if(i == sorted.length)
         System.out.println("(Linear Search) Find: " +  toFind + " array index = -1"); 
      else
         System.out.println("(Linear Search) Find: " +  toFind + " array index = " + i);
      return (k+3);
      //return i;
   }
   
   public int binarySearch(int[] sorted, int toFind) 
   {
      int low = 0;
      int high = sorted.length;
      int k1 = 0;
      int k2 = 0;
      int k3 = 0;
          
      while (low < high) 
      {
         k3++;
         int mid = (low + high) / 2;  // Compute mid point.
            k1++;              
            if (toFind < sorted[mid]) 
               high = mid;       // repeat search in bottom half. 
            else 
            {
               k2++;                 
               if (toFind > sorted[mid]) 
                  low = mid + 1;  // Repeat search in top half. 
               else
               {
                  System.out.println("(Binary Search) Find: " +  toFind + " array index = " + mid);
                  return mid;       // Found it. return position
               }
            }
      }
      System.out.println("(Binary Search) Find: " +  toFind + " array index = -1");   
      return (k1+k2+k3+8);
         //return -(low + 1);      // Failed to find toFind
   }
      
   public int interpolationSearch(int[] sorted, int toFind)
   {
      int low = 0;
      int high = sorted.length - 1;
      int mid;
      int k1 = 0;
      int k2 = 0;
      int k3 = 0;
         
      while (sorted[low] <= toFind && sorted[high] >= toFind) 
      {
         k1 = 2*k1+3;
         mid = low +
         ((toFind - sorted[low]) * (high - low)) /
         (sorted[high] - sorted[low]);
         k2 = k2 + 2;            
         if (sorted[mid] < toFind)
         {
            low = mid + 1;
         }   
         else
         {
            k3 = k3 + 2;             
            if (sorted[mid] > toFind)
            {
               high = mid - 1;
            }
            else
            {
               System.out.println("(Interpolation Search) Find: " +  toFind + " array index = " + mid);
               //return mid;
               return (k1+k2+k3+3);
            }
         } 
      }
      
      if (sorted[low] == toFind)
      {
         System.out.println("(Interpolation Search) Find: " +  toFind + " array index = " + low);
        // return low;
         return (k1+k2+k3+3);
      }
      else
      {
         System.out.println("(Interpolation Search) Find: " +  toFind + " array index = -1");
         //return -1; // Not found
         return (k1+k2+k3+3);
      }
   }
   
     
   public static double logX(double num, int base)
   {
      return (Math.log(num)/Math.log(base));
   }
}