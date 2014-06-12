// Name: Kwan, Calvin
// Project: #3
// Due: 2/20/2012
// Course: CS-245-01-w12
//
// Description:
//Implement a Rolodex class to display a contact file using tabs. The contact information is stored
//in a file name contacts.txt. Each line consists of the following items:
//Last, First~email~photo.jpg
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
 
public class Rolodex
{
   JLabel imageLabel;
   JTabbedPane tpane;
   int i = 0;
   int numTab;
   ImageIcon icon;
   String temp [] = new String[50];
   String contactName [] = new String[50];
   String contactEmail [] = new String[50];
   String contactPicture [] = new String[50];   
   
   public Rolodex()
   {
      //----------read file-----------------     
      try
      {    
         File contactFile = new File( "contacts.txt" );

         Scanner contactList = new Scanner(contactFile);

         while (contactList.hasNext())
         {
            String storeContactData = contactList.nextLine();
            temp = storeContactData.split("~");
            contactName[i] = temp[0];
            contactEmail[i] = temp[1];
            contactPicture[i] = temp[2];
            i++;
         }
         numTab = i;
         contactList.close();        
      }
      catch(IOException e)
      {
         System.out.println("File was not found");
         System.exit(0);
      }      
//---------Create JFrame      
      JFrame frame = new JFrame("Rolodex");    

      frame.setLayout(new FlowLayout());
      frame.setSize(550, 170);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //creates the menubar part
      JMenuBar menubar = new JMenuBar();
      
//----------------creates the file menu
      JMenu file = new JMenu("File");
      JMenuItem open = new JMenuItem("Open");
      
      //disables open
      open.setEnabled(false);
      file.add(open);
      
      //creates the exit menu
      JMenuItem exit = new JMenuItem("Exit");
      //set Mnemonic for Exit ('x')
      exit.setMnemonic(KeyEvent.VK_X);
      file.addSeparator();
      file.add(exit);
      
      menubar.add(file);
            
//----------------JMenu for Tabs
      JMenu tabs = new JMenu("Tabs");
      //set Mnemonic for Tabs ('T')
      tabs.setMnemonic(KeyEvent.VK_T);
      
      //creates Submenu for placements
      JMenu placement = new JMenu("Placement");
      
      JMenuItem top = new JMenuItem("TOP");
      JMenuItem right = new JMenuItem("RIGHT");
      JMenuItem bot = new JMenuItem("BOTTOM");
      JMenuItem left = new JMenuItem("LEFT");
      placement.add(top);
      placement.add(right);
      placement.add(bot);
      placement.add(left);
      tabs.add(placement);
      tabs.addSeparator();  
      
      //creates Submenu for Layout
      JMenu layout = new JMenu("Layout Policy");
      JMenuItem scroll = new JMenuItem("Scroll");
      JMenuItem wrap = new JMenuItem("Wrap");      
      layout.add(scroll);
      layout.add(wrap);
      tabs.add(layout);
      tabs.addSeparator();    
      
//----------creates Submenu for defaults
      JMenuItem defaults = new JMenuItem("Defaults");
      //setAccelerator for Defaults (Ctrl + D)
      defaults.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
      defaults.setMnemonic('D');
      tabs.add(defaults);  
          
      menubar.add(tabs);
        
//-------JMenu for Help
      JMenu help = new JMenu("Help");
      JMenuItem about = new JMenuItem("About");
      help.add(about);
      
      menubar.add(help);
      
//----------Create Panel
      
      JPanel [] topPanel = new JPanel[numTab];
      for (i=0; i<numTab; i++)
      {
         topPanel[i] = new JPanel(new GridLayout(1,2));
   //---------------left panel      
         JPanel leftPanel = new JPanel(new GridLayout(1,1));
         icon = new ImageIcon(contactPicture[i]);
         imageLabel = new JLabel();
         imageLabel.setIcon(icon);
         imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
         leftPanel.add(imageLabel);
    //-------------right panel  
         JPanel rightPanel = new JPanel();
         
         JLabel name = new JLabel("Name:");
         rightPanel.add(name);
         JTextField t1 = new JTextField(19);
         t1.setText(contactName[i]);
         rightPanel.add(t1);
      
         JLabel email = new JLabel("Email:");      
         rightPanel.add(email);
         JTextField t2 = new JTextField(19);
         t2.setText(contactEmail[i]);
         rightPanel.add(t2);
    //-----------add left and right panels to topPanel    
         topPanel[i].add(leftPanel);
         topPanel[i].add(rightPanel);
      }

//----------Create Tabs
      tpane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
      
      tpane.setPreferredSize(new Dimension(525, 100));
         
      for(i = 0; i<numTab;i++)
      {
         tpane.addTab(contactName[i], topPanel[i]);
      }
//----------ActionListeners for Layout Policy, Placement, Default, About, Exit
  
      //Set Default to Layout Policy "Scroll" and Placement "Top"
      defaults.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent ae)
         {
            tpane.setTabPlacement(JTabbedPane.TOP);
            tpane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT); 
         }
      });
      
      top.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent ae)
         {
            tpane.setTabPlacement(JTabbedPane.TOP);
         }
      });
      
      right.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent ae)
         {
            tpane.setTabPlacement(JTabbedPane.RIGHT);
         }
      });
      
      bot.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent ae)
         {
            tpane.setTabPlacement(JTabbedPane.BOTTOM);
         }
      });
      
      left.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent ae)
         {
            tpane.setTabPlacement(JTabbedPane.LEFT);
         }
      });
      
      scroll.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent ae)
         {
            tpane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT); 
         }
      });
      
      wrap.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent ae)
         {
            tpane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);   
         }
      });
      
      //showMessageDialog appears when Help --> About is clicked
      about.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent ae)
         {
            JOptionPane.showMessageDialog(null, "Rolodex version 0.1 \n(c) 2012 Kwan");         
         }
      });
      
      //exits program
      exit.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent ae)
         {
            System.exit(0);
         }
      });      

      frame.add(tpane);
      frame.setJMenuBar(menubar);
      //start the program at the center of the screen
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String []args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            new Rolodex();
         }
      });
   }
}