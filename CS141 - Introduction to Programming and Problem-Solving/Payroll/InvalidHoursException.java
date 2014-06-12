public class InvalidHoursException extends Exception
{
   public InvalidHoursException() 
   {
      super("Error - Invalid number of hours: ");
   }
   public InvalidHoursException(double hrsw) 
   {
      super("Error - Invalid number of hours: " + hrsw);
   }
}