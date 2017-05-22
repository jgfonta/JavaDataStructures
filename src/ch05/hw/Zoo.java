package ch05.hw;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import ch05.collections.ArrayCollection;
import ch05.collections.CollectionInterface;


//************************************************
//problem #13
//************************************************
//The file Animals.txt found in the input folder contains a
//long list of animal names, one per line. Create an application that
//reads that file and creates a collection of animal names. Use the ArrayCollection
//class. Your application should then generate a random
//character and challenge the user to repeatedly enter an animal
//name that begins with that character, reading the names entered by
//the user until they either enter a name that does not begin with the
//required character or is not in the collection, or they enter a name
//they used before. Finally, your application reports how many names
//they successfully entered.

public class Zoo {

	public static void main(String[] args) throws IOException 
	{
	    final int CAPACITY = 1000;   

		String fname = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\input\\Animals.txt";
		
		String animal;
		int totAnimals = 0;
	    CollectionInterface<String> animals = new ArrayCollection<String>(CAPACITY);

		
	    FileReader fInput = new FileReader(fname);
	    Scanner wordsIn = new Scanner(fInput);

	    System.out.println("Filling the zoo, watch your step");
	    while (wordsIn.hasNext())      
	    {
	      animal = wordsIn.next();          
	      animal = animal.toLowerCase();
	      if (animals.isFull())
	      {
	    	  System.out.println("Exceeded maximum of " + CAPACITY + " words. \nProgram Terminated");
	    	  break;
	      } 
	      if (!animals.contains(animal))
	        animals.add(animal);
	      totAnimals++;
	    }
	    System.out.println("Zoo population at capacity with " + animals.size() + " animals.");
	    
	    Random myRando = new Random();
	    char randChar;
	    Scanner animalGuess = new Scanner(System.in);
	    do     
	    {
		  randChar = (char) (myRando.nextInt(26) + 'a');
		  System.out.println("Guess what animal starts with " + randChar + " or 'STOP' to exit");
		  animal = animalGuess.next();
	      while (!animals.contains(animal) && !animal.equals("STOP"))
	      {
	    	  System.out.println("Sorry, try again");
			  System.out.println("Guess what animal starts with " + randChar);
			  animal = animalGuess.next();
	      }
	      if (!animal.equals("STOP"))
	    	  System.out.println("Yahoo!  You got it, there is a " + animal);
	    }
	    while (!animal.equals("STOP"));
	}

}
