//
// Name: Kwan, Calvin
// Project: #1
// Due: 1/20/2012
// Course: CS-245-01-w12
//
// Description:
// Implement a simple stop watch adding:
// 1) center the initlal frame on the screen
// 2) Add a label “(c) 2012 your-name” before the buttons
// 3) Use getWhen() instead of Calendar

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public  class StopWatch implements ActionListener
{
   JLabel jlab, beforebt;
   long start;
   
   StopWatch()
   {
      JFrame jfrm = new JFrame ("A Simple Stopwatch");
      
      jfrm.getContentPane().setLayout(new FlowLayout());
      
      jfrm.setSize(230, 90);
      
      jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      beforebt = new JLabel("(c) 2012 Calvin Kwan");
      jfrm.getContentPane().add(beforebt);
      
      JButton jbtnStart = new JButton("Start");
      JButton jbtnStop = new JButton("Stop");
      
      jbtnStart.addActionListener(this);
      jbtnStop.addActionListener(this);
      
      jfrm.getContentPane().add(jbtnStart);
      jfrm.getContentPane().add(jbtnStop);
      
      jlab = new JLabel("Press Start to begin timing.");
      
      jfrm.getContentPane().add(jlab);
      
      jfrm.setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getActionCommand().equals("Start"))
      {
         start = ae.getWhen();
         jlab.setText("StopWatch is Running...");
      }
      
      else
         jlab.setText("Elapsed time is " + (double)(ae.getWhen() - start)/1000);
   }

   public static void main(String [] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            new StopWatch();
         }
      });
   }
}