public class BankAccount{
	private String accNum;
	private String accName;
	private double balance;

	//constructors
	public BankAccount(){}

	public BankAccount(String accNum, String accName, double balance)
	{
		this.accNum = accNum; 
		this.accName = accName;//setters
		this.balance = balance;
	}

	///getters
	public String getAccnum()
	{
		return accNum;
	}
	public String getAccname()
	{
		return accName;
	}
	public double getBalance()
	{
		return balance;
	}

	public double deposit(double amount)
	{
		if(amount > 0)
		{
			balance += amount;
		}
		return balance;
	}
	public double negadeposit(double amount)
	{
		if(amount < 0){
			balance +=amount;
			}
			return balance;
		}
	boolean withdraw(double amount)
	{
		boolean temp = false;
		if(balance >= amount)
		{
			temp = true;
			balance -= amount;
		}
		return temp;
	}
	void fundtransfer(BankAccount obj1,BankAccount obj2, double amount)
	{
		if(obj1.balance > amount)
		{
			obj2.balance += amount;
			obj1.balance -= amount;
		}
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("Account Name: " +accName+"\nAccount Number: "+accNum+"\nBalance: "+balance);
		return sb.toString();
	}

	public static void main(String [] args)
	{
		BankAccount bank = new BankAccount("0995810","Jeanne",14314);
		bank.toString();
		bank.withdraw(2500);
		System.out.println(bank + "\n");
		BankAccount bank2 = new BankAccount("094521371","Kerr",0);
		bank.fundtransfer(bank,bank2,700);
		bank2.toString();
		System.out.println(bank + "\n");
		System.out.println(bank2 + "\n");
	}
}