public class InvalidNameException extends Exception
{
   public InvalidNameException()
   {
      super("Error -  invalid name entry: ");
   }
   public InvalidNameException(String em)
   {
      super("Error - nvalid name entry: " + em);
   }
}