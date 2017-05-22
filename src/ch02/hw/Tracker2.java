package ch02.hw;

//Create a class called Tracker2 that implements the NumTrackerInterface. 
//This class should use two instance variables, count and sum, to hold information. 
//The average should be calculated only when needed with this approach. 
//Create a test driver application that demonstrates that the Tracker2 class 
//works correctly.

public class Tracker2 implements NumTrackerInterface {

	int count, sum;
	
	public Tracker2()
	{
		count = 0;
		sum = 0;
	}
	
	public void add(int number)
	{
		count++;
		this.sum += number;
	}

	public int getCount()
	{
		return (count);
	}

	public int getSum()
	{
		return (sum);
	}

	public double getAverage()
	{
		return ((double) sum/ (double) count);
	}

}
