package ch01.apps;

public class BankAccountException extends Exception 
{
	public BankAccountException()
	{
		super();
	}
	
	public BankAccountException(String message)
	{
		super(message);
	}
}
