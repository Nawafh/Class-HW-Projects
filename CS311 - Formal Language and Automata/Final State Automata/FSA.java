//Calvin Kwan
//CS 311 - Project 1
//10/19/2011
import java.util.Scanner;
import java.io.*;

public class FSA
{
   public static void main(String[]args) throws IOException
   {
      read();
   }
   public static void read() throws IOException
   {
      System.out.println("Run which FSA: 1 2 3 4 5");
      Scanner kb = new Scanner(System.in);
      String num = kb.nextLine();
      File myFile = new File ("Part" + num + ".txt");   
      Scanner inputFile = new Scanner(myFile);      
      System.out.println("Finite State Automata #" + num);
      
      String temp; //inputFile String for reading 
      String tester; //the FSA input Strings
      String transition; //the transition table input string     
      int num_states;
      
      temp = inputFile.nextLine();
      num_states = Integer.parseInt(temp);
      final int DEAD_END_STATE = num_states;
      boolean [] isFinalState = new boolean [num_states];
      System.out.println("(1) Number of states: " + num_states);
         
      temp = inputFile.nextLine();
      System.out.println("(2) Final States: " + temp);         
      String [] final_states = temp.split("\\s+");
      for(int i = 0; i < final_states.length; i++)
      {
         isFinalState[Integer.parseInt(final_states[i])] = true;
      }

      temp = inputFile.nextLine();         
      String [] alphabets = temp.split("\\s+");
      System.out.println("(3) Alphabets: " + temp);         
      
      //create 2Dimensional array for transition table
      int stateMap [][] = new int [num_states][alphabets.length];
      int curState;
      int newState;
      int symCode;
      boolean transition_end = false;

      System.out.println("(4) Transitions: ");
      while (inputFile.hasNext() && !(transition_end))
      {
         transition = inputFile.nextLine();
         if (transition.charAt(0) == '#') //# to determine end of TTable
         {
            transition_end = true;
         }
         else
         {
            System.out.println(transition);         
            curState = Integer.parseInt(transition.substring(1,2)); //gets the after number "("
            symCode = getMask(transition.charAt(3), alphabets);
            newState = Integer.parseInt(transition.substring(5,6)); //gets the number before the ")"
            if (symCode != -1)
            {
               stateMap[curState][symCode] = newState;
            }
         }
      }
      
      System.out.println("\n(5) Strings:");  
      while (inputFile.hasNext())
      {          
         tester = inputFile.nextLine();

         char letter;         
         boolean exit = false;
         int state = 0;         
         int k = 0;
         int code;
         
         while (!(exit))
         {
            if (k == tester.length())
            {
               letter = '^'; 
            }
            else
            {
               letter = tester.charAt(k++);               
            }

            code = getMask(letter, alphabets);
            if(code != -1)
            {
               state = NextState(state, code, stateMap);
               if (state == DEAD_END_STATE)
               {
                  exit = true;
                  Reject(tester);
               }
            }
            else
            {
               exit = true;
               if(letter != '^')
               {
                  Reject(tester);
               }
               else if (isFinalState[state])
               {
                  Accept(tester);
               }
               else
               {
                  Reject(tester);
               }
            }
         }
      }
      inputFile.close();
   }

   //used to number the alphabet internally and used chartAt 
   //to look for index of the alphabets
   public static int getMask(char symbol, String alphaMap[])
   {
      for (int i = 0; i < alphaMap.length; i++)
      {
         if (alphaMap[i].charAt(0) == symbol)
         {
            return i;
         }
      }
      return -1;
   }

   //store the triple (p,a,q) in a table so that the value returned by this function is NextState
   public static int NextState(int currentState, int inputsymbol, int mapping [][])
   {
      int newState;
      newState = mapping[currentState][inputsymbol];
      return newState;
   }
   
   //print Accepted string
   public static void Accept(String result)
   {
      System.out.println(result + "      Accept");
   }

   //print Rejected string
   public static void Reject(String result)
   {
      System.out.println(result + "      Reject");
   }
}