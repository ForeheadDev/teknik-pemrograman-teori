package bankPackage;

public class CurrentAccount extends SavingsAccount{

	private double overdraftLimit;
	
	public CurrentAccount(int a) {
		super(a);
	}
	
	public CurrentAccount(int a, int b)
	{
		super(a, b);
		this.overdraftLimit = 0;
	}
	
	public CurrentAccount(int a, int b, double c)
	{
		super(a, b);
		this.overdraftLimit = c;
	}
	
	public void Withdraw(double b)
	{
		if(getBalance() - b <= getOverdraftLimit() * -1)
			System.out.println("Kamu Gak bisa withdraw lebih dari overdraft limit");
		else
			withdraw(b);  
	}
	
	public boolean isOverdraft()
	{
		return (getBalance() < 0) ? true : false;
	}
	
	public double getOverdraftLimit()
	{
		return this.overdraftLimit;
	}

}
