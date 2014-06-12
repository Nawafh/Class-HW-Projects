/**
Calvin Kwan
CS240
Project 3 - Stack Application
*/	

public class Conversion
{	
   private Stack postfixStack;
   private Stack prefixStack;
   private Stack outStack;
   private String input;
   private String outPostfix = "";
   private String outPrefix = "";

  public Conversion(String in) 
  {
     input = in;
     int stackSize = input.length();
     postfixStack = new Stack(stackSize);
     prefixStack = new Stack(stackSize);
     outStack = new Stack(stackSize);
  }

   public boolean chkInput(String input) //checks for missing operand and operator
   {
      boolean validity;   
      int sum = 0;
      int value;
      
      for(int i = input.length() - 1; i >= 0; i--)
      {
         char ch = input.charAt(i);
         switch(ch)
         {
            case ')':
            case '(':
            case ' ':
            {
               value = 0;
               break;
            }
            case '+': 
            case '-': 
            case '*':
            case '/':
            case '%':
            {
               value = 1;
               break;
            }
            default:
            {
               value = -1;
               break;
            }
         }
         sum = sum + value;
      }
      
      if (sum != -1)
      {
         if(sum < -1)
            System.out.println("missing operator(s)");
         else   
            System.out.println("missing operand(s)");
         validity = false;
      }
      else
         validity = true;
         
      return validity;
   }
            
   public String toPostfix() 
   {
      for (int j = 0; j < input.length(); j++) 
      {
         char ch = input.charAt(j);
         
         switch (ch) 
         {
            case '+': 
            case '-':
            case '*':
            case '/':
            case '%':
            {
               while(!postfixStack.isEmpty() && priority(postfixStack.peek()) >= priority(ch))
               {
                  outPostfix = outPostfix + postfixStack.pop() + ' ';
               }
               postfixStack.push(ch);  //push operator to postfix stack
               break;
            }            
            case '(': // it's a left paren
               postfixStack.push(ch); // push it
               break;
            case ')': // it's a right paren
            {
               char chk = ' ';
                  while (!postfixStack.isEmpty()) 
                  {
                     chk = postfixStack.pop();
                        if (chk == '(') 
                           break; 
                           
                        else
                        outPostfix = outPostfix + chk + ' '; 
                  }
                  if(chk != '(') // check for missing left paren
                  {
                     outPostfix = "?";
                     return outPostfix;
                  }
            }
            case ' ':
               break;
            default: // must be an operand
               outPostfix = outPostfix + ch + ' '; // write it to outPostfix
               break;
         }
      }
      
      if(!outPostfix.equals( "?"))
      {
         while (!postfixStack.isEmpty()) 
         {
            if (postfixStack.peek() == '(') //check for missing right paren
            {
               outPostfix = "?";
               break;
            }
            outPostfix = outPostfix + postfixStack.pop() + ' ';
         }
      }
      return outPostfix; // return postfix
   }
 
   public String toPrefix()
   {
      for(int i = input.length() - 1; i >= 0; i--)
      {
         char ch = input.charAt(i);
         switch(ch)
         {
            case ')':
               prefixStack.push(ch);
               break;
            case '(':
            {
               char chk = ' ';
               while (!prefixStack.isEmpty()) 
               {
                  chk = prefixStack.pop();
                     if (chk == ')') 
                        break; 
                        
                     else
                     outStack.push(chk);
               }
               if(chk != ')') // check for missing right paren
               {
                  outPrefix = "?";
                  return outPrefix;
               }
            }
            case ' ':
               break;
            case '+': 
            case '-': 
            case '*':
            case '/':
            case '%':
            {
               while(!prefixStack.isEmpty() && priority(prefixStack.peek()) > priority(ch))
               {
                  outStack.push(prefixStack.pop());   //prefixStack.pop();
               }
               prefixStack.push(ch);  //push operator to prefix stack
               break;
            }
            default:
            {
               outStack.push(ch);  //push operand to outPrefix stack
               break;
            }
         }
      }

  if(!outPrefix.equals("?"))
  {
      while(!prefixStack.isEmpty())
      {
         if(prefixStack.peek() == ')') // checking missing paren
         {
            outPrefix = "?";
            return outPrefix;
         }
         outStack.push(prefixStack.pop());         
      }
   }  
      while(!outStack.isEmpty())
      {
         outPrefix =  outPrefix + outStack.pop() + ' ' ; 
      }
   return outPrefix;
   }
  
   int priority(char op)
   {

      int prec;
      switch (op)
      {
         case '+' :
         case '-' :
            prec = 1;
            break;
         case '*' :
         case '/' :
         case '%':
            prec = 2;
            break;
         default:
            prec = 0;
            break;
      }

   return prec;
   }
}