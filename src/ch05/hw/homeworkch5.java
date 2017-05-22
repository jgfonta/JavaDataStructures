package ch05.hw;


//************************************************
// problem #8   done
//************************************************
//Add the following methods to the ArrayCollection class,
//and create a test driver for each to show that they work correctly. In
//order to practice your array coding skills, code each of these methods
//by accessing the internal variables of the ArrayCollection,
//not by calling the previously defined public methods of the class
//
//1. String toString() creates and returns a string that correctly
//represents the current collection. Such a method could
//prove useful for testing and debugging the class and for testing
//and debugging applications that use the class. Assume
//each stored element already provides its own reasonable
//toString method.
//
//2. int count(T target) returns a count of the number of elements
//e in the collection such that e.equals(target) is
//true.
//
//3. void removeAll(T target) removes all elements e from
// the collection such that e.equals(target) is true.
//
//4. ArrayCollection<T> combine(ArrayCollection<T>
//other) creates and returns a new ArrayCollection object
//that is a combination of this object and the argument object.

//************************************************
//problem #12  done
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
//
//3. it permits multiple filenames to be passed as command line
//arguments, and will proceed to separately analyze and report
//on each of the files.
//
//4. expand on the previous revision so that in addition to the separate
//analysis of the files it also performs a combined analysis,
//as if the combined files all represented a single text.
//************************************************
//problem #13  done 
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

//************************************************
//problem #14  done
//************************************************
//The file Keywords.txt found in the input folder contains
//all the Java keywords. Create an application that accepts the name
//of a Java program file as a command line argument and displays a
//count of the total number of keywords the program contains. For
//example, if you use the VocabularyDensity.java program as
//your input, the application should display
//VocabularyDensity.java contains 24 Java keywords
//As part of your solution you should create a collection of keywords
//using the information in the Keywords.txt file. Do not worry
//about the fact that you might be counting keywords contained
//within comments or strings.


//************************************************
//problem #26  done
//************************************************
//Add the following methods to the SortedArrayCollection
//class, and create a test driver for each to show that they work correctly.
//Code each of these methods by accessing the internal variables
//of the SortedArrayCollection, not by calling the previously
//defined methods of the class.
//
//1. String toString() creates and returns a string that correctly
//represents the current collection. Such a method could
//prove useful for testing and debugging the class and for testing
//and debugging applications that use the class. Assume
//each stored element already provides its own reasonable
//toString method.
//
//2. T smallest() returns null if the collection is empty, otherwise
//returns the smallest element of the collection.
//
//3. int greater(T element) returns a count of the number of
//elements e in the collection that are greater than element,
//that is such that e.compareTo (element) is > 0.
//
//4. SortedArrayCollection<T> combine(SortedArray-
//Collection<T> other) creates and returns a new
//SortedArrayCollection object that is a combination of
//this object and the argument object.


//************************************************
//problem #31  done
//************************************************
//Create a new collection class named SortedLinkedCollection
//that implements a collection using a sorted linked list. Include
//a toString method as described in Exercise 30a. Include a test
//driver application that demonstrates your class works correctly.


//************************************************
//problem #33
//************************************************
//Create a class that implements the BagInterface, plus a
//test driver that shows that your class operates correctly:
//
//1. Using an unsorted array (if you like, you can extend the ArrayCollection
//class)
//
//2. Using a sorted array (if you like, you can extend the
//SortedArrayCollection class)
//
//3. Using a linked list (if you like, you can extend the Linked-
//Collection class)


public class homeworkch5 {

	//does nothing but hold the above comments
	
}
