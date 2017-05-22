package ch08.hw;

import java.io.*;
import java.util.*;
import ch08.maps.*;

public class JavaProgramAnalyzer {
	final static String JAVAFILE = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\input\\javawords.txt"; 
    final static String PROGRAM1 = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\ch08\\apps\\WordFreqCounter.java";
    final static String PROGRAM2 = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\ch06\\hw\\BridgePlayer.java";
    final static String PROGRAM3 = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\ch05\\apps\\VocabularyDensity2.java";
    final static String PROGRAM4 = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\ch04\\hw\\AverageWaitTimes.java";
    final static String PROGRAM5 = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\ch02\\hw\\Auction.java";
    //final static int JAVATYPES = 4;
    enum JAVATYPES {accesscontrol, flow, datatype, exception};

  //Java reserved words can be categorized into subsets such as
  //“primitive types,” “control,” “access control,” etc. Research the reserved
  //words and create your own categorization scheme. Then...
  //
  //1) Create an application called Categories that first creates a
  //map based on your categorization of reserved words (e.g., int
  // “primitive type”) and then reads a .java file and displays
  //the keyword types found in the file. For example, if MapEntry.
  //java is the input file then the output, depending on your
  //categorization, might look like this:
  //
  //control, organization, access control, definition,
  //control . . . because of the sequence of reserved
  //words for (see opening comment), package, public,
  //class, protected, . . .
  //
  //2) Improve your application so that it ignores the contents of literal
  //strings.
  //
  //3) Improve your application so that it ignores the contents of
  //comments.    
    
	public static void main(String[] args) throws IOException {

			
			FileReader myInputFile = new FileReader(JAVAFILE);
			Scanner myInputLine = new Scanner(myInputFile);
			
			myInputLine.useDelimiter("[#\\n\\r]");  // delimiters are # signs, line feeds,
	        										// carriage returns)
			
			HMap<String, String> myMap = new HMap<String, String>();
			
			String currStatement = "", currType = "";  
			int lastElementNum;
			
			
			//Dynamically build table of elements 
			// by reading file and creating a map 
			while (myInputLine.hasNext())
			{
				currStatement = myInputLine.next();
				currType = myInputLine.next();
				if (myInputLine.hasNext())
					myInputLine.nextLine();
				//System.out.println(currStatement + " Java instruction is type " + currType);
				myMap.put(currStatement.toLowerCase(), currType.toLowerCase());
			}
			myInputLine.close();
		
			
			currStatement = "";
			currType = "";
			int[] found = {0,0,0,0}; 
			int comment = 0;
			int code = 0;
			int myNDX;
			
			System.out.println("Welcome to the Java program analzyer");
			System.out.println("Analysis of program ");
			
			myInputFile = new FileReader(PROGRAM1);
			myInputLine = new Scanner(myInputFile);
			myInputLine.useDelimiter("[;\\n\\r]");  // delimiters are line feeds,
			                                       // carriage returns)

			
			while (myInputLine.hasNext())
			{				
				currStatement = myInputLine.next();
				//currStatement = currStatement.replaceAll(" ", "");
				while (currStatement.equals("") && myInputLine.hasNext())
				{
					currStatement = myInputLine.next();					
				}
				while (currStatement.length() > 0 && currStatement.startsWith(" "))
					currStatement = currStatement.substring(1);				
				if (currStatement.length() > 1 && currStatement.indexOf(' ') >= 0)
						currStatement = currStatement.substring(0, currStatement.indexOf(' '));
				if (currStatement.length() >= 2 && (currStatement.substring(0, 2)).equals("//"))
				{
					comment++;
					myInputLine.nextLine();
				}
				else if (currStatement.length() >= 1 
						&& !currStatement.equals("\n") 
						&& myMap.contains(currStatement))
				{
					try
					{
						currType = myMap.get(currStatement);
						myNDX = JAVATYPES.valueOf(currType).ordinal();
						found[myNDX]++;
					}
					catch (Exception e)
					{
						
					}
					//System.out.println(currStatement);
				}
				else if (currStatement.length() >= 1 && !currStatement.equals("{") && !currStatement.equals("}"))
				{
					code++;
				}
			}
			myInputLine.close();

			System.out.println("Found accesscontrol=" + found[0]);
			System.out.println("Found flow=" + found[1]);
			System.out.println("Found datatype=" + found[2]);
			System.out.println("Found exception=" + found[3]);
			System.out.println("Found comments=" + comment);
			System.out.println("Found code expressions=" + code);
			
		}


}
