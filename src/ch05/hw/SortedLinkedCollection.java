//---------------------------------------------------------------------------
// LinkedCollection.java          by Dale/Joyce/Weems               Chapter 5
//
// Implements the CollectionInterface using a linked collection.
// Null elements are not allowed. Duplicate elements are allowed.
// One constructor is provided, one that creates an empty collection.
//---------------------------------------------------------------------------

package ch05.hw;

import support.LLNode;
import ch05.collections.*;

//************************************************
//problem #31
//************************************************
//Create a new collection class named SortedLinkedCollection
//that implements a collection using a sorted linked list.  Include a test
//driver application that demonstrates your class works correctly.


public class SortedLinkedCollection<T> implements CollectionInterface<T>  
{
  protected LLNode<T> head;       // head of the linked list
  protected int numElements = 0;  // number of elements in this collection

  // set by find method
  protected boolean found;        // true if target found, else false
  protected LLNode<T> location;   // node containing target, if found
  protected LLNode<T> previous;   // node preceding location

  public SortedLinkedCollection()
  {
    numElements = 0;
    head = null;
  }

  public boolean add(T element)
  // Adds element to this collection.
  {
    
    //if already exists then fail to add the element
    recFind(element);
    if (found) 
    	return false;

    LLNode<T> newNode = new LLNode<T>(element);
    //not found so add it
    if (location == null)
    {
    	newNode.setLink(head);
    	head = newNode;
    }
    else
    {
    	newNode.setLink(location.getLink());
    	location.setLink(newNode);
    }
   	numElements++;
    return true;
  }

  protected void recFind(T target)
  {
	int result;       // result of the comparison
	location = head;
	found = false;
	previous = null;

	while (location != null) 
	{  
	   result = ((Comparable)target).compareTo(location.getInfo());
	   // Target less than current
	   // Stop searching and set 
	   // location to previous 
	   if (result < 0)
	   {
		   location = previous;
		   return;
	   }
	   // Target greater than current
	   // Get next element and check it
	   else if (result > 0) 
	   {
		   previous = location;
	       location = location.getLink();    
	   }
	   //matched target
	   else               
	   {
		   found = true;
		   return;
	   }
	}
	location = previous;
  }
  
  protected void find(T target)
  // Searches the collection for an occurrence of an element e such that
  // e.equals(target). If successful, sets instance variables
  // found to true, location to node containing e, and previous
  // to the node that links to location. If not successful, sets 
  // found to false.
  {
    location = head;
    found = false;

    while (location != null) 
    {
      if (location.getInfo().equals(target))  // if they match
      {
       found = true;
       return;
      }
      else
      {
        previous = location;
        location = location.getLink();
      }
    }
  }

  public int size()
  // Returns the number of elements on this collection. 
  {
    return numElements;
  }

  public boolean contains (T target)
  // Returns true if this collection contains an element e such that 
  // e.equals(target); otherwise, returns false.
  {
    find(target);
    return found;
  }

  public boolean remove (T target)
  // Removes an element e from this collection such that e.equals(target)
  // and returns true; if no such element exists, returns false.
  {
    find(target);
    if (found)
    {
      if (head == location)     
        head = head.getLink();    // remove first node
      else
        previous.setLink(location.getLink());  // remove node at location

      numElements--;
    }
    return found;
  }

  public T get(T target)
  // Returns an element e from this collection such that e.equals(target);
  // if no such element exists, returns null.
  {
    find(target);    
    if (found)
      return location.getInfo();
    else
      return null;
  }
    
  public boolean isEmpty()
  // Returns true if this collection is empty; otherwise, returns false.
  {
    return (numElements == 0);  
  }

  public boolean isFull()
  // Returns true if this collection is full; otherwise, returns false.
  {
    return false;  // Linked implementation is never full
  }  
  
  @Override
  public String toString()
  {
	//creates and returns a string that correctly
	//represents the current collection. Such a method could
	//prove useful for testing and debugging the class and for testing
	//and debugging applications that use the class. Assume
	//each stored element already provides its own reasonable
	//toString method.
	  String finalString = "";
	  LLNode<T> current;
	  
	  current = head;
	  while (current != null) 
	  {
		  finalString += (current.getInfo()).toString();
		  current = current.getLink();
	  }
	  return finalString;
  }
}
