//calvin kwan 
//cs141, section 1
//project 2 - parkingticket simulator
//10/19/10
public class ParkingTicketTest
{
	public static void main(String[]args)
	{
		System.out.println("... set minutes purchased to 60 and parked for 125 minutes");
		System.out.println("parked for 125 minutes");
		
		ParkedCar car = new ParkedCar ("Volkswagon", "2002", "Red", "3RHZ147", 125);
		
		ParkingMeter meter = new ParkingMeter (60);
		
		PoliceOfficer officer = new PoliceOfficer ("Joe Friday", "4788");
		
		ParkingTicket ticket = officer.patrol (car, meter);
		
		if (ticket != null)
			System.out.println(ticket);
		else 
			System.out.println("No crimes committed!");
	
		System.out.println("... set minutes purchased to 60 and parked for 60 minutes");
		System.out.println("parked for 125 minutes");
		
		ParkedCar car2 = new ParkedCar ("Volkswagon", "2002", "Red", "3RHZ147", 60);
		
		ParkingMeter meter2 = new ParkingMeter (60);
		
		PoliceOfficer officer2 = new PoliceOfficer ("Joe Friday", "4788");
		
		ParkingTicket ticket2 = officer.patrol (car2, meter2);
		
		if (ticket != null)
			System.out.println(ticket2);
		else 
			System.out.println("No crimes committed!");
	
	
		System.out.println("... set minutes purchased to 60 and parked for 61 minutes");
		System.out.println("parked for 125 minutes");
		
		ParkedCar car3 = new ParkedCar ("Volkswagon", "2002", "Red", "3RHZ147", 61);
		
		ParkingMeter meter3 = new ParkingMeter (60);
		
		PoliceOfficer officer3 = new PoliceOfficer ("Joe Friday", "4788");
		
		ParkingTicket ticket3 = officer.patrol (car3, meter3);
		
		if (ticket != null)
			System.out.println(ticket3);
		else 
			System.out.println("No crimes committed!");
	
		System.out.println("... change car model to 2010...");
		
		ParkedCar car4 = new ParkedCar ("Volkswagon", "2010", "Red", "3RHZ147", 61);
		
		ParkingMeter meter4 = new ParkingMeter (60);
		
		PoliceOfficer officer4 = new PoliceOfficer ("Joe Friday", "4788");
		
		ParkingTicket ticket4 = officer.patrol (car4, meter4);
		
		if (ticket != null)
			System.out.println(ticket4);
		else 
			System.out.println("No crimes committed!");
			
		System.out.println("... set minutes purchased to 70...");
		System.out.println("parked for 125 minutes");
		
		ParkedCar car5= new ParkedCar ("Volkswagon", "2010", "Red", "3RHZ147", 61);
		
		ParkingMeter meter5 = new ParkingMeter (70);
		
		PoliceOfficer officer5 = new PoliceOfficer ("Joe Friday", "4788");
		
		ParkingTicket ticket5 = officer.patrol (car5, meter5);
		
		if (ticket != null)
			System.out.println(ticket5);
		else 
			System.out.println("No crimes committed!");
	}
}