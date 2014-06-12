public class InvalidHourlyRateException extends Exception
{
   public InvalidHourlyRateException()
   {
      super("Error - Invalid hourly pay rate: ");
   }
   public InvalidHourlyRateException(double pr)
   {
      super("Error - Invalid hourly pay rate: " + pr);
   }
}