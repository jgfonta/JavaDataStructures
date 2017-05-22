//---------------------------------------------------------------------
// Simulation.java           by Dale/Joyce/Weems              Chapter 4
//
// Models a sequence of customers being serviced
// by a number of queues.
//---------------------------------------------------------------------
package ch04.hw;

import support.*;       // Customer, CustomerGenerator
import ch04.queues.*;   // LinkedGlassQueue

//*********************************************
//Problem #42
//*********************************************
//	Revise the Average Waiting Time program to do the following:
//	Also output the largest number of customers who were on a
//	queue at the same time.
//
//	1.  Also output the percentage of the time at least one server was
//	“idle.”
//	
//	2.	Choose the queue for a customer to enter based on shortest
//	finish time, rather than shortest size. The user should have
//	the ability to choose which approach to use for any simulation
//	run.
	

public class AverageWaitTimes 
{
  final int MAXTIME = Integer.MAX_VALUE; 
                               
  CustomerGenerator custGen;   // a customer generator
  float avgWaitTime = 0.0f;    // average wait time for most recent simulation
  float avgIdleTime = 0.0f;    

  public AverageWaitTimes(int minIAT, int maxIAT, int minST, int maxST)
  {
    custGen = new CustomerGenerator(minIAT, maxIAT, minST, maxST);
  }
  
  public float getAvgWaitTime()
  {
    return avgWaitTime;
  }

  public float getAvgIdleTime()
  {
    return avgIdleTime;
  }
  
  public void simulate(int numQueues, int numCustomers)
  // Preconditions: numQueues > 0
  //                numCustomers > 0
  //                No time generated during simulation is > MAXTIME
  //
  // Simulates numCustomers customers entering and leaving the
  // a queuing system with numQueues queues
  {
    // the queues
    LinkedGlassQueue<Customer>[] queues = new LinkedGlassQueue[numQueues]; 

    Customer nextCust;      // next customer from generator
    Customer cust;          // holds customer for temporary use
    
    int totWaitTime = 0;    // total wait time
    int totIdleTime = 0;    // total idle time
    int custInCount = 0;    // count of customers started so far
    int custOutCount = 0;   // count of customers finished so far
 
    int nextArrTime;        // next arrival time
    int nextDepTime;        // next departure time
    int nextQueue;          // index of queue for next departure
 
    int shortest;           // index of shortest queue
    int shortestSize;       // size of shortest queue
    int shortestWait;       // wait time of shortest queue
    Customer rearCust;      // customer at rear of shortest queue
    int finishTime;         // calculated finish time for customer being enqueued

    // instantiate the queues
    int idleTime[] = new int[numQueues];
    for (int i = 0; i < numQueues; i++)
    {
      queues[i] = new LinkedGlassQueue<Customer>();
      idleTime[i] = 0;
    }
    // set customer generator and get first customer
    custGen.reset();
    nextCust = custGen.nextCustomer();
    
    while (custOutCount < numCustomers)  // while still more customers to handle
    { 
      // get next arrival time
      if (custInCount != numCustomers) 
        nextArrTime = nextCust.getArrivalTime();
      else 
        nextArrTime = MAXTIME; 
 
      // get next departure time and set nextQueue
      nextDepTime = MAXTIME;
      nextQueue = -1;
      for (int i = 0; i < numQueues; i++)
        if (queues[i].size() != 0)
        {
          cust = queues[i].peekFront();
          if (cust.getFinishTime() < nextDepTime)
          {
            nextDepTime = cust.getFinishTime();
            nextQueue = i;
          }          
        }

      if (nextArrTime < nextDepTime)
      // handle customer arriving
      {
        // determine shortest queue
        shortest = 0;
        shortestSize = queues[0].size();
        if (shortestSize != 0)
        	shortestWait =  (queues[0].peekFront()).getFinishTime() - nextCust.getArrivalTime();
        else
        	shortestWait = 0;
        for (int i = 1; i < numQueues; i++)
        {
          //if (queues[i].size() < shortestSize)
          if (queues[i].size() > 0)
          {
	          if (shortestWait > (queues[i].peekFront()).getFinishTime() - nextCust.getArrivalTime())
	          {
	            shortest = i;
	            shortestSize = queues[i].size();
	            shortestWait =  (queues[i].peekFront()).getFinishTime() - nextCust.getArrivalTime();
	          }
          }
	      else if (shortestWait != 0)
	      {
	            shortest = i;
	            shortestSize = queues[i].size();
	            shortestWait = 0;	    	  
	      }
        }

        // determine the finish time
        //if (shortestSize == 0)
        if (shortestSize == 0)
          finishTime = nextCust.getArrivalTime() + nextCust.getServiceTime();
        else
        {
          rearCust = queues[shortest].peekRear();
          finishTime = rearCust.getFinishTime() + nextCust.getServiceTime();
        }
    
        // set finish time and enqueue customer
        nextCust.setFinishTime(finishTime);
        //idle time is from from arrival to previous time
        //if (queues[shortest].isEmpty())
        if (idleTime[shortest] == 0)
        	totIdleTime += nextArrTime - 1;
        else
        {
        	if (nextCust.getWaitTime() <= 0 )
        		totIdleTime += nextArrTime - idleTime[shortest] - 1;
        }
    	idleTime[shortest] = finishTime;
        queues[shortest].enqueue(nextCust);

        custInCount = custInCount + 1;
          
        // if needed, get next customer to enqueue
        if (custInCount < numCustomers)
          nextCust = custGen.nextCustomer();
      }
      else
      // handle customer leaving
      {
          cust = queues[nextQueue].dequeue();
          System.out.println("Line:" + nextQueue + " Arrived:" + cust.getArrivalTime() + " Started:" + (cust.getWaitTime()+cust.getArrivalTime())+ " Left:" + cust.getFinishTime());
          totWaitTime = totWaitTime + cust.getWaitTime();
          custOutCount = custOutCount + 1;
      }
    }  // end while
      
    avgWaitTime = totWaitTime/(float)numCustomers;
    avgIdleTime = totIdleTime/(float)numQueues;
  }
}