package ch04.hw;

import java.util.Random;

import ch04.queues.ArrayUnboundedQueue;

//Using the Queue ADT: For this exercise you should use the
//methods listed in the QueueInterface interface and standard Java
//control operations. Assume all of the queues are able to hold elements
//of type int and have sufficient capacity to fulfill the problem
//specifications.

//1. Assume startQ contains elements of type int and both
//evenQ and oddQ are empty. Devise a section of code that
//moves all of the integers from startQ to the other two queues
//such that when finished, startQ is empty, evenQ contains
//the even integers, and oddQ contains the odd integers.

public class EvenOddQueueBuilder {

	ArrayUnboundedQueue <Integer> evenQ;
	ArrayUnboundedQueue <Integer> oddQ;
	ArrayUnboundedQueue <Integer> startQ;
	
	public EvenOddQueueBuilder ()
	{
		startQ = new ArrayUnboundedQueue<Integer>();
	}
	public static void main(String[] args) 
	{
		EvenOddQueueBuilder mybuilder = new EvenOddQueueBuilder();
		mybuilder.startQ.size();
		Random myRandom = new Random();
		int myvalue = 0;
		for (int i = 0; i < 100;i++)
		{
			mybuilder.startQ.enqueue((int)myRandom.nextInt(Integer.MAX_VALUE));
		}
		
		mybuilder.oddQ = new ArrayUnboundedQueue<Integer>(mybuilder.startQ.size());
		mybuilder.evenQ = new ArrayUnboundedQueue<Integer>(mybuilder.startQ.size());
		
		while (!mybuilder.startQ.isEmpty()) 
		{
			int currentNum;
			
			currentNum = mybuilder.startQ.dequeue();

			if ((currentNum % 2) == 0 )
			{
				mybuilder.evenQ.enqueue(currentNum);
			}
			else
			{
				mybuilder.oddQ.enqueue(currentNum);
			}
		}
		int i = 0;
		while (!mybuilder.oddQ.isEmpty())
		{
			System.out.println("Odd entry[" + i + "] = " 
					+ mybuilder.oddQ.dequeue());
			i++;
		}
		
		System.out.println("***********************************");
		System.out.println("  Odd above , Even after");
		System.out.println("***********************************");
		i = 0;
		while (!mybuilder.evenQ.isEmpty())
		{
			System.out.println("Even entry[" + i + "] = " 
					+ mybuilder.evenQ.dequeue());
			i++;
		}

	}

}
