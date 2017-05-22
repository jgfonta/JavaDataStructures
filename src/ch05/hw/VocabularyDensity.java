//---------------------------------------------------------------------------
// VocabularyDensity.java       by Dale/Joyce/Weems                 Chapter 5
//
// Displays the number of total words, unique words in the input text file,
// and the resulting vocabulary density.
// Input file indicated by a command line argument.
//---------------------------------------------------------------------------
package ch05.hw;

import java.io.*;
import java.util.*;
import ch05.collections.*;


//************************************************
//problem #12
//************************************************
//Revise the Vocabulary Density application so that
//
//1. if the collection becomes full, then the application no longer
//continues processing—instead it displays a suitable message
//and then ends.
//
//2. it includes a constant THRESHOLD of type int and ignores
//words whose length is less than the threshold value—thus the
//word analysis would not include “short” words.

// ...skipped...
//3. it permits multiple filenames to be passed as command line
//arguments, and will proceed to separately analyze and report
//on each of the files.
//
//4. expand on the previous revision so that in addition to the separate
//analysis of the files it also performs a combined analysis,
//as if the combined files all represented a single text.

public class VocabularyDensity
{
  public static void main(String[] args) throws IOException 
  {
    final int CAPACITY = 1000;   // capacity of collection
    final int THRESHOLD = 3;     //ignore short words
    String fname; // = args[0];      // input file of text
    String word;                 // current word
    int numWords = 0;            // total number of words
    int uniqWords;               // number of unique words
    double density;              // vocabulary density
    boolean successfulRead = true;  // Success until failure

    CollectionInterface<String> words = new ArrayCollection<String>(CAPACITY);
    //India Constitution
    //fname = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\input\\historical\\IndiaPurnaSwaraj.txt";

    //USA Constitution
    fname = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\input\\historical\\constitution.txt";

    //Declaration of Independence
    //fname = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\input\\historical\\USAdeclaration.txt";

    //British Magna Carta
    //fname = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\input\\historical\\BritishMagnaCarta.txt";
 
    // Set up file reading
    FileReader fin = new FileReader(fname);
    Scanner wordsIn = new Scanner(fin);
    wordsIn.useDelimiter("[^a-zA-Z']+");  // delimiters are nonletters,'

    while (wordsIn.hasNext())      // while more words to process
    {
      word = wordsIn.next();          
      word = word.toLowerCase();
      if (words.isFull())
      {
    	  System.out.println("Exceeded maximum of " + CAPACITY + " words. \nProgram Terminated");
    	  successfulRead = false;
    	  break;
      } 
      if (!words.contains(word) && word.length() > THRESHOLD)
        words.add(word);
      numWords++;
    }
  
    if (successfulRead)
    {
	    density = (double)numWords/words.size();
	    System.out.println("Analyzed file " + fname);
	    System.out.println("\n\tTotal words:  " + numWords);
	    if (words.size() == CAPACITY)
	      System.out.println("\tUnique words: at least " + words.size());
	    else
	    {
	      System.out.println("\tUnique words: " + words.size());
	      System.out.printf("\n\tVocabulary density: %.2f", density);
	    }
    }
  } 
} 