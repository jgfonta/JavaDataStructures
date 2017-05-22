package ch02.hw;

//For this problem you must define a simple interface NumTrackerInterface and 
//two implementations of the interface, Tracker1 and Tracker2.

//Define a Java interface named NumTrackerInterface. A class that implements 
//this interface must keep track of both the sum and the count of numbers that 
//are submitted to it through its add method, and provide getters for the sum, 
//the count, and the average of those numbers. The add method should accept an 
//argument of type int, the getSum and getCount methods should both return values
// of type int, and the getAverage method should return a value of type double. 
//
//Suppose a class named Tracker1 implements the NumTrackerInterface. 
//A simple sample application that uses Tracker1 is shown here. 
//Its output would be “3 29 9.67.”
//  public class Sample{   
//  public static void main (String[] args)   
//  {      
//    NumTrackerInterface nt = new Tracker1();      
//    nt.add(5); nt.add(15); nt.add(9);      
//    System.out.print(nt.getCount() + " ");      
//    System.out.print(nt.getSum() + " ");     
//    System.out.println(nt.getAverage());   
//  }
//}
public interface NumTrackerInterface {
	
	void add(int number);
	//Add the number to the total
	int getCount();
	//Return the total numbers added 
	int getSum();
	//Return the sum
	double getAverage();
	//Return the average numbers added together
}
