package ch04.hw;

import java.util.Random;

//*********************************************
//Problem #45
//*********************************************	
//	Create a PrintChar class that implements Runnable. The
//	constructor should accept a character and an integer as parameters.
//	The run method should print the character the number of times indicated
//	by the integer. Create an application that instantiates two
//	PrintChar objects, one passed “A” and 200 and one passed “B”
//	and 200. It then instantiates and starts two thread objects, one for
//	each of the two PrintChar objects. Experiment with the resulting
//	system, using different numerical parameters for the PrintChar
//	objects. Create a report about the results of your experimentation.

public class PrintChar implements Runnable {

	private char printChar;
	private int printNum;
	
	public PrintChar (char myChar, int myNum)
	{
		printChar = myChar;
		printNum = myNum;
	}
	
	public void run()
	{
		//int abc;
		//Random xyz = new Random();
		for (int i=1; i<=printNum;i++)
		{
			if (i % 20 == 0)
				System.out.println(this.printChar);
			else 
				System.out.print(this.printChar);
			//if (printChar == 'A')
			//{
			//	abc = xyz.nextInt(1);
			//}
				
		}
	}
}
