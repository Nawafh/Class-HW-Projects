// Name: Kwan, Calvin
// Project: #2
// Due: 2/6/2011
// Course: CS-245-01-w12
// Description:
//1. Center the calculator on the screen at startup.
//2. All the operations are in the form:
//(operand1 operator2 operand2 = ) operator2 operand3 =
//3. Ctrl and the “C” key will display “(c) 2012 your-name”
//The “C” key will restore the current display.
//4. The “=” key is the default button.
//5. The result can be negative.
//6. Only allow up to 10 digits.
//7. Display error such as “Overflow”, “Div by 0”, …, and the “C” key will clear the error
//and reset the calculator.
//

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JCalc implements ActionListener 
{
    
   JLabel display;
   int digitCnt = 0;
   double result = 0.0;
   double operand1 = 0.0;
   double operand2 = 0.0;      
   boolean isoperator1filled = false;
   boolean clearDisplay = true;
   char op = '^';
   String operator = "^";   
   JFrame  frame;
   String num = "";

   
   JCalc() 
   {
        // Create a new JFrame container. 
      frame = new JFrame("JCalc");

        // Give the frame an initial size. 
      frame.setLayout(new FlowLayout()); 
      //set frame size  
      frame.setSize(306, 390);       

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JPanel northPanel = new JPanel();

      northPanel.setPreferredSize(new Dimension(300, 180));
      northPanel.setBorder(BorderFactory.createLineBorder(Color.RED,4));
 
      display = new JLabel("0", SwingConstants.RIGHT);
      display.setFont(new Font("Arial", Font.BOLD, 20));
      display.setPreferredSize(new Dimension(290,180));
      northPanel.add(display);
      
      //------------------------------End of Top Panel (Output Display)
      
      JPanel southPanel = new JPanel();
      southPanel.setPreferredSize(new Dimension(300,172));
        String keys[] = {"7", "8", "9", "/",
                              "4", "5", "6",  "*",
                              "1", "2", "3", "-",
                              "0", "C", "=", "+"};
        JButton but[] = new JButton[16];
               
        but[0] = new JButton("7");
        but[1] = new JButton("8");
        but[2] = new JButton("9");
        but[3] = new JButton("/");
        but[4] = new JButton("4");
        but[5] = new JButton("5");
        but[6] = new JButton("6");
        but[7] = new JButton("*");
        but[8] = new JButton("1");
        but[9] = new JButton("2");
        but[10] = new JButton("3");
        but[11] = new JButton("-");
        but[12] = new JButton("0");
        but[13] = new JButton("C");
        but[14] = new JButton("=");
        but[15] = new JButton("+");
        
        southPanel.setLayout(new GridLayout(4, 4));
        for (int i = 0; i < keys.length; i++) 
        {
            but[i].setFont(new Font("Arial", Font.BOLD, 20));
            if (keys[i].charAt(0) == '@') 
            {
                but[i].addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent ae) 
                    {
                        op = '^';
                        digitCnt = 0;
                        display.setText("0");
                    }
                });
            } 
            else
            {            
               but[i].addActionListener(this);
               but[13].setMnemonic('C');
            }

            southPanel.add(but[0]);
            southPanel.add(but[1]);
            southPanel.add(but[2]);
            southPanel.add(but[3]);
            southPanel.add(but[4]);
            southPanel.add(but[5]);
            southPanel.add(but[6]);
            southPanel.add(but[7]);
            southPanel.add(but[8]);
            southPanel.add(but[9]);
            southPanel.add(but[10]);
            southPanel.add(but[11]);
            southPanel.add(but[12]);
            southPanel.add(but[13]);
            southPanel.add(but[14]);
            
            //set "=" as default button
            frame.getRootPane().setDefaultButton(but[14]);                  
            southPanel.add(but[15]);           
        }
      //-------------------------------End of Making the button part 

        frame.add(northPanel);
        frame.add(southPanel);

        //Since Windows  7's Calculator is not resizeable
        //my calculator is not resizeable too        
        frame.setResizable(false);
        
        //Center initlal frame on the screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);     
   }
/* 
   public void keyPressed(KeyEvent ke)
   {
      char key = ae.getActionCommand().charAt(0);
      if(ke.isControlDown() && key == 'C')
      //char key = ke.getKeyChar();
      //String str = Character.toString(key);
      display.setText("(c) 2012 Calvin Kwan");
   }
*/
   public void actionPerformed (ActionEvent ae) 
   {
      char key = ae.getActionCommand().charAt(0);
       
      switch (key) 
      {
         case '9':
         case '8':
         case '7':
         case '6':
         case '5':
         case '4':
         case '3':
         case '2':
         case '1':
         case '0':
         
         num = num + key;
         if(clearDisplay)
         {
            display.setText("");
            clearDisplay = false;
         }
         
         if (digitCnt == 0) 
         {
            if (key != '0') 
            {
               display.setText(ae.getActionCommand());
               digitCnt++;
            }
             else
            {
               display.setText("0");

               num = "" + '0';
            }           
         } 
 //allow up to 10 digits        
         else 
         {
            if (digitCnt < 10) 
            {
               display.setText(display.getText() + ae.getActionCommand());
               digitCnt++;
            }
         }
         break;
         
         case 'C':
            operand1 = 0;
            operand2 = 0;
            digitCnt = 0;
            op = '^';
            num = "";
            isoperator1filled = false;
            display.setText("0");
         break;
         
         case '=':
         if(!num.equals(""))
         {
            operand2 = Double.parseDouble(num);
         }
            
            if (op == '/' && operand2 == 0)
            {
               display.setText("Divide by 0");
                //System.out.println("ERROR");
            }             
               switch (op) 
               {
                  case '/':
                     result = operand1 / operand2;
                     break;
                  case '*':
                     result = operand1 * operand2;
                     break;
                  case '-':
                     result = operand1 - operand2;
                     break;
                  case '+':
                     result = operand1 + operand2;
                     break;
               }
               digitCnt = 0;
               if(result > 9999999999.0)
                  display.setText("Overflow");
               else
                  display.setText(String.format("%.2f", result));              
               break;
         
             
         default: //default is operator     
            clearDisplay = true;
            digitCnt = 0;
            if(!num.equals(""))
            {
               if (!(isoperator1filled))
               {
                  operand1 = Double.parseDouble(num);
                  operand2 = operand1;
                  isoperator1filled = true;
                  op = key;
                  num = "";
               }
               
               else
               {
                     operand2 = Double.parseDouble(num);
                     switch (op) 
                     {
                        case '/':
                           operand1 = operand1 / operand2;
                           break;
                        case '*':
                           operand1 = operand1 * operand2;               
                           break;
                        case '-':
                           operand1 = operand1 - operand2;                 
                           break;
                        case '+':
                           operand1 = operand1 + operand2;                
                           break;
                     }
                     operand2 = operand1;
                     op = key;
                     num = "";
               }
            }
      }
      return;
   }

   public static void main(String args[]) 
   {
      SwingUtilities.invokeLater(new Runnable() 
      {            
         public void run() {                
            new JCalc();                
            }            
      });        
    }    
}

