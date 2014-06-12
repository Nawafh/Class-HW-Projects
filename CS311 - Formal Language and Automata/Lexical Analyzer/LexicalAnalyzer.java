//Calvin Kwan
//CS 311 - Project 2
// 11/9/10
import java.io.*;
import java.util.Scanner;
public class LexicalAnalyzer
{
   final int T_ERROR = -1;
   final int T_IGNORE = -1;
   final int T_DOUBLE = 0;
   final int T_ELSE = 1;
   final int T_IF= 2;
   final int T_INT = 3;
   final int T_RETURN = 4;
   final int T_VOID = 5;
   final int T_WHILE = 6;
   final int T_PLUS = 7;
   final int T_MINUS = 8;
   final int T_MULTIPLICATION = 9;
   final int T_DIVISION = 10;  
   final int T_LESS = 11;
   final int T_LESSEQUAL = 12;
   final int T_GREATER = 13;
   final int T_GREATEREQUAL = 14;
   final int T_EQUAL = 15;
   final int T_NOTEQUAL = 16;  
   final int T_ASSIGNOP = 17;
   final int T_SEMICOLON = 18;
   final int T_COMMA = 19;
   final int T_PERIOD = 20;   
   final int T_LEFTPAREN = 21;
   final int T_RIGHTPAREN = 22;
   final int T_LEFTBRACKET = 23;
   final int T_RIGHTBRACKET = 24;
   final int T_LEFTBRACE = 25;
   final int T_RIGHTBRACE = 26;   
   final int T_ID = 27;
   final int T_NUM = 28;
   
   boolean eol;
   int lineNumber;
   int position = -1;
   int state;
   int token;
   String lexeme;
   String inLine;
   Scanner inputFile;
   String [] tokenImage = {"DOUBLE", "ELSE", "IF", "INT", "RETURN", "VOID", 
                                          "WHILE", "plus", "minus", "multiplication", "division", 
                                       "less", "lessequal", "greater", "greaterequal", "equal", 
                                       "notequal", "assignop", "semicolon", "comma", 
                                       "period", "leftparen", "rightparen", "leftbracket", 
                                       "rightbracket", "leftbrace", "rightbrace", "id", "num" };
    
   String [] keywords = {"double", "else", "if", "int", "return", "void", "while"};
                                 
   public void read() throws IOException
   {
      int token = -1;
      File inFile = new File("inFile.txt");
      inputFile = new Scanner(inFile);
      while (inputFile.hasNext())
      {
         position = -1;
         inLine = inputFile.nextLine();
         inLine = inLine + "^"; //add end-of-line marker
         eol = false;
         
			while(!eol)
			{
            token = nextToken();
            if (token >= 0)
               printToken(token);  //output token image
			}
         System.out.println();
      }
      inputFile.close();
   }
 
	public char nextChar()
	{
         position++;
			if (position < inLine.length())  //end on line
			{
				return inLine.charAt(position);
			}
			return ('^');
   }

