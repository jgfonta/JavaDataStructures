package ch02.hw;


//Suppose a class named Tracker1 implements the NumTrackerInterface. 
//A simple sample application that uses Tracker1 is shown here. 
//Its output would be “3 29 9.67.”
//public class Sample{   
//public static void main (String[] args)   
//{      
//  NumTrackerInterface nt = new Tracker1();      
//  nt.add(5); nt.add(15); nt.add(9);      
//  System.out.print(nt.getCount() + " ");      
//  System.out.print(nt.getSum() + " ");     
//  System.out.println(nt.getAverage());   
//}
//}

//Create a class called Tracker1 that implements the NumTrackerInterface. 
//This class should use three instance variables, count, sum, and average, 
//to hold information. The getters should simply return the information when 
//requested. Create a test driver application that demonstrates that the 
//Tracker1 class works correctly.

public class Tracker1 implements NumTrackerInterface {

	int count, sum;
	double average;
	
	public Tracker1()
	{
		count = 0;
		sum = 0;
		average = 0;
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
		average = (double) sum / (double) count;
		return (average);
	}

}
