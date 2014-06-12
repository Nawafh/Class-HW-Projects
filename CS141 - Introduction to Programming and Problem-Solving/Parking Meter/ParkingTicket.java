//calvin kwan 
//cs141, section 1
//project 2 - parkingticket simulator
//10/19/10
public class ParkingTicket
{
	private ParkedCar car;
	private PoliceOfficer officer;
	private double fine;
	private int minutes;
	public final double BASE_FINE = 25.0;
	public final double HOURLY_FINE = 10.0;
	
	public ParkingTicket (ParkedCar aCar, PoliceOfficer anOfficer, int min)
	{
		car = aCar;
		officer = anOfficer;
		minutes = min;
	}
	public ParkingTicket (ParkingTicket ticket2)
	{
		car = ticket2.car;
		officer = ticket2.officer;
		minutes = ticket2.minutes;
	}
	public void setCar(ParkedCar aCar)
	{
		car = aCar;
	}
	public void setOfficer(PoliceOfficer anOfficer)
	{
		officer = anOfficer;
	}
	public void setMinutes(int min)
	{
		minutes = min;
	}
	public ParkedCar getCar()
	{
		return car;
	}
	public PoliceOfficer getOfficer()
	{
		return officer;
	}
	public int getMinutes()
	{
		return minutes;
	}
	public void calculateFine()
	{
		fine = BASE_FINE;
		minutes = minutes - 60;
		do 
		{
			minutes = minutes - 60;
			fine = fine + HOURLY_FINE;
		} while (minutes > 0);		
	}
	public String toString()
	{
		return "Car Data--\n" + car + "\nOfficer Data--\n" + officer +
					"\nMinutes Illegally Parked-- " + minutes + "\nFine-- " + fine+ "\n";
	}
}
