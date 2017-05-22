package ch06.hw;

import java.util.*;
import ch06.lists.*;

public class VisitedCountries {
	
	//*********************************
	//*   Problem #29  
	//*********************************
	//Create an application (that uses the SortedABList) that
	//allows a user to enter a list of countries that he or she has visited
	//and then displays the list in alphabetical order, plus a count of how
	//many countries are on the list. If the user mistakenly enters the
	//same country more than once, the program should inform the user
	//of their error and refrain from inserting the country into the list a
	//second time.

	public static void main(String[] args) {
		Scanner myInput = new Scanner (System.in);
		String inputString, country;
		boolean getCountries = true;
		ListInterface countryList = new SortedABList<String>();
		
		System.out.println("Welcome to the countries visited application");

		do 
		{
			System.out.print("Type the name of a country that you have visited (or QUIT to end application)");
			//inputString = myInput.next();
			inputString = myInput.nextLine();   //Get countries with spaces
			country = (inputString.substring(0, 1)).toUpperCase() + (inputString.substring(1)).toLowerCase();
			if (country.length() == 4 && (country.equals("Quit")))
			{
				getCountries = false;
			}
			else
			{
				//Has user specified this country before?
				if (!(countryList.contains(country)))
				{
					//New country, add it to the list
					countryList.add(country);
				}
				else
				{
					System.out.println("Remember to avoid duplicates, thanks!");
				}
			}
			
		}
		while(getCountries);
		
		
		System.out.println("You have visited these countries:");
		while (!countryList.isEmpty())
		{
			System.out.println(countryList.remove(0));			
		}
		myInput.close();
	}

}
