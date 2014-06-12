//Calvin Kwan
//Project 2 - Set ADT using Single Linked List
//CS240

import java.util.LinkedList;
public class ADT
{
   public Node head;
   public Node tail;
   public Node curNode;
   
    public ADT(String set)
   {
      String [] data= set.split(","); // removes the comma
      for(int i = 0; i < data.length; i++)
      {
         addElement(data[i]);
      }
   }
 
   public boolean contain(String data) // check if the data is contained in the Set
   {
      curNode = head;
      boolean found = false;
      while (curNode != null && !(found))  
      {
         if(curNode.getData().equals(data)) // if the data match, return true
            found = true;
         else
            curNode = curNode.getNext(); //curNode points to the next Node
      }
      return found;
   }

   public boolean remove(String data) //checks if the data is successfully removed
   {
      if (head == null)
         return false;
         
      curNode = head;
      if(curNode.getData().equals(data))
      {
         if(curNode.getNext() == null) //if the head's next pointer is null, set head to null
            head = null;
         else
            head = curNode.getNext(); // head points to the next Node
         return true;
     }
     
      while(curNode.getNext() != null)
      {
         Node dropNode = curNode.getNext(); //temporary Node
         if(curNode.getNext().getData().equals(data))
         {
            curNode.setNext(dropNode.getNext()); 
            return true;
         }
         curNode = curNode.getNext();            
      }
      return false;
   }

   public boolean addElement(String data)
   {
      boolean addData;
      if(this.contain(data)) // checks if the element being added is in the list
      addData = false;
      
      else
      {
         Node newNode = new Node(data, null);  //dummy head
         if(head == null)
         {
            head = newNode;
         }
         else
         {
            tail.setNext(newNode); //have the tail set its next point to the last Node
         }
         tail = newNode;
         addData = true;
      }
      return addData;
   }
   
   public int size() //checks the size of the singly linked list
   {
      int size = 0;
      Node pointer = head;
      while (pointer != null)
      {
         size++;
         pointer = pointer.getNext();
      }
      return size;
   }
   public String traverseList() //displays the data
   {
      String output  = "{";
      Node curNode = head;
      while (curNode != null)  
      {
         output = output + curNode.getData() + ","; 
         curNode = curNode.getNext();
      } 
      if (output.endsWith(","))
      {
         output = output.substring(0, output.length() - 1);
      }
      output = output + "}";
      return output;
   }

   public boolean subsetOf(ADT superSet) //checks if the first Set contains the second Set
   {
   
      if(this.size() == 0)// if size is zero, it is automatically true
         return true;
      else if (this.size() > superSet.size())
         return false;
      else
      {
         Node curANode = this.head;
         while(curANode != null)
         {
            Node curBNode = superSet.head;       
            while(curBNode != null)
            {
               if(!(superSet.contain(curANode.getData())))
                  return false;
               curBNode = curBNode.getNext();
            }
            curANode = curANode.getNext();
         }
      }
      return true;
   }
   
   public boolean isEqual(ADT set) //checks if the first Set is equal to the second Set (Order does not matter)
   {
      if(this.size() == set.size()  && this.size() == 0)
         return true;
      else if (this.size() != set.size())
         return false;
      else
      {
         Node curANode = this.head;
         while(curANode != null)
         {
            Node curBNode = set.head;          
            while(curBNode != null)
            {
               if(!(set.contain(curANode.getData())))
                  return false;
               curBNode = curBNode.getNext();
            }
            curANode = curANode.getNext();
         }
      }
      return true;
   }

   public ADT union(ADT set) //returns all the set data in Set A and Set B without the duplicates
   {
      ADT unionSet = new ADT("");
      unionSet.remove("");
      Node current = this.head;
      while(current != null)
      {
         unionSet.addElement(current.getData());
         current =  current.getNext();
      }
      
      Node curBNode = set.head;          
      while(curBNode != null)      
      {
         Node curANode = this.head;
         while(curANode != null)
         {
            if(!(this.contain(curBNode.getData())))
               unionSet.addElement(curBNode.getData());
            curANode = curANode.getNext();
         }
         curBNode = curBNode.getNext();    
      }
      return unionSet;
   }
      
   public ADT intersection(ADT set) //returns the data in Set A and Set B that share in common 
   {
      ADT intersectionSet = new ADT("");
      intersectionSet.remove("");
      Node curANode = this.head;
      while(curANode != null)
      {
         Node curBNode = set.head;          
         while(curBNode != null)
         {
            if(set.contain(curANode.getData()))
               intersectionSet.addElement(curANode.getData());
            curBNode = curBNode.getNext();
         }
         curANode = curANode.getNext();    
      }
      return intersectionSet;   
   }
   public ADT complement(ADT set) //returns the Set in A, subtract the intersections, and not to include set B data
   {
      ADT complementSet = new ADT("");
      complementSet.remove("");
      ADT intersection = this.intersection(set);
      Node curANode = this.head;
      while(curANode != null)
      {
         Node curBNode = intersection.head;          
         while(curBNode != null)
         {
            if(!(intersection.contain(curANode.getData())))
               complementSet.addElement(curANode.getData());
            curBNode = curBNode.getNext();
         }
         curANode = curANode.getNext();    
      }
      return complementSet;   
   }
}