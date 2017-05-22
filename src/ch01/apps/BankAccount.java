package ch01.apps;

public class BankAccount {

	int myAccounts[];

	public BankAccount() 
	{
		//Default to 100 accounts
		myAccounts = new int[100];
	}
	
	public BankAccount(int totalAccounts) 
	{
		myAccounts = new int[totalAccounts];
	}
	
	
	public void deposit(int amount) throws BankAccountException
	{
		this.deposit(1, amount);
	}
	
	public void deposit(int account, int amount) throws BankAccountException
	{
		if (account > myAccounts.length)
			throw new BankAccountException("Unknown account number");
		if (amount < 0 )
			throw new BankAccountException("Cannot deposit a negative amount");
		myAccounts[account] = myAccounts[account] + amount;
	}
	
	public void withdrawl(int amount) throws BankAccountException
	{
		this.withdrawl(1, amount);
	}
	
	public void withdrawl(int account, int amount) throws BankAccountException
	{
		if (account > myAccounts.length)
			throw new BankAccountException("Unknown account number");
		if (amount < 0 )
			throw new BankAccountException("Cannot withdraw a negative amount");
		if ((myAccounts[account] - amount) < 0)
			throw new BankAccountException("Withdrawl exceeds account balance");
		myAccounts[account] = myAccounts[account] - amount;
	}
	
	public int balance(int account) 
	{
		return myAccounts[account];
	}
	
	@Override
	public String toString()
	{
		return ("$" + this.balance(1));
	}
	
	public String toString(int account)
	{
		return ("$" + this.balance(account));
	}
}
