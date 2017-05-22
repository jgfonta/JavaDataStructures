package ch04.hw;

import ch04.queues.ArrayUnboundedQueue;
import java.util.*;


public class NameGenderSorter {
//*********************************************
// Problem #10
//*********************************************
//		Using the Queue ADT: Write a program that repeatedly
//		prompts the user to enter strings, using the string “x done” to indicate
//		when finished. The user is assumed to only enter strings of the
//		form “f name” or “m name.” Output the names that had “m” indicated
//		in the same order they were entered, preceded by the string
//		“males:” and then do the same for the names that had “f” indicated,
//		preceded by the string “females:”. Use two ArrayBoundedQueue
//		objects in your program.	
		
//		Sample Run
//		Input a gender and name (x done to quit) > m Fred
//		Input a gender and name (x done to quit) > f Wilma
//		Input a gender and name (x done to quit) > m Barney
//		Input a gender and name (x done to quit) > m BamBam
//		Input a gender and name (x done to quit) > f Betty
//		Input a gender and name (x done to quit) > x done
//		males: Fred Barney BamBam females: Wilma Betty
		
	public static void main(String[] args) 
	{
		ArrayUnboundedQueue menQ = new ArrayUnboundedQueue <String> ();
		ArrayUnboundedQueue womenQ = new ArrayUnboundedQueue <String> ();
		
		String inputString, myName, myGender;
		Scanner myInput = new Scanner(System.in);
		do
		{
			System.out.print("Input a gender and name (x done to quit) >");
			inputString = myInput.nextLine();
			myGender = (inputString.substring(0,1)).toUpperCase();
			myName = (inputString.substring(2,inputString.length()));
			if ( myGender.equals("M") )
			{
				menQ.enqueue(myName);
			}
			else if ( myGender.equals("F") )
			{
				womenQ.enqueue(myName);
			}
		}
		while (!(inputString.toUpperCase()).equals("X DONE"));
		
		System.out.print("Males: ");
		while (!menQ.isEmpty())
		{
			System.out.print(menQ.dequeue() + " ");
		}
		System.out.print("Females: ");
		while (!womenQ.isEmpty())
		{
			System.out.print(womenQ.dequeue() + " ");
		}
		System.out.print("\n");
	}

}
