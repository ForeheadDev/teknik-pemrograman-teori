package bankPackage;

public class SavingsAccount extends Account{
	
	private int interest; // in percentage
	
	public SavingsAccount(int a) {
		super(a);
		this.interest = 0;
	}
	
	public SavingsAccount(int a, int b) {
		super(a);
		this.interest = b;
	}

	public void AddInterest()
	{
		if(getBalance() != 0)
		{
			if(getBalance() > 0)
				deposit(getBalance() * (getInterest() / 100.0));
			else if(getBalance() < 0)
				deposit((getBalance() * -1) * (getInterest() / 100.0));
		}
	}
	
	public double getInterest()
	{
		return this.interest;
	}
	
}
