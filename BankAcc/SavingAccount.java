public class SavingAccount extends BankAccount{
	private  double interestRate;

	//constructors
	public SavingAccount(){}

	public SavingAccount(String accNum, String accName, double balance, double interest)
	{
		super(accNum,accName,balance);
		interestRate = interest;
	}

	public void setInterest(double interest)
	{
		interestRate = interest;//setters
	}

	//getters
	public double getInterest()
	{
		return interestRate;
	}

	public void calculateInterest()
	{
		double interest = getBalance() * interestRate / 100.0;
		deposit(interest);
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("\nInterest: " + interestRate);
		return sb.toString();
	}

	public static void main(String[] args)
	{
		SavingAccount kerr = new SavingAccount("09452137124","Kerr", 6000, 0.5);
		kerr.calculateInterest();
		kerr.toString();
		System.out.println(kerr);
	}
}
