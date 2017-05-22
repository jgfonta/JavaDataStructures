//---------------------------------------------------------------------------
// VocabularyDensity.java       by Dale/Joyce/Weems                 Chapter 5
//
// Displays the number of total words, unique words in the input text file,
// and the resulting vocabulary density.
// Input file indicated by a command line argument.
//---------------------------------------------------------------------------
package ch05.apps;

import java.io.*;
import java.util.*;
import ch05.collections.*;

public class VocabularyDensity
{
  public static void main(String[] args) throws IOException 
  {
    final int CAPACITY = 10000;   // capacity of collection
    String fname; // = args[0];      // input file of text
    String word;                 // current word
    int numWords = 0;            // total number of words
    int uniqWords;               // number of unique words
    double density;              // vocabulary density

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
      if (!words.contains(word))
        words.add(word);
      numWords++;
    }
  
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