package ch06.hw;

import java.io.*;
import java.util.*;
import ch06.lists.*;


//*********************************
//*   Problem # 28
//*********************************
//Create an application (that uses the SortedABList) that
//reads a list of strings from a file and outputs them in alphabetical
//order.

public class FileStringSorter  {

	public static void main(String[] args) throws IOException {
		FileInputStream myfile;
		String fname;
	    //India Constitution
	    //fname = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\input\\historical\\IndiaPurnaSwaraj.txt";

	    //USA Constitution
	    fname = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\input\\historical\\constitution.txt";

	    //Declaration of Independence
	    //fname = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\input\\historical\\USAdeclaration.txt";

	    //British Magna Carta
	    //fname = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\input\\historical\\BritishMagnaCarta.txt";

		
		myfile = new FileInputStream(fname);
		Scanner myInput = new Scanner(myfile);
		
		SortedABList<String> mySortedFile = new SortedABList<String>();

		while (myInput.hasNext())
		{
			mySortedFile.add(myInput.next());
		}
		
		while (!mySortedFile.isEmpty())
		{
			System.out.println(mySortedFile.remove(0));
		}
	}

}
