package ch04.hw;
import java.util.Calendar;
import java.util.Formatter;

import ch02.stacks.*;
import ch04.queues.*;

//*********************************************
//Problem #29
//*********************************************	
//	This question deals with palindromic dates—that is, dates
//	that read the same forward and backward.
//	The year 2002 was a palindromic year. When is the next
//	palindromic year?
	
//	1.	If dates are written MMDDYYYY, then May 2, 2050, is a
//	palindromic date. What is the earliest palindromic date of the
//	21st century?

//	2.	Create a program that identifies all palindromic dates in a
//	given year. First a user enters a year. Then the program reports
//	the palindromic dates. Finally, the program asks the
//	user if he or she wishes to try again. Note that you need a
//	class similar to the Palindrome class, but one that permits
//	testing “digit” characters.
public class PaldindromeDates {

	
	public PaldindromeDates()
	{
	
	}
	
	public void FindDate(int theYear)
	{
	//Find all the palindrome dates in a specific year
		//int DaysMonth[];
		Calendar myCalendar;
		myCalendar = Calendar.getInstance();
		String dateString;
		QueueInterface matchesQueue = new ArrayUnboundedQueue <String> ();
		for (int month = 0; month<12; month++)
		{
			myCalendar.set(theYear, month, 1);
			//System.out.print("Month " + (month+1));
			for (int day = 0; day < myCalendar.getActualMaximum(Calendar.DAY_OF_MONTH); day++)
			{
				dateString = String.format("%04d", theYear);
				dateString += String.format("%02d", month + 1);
				dateString += String.format("%02d", day+1);
				//System.out.print(dateString);
				if (isPalindrome(dateString))
				{
					matchesQueue.enqueue((String)dateString);
				}
			}
		}

		while (!matchesQueue.isEmpty())
		{
			System.out.println("Date = " + matchesQueue.dequeue());
		}	
	 
	}
	
	private boolean isPalindrome(String myDate)
	{
		StackInterface datesStack = new ArrayListStack <Character> ();
		QueueInterface datesQueue = new ArrayUnboundedQueue <Character> ();
		for (int i = 0; i<myDate.length();i++)
		{
			datesStack.push(myDate.charAt(i));
			datesQueue.enqueue(myDate.charAt(i));
		}
		while (!datesStack.isEmpty())
		{
			if (datesStack.top() != datesQueue.dequeue())
			 return false;
			datesStack.pop();
		}
		return true;
	}
	
}
