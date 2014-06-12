//calvin kwan 
//cs141, section 1
//project 2 - parkingticket simulator
//10/19/10
public class PoliceOfficer
{
	private String name;
	private String badgeNumber;
	
	public PoliceOfficer (String n, String bn)
	{
		name = n;
		badgeNumber = bn;
	}
	public PoliceOfficer (PoliceOfficer officer2)
	{
		name = officer2.name;
		badgeNumber = officer2.badgeNumber;
	}
   public void setName(String n)
   {
      name = n;
   }
   public void setBadgeNumber(String bn)
   {
      badgeNumber = bn;
   }
   public String getName()
   { 
      return name;
   }
   public String getBadgeNumber()
   {
      return badgeNumber;
   }
	public ParkingTicket patrol (ParkedCar car, ParkingMeter meter)
	{
		int minutes = car.getMinutesParked() - meter.getMinutesPurchased();
		if (car.getMinutesParked() > meter.getMinutesPurchased())
			return new ParkingTicket (car, this, minutes);
		else
			return null;
	}
	public String toSting()
	{
		return "\nName:" + name + "\nBadgeNumber" + badgeNumber;
	}
}
