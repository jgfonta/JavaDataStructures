package ch02.hw;

import java.text.DecimalFormat;

//For this problem you must define a simple interface NumTrackerInterface and 
//two implementations of the interface, Tracker1 and Tracker2.

//Define a Java interface named NumTrackerInterface. A class that implements 
//this interface must keep track of both the sum and the count of numbers that 
//are submitted to it through its add method, and provide getters for the sum, 
//the count, and the average of those numbers. The add method should accept an 
//argument of type int, the getSum and getCount methods should both return values
//of type int, and the getAverage method should return a value of type double. 
//
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

//Create a class called Tracker2 that implements the NumTrackerInterface. 
//This class should use two instance variables, count and sum, to hold information. 
//The average should be calculated only when needed with this approach. 
//Create a test driver application that demonstrates that the Tracker2 class 
//works correctly.

public class TestTrackers {

	public static void main(String[] args) {
		NumTrackerInterface testTracker1 = new Tracker1();
		NumTrackerInterface testTracker2 = new Tracker2();
		DecimalFormat formatter = new DecimalFormat("#0.00");

		System.out.println("Welcome to number tracker");
		
		System.out.println("\nTesting tracker #1");
		
		testTracker1.add(5); 
		testTracker1.add(15); 
		testTracker1.add(9);      
		System.out.println("5 15 9");
		System.out.print(testTracker1.getCount() + " ");      
		System.out.print(testTracker1.getSum() + " ");     
		System.out.println(formatter.format(testTracker1.getAverage()));  
		
		testTracker1.add(10); 
		testTracker1.add(20); 
		testTracker1.add(30);      
		testTracker1.add(50); 
		testTracker1.add(60); 
		testTracker1.add(70);      
		testTracker1.add(80); 
		testTracker1.add(90); 
		testTracker1.add(100);      
		System.out.println("5 15 9 10 20 30 40 50 60 70 80 90 100");
		System.out.print(testTracker1.getCount() + " ");      
		System.out.print(testTracker1.getSum() + " ");     
		System.out.println(formatter.format(testTracker1.getAverage()));  
		
		System.out.println("\nTesting tracker #2");
		
		testTracker2.add(5); 
		testTracker2.add(15); 
		testTracker2.add(9);      
		System.out.println("5 15 9");
		System.out.print(testTracker2.getCount() + " ");      
		System.out.print(testTracker2.getSum() + " ");     
		System.out.println(formatter.format(testTracker2.getAverage()));  
		
		testTracker2.add(10); 
		testTracker2.add(20); 
		testTracker2.add(30);      
		testTracker2.add(50); 
		testTracker2.add(60); 
		testTracker2.add(70);      
		testTracker2.add(80); 
		testTracker2.add(90); 
		testTracker2.add(100);      
		System.out.println("5 15 9 10 20 30 40 50 60 70 80 90 100");
		System.out.print(testTracker2.getCount() + " ");      
		System.out.print(testTracker2.getSum() + " ");     
		System.out.println(formatter.format(testTracker2.getAverage()));  


	}

}
