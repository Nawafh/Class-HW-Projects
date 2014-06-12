public class InvalidIDException extends Exception
{
   public InvalidIDException()
   {
      super("Error: invalid id value: ");
   }
   public InvalidIDException(int id)
   {
      super("Error: invalid id value: " + id);
   }
}