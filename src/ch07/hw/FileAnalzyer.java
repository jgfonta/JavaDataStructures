package ch07.hw;

import java.io.*;
import java.util.*;

import ch07.trees.BinarySearchTree;
import support.*;

public class FileAnalzyer {

	
// FileAnalzyer Application problem
//
//52. Create an application that will read a text file (file name/location
//provided through a command line argument) and display the
//longest word (or words if there is a tie) in the file and how many
//times they occur.
//
//53.Create an application that will read a text file (file name/location
//		provided through a command line argument) and display the
//		most frequently used word (or words if there is a tie) in the file and
//		how many times they occur.
//
//54.Create an application that will read a text file (file name/location
//		provided through a command line argument) and display the
//		word or words in the file that occur exactly once.
	
	public static void main(String[] args) {
		
		String fname, tempWord; 
		FileReader fin;
		WordFreq myWord;
		BinarySearchTree<WordFreq> myTree;

		
		final int MINWORDLEN = 3;
		//India Constitution
	    fname = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\input\\historical\\IndiaPurnaSwaraj.txt";

	    //USA Constitution
	    //fname = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\input\\historical\\constitution.txt";

	    //Declaration of Independence
	    //fname = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\input\\historical\\USAdeclaration.txt";

	    //British Magna Carta
	    //fname = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\input\\historical\\BritishMagnaCarta.txt";
	 
	    // Set up file reading

	    myTree = null;
	    try
	    {
	    	fin = new FileReader(fname);
		    Scanner wordsIn = new Scanner(fin);
		    wordsIn.useDelimiter("[^a-zA-Z']+");  // delimiters are nonletters,'		    
			myTree = new BinarySearchTree<WordFreq>();
			while (wordsIn.hasNext())
			{
				tempWord = wordsIn.next();
				tempWord = tempWord.toLowerCase();
				if (tempWord.length() > MINWORDLEN)
				{
					myWord = new WordFreq(tempWord);
					if (myTree.contains(myWord))
					{
						myWord = myTree.get(myWord);
					}
					else
					{
						myTree.add(myWord);
					}
					myWord.inc();
				}
			}
		    wordsIn.close();
		    
		    int maxOccurs = 0, longest = 0;
		    String maxWord = "", longestWord = "";
		    
	    	for (WordFreq c: myTree)
		    {
	    		if (c.getWordIs().length() > longest)
	    		{
	    			longestWord = c.getWordIs();
	    			longest = longestWord.length();
	    		}
	    		if (c.getFreq() > maxOccurs)
	    		{
	    			maxOccurs = c.getFreq();
	    			maxWord = c.getWordIs();
	    		}

		    }
	    	System.out.println("Max occurance " + maxOccurs + " " + maxWord);
	    	System.out.println("Longest word " + longest + " " + longestWord);
	    }
	    catch (Exception e)
	    {
	    	System.out.println(e);
	    }
	    


	    

	}

}