	public int nextToken()
	{
		char c;
		state = 0;
		c = nextChar();
		while (true)//there is a token
		{
			switch (state)
			{
				case 0:	
               if (c=='<')
                  state=1;
					else if (c=='=')
						state=2;
					else if (c=='>')
						state=3;
					else if (c=='!')
						state=4;
					else 
						furthercheck();
               break;
                  
				case 1:	
				{	
					c = nextChar ();
					if (c=='=')
					{
						//tokenValue = "<="
						return T_LESSEQUAL;
					}
					else
               {
                  backone();
                  //tokenValue= "<"  
                   return T_LESS;
               }
				}	
                  
				case 2:	
				{	
					c = nextChar ();
					if (c=='=')
					{
						//tokenValue = "=="
						return T_EQUAL;
					}
					else
               {
                  backone();
                  //tokenValue= "="  
                   return T_ASSIGNOP;
               }
				}	
						
				case 3:	
				{
					c = nextChar ( );	
					if (c=='=')
						{
							//tokenValue= ">="
							return T_GREATEREQUAL;
						}
						else
						{
							backone();
							//tokenValue = ">"  
							return T_GREATER;
						}
				}
						
				case 4:	
				{
					c = nextChar ( );	
					if (c=='=')
						{
							//tokenValue= "!="
							return T_NOTEQUAL;
						}
						else
						{
							backone();
                     return T_ERROR;
						}
				}
            
				case 9:	
               if ((c>='A' && c<='Z')||(c>='a' && c<='z') || c == '_')
               {
						lexeme = "" +c;
						state = 10;
					}
					else 
						furthercheck();
               break;
                  
				case 10: 
				{
					c = nextChar();
					while ((c>='A' && c<='Z')||(c>='a' && c<='z')||(c>='0' && c<='9')||c=='_')
					{
						lexeme = lexeme + c;
						c = nextChar();
					}
               backone();
               for (int j = 0; j<keywords.length; j++)
               {
                  if (lexeme.equals(keywords[j]))
                     return j;
               }
               return T_ID;               
            }
            
				case 12: 
               if (c==';')
					{
						//tokenValue = ";"  
						return T_SEMICOLON;
					}
					else if (c=='.')
					{
						//tokenValue = "."  
						return T_PERIOD;
					}
               else if (c==',')
					{
						//tokenValue = ","  
						return T_COMMA;
					}
					else if (c=='(')
					{
						//tokenValue = "("
						return T_LEFTPAREN;
					}
					else if (c==')')
					{
						//tokenValue = ")"
						return T_RIGHTPAREN;
					}
					else if (c=='{')
               {
                  //tokenValue = "{"
                  return T_LEFTBRACE;
               }
               else if (c=='}')
               {
                  //tokenValue = "}"
                  return T_RIGHTBRACE;
               }
               else if (c=='[')
               {
                  //tokenValue = "["
                  return T_LEFTBRACKET;
               }
               else if (c==']')
               {
                  //tokenValue = "]"
                  return T_RIGHTBRACKET;
               }
               else
						furthercheck();
                  break;
        
				case 21:
					if (c=='+')
					{
						//tokenValue = "+"
						return T_PLUS;
					}
					else if (c=='-')
               {
						//tokenValue = "-"  
						return T_MINUS;
					}
					else if (c=='*')
					{
                  //tokenValue = "*"  
                  return T_MULTIPLICATION;
					}
					else if (c=='/')
					{
                  c = nextChar ();
                  if (c=='/')
                  {
                     //tokenValue = "//"
                     eol = true;
                     return T_IGNORE;
                  }
                  else if (c=='*')
                  {
                     //tokenValue= "/*"
                     eol = true;                     
                     return T_IGNORE;
                  }
                  else
                  {
                     backone();
                     //tokenValue= "/"  
                     return T_DIVISION;
                  }
               }
					else
						furthercheck();
					break;
               
				case 26:
					if (c>='0' && c<='9')
					{
						lexeme = "" + c;
						state = 27;
					}
					else 
						furthercheck();
					break;
               
				case 27:
				{
					c = nextChar();
					while ((c>='0' && c<='9')||c=='.')
					{
						lexeme = lexeme + c;
						c = nextChar();
					}
					backone();
					return T_NUM;
				}
            
				case 29:   // check end-of-line marker or  a whitespace
					if(c=='^')
               {
						eol = true;
                  return T_IGNORE;
               }
               else if (c==' ')
               {
                  state = 30;
                }
					break;
					
				case 30:  // eliminate whitespaces
				{
					c = nextChar();
					while (c==' ')
						c = nextChar();
					state = 0;
					break;
				}	
			}
		}
	}

	public void furthercheck()
	{
		switch (state)
		{
         case 0: state=9; break;
         case 9: state=12; break;
         case 12: state=21; break;
         case 21: state=26; break;
         case 26: state=29; break;
		}
	}
   
	public void backone()
	{
		position--;
	}

	public void printToken(int index)
	{
		System.out.print(tokenImage[index]+" ");
	}
}