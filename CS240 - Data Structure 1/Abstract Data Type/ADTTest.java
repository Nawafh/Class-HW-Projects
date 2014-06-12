//Calvin Kwan
//Project 2 - Set ADT using Single Linked List
//CS240

import java.util.*;

public class ADTTest
{
   public static void main(String[] args)
   {
      ADT A = new ADT("1,3,5,7");
      ADT B = new ADT("3,4,5");
      ADT D = new ADT("");
      D.remove("");
      System.out.println("A = " +  A.traverseList());
      System.out.println("B = " +  B.traverseList());
      System.out.println("D = " +  D.traverseList() +"\n");
      
      System.out.println("A.isEqual(B) = " + A.isEqual(B));            
      System.out.println("A.union.(B) = " +  A.union(B).traverseList());
      System.out.println("A.intersection(B) = " +  A.intersection(B).traverseList());
      System.out.println("A.complement(B) = " +  A.complement(B).traverseList());
      
      System.out.println("D.subsetOf(A) = " + D.subsetOf(A));
      System.out.println("D.subsetOf(B) = " + D.subsetOf(B));
      System.out.println("D.subsetOf(A.union(B)) = " + D.subsetOf(A.union(B)));
      System.out.println("D.subsetOf(D) = " + D.subsetOf(D));
      System.out.println("A.subsetOf(B) = " + A.subsetOf(B));
      System.out.println("(A.intersection(B)).subsetOf(A) = " + A.intersection(B).subsetOf(A) + "\n");
      
      ADT E = new ADT("t,x,y,z");
      ADT F = new ADT("r,s,t,u,v,w,x");
      ADT G = new ADT("x,t,z,y");
      

      
      System.out.println("E = " +  E.traverseList());
      System.out.println("F = " +  F.traverseList());
      System.out.println("G = " +  G.traverseList() +"\n");
      
      System.out.println("E.isEqual(G) = " + E.isEqual(G));      
      System.out.println("E.union.(F) = " +  E.union(F).traverseList());
      System.out.println("E.intersection(G) = " +  E.intersection(G).traverseList());
      System.out.println("E.complement(G) = " +  E.complement(G).traverseList());
      System.out.println("E.complement(F) = " +  E.complement(F).traverseList());      
     
      System.out.println("D.subsetOf(E) = " + D.subsetOf(E));
      System.out.println("D.subsetOf(F) = " + D.subsetOf(F));
      System.out.println("D.subsetOf(E.union(F)) = " + D.subsetOf(E.union(F)));
      System.out.println("D.subsetOf(G) = " + D.subsetOf(G));
      System.out.println("E.subsetOf(F) = " + E.subsetOf(F));
      System.out.println("E.subsetOf(G) = " + E.subsetOf(G));
      System.out.println("(E.intersection(F)).subsetOf(E) = " + E.intersection(F).subsetOf(E));
   }
}