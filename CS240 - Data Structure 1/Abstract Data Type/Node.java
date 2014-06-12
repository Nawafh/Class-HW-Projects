//Calvin Kwan
//CS240

public class Node
{
   private String data;
   private Node next;
   
   public Node()
  {
      next = null;
      data = null;
   }
    public Node(String d,Node n)
   {
        data = d;
        next = n;
   }
   public void setNext(Node n)
  {
      next = n;
   }
    public Node getNext()
   {
      return next;
   }
    public String getData()
   {
      return data;
   }
}