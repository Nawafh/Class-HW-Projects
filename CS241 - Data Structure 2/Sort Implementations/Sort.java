/*
Calvin Kwan
CS241 - Project 4 Search Algorithms
*/
import java.io.*;
import java.util.Scanner;
import java.text.Format;
import java.util.Formatter;
public class Sort
{
   final int AR_SIZE = 1000;
   int array1 [] = new int[AR_SIZE];
   int array2 [] = new int[AR_SIZE];
   int array3 [] = new int[AR_SIZE];
    
   public void readData (String fileName) throws IOException
   {
      File inFile = new File (fileName);
      Scanner inputFile = new Scanner(inFile);
      String line;
      String []store;
      int i = 0;
      while (inputFile.hasNext())
      {
         line = inputFile.nextLine().trim();
         store = line.split("\\s+");
         for(int r=0; r<store.length; r++)
         {
            if(fileName.equals("numseq1.dat"))
               array1[i++] = Integer.parseInt(store[r]);
            if(fileName.equals("numseq2.dat"))
               array2[i++] = Integer.parseInt(store[r]);
            if(fileName.equals("numseq3.dat"))
               array3[i++] = Integer.parseInt(store[r]);
            //System.out.println(arr[r]);
         }
      }
      inputFile.close();      
   }
   
   public void initializeArr(int [] arrUnS, int [] arrAsc, int [] arrDsc)
   {
      for(int i = 0; i<array1.length; i++)
         arrUnS[i] = array1[i];
      for(int j = 0; j<array2.length; j++)
         arrAsc[j] = array2[j];
      for(int k = 0; k<array3.length; k++)
         arrDsc[k] = array3[k];
       
       //for(int r = 0; r<100; r++)
       //System.out.println(arrUnS[r]);  
   }
   
   public void bubbleSort(int [] a)
   {
      int i, j,t, countC=0, countM=0;
  
      for(i = 0; i < a.length; i++)
      {
         for(j = 1; j < (a.length-i); j++)
         {
            countC++;
            if(a[j-1] > a[j])
            {
               t = a[j-1];               
               a[j-1]=a[j];
               a[j]=t;
               countM = countM + 3;
            }
         }
      }
      System.out.println("(Bubble Sort) First 20 numbers: ");
      for(int f = 0; f < 20; f++)
         System.out.print(a[f] + " ");

      System.out.println("\n\n(Bubble Sort) Last 20 numbers: ");         
      for(int l = a.length - 20; l < a.length; l++)
         System.out.print(a[l] + " ");         
         
      System.out.println("\n\n(Bubble Sort) Number of Comparison: "
                              + countC + " ; Number of Moves: " + countM + "\n");
   }
   
   public void selectionSort(int [] a)
   {
      int countC=0, countM=0;
      for (int i = 0; i < a.length; i++) 
      {
         int min = i;
         int j;
         countM++;
         //Find the smallest element in the unsorted list
         for (j = i + 1; j < a.length; j++) 
         {
            countC++;
            if (a[j] < a[min]) 
            {
               min = j;
               countM++;
            }
         }
     
         //Swap the smallest unsorted element into the end of the sorted list.
         int T = a[min];
         a[min] = a[i];
         a[i] = T;
         countM = countM + 3;
      }
      
      System.out.println("(Selection Sort) First 20 numbers: ");
      for(int f = 0; f < 20; f++)
         System.out.print(a[f] + " ");

      System.out.println("\n\n(Selection Sort) Last 20 numbers: "); 
      for(int l = a.length - 20; l < a.length; l++)
         System.out.print(a[l] + " ");

      System.out.println("\n\n(Selection Sort) Number of Comparison: "
                              + countC + " ; Number of Moves: " + countM + "\n");         
 
   }
   
   public static void heapSort(int a[])
   {
      int i,s,j,elt,v,c=0, countC=0, countM=0;
      int n = a.length;
      for(i=1; i<n; i++)
      {
         elt=a[i];
         s=i;
         j=(s-1)/2;
         countM = countM + 3;
         while(s>0 && a[j]<elt)
         {
            a[s]=a[j];
            s=j;
            j=(s-1)/2;
            countM = countM + 3;
         }
         a[s]=elt;
         c++;
         countM = countM + 2;
      }
  
      for(i=n-1; i>0; i--)
      {
         v=a[i];
         a[i]=a[0];
         j=0;
         countM = countM + 3;
         countC++;
         if(i==1)
         {
            s=-1;
            countM++;
         }
         else
         {
            s=1;
            countM++;
         }
         countC++;
         if(i>2 && a[2]>a[1])
         {
            s=2;
            countM++;
         }
         
         while(s>=0 && v<a[s])
         {
            a[j]=a[s];
            j=s;
            s=2*j+1;
            countM = countM + 3;
            countC = countC + 2;
            if((s+1)<=i-1 && a[s]<a[s+1])
            {
               s=s+1;
               countM++;
            }
            
            countC++;
            if(s>(i-1))
            {
               s=-1;
               countM++;
            }
         }
         a[j]=v;
         countM++;
      }
      
      System.out.println("(Heap Sort) First 20 numbers: ");
      for(int f = 0; f < 20; f++)
         System.out.print(a[f] + " ");

      System.out.println("\n\n(Heap Sort) Last 20 numbers: "); 
      for(int l = a.length - 20; l < a.length; l++)
         System.out.print(a[l] + " ");

      System.out.println("\n\n(Heap Sort) Number of Comparison: "
                              + countC + " ; Number of Moves: " + countM + "\n");      
    
}
  
   public void shellSort(int [] a)
   {
      int countC=0, countM=0;
      int h = 1;
      
      //find the largest h value possible 
      while ((h * 3 + 1) < a.length) 
      {
         countC++;
         h = 3 * h + 1;
         countM++;
      }
      //while h remains larger than 0 
      while( h > 0 ) 
      {
         //for each set of elements (there are h sets)
         for (int i = h - 1; i < a.length; i++) 
         {
            //pick the last element in the set
            int B = a[i];
            int j = i;
            countM = countM + 2;
             /*
            compare the element at B to the one before it in the set
            if they are out of order continue this loop, moving
            elements "back" to make room for B to be inserted.
            */
            for( j = i; (j >= h) && (a[j-h] > B); j -= h) 
            {
               countC = countC + 2;
               a[j] = a[j-h];
               countM++;
            }
            //insert B into the correct place
            a[j] = B;
            countM++;
         }
         //all sets h-sorted, now decrease set size
         h = h / 3;
         countM++;
      }

      System.out.println("(Shell Sort) First 20 numbers: ");
      for(int f = 0; f < 20; f++)
         System.out.print(a[f] + " ");

      System.out.println("\n\n(Shell Sort) Last 20 numbers: "); 
      for(int l = a.length - 20; l < a.length; l++)
         System.out.print(a[l] + " ");
         
      System.out.println("\n\n(Shell Sort) Number of Comparison: "
                              + countC + " ; Number of Moves: " + countM + "\n");
   }
   
   public int [] quickSort(int[]a, int low, int n)
   {
      int countC=0, countM=0;
      int cnt [] = new int[2];
      int lo = low;
      int hi = n - 1;
      countM = countM + 2;
      
      countC++;
      if (lo >= n - 1) 
      {
         return cnt;
      }
      
      int mid = a[(lo + hi) / 2];
      countM++;
      while (lo < hi) 
      {
         while (lo<hi && a[lo] < mid) 
         {
            lo++;
            countM++;
         }
         
         while (lo<hi && a[hi] > mid) 
         {
            hi--;
            countM++;
         }
         
         countC++;
         if (lo < hi) 
         {
            int T = a[lo];
            a[lo] = a[hi];
            a[hi] = T;
            countM = countM + 3;
         }
      }
      
      countC++;
      if (hi < lo) 
      {
         int T = hi;
         hi = lo;
         lo = T;
         countM = countM + 3;
      }
      quickSort(a, low, lo);
      quickSort(a, lo == low ? lo+1 : lo, n);
      cnt[0] = cnt[0] + countC;
      cnt[1] = cnt[1] + countM;
      return cnt;
  }
  
  public int [] mergeSort(int [] a, int lo, int n)
  {
      int cnt [] = new int[2];
      int countC=0, countM=0;
      int low = lo;
      int high = n;
      countM = countM + 2;
      
      countC++;
      if (low >= high) 
      {  
         return cnt;
      }

      int middle = (low + high) / 2;
      countM++;
      
      mergeSort(a, low, middle);
      mergeSort(a, middle + 1, high);
      
      int end_low = middle;
      int start_high = middle + 1;
      countM = countM + 2;
      
      while ((lo <= end_low) && (start_high <= high)) 
      {
         countC++;
         if (a[low] < a[start_high]) 
         {
            low++;
            countM++;
         } 
         else 
         {
            int Temp = a[start_high];
            countM++;
            for (int k = start_high- 1; k >= low; k--) 
            {
               a[k+1] = a[k];
               countM++;
            }
            
            a[low] = Temp;
            low++;
            end_low++;
            start_high++;
            countM = countM + 4;
         }
      }
      cnt[0] = cnt[0] + countC;
      cnt[1] = cnt[1] + countM;
      return cnt;
   }

   public void radixSort(int a[], int m)
   {
      int countC=0, countM=0;
      Node last[]=new Node[10];
      Node bucket[]=new Node[10];
      Node current;
      int i,digit,divisor,d,j,k;
      countM = countM + 2;

      for(digit=1;digit<=m;digit++)
      {
         for( i=0;i<10;i++)
         {
            last[i]=bucket[i]=null;
            countM++;
         }
         
         divisor=1;
         countM++;
         
         for(k=1;k<=digit-1;k++)
         {
            divisor=divisor*10;
            countM++;
         }
            
         for(i=0;i<a.length;i++)
         {
            Node temp=new Node(a[i]);
            d=(a[i]/divisor)%10;
            countM = countM + 2;
            
            countC++;
            if(bucket[d]==null)
            {
               bucket[d]=last[d]=temp;
               countM++;
            }
            else
            {
               last[d].next=temp;
               last[d]=temp;
               countM = countM + 2;
            }
         }
         
         j=0;
         countM++;
         
         for(i=0;i<10;i++)
         {
            current=bucket[i];
            countM++;
            while(current!=null)
            {
               a[j]=current.data;
               j++;
               current=current.next;
               countM = countM + 3;
            }
         }
      }
      System.out.println("(Radix Sort) First 20 numbers: ");
      for(int f = 0; f < 20; f++)
         System.out.print(a[f] + " ");

      System.out.println("\n\n(Radix Sort) Last 20 numbers: "); 
      for(int l = a.length - 20; l < a.length; l++)
         System.out.print(a[l] + " "); 

      System.out.println("\n\n(Radix Sort) Number of Comparison: "
                              + countC + " ; Number of Moves: " + countM + "\n");         
   } 
}