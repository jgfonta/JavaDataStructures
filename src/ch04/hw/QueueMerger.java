package ch04.hw;
import java.util.Random;

import ch04.queues.*;

//Using the Queue ADT: For this exercise you should use the
//methods listed in the QueueInterface interface and standard Java
//control operations. Assume all of the queues are able to hold elements
//of type int and have sufficient capacity to fulfill the problem
//specifications.

//2. Assume queueA and queueB contain integers and queueC is
//empty. Devise a section of code that will alternately move an
//integer from queueA to queueC and then from queueB to
//queueC until either or both of the source queues are
//empty—if anything is left in a source queue then those integers
//are also copied to queueC. For example, if you start with
//queueA containing 1 2 3 4 and queueB containing 5 6 then
//when the code finishes executing the two source queues are
//empty and queueC contains 1 5 2 6 3 4.


public class QueueMerger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayUnboundedQueue <Integer> queueA;
		ArrayUnboundedQueue <Integer> queueB;
		ArrayUnboundedQueue <Integer> queueC;
		
		Random myRandom = new Random();
		int myvalue = 0;
		queueA = new ArrayUnboundedQueue<Integer>();
		queueB = new ArrayUnboundedQueue<Integer>();
		
		int currentNum;
		for (int i = 0; i < 100;i++)
		{
			currentNum = (int)myRandom.nextInt(Integer.MAX_VALUE);
			if ((currentNum % 2) == 0 )
			{
				queueA.enqueue(currentNum);
			}
			else
			{
				queueB.enqueue(currentNum);
			}
		}
		
		queueC = new ArrayUnboundedQueue<Integer>(queueA.size()+queueB.size());

		boolean mySwitch = false;
		while (!queueA.isEmpty() || !queueB.isEmpty()) 
		{

			if (mySwitch)
			{
				if (!queueA.isEmpty())
					queueC.enqueue(queueA.dequeue());
				mySwitch = false;
			}
			else
			{
				if (!queueB.isEmpty())
					queueC.enqueue(queueB.dequeue());
				mySwitch = true;
			}
		}
		
		int i = 0;
		while (!queueC.isEmpty())
		{
			System.out.println("Merged entry[" + i + "] = " 
					+ queueC.dequeue());
			i++;
		}
	}

}
