package ch04.hw;

public class JeffNumberSum implements Runnable 
{

	private int myArrayNum; 
	private JeffNumbers myJeffNumber;
	public JeffNumberSum(JeffNumbers jeffnums, int arrayNum)
	{
		myArrayNum = arrayNum;
		myJeffNumber = jeffnums;
	}
	
	public void run()
	{
		myJeffNumber.setSum((myJeffNumber.sumArray(myArrayNum)),myArrayNum);
	}
}
