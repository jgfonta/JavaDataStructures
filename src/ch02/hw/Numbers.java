package ch02.hw;

import support.LLNode;
import java.util.*;

//Assume numbers points to a linked list of LLNode<Integer>. 
//Write code that prints the following. Do not forget to consider the case where the 
//list is empty. Recall that LLNode exports setters and getters for both info and link.
//The sum of the numbers on the list
//The count of how many elements are on the list
//The count of how many positive numbers are on the list
//The enumerated contents of the list; 
//for example, if the list contains 5, 7, and -9 the code will print 
//5  
//7 
//-9
//The reverse enumerated contents of the list (hint: use a stack); 
//for example, if the list contains 5, 7, and -9 the code will print
//-9  
//7
//5

public class Numbers {

	public static void main(String[] args) 
	{
		Scanner myInput = new Scanner(System.in);
		System.out.println("Welcome to the numbers program");
		
		

		System.out.println("Input simulation is 5,7,-9");

		LLNode head = null;
		LLNode tail = null;
		LLNode currNode = null;
		LLNode prevNode = null;

		boolean keepLooping = true;
		do 
		{
			prevNode = currNode;
			System.out.println("Enter a number (or char when done):");
			try
			{
				currNode = new LLNode((int)myInput.nextInt());
				if (prevNode != null)
				{
					prevNode.setLink(currNode);
				}
				if (head == null)
				{
					head = currNode;
				}
			} catch (Exception e)
			{
				keepLooping = false;
			}
		}
		while (keepLooping);
		tail = currNode;

		currNode = head;
		int sum = 0, count = 0;
		double average = 0;
		ArrayList myStack = new ArrayList<Integer>();
		while(currNode != null)
		{
			count++;
			sum += (int)currNode.getInfo();
			System.out.println("Node " + currNode.getInfo());
			myStack.add((Integer)currNode.getInfo());
			currNode = currNode.getLink();
		}
		average = (double) sum / (double) count;

		while(myStack.isEmpty() == false)
		{
			System.out.println("Reverse node " + myStack.get(myStack.size() - 1));
			myStack.remove(myStack.size()- 1);
		}
		
		System.out.println("Sum =" + sum + " Count = " + count);
		System.out.println("Average =" + average);


	}

}
