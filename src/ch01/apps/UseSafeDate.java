//----------------------------------------------------------------------
// UseSafeDate.java          by Dale/Joyce/Weems               Chapter 1
//
// Example of catching exceptions thrown by SafeDate class 
//----------------------------------------------------------------------

package ch01.apps;

import java.util.Scanner;
import ch01.dates.*;

public class UseSafeDate
{
  public static void main(String[] args)
  {
    int month1, day1, year1;
    SafeDate theDate1;
    int month2, day2, year2;
    SafeDate theDate2;
    int comparisondate;

    boolean DateOK = false;
    Scanner scan1 = new Scanner(System.in);
 
    while (!DateOK)
    {
      System.out.println("Enter 1st date (month day and year):");
      month1 = scan1.nextInt(); 
      day1 = scan1.nextInt(); 
      year1 = scan1.nextInt();
      System.out.println("Enter 2nd date (month day and year):");
      month2 = scan1.nextInt(); 
      day2 = scan1.nextInt(); 
      year2 = scan1.nextInt();
      try
      {
    	  
        theDate1 = new SafeDate(month1, day1, year1);
        theDate2 = new SafeDate(month2, day2, year2);
        DateOK = true;
        System.out.println(theDate1 + " is a safe date.");
        System.out.println(theDate2 + " is a safe date.");
        comparisondate = theDate1.compareTo(theDate2);
        if (comparisondate == 0 )
        	System.out.println("Dates the same");
        else if (comparisondate < 0)
        	System.out.println(theDate1 + " less than " + theDate2);       	
        else
        	System.out.println(theDate1 + " greater than " + theDate2);
      }
      catch(DateOutOfBoundsException DateOBExcept)
      {
    	  System.out.println(DateOBExcept.getMessage() + "\n");
      }
    }
  }
}
