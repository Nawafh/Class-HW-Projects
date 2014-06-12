//calvin kwan 
//cs141, section 1
//project 2 - parkingticket simulator
//10/19/10
public class ParkingMeter
{
	private int minutesPurchased;
	
	public ParkingMeter(int mp)
	{
		minutesPurchased= mp;
	}
   public void setMinutesPurchased(int mp)
   {
      minutesPurchased = mp;
   }
   public int getMinutesPurchased()
   {
      return minutesPurchased;
   }
	public String toString()
	{
		return "minutes: " + minutesPurchased;
	}
}

