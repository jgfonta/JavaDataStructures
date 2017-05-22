package ch05.hw;
import java.util.Random;

import ch05.collections.*;

public class UnsortedArrayBagCollection <T> extends ArrayCollection<T> implements BagInterface<T>
{

	
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

	public UnsortedArrayBagCollection()
	{
		super();
	}
	
	public T grab()
	// If this bag is not empty, removes and returns a random element of the bag;
	// otherwise returns null.
	{
		Random myRando = new Random();
		int randoNum;
		T myElement;
		
		randoNum = myRando.nextInt(super.numElements);
		myElement = super.elements[randoNum];
		super.remove(myElement);
		return myElement;
	}
	
	public int count(T target)
	// Returns a count of all elements e in this collection such that e.equals(target).
	{
		super.find(target);
		if (super.found)
			return 1;
		else
			return 0;
	}

	
	public int removeAll(T target)
	// Removes all elements e from this collection such that e.equals(target)
	// and returns the number of elements removed.
	{
		int targetsRemoved = 0;
		while (super.remove(target))
		{
			targetsRemoved++;
		}
		return targetsRemoved;
	}


	public void clear()
	// Empties this bag so that it contains zero elements.
	{
		while (!super.isEmpty())
		{
			super.remove(super.elements[0]);
		}
	}
	
	
}
