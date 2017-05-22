package ch09.hw;
import java.util.*;
import java.math.*;
import ch09.priorityQueues.*;

//Use the SortedABPriQ class to help solve the following problem. 
//Create an application Random10K that generates 100 numbers between 1 and 10,000, 
//stores them in a priority queue (you can wrap them in an Integer object), and then 
//prints them out in columns 10 integers wide in
//1) decreasing order
//2) increasing order
//3) ordered increasingly by the sum of the digits in the number.

public class Random10K {

	final static int RANDOMNUMS = 100;
	
	public static void main(String[] args) 
	{
		SortedABPriQ <Integer> decreasingHeap;
		SortedABPriQ <Integer> increasingHeap;
		SortedABPriQ <Integer> sumHeap;
		Comparator <Integer> increaseComp;
		Comparator <Integer> sumComp;
		

		increaseComp = new Comparator<Integer>()
	    {
	       public int compare(Integer element1, Integer element2)
	       {
	         return ((Comparable)element2).compareTo(element1);
	       }
	    };
	    
		sumComp = new Comparator<Integer>()
	    {
	       public int compare(Integer element1, Integer element2)
	       {
	    	 int sum1 = 0, sum2 = 0;
	    	 int val1 = element1, val2 = element2;
	    	 while (val1 > 0)
	    	 {
	    		 sum1 += val1 % 10;
	    		 val1 = val1 / 10; 
	    	 }
	    	 while (val2 > 0)
	    	 {
	    		 sum2 += val2 % 10;
	    		 val2 = val2 / 10; 
	    	 }

	         return ((Comparable)sum1).compareTo(sum2);
	       }
	    };

		//Create 3 heaps
		decreasingHeap = new SortedABPriQ<Integer>();
		increasingHeap = new SortedABPriQ<Integer>(increaseComp);
		sumHeap = new SortedABPriQ<Integer>(sumComp);
		
		
		//Create loop to fill the heaps
		Random myRando = new Random();
		int randNum, counter;
		

		for (int i = 0; i < RANDOMNUMS ; i++)
		{
			randNum = myRando.nextInt(999) + 1;
			decreasingHeap.enqueue(randNum);
			increasingHeap.enqueue(randNum);
			sumHeap.enqueue(randNum);
		}
		
		System.out.println("Decreasing queue");
		counter = 1;
		while (!decreasingHeap.isEmpty())
		{
			System.out.print(decreasingHeap.dequeue() + "\t");
			if ((counter % 10) == 0 )
				System.out.println("");
			counter++;
		}
		
		System.out.println("\nIncreasing queue");
		counter = 1;

		while (!increasingHeap.isEmpty())
		{
			System.out.print(increasingHeap.dequeue() + "\t");
			if ((counter % 10) == 0 )
				System.out.println("");
			counter++;

		}

		System.out.println("\nSum queue");
		counter = 1;

		while (!sumHeap.isEmpty())
		{
			System.out.print(sumHeap.dequeue() + "\t");
			if ((counter % 10) == 0 )
				System.out.println("");
			counter++;

		}

		
	}

	

}
