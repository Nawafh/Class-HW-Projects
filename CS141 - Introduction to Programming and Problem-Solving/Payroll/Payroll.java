public class Payroll
{
   private String employee_name;
   private int id_number;
   private double payRate;
   private double hoursWorked;
   
   public Payroll()
   {
      employee_name = "";
      id_number = 0;
      payRate = 0.0;
      hoursWorked = 0.0;
   }
   public Payroll(String em, int id, double pr, double hrsw)
   {
      employee_name = em;
      id_number =  id;
      payRate = pr;
      hoursWorked = hrsw;
   }
   
   public void setName(String em) throws InvalidNameException
   {
      if (em == null || em == " ")
         throw new InvalidNameException(em);
      employee_name = em;
   }
   public void setID(int id) throws InvalidIDException
   {
      if (id <= 0)
         throw new InvalidIDException(id);
      id_number = id; 
   }
   public void setPayRate(double pr) throws InvalidHourlyRateException
   {
      if (pr < 0 || pr > 25)
         throw new InvalidHourlyRateException(pr);
      payRate = pr;
   }
   public void setHoursWorked(double hrsw) throws InvalidHoursException
   {
      if (hrsw < 0 || hrsw > 84)
         throw new InvalidHoursException(hrsw);
      hoursWorked = hrsw;
   }
   public String getName()
   {
      return employee_name;
   }
   public int getID()
   {
      return id_number;
   }
   public double getPayRate()
   {
      return payRate;
   }
   public double getHoursWorked()
   {
      return hoursWorked;
   }
   public double getGrossPay()
   {
      return (payRate * hoursWorked);
   }
   public String toString()
   {
      return "Employee Payroll Data:\n " +
                  "Name: " + employee_name +
                  "\nId: " + id_number +
                  "\nPay rate: " + payRate +
                  "\nHours worked: " + hoursWorked +
                  "\nGross pay: " +  payRate * hoursWorked;
   }
}