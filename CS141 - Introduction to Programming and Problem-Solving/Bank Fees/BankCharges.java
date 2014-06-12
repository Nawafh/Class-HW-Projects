// Calvin Kwan
// CS141, section 01
// Project 1 - Bank Charges
// 10/2/2010
public class BankCharges
{
	private double balance;
	private int numcheck;
	private final double BASE = 10.00;
	private final double LOW_BAL_TH = 0.00;
	private final double LOW = 15.00;
	
	public BankCharges(double bal, int nc)
	{
		balance = bal;
		numcheck = nc;
	}
	public BankCharges()
	{
		balance = 0.00;
	}
	public void setBalance(double bal)
	{
		balance = bal;
	}
	public void setCheck(int nc)
	{
		numcheck = nc;
	}
	public double getBalance()
	{
		if(balance >= 400.00)
			return BASE + LOW_BAL_TH; 
		else
			return BASE + LOW;
	}	
	public double getChecks()
	{
		if(numcheck < 20)
			return .10 * numcheck;
		else if(numcheck >= 20 && numcheck <= 39)
			return .08 * numcheck;
		else if(numcheck >= 40 && numcheck <= 59)
			return .06 * numcheck;
		else
			return .04 * numcheck;
	}
}