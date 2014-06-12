import java.io.*;
public class SortTest
{
   public static void main(String[]args) throws IOException
   {
      final int AR_SIZE = 1000;
      int arrRandom [] = new int[AR_SIZE];
      int arrAscend [] = new int[AR_SIZE];
      int arrDescend [] = new int[AR_SIZE];
      Sort test = new Sort();

      test.readData("numseq1.dat");
      test.readData("numseq2.dat");
      test.readData("numseq3.dat");
      
      


      //(1) BUBBLE SORT
      test.initializeArr(arrRandom, arrAscend, arrDescend);
      System.out.println("With random numbers >>>");
      test.bubbleSort(arrRandom);
      System.out.println("With numbers sorted in Ascending Order >>>");
      test.bubbleSort(arrAscend);
      System.out.println("With numbers sorted in Descending Order >>>");      
      test.bubbleSort(arrDescend);
      System.out.println("---------------------------------------------");      
 
      //(2) SELECTION SORT
      test.initializeArr(arrRandom, arrAscend, arrDescend);
      System.out.println("With random numbers >>>");      
      test.selectionSort(arrRandom);
      System.out.println("With numbers sorted in Ascending Order >>>");      
      test.selectionSort(arrAscend);
      System.out.println("With numbers sorted in Descending Order >>>");      
      test.selectionSort(arrDescend);
      System.out.println("---------------------------------------------");

      //(3) QUICK SORT
      test.initializeArr(arrRandom, arrAscend, arrDescend);
      int countQR [] = new int[2];
      
      System.out.println("With random numbers >>>");    
      countQR = test.quickSort(arrRandom, 0, arrRandom.length-1);
      System.out.println("(Quick Sort) First 20 numbers: ");
      for(int f = 0; f < 20; f++)
         System.out.print(arrRandom[f] + " ");

      System.out.println("\n\n(Quick Sort) Last 20 numbers: "); 
      for(int l = arrRandom.length - 20; l < arrRandom.length; l++)
         System.out.print(arrRandom[l] + " ");
         
      System.out.println("\n\n(Quick Sort) Number of Comparison: "
                              + countQR[0] + " ; Number of Moves: " + countQR[1] + "\n");


      int countQA [] = new int[2];
      
      System.out.println("With numbers sorted in Ascending Order >>>"); 
      countQA = test.quickSort(arrAscend, 0, arrAscend.length-1);
      System.out.println("(Quick Sort) First 20 numbers: ");
      for(int f = 0; f < 20; f++)
         System.out.print(arrAscend[f] + " ");

      System.out.println("\n\n(Quick Sort) Last 20 numbers: "); 
      for(int l = arrAscend.length - 20; l < arrAscend.length; l++)
         System.out.print(arrAscend[l] + " ");
         
      System.out.println("\n\n(Quick Sort) Number of Comparison: "
                              + countQA[0] + " ; Number of Moves: " + countQA[1] + "\n");      

                              
      int countQD [] = new int[2];
      
      System.out.println("With numbers sorted in Descending Order >>>");  
      countQD = test.quickSort(arrDescend, 0, arrDescend.length-1);
      System.out.println("(Quick Sort) First 20 numbers: ");
      for(int f = 0; f < 20; f++)
         System.out.print(arrDescend[f] + " ");

      System.out.println("\n\n(Quick Sort) Last 20 numbers: "); 
      for(int l = arrDescend.length - 20; l < arrDescend.length; l++)
         System.out.print(arrDescend[l] + " ");
         
      System.out.println("\n\n(Quick Sort) Number of Comparison: "
                              + countQD[0] + " ; Number of Moves: " + countQD[1] + "\n");
      System.out.println("---------------------------------------------");                           

      
      //(4) HEAP SORT
      test.initializeArr(arrRandom, arrAscend, arrDescend);
      System.out.println("With random numbers >>>");
      test.heapSort(arrRandom);
      System.out.println("With numbers sorted in Ascending Order >>>");      
      test.heapSort(arrAscend);
      System.out.println("With numbers sorted in Descending Order >>>");      
      test.heapSort(arrDescend);
      System.out.println("---------------------------------------------");

      
      //(5) MERGE SORT
      test.initializeArr(arrRandom, arrAscend, arrDescend);
      int countMR [] = new int[2];
      
      System.out.println("With random numbers >>>");    
      countMR = test.mergeSort(arrRandom, 0, arrRandom.length-1);
      System.out.println("(merge Sort) First 20 numbers: ");
      for(int f = 0; f < 20; f++)
         System.out.print(arrRandom[f] + " ");

      System.out.println("\n\n(Merge Sort) Last 20 numbers: "); 
      for(int l = arrRandom.length - 20; l < arrRandom.length; l++)
         System.out.print(arrRandom[l] + " ");
         
      System.out.println("\n\n(Merge Sort) Number of Comparison: "
                              + countMR[0] + " ; Number of Moves: " + countMR[1] + "\n");


      int countMA [] = new int[2];
      
      System.out.println("With numbers sorted in Ascending Order >>>"); 
      countMA = test.mergeSort(arrAscend, 0, arrAscend.length-1);
      System.out.println("(Merge Sort) First 20 numbers: ");
      for(int f = 0; f < 20; f++)
         System.out.print(arrAscend[f] + " ");

      System.out.println("\n\n(Merge Sort) Last 20 numbers: "); 
      for(int l = arrAscend.length - 20; l < arrAscend.length; l++)
         System.out.print(arrAscend[l] + " ");
         
      System.out.println("\n\n(Merge Sort) Number of Comparison: "
                              + countMA[0] + " ; Number of Moves: " + countMA[1] + "\n");      

                              
      int countMD [] = new int[2];
      
      System.out.println("With numbers sorted in Descending Order >>>");  
      countMD = test.mergeSort(arrDescend, 0, arrDescend.length-1);
      System.out.println("(Merge Sort) First 20 numbers: ");
      for(int f = 0; f < 20; f++)
         System.out.print(arrDescend[f] + " ");

      System.out.println("\n\n(Merge Sort) Last 20 numbers: "); 
      for(int l = arrDescend.length - 20; l < arrDescend.length; l++)
         System.out.print(arrDescend[l] + " ");
         
      System.out.println("\n\n(Merge Sort) Number of Comparison: "
                              + countMD[0] + " ; Number of Moves: " + countMD[1] + "\n");  
      System.out.println("---------------------------------------------");


      //(6) RADIX SORT
      test.initializeArr(arrRandom, arrAscend, arrDescend);
      System.out.println("With random numbers >>>");      
      test.radixSort(arrRandom, 4);
      System.out.println("With numbers sorted in Ascending Order >>>");      
      test.radixSort(arrAscend, 4);
      System.out.println("With numbers sorted in Descending Order >>>");      
      test.radixSort(arrDescend, 4);
      System.out.println("---------------------------------------------");
      
      //(7) SHELL SORT
      test.initializeArr(arrRandom, arrAscend, arrDescend);
      System.out.println("With random numbers >>>");      
      test.shellSort(arrRandom);
      System.out.println("With numbers sorted in Ascending Order >>>");      
      test.shellSort(arrAscend);
      System.out.println("With numbers sorted in Descending Order >>>");      
      test.shellSort(arrDescend); 
                            
   }
}