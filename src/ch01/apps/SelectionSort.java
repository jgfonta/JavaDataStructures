package ch01.apps;

//For this exercise you must implement the selection sort algorithm.
//Create a program named SelectionSort that instantiates an array of 
//int of size 100 and initializes it with random numbers between 1 and 1000. 
//The program should display the integers from the array in five columns. 
//Next it sorts the array using selection sort. Finally, it prints the contents 
//of the array again, in columns of 5.

//Augment your program from part a so that it also counts the number of comparisons 
//and the number of swaps executed during the selection sort. It should report these 
//numbers after printing the sorted array. Based on the analysis of selection sort 
//in this section what are the expected values for the number of comparisons and 
//the number of swaps? How do the values reported by your program compare to the 
//“theoretical” values?

//Augment your program from part b so that it works first with an array of size 10, 
//then 100, then 1000, then 10,000, and finally 100,000 (remove the code that prints 
//out the array values of course). For each array size your program should display 
//the number of comparisons and swaps. Have the program display these numbers in 
//a nice tabular format.


public class SelectionSort {

	int [] arrayOfNums;
	int compares, swaps;
	int expectedCompares;
	int index;
	
	public SelectionSort()
	{
		compares = 0;
		swaps = 0;
		index = 10000;
		expectedCompares = ((index * index) / 2) - (index / 2);
		arrayOfNums = new int[index];
		
		for (int i=0; i<index; i++)
		{
			arrayOfNums[i] = (int) Math.floor((Math.random() * 1000 + 1));
		}
	}
	
	public void sortArray()
	{
		int current, swap;
		for (int j=0; j<index; j++)
		{
			current = arrayOfNums[j];
			swap = j;
			for (int i=(j+1); i<index; i++)
			{
				compares++;
				if (current > arrayOfNums[i])
				{
					current = arrayOfNums[i];
					swap = i;
					swaps++;
				}
			}
			arrayOfNums[swap] = arrayOfNums[j];
			arrayOfNums[j] = current;
		}
	}
	public static void main(String[] args) {
		SelectionSort mySelSort = new SelectionSort();
		
		System.out.println("Random unsorted array of " + mySelSort.arrayOfNums.length + " integer numbers");
		for (int i=0; i< mySelSort.index; i++)
		{
			if (((i + 1) % 10) == 0)
				System.out.println(mySelSort.arrayOfNums[i]);
			else
				System.out.print(mySelSort.arrayOfNums[i] + "\t");
		}
		
		mySelSort.sortArray();
		
		System.out.println("\nRandom sorted array of " + mySelSort.arrayOfNums.length + " integer numbers");
		for (int i=0; i< mySelSort.index; i++)
		{
			if (((i + 1) % 10) == 0)
				System.out.println(mySelSort.arrayOfNums[i]);
			else
				System.out.print(mySelSort.arrayOfNums[i] + "\t");
		}
		System.out.println("\n          Comparison=" + mySelSort.compares + " and Swapped=" + mySelSort.swaps);
		System.out.println("Expected Comparisons=" + mySelSort.expectedCompares);

	}

}
