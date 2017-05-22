package ch04.hw;

import java.util.Random;

//*********************************************
//Problem #46
//*********************************************
//	Create an application that instantiates a 20 × 20 two-dimensional
//	array of integers, populates it with random integers drawn
//	from the range 1 to 100, and then outputs the index of the row with
//	the highest sum among all the rows. To support your solution, create
//	a class from which you can instantiate Runnable objects, each
//	of which will sum one row of the two-dimensional array and then
//	place the sum of that row into the appropriate slot of a one-dimensional,
//	20-element array. To summarize, your application will:
//	1. Generate the two-dimensional array of random integers.
//  2. Start 20 concurrent threads, each of which places the sum of
//	   one row of the two-dimensional array into the corresponding
//	   slot of a one-dimensional array.
//	3. Output the index of the row with the maximum value.

public class ArraySumMachine {

	public static void main(String[] args) 
	{
		System.out.println("Welcome to the random array sum application");

		//Create a new 20 x 20 array with random numbers from 1 to 100
		int ARRAYDIM = 20;
		int MAXINT = 100;
		
		JeffNumbers sumMachine = new JeffNumbers(ARRAYDIM,ARRAYDIM,MAXINT);
		int sumArray[] = new int[ARRAYDIM];
		Thread myThreads[] = new Thread[ARRAYDIM];
		JeffNumberSum mySummarizer[] = new JeffNumberSum[ARRAYDIM];
		
		for (int i = 0; i<ARRAYDIM; i++)
		{
			mySummarizer[i] = new JeffNumberSum(sumMachine, i);
			myThreads[i] = new Thread(mySummarizer[i]);
			myThreads[i].start();
		}
		
		for (int i = 0; i<ARRAYDIM; i++)
		{
			try
			{
				myThreads[i].join(); 
			}
			catch (Exception e)
			{
				//do nothing
			}
			System.out.println("Sum = " + sumMachine.getSum(i) + " vs Sum = " + sumMachine.sumArray(i));
		}
		
	
	


	}

}
