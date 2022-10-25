public class BankChecker{
	public static void main(String[] args)
	{
		SavingAccount jeanne = new SavingAccount("094521371","Kerr",4000,0.5);
		SavingAccount kerr = new SavingAccount("099581050","Jeanne",2000,0.5);
		CheckingAccount kuu = new CheckingAccount("789","Bil",4000,1500,300);

		jeanne.deposit(500);
		kerr.deposit(500);
		System.out.println(jeanne);
		System.out.println(kerr + "\n");

		jeanne.withdraw(1000);
		kerr.withdraw(1000);
		System.out.println(jeanne);
		System.out.println(kerr + "\n");

		jeanne.fundtransfer(jeanne, kerr, 500);
		System.out.println(jeanne + "\n");

		System.out.println(kerr + "\n");
		System.out.println(kuu);
	}
}