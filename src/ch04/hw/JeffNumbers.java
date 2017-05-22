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
//2. Start 20 concurrent threads, each of which places the sum of
//	one row of the two-dimensional array into the corresponding
//	slot of a one-dimensional array.
//	3. Output the index of the row with the maximum value.

public class JeffNumbers 
{

	int myTwoDimArray[][];
	int mySum[];
	
	public JeffNumbers(int dim1,int dim2, int arrayLim)
	{
		myTwoDimArray = new int[dim1][dim2];
		mySum = new int[dim1];
		Random myRando;

		System.out.println("Starting to build the array");
		
		myRando = new Random();
		for (int i = 0; i < dim1; i++)
		{
			mySum[i] = 0;
			for (int j = 0; j < dim2; j++)
			{
				myTwoDimArray[i][j] = myRando.nextInt(arrayLim-1) + 1;
			}
		}
		
		System.out.println("Completed array");		

	}
	
	public void setSum(int sumval, int dim1)
	{

		mySum[dim1] = sumval;
		
	}
	
	public int getSum(int dim1)
	{

		return mySum[dim1];
		
	}
	
	public int sumArray(int dim1)
	{
		int sum = 0;
		for (int i = 0; i < (myTwoDimArray[dim1].length); i++)
		{
			sum += myTwoDimArray[dim1][i];
		}
		return sum;
	}
	
	public String printArray(int dim1)
	{
		String thisLine = "";
		for (int i = 0; i < (myTwoDimArray[dim1].length); i++)
		{
			thisLine += myTwoDimArray[dim1][i] + " ";
		}
		return thisLine;
	}
}
