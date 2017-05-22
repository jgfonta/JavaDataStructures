package ch04.hw;


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

public class FindPalindromeDates {

	public static void main(String[] args) {
		PaldindromeDates myDates = new PaldindromeDates();
		
		for (int i = 1890; i<2150;i++)
		  myDates.FindDate(i);

	}

}
