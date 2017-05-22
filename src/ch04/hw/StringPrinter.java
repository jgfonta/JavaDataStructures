package ch04.hw;


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

public class StringPrinter {

	
	public static void main(String[] args) 
	{
		PrintChar charPrint1, charPrint2;
		Thread printer1, printer2;
		
		charPrint1 = new PrintChar('A',200);
		charPrint2 = new PrintChar('B',200);
		printer1 = new Thread(charPrint1);
		printer2 = new Thread(charPrint2);
		
		//Kick off the thread's run method
		printer1.start();
		printer2.start();
		
	}

}
