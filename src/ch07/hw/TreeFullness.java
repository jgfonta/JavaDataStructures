package ch07.hw;

import ch07.trees.*;
import support.*;
import java.util.*;

//TreeFullness Application problem
//
//32. Design and implement a method height for Binary-
//SearchTree, that returns the height of the tree with recursion or iteratively.
//
//47.Revise our BSTInterface interface and Binary-
//SearchTree class to include the balance method. 
//
//48.Fullness Experiment:
//1.	Design and implement a method height for Binary-
//	SearchTree that returns the height of the tree 
//2.	Define the fullness ratio of a binary tree to be the ratio between
//	its minimum height and its height (given the number
//	of nodes in the tree). For example, the tree in Figure 7.5a has
//	a fullness ratio of 1.00 (its minimum height is 3 and its height
//	is 3) and the tree in Figure 7.6c has a fullness ratio of 0.33 (its
//	minimum height is 3 and its height is 9). Implement a
//	method fRatio to be added to the BinarySearchTree class
//	that returns the fullness ratio of the tree.
//3.    Create an application that generates 10 “random” trees, each
//	with 1,000 nodes (random integers between 1 and 3,000). For
//	each tree output its height, optimal height, and fullness ratio.


public class TreeFullness {

	
	public static void main(String[] args) {
	
		int myNum;
		double fRatio;
		BinarySearchTree<Integer> myTree;
		Random myRando;
		int bestTree = -1;
		double bestRatio = 0;
		
		//Build a 1,000 node tree
		for (int j = 1; j <= 100000; j++)
		{
			myTree = new BinarySearchTree<Integer>();
			myRando = new Random();
			for (int i = 0; i<1000; i++)
			{
				myNum = myRando.nextInt(2999) + 1;	
				myTree.add(myNum);
			}
			if (j % 10000 == 0)
				System.out.println("Random trees analyzed " + j);
			//System.out.println("Tree " + j + " Height = " + myTree.height());
			//System.out.println(myTree.toString());

			fRatio = myTree.balance();
			
			//System.out.println("Balanced Tree " + j + " Height = " + myTree.height());
			//System.out.println(myTree.toString());
			
			//System.out.println("Tree " + j + " fullness ratio " + fRatio);
			
			//System.out.println("\n");
			
			if (fRatio > bestRatio)
			{
				bestRatio = fRatio;
				bestTree = j;
			}
		}
		bestRatio = bestRatio * 100;
		System.out.println("Best tree was " + bestTree + " was " + bestRatio + "% well sorted.");
	}
	
	

}
