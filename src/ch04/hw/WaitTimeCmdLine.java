//---------------------------------------------------------------------
// AverageWaitTimesCLI.java       by Dale/Joyce/Weems               Chapter 4
//
// Simulates customers waiting in queues. Customers always enter
// the shortest queue.
//
// Input consists of customer information:
//    Minimum and maximum customer interarrival time.
//    Minimum and maximum customer service time.
// Followed by a sequence of AverageWaitTimes instance information:
//    Number of queues and customers.
//
// Output includes, for each AverageWaitTimes instance:
//    The average waiting time for a customer.
//
// Uses a command line interface.
//----------------------------------------------------------------------
package ch04.hw;

import java.util.Scanner;

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

public class WaitTimeCmdLine
{
  public static void main(String[] args)
  {
    Scanner conIn = new Scanner(System.in);

    int minIAT;    // minimum interarrival time
    int maxIAT;    // maximum interarrival time
    int minST;     // minimum service time
    int maxST;     // maximum service time
    int numQueues; // number of queues
    int numCust;   // number of customers

    String skip;           // skip end of line after reading an integer
    String more = null;    // used to stop or continue processing

    // Get customer information
    System.out.print("Enter minimum interarrival time: ");
    minIAT = conIn.nextInt();
    System.out.print("Enter maximum interarrival time: ");
    maxIAT = conIn.nextInt();
    System.out.print("Enter minimum service time: ");
    minST = conIn.nextInt();
    System.out.print("Enter maximum service time: ");
    maxST = conIn.nextInt();
    System.out.println();      

    // create object to perform AverageWaitTimes
    AverageWaitTimes sim = new AverageWaitTimes(minIAT, maxIAT, minST, maxST);

    do
    {
      // Get next AverageWaitTimes instance to be processed.
      System.out.print("Enter number of queues: ");
      numQueues = conIn.nextInt();     
      System.out.print("Enter number of customers: ");
      numCust = conIn.nextInt();    
      skip = conIn.nextLine();   // skip end of line
      
      // run AverageWaitTimes and output average waiting time
      sim.simulate(numQueues, numCust);
      System.out.println("Average waiting time is " + sim.getAvgWaitTime());
      System.out.println("Average idle server time is " + sim.getAvgIdleTime());

      
      // Determine if there is another AverageWaitTimes instance to process
      System.out.println(); 
      System.out.print("Evaluate another AverageWaitTimes instance? (Y=Yes): ");
      more = conIn.nextLine();
    }
    while (more.equalsIgnoreCase("y"));

    System.out.println("Program completed.");
  }
}