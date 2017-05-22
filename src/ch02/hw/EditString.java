package ch02.hw;

import java.util.Scanner;

import ch02.stacks.ArrayBoundedStack;

//Using the ArrayBoundedStack class, create an application EditString that prompts 
//the user for a string and then repeatedly prompts the user for changes to the string, 
//until the user enters an X, indicating the end of changes. 

//Legal change operations are:
//U—make all letters uppercase
//L—make all letters lowercase
//R—reverse the string
//C ch1 ch2—change all occurrences of ch1 to ch2
//Z—undo the most recent change

//You may assume a “friendly user,” that is, the user will not enter anything illegal. 
//When the user is finished the resultant string is printed. 
//For example, if the user enters:
//All dogs go to heaven
//U
//R
//Z
//C O A
//C A t
//Z
//the output from the program will be “ALL DAGS GA TA HEAVEN”

public class EditString {

	//private String myString;
	private int slotsLeft;
	private int MAXSLOTS = 99;
	private ArrayBoundedStack myArray;
		
	public EditString(String theirString)
	{
		//myString = new String(theirString);
		slotsLeft = MAXSLOTS;
		myArray = new ArrayBoundedStack<String>(100);
		myArray.push((String)theirString);
	}
	
	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		String inputString = new String();
		
		System.out.println("Welcome to the string program");
		System.out.println("Type in sentence or phase");

		do
		{
			inputString = myInput.nextLine();
		}
		while (inputString.equals(""));
		EditString myEditString = new EditString(inputString);

		System.out.println("Thank you! \nValid operations are:");
		System.out.println("U—make all letters uppercase");
		System.out.println("L—make all letters lowercase");
		System.out.println("R—reverse the string");
		System.out.println("C char1 char2—change all occurrences of char1 to char2");
		System.out.println("Z—undo the most recent change");
		System.out.println("P—debugging option to print the current string");
		System.out.println("STOP—all done with editing");
			
		while (!((inputString.toUpperCase()).equals("STOP")) && (myEditString.remainingSlots() > 1))
		{	
			//System.out.println("There are " + myEditString.remainingSlots() + " slots remaining");
			try
			{
				inputString = myInput.nextLine();
			}
			catch (Exception e)
			{
				inputString = "STOP";
			}
			if(inputString.length() > 0 )
			{
				switch ((inputString.toUpperCase()).charAt(0))
				{
					case 'U':
					{
						myEditString.toUpper();
						break;
					}
					case 'L':
					{
						myEditString.toLower();
						break;
					}
					case 'R':
					{
						myEditString.reverseString();
						break;
					}
					case 'C':
					{
						//01234
						//c x y
						if (inputString.length() >= 4)
						{
							myEditString.changeCharacter(inputString.charAt(2),inputString.charAt(4));
						}
						else
						{
							System.out.println("Missing original and replacement characters");
						}
						break;
					}
					case 'Z':
					{
						myEditString.undoCommand();
						break;
					}
					case 'P':
					{
						System.out.println(myEditString.toString());
						break;
					}

					default:
					{
						break;
					}
				}
			}
		}
		System.out.println("Final String is as follows\n" + myEditString.toString());
	}

	@Override
	public String toString()
	{
		return ((String)myArray.top());
	}
	
	public int remainingSlots()
	{
		return slotsLeft;
	}
		
	public void undoCommand()
	{
		if (slotsLeft < MAXSLOTS)
		{
			slotsLeft++;
			myArray.pop();
		}
		else
		{
			System.out.println("Nothing to undo");
		}
	}
	
	public void changeCharacter(char orig, char newer)
	{
		String tempString;
		tempString = (String) myArray.top();
		tempString = tempString.replace(orig,newer);
		myArray.push((String)tempString);
		slotsLeft--;
	}
	
	public void reverseString()
	{
		String tempString;
		int indexEnd;
		
		ArrayBoundedStack tempArray = new ArrayBoundedStack<String>(100);
		tempString = (String) myArray.top();
		indexEnd = -1;
		
		while (indexEnd <= (tempString.length()-1))
		{
			tempString = tempString.substring(indexEnd+1);
			if (tempString.indexOf(' ') < 0)
			    indexEnd = tempString.length();
			else
				indexEnd = tempString.indexOf(' ');
			tempArray.push((String)tempString.substring(0,indexEnd));
		}
		tempString = "";
		while (!tempArray.isEmpty())
		{
			tempString += (String) tempArray.top();
			tempArray.pop();
			if (!tempArray.isEmpty())
				tempString += " ";
		}
		myArray.push((String)tempString);
		slotsLeft--;
	}
	
	public void toLower()
	{
		String tempString;
		tempString = (String) myArray.top();
		tempString = tempString.toLowerCase();
		myArray.push((String)tempString);
		slotsLeft--;
	}
	
	public void toUpper()
	{
		String tempString;
		tempString = (String) myArray.top();
		tempString = tempString.toUpperCase();
		myArray.push((String)tempString);
		slotsLeft--;
	}

}
