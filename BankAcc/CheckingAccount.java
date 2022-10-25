public class CheckingAccount extends BankAccount{
	private double minimumBal;
	private double chargeS;

	//constructors
	public CheckingAccount(){}

	public CheckingAccount(String accNum,String accName,double balance,double minimum, double charge)
	{
		super(accNum,accName,balance);
		minimumBal = minimum;
		chargeS = charge;
	}

	//setters
	public void setMinimum(double minimum)
	{
		minimumBal = minimum;
	}
	public void setCharge(double charge)
	{
		chargeS = charge;
	}

	//getters
	public double getMinimum()
	{
		return minimumBal;
	}
	public double getCharge()
	{
			return chargeS;
	}

	public void cashCheck(String payee,double amount)
	{
		double balancetemp =0;
		balancetemp -= amount;
		if(balancetemp<minimumBal)
		{
			balancetemp -= chargeS;
		}
		negadeposit(balancetemp);
	}

	public String toString()
	{
			StringBuffer sb = new StringBuffer();
			sb.append(super.toString());
			sb.append("\nBalance Minimum: "+minimumBal+"\nCharge: "+chargeS);
			return sb.toString();
	}
	public static void main(String [] args)
	{
		CheckingAccount ca= new CheckingAccount("099581050", "Jeanne", 3750, 1250, 300);//300 charge
		ca.cashCheck("Kerr", 2000);
		ca.toString();
		System.out.println(ca);
	}
}