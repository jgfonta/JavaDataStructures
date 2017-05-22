package ch08.hw;
import java.util.*;
import ch08.maps.*;

import java.io.*;

//***************************************
//Problem #12
//***************************************
//Create an application, similar to StringPairApp, which
//acts as a chemistry quiz. It randomly generates a periodic number
//between 1 and 118 and asks the user for the corresponding element.
//It then checks their answer against the correct answer (using a map
//based on the periodic.txt file) and reports the result, displaying
//the correct answer if they get it wrong. It repeats this for 10 questions
//and then reports the percentage of correct answers. How can
//your application be made more generally usable?

public class ChemistryQuiz {

	final static String PERIODICFILE = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\input\\periodic.txt"; 
	final static int TOTALQUESTIONS = 25;

	public static void main(String[] args) throws IOException {

		
		FileReader myInputFile = new FileReader(PERIODICFILE);
		Scanner myInputLine = new Scanner(myInputFile);
		
		myInputLine.useDelimiter("[#\\n\\r]");  // delimiters are # signs, line feeds,
        										// carriage returns)
		
		HMap<String, String> myMap = new HMap<String, String>();
		
		String currNum = "", currName = "";  
		String headerElementNum, headerElementName;
		int lastElementNum;
		
		//Get the header information from the file
		headerElementNum = myInputLine.next();
		headerElementName = myInputLine.next();
		myInputLine.nextLine();		
		//System.out.println("Reading " + headerElementNum + " and " + headerElementName);
		
		//Dynamically build a periodic table of elements 
		// by reading file and creating a map 
		while (myInputLine.hasNext())
		{
			currNum = myInputLine.next();
			currName = (myInputLine.next()).substring(1);
			myInputLine.nextLine();
			//System.out.println(currNum + " " + currName);
			myMap.put(currNum, currName);
		}
		myInputLine.close();
	
		//Periodic table of elements map has been built
		//Start the quiz on elements
		myInputLine = new Scanner(System.in);
		lastElementNum = Integer.parseUnsignedInt(currNum);
		currNum = "";
		currName = "";
		int correct = 0;
		Random myRando = new Random();
		int randomNum;
		
		System.out.println("Welcome to the chemistry quiz!");
		System.out.println("You will be asked to name " + TOTALQUESTIONS + " randomly generated " + headerElementName);
		for (int i = 1; i<=TOTALQUESTIONS;i++)
		{
			randomNum = myRando.nextInt(lastElementNum) + 1;
			currNum = String.valueOf(randomNum);
			System.out.print("#" + i + " " + headerElementNum + " " + currNum + ":");
			currName = myInputLine.next();
			if (currName.equalsIgnoreCase(myMap.get(currNum)))
			{
				correct++;
			}
		}
		double gradePercent;
		char gradeLetter;
		gradePercent = ( (double) correct / TOTALQUESTIONS ) * 100;
		if (gradePercent >= 89.49)
			gradeLetter = 'A';
		else if (gradePercent >= 79.49)
			gradeLetter = 'B';
		else if (gradePercent >= 69.49)
			gradeLetter = 'C';
		else if (gradePercent >= 59.49)
			gradeLetter = 'D';
		else 
			gradeLetter = 'F';
		
		System.out.println("You got an " + gradeLetter + " " + gradePercent + "%");
	}

}
