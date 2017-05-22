//----------------------------------------------------------------------
// SafeDate.java          by Dale/Joyce/Weems                  Chapter 1
//
// Supports date objects having year, month, and day attributes with
// some protection from the creation of non-existent dates.
//----------------------------------------------------------------------

package ch01.dates;

public class SafeDate 
{
  protected int year, month, day;
  public static final int MINYEAR = 1583;

  public SafeDate(int newMonth, int newDay, int newYear)
                       throws DateOutOfBoundsException
  {
    if ((newMonth <= 0) || (newMonth > 12))
      throw new DateOutOfBoundsException("month " + newMonth + " illegal");
    else
      month = newMonth;  
      
    day = newDay;  
    
    if (newYear < MINYEAR)
      throw new DateOutOfBoundsException("year " + newYear + " too early");
    else    
      year = newYear;
  }

  // Observers
  public int getYear() { return year;  }
  public int getMonth(){ return month; }
  public int getDay()  { return day;   }

  public int lilian()
  {
    // Returns the Lilian Day Number of this date.
    // Precondition: This Date is a valid date after 10/14/1582.
    //
    // Computes the number of days between 1/1/0 and this date as if no calendar
    // reforms took place, then subtracts 578,100 so that October 15, 1582 is day 1. 
    
    final int subDays = 578100;  // number of calculated days from 1/1/0 to 10/14/1582

    int numDays = 0;

    // Add days in years.
    numDays = year * 365;

    // Add days in the months.
    if (month <= 2) 
      numDays = numDays + (month - 1) * 31;
    else 
      numDays = numDays + ((month - 1) * 31) - ((4 * (month-1) + 27) / 10);

    // Add days in the days.
    numDays = numDays + day;

    // Take care of leap years.
    numDays = numDays + (year / 4) - (year / 100) + (year / 400);

    // Handle special case of leap year but not yet leap day.
    if (month < 3) 
    {
        if ((year % 4) == 0)   numDays = numDays - 1;
        if ((year % 100) == 0) numDays = numDays + 1;
        if ((year % 400) == 0) numDays = numDays - 1;
      }

    // Subtract extra days up to 10/14/1582.
    numDays = numDays - subDays;
    return numDays;
  }

  @Override
  public String toString()
  // Returns this date as a String.
  {
    return(month + "/" + day + "/" + year);
  }
  
  public int compareTo(SafeDate anotherDate)
  //This method should return the value 0 if this date 
  //(the date of the object upon which the method is invoked) 
  //is equal to the argument date; a value less than 0 if this
  //date is a date earlier than the argument date; and a value 
  //greater than 0 if this date is a date later than the argument 
  //date. Create a test driver that shows that your method 
  //performs correctly.
  {
	  //Return zero if equal
	  if (anotherDate.getYear() == this.year)
	  {
		  if (anotherDate.getMonth() == this.month)
		  {
			  if (anotherDate.getDay() == this.day)
			  {
				  return 0;
			  }
			  //less than 0 if this date is earlier than argument date
			  else if (this.day < anotherDate.getDay())
			  {
				  return -1;
			  }
			  //greater than 0 if this date is greater than argument date
			  else
			  {
				  return 1;
			  }
		  }
		  //less than 0 if this date is earlier than argument date
		  else if (this.month < anotherDate.getMonth())
		  {
			  return -1;
		  }
		  //greater than 0 if this date is greater than argument date
		  else
		  {
			  return 1;
		  }
	  }
	  //less than 0 if this date is earlier than argument date
	  else if (this.year < anotherDate.getYear())
	  {
		  return -1;
	  }
	  //greater than 0 if this date is greater than argument date
	  else   
	  {
		  return 1;
	  }
				  
  }

}
 