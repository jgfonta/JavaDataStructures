package ch10.hw;
import ch10.graphs.*;
import ch04.queues.*;

//Problem #30
//Design and code a reference-based weighted graph class with 
//the vertices stored in a linked list as in Figure 10.7. 
//Your class should implement our WeightedGraphInterface.

// Vertex Nodes (VertexNode.java)
// ----------------------------------------------------------
// |  pointer to next |  Value of vertex |  pointer to edge |
// ----------------------------------------------------------

// Edge Nodes  (EdgeNode.java)
// -----------------------------------------------------------
// |  pointer to next |  Value of edge |  Destination Vertex |
// -----------------------------------------------------------


public class LLGraph<T> implements WeightedGraphInterface<T>
{
  public static final int NULL_EDGE = 0;
  private int numVertices;
  private VertexNode<T> head;

  public LLGraph()
  {
	head = null;
    numVertices = 0;
  }
 
  public boolean isEmpty()
  // Returns true if this graph is empty; otherwise, returns false.
  {
	  return (head == null);
  }

  public boolean isFull()
  // Linked list is never full
  {
	  return false;
  }

  public void addVertex(T vertex)
  // Preconditions:   This graph is not full.
  //                  vertex is not already in this graph.
  //                  vertex is not null.
  //
  // Adds vertex to this graph.
  {
	  
	//Prevent user errors if already exists 
	if (hasVertex(vertex))
		return;

	VertexNode<T> newNode = new VertexNode<T>(vertex);
	if (head == null)
	{
		head = newNode;
	}
	else
	{
		newNode.setNext(head);
		head = newNode;
	}
    numVertices++;
  }

  public boolean hasVertex(T vertex)
  // Returns true if this graph contains vertex; otherwise, returns false.
  {
	 boolean found = false;
	 VertexNode<T> currNode = head;

	 while (currNode != null)
	 {
		 if (currNode.getValue().equals(vertex))
		 {
			 found = true;
			 currNode = null;
		 }
		 else
			 currNode = currNode.getnext();
	 }
     return found;
  }
  
  private VertexNode<T> findVertex(T vertex)
  // Returns true if this graph contains vertex; otherwise, returns false.
  {
	 VertexNode<T> currNode = head;

	 while (currNode != null)
	 {
		 if (currNode.getValue().equals(vertex))
			 return currNode;
		 else
		 currNode = currNode.getnext();
	 }
     return null;
  }


  public void addEdge(T fromVertex, T toVertex, int weight)
  // Adds an edge with the specified weight from fromVertex to toVertex.
  {
    VertexNode<T> currNode, targetNode;
    EdgeNode<T> newEdge, currEdge;
 
	currNode = findVertex(fromVertex);
	targetNode = findVertex(toVertex);
	if (currNode == null || targetNode == null)
	  return;
	
	currEdge = currNode.getEdge();	
	while (currEdge != null)
	{
		if (currEdge.getDestination().getValue().equals(targetNode))
			return;
		currEdge = currEdge.getNext();
	}
	
    newEdge = new EdgeNode<T>(weight, targetNode);
    newEdge.setNext(currNode.getEdge());
    currNode.setEdge(newEdge);
	
	return;
  }

  public int weightIs(T fromVertex, T toVertex)
  // If edge from fromVertex to toVertex exists, returns the weight of edge;
  // otherwise, returns a special “null-edge” value.
  {

	  VertexNode<T> currNode;
	  EdgeNode<T> currEdge;

	  currNode = findVertex(fromVertex);
	  if (currNode == null)
		  return NULL_EDGE;

	  currEdge = currNode.getEdge();	
	  while (currEdge != null)
	  {
		 if (currEdge.getDestination().getValue().equals(toVertex))
			 return currEdge.getValue();
		 currEdge = currEdge.getNext();
	  }
	  return NULL_EDGE;
  
  }

  public QueueInterface<T> getToVertices(T vertex)
  // Returns a queue of the vertices that vertex is adjacent to.
  {
	if (head == null)
		return null;

    QueueInterface<T> adjVertices = new LinkedQueue<T>();
	VertexNode<T> currNode;
	EdgeNode<T> currEdge;

    currNode = findVertex(vertex);
    adjVertices.enqueue(currNode.getValue());
    currEdge = currNode.getEdge();
    while (currEdge != null)
    {
      	//if (!currEdge.getDestination().getValue().equals(currNode.getValue()))
    	adjVertices.enqueue(currEdge.getDestination().getValue());
      	currEdge = currEdge.getNext();
    }

    return adjVertices;
  }

  public void clearMarks()
  // Unmarks all vertices.
  {

	 VertexNode<T> currNode = head;

	 while (currNode != null)
	 {
		 currNode.setMark(false);
		 currNode = currNode.getnext();
	 }

  }

  public void markVertex(T vertex)
  // Marks vertex.
  {
	  VertexNode<T> currNode;

	  currNode = findVertex(vertex);
	  if (currNode != null)
		  currNode.setMark(true);
  }

  public boolean isMarked(T vertex)
  // Returns true if vertex is marked; otherwise, returns false.
  {
	  VertexNode<T> currNode;

	  currNode = findVertex(vertex);
	  if (currNode != null)
		  return currNode.getMark();	  
	  return false;
  }
  
  public T getUnmarked()
  // Returns an unmarked vertex if any exist; otherwise, returns null.
  {
	  VertexNode<T> currNode = head;

	  while (currNode != null)
	  {
		 if (!currNode.getMark())
			 return currNode.getValue();
		 currNode = currNode.getnext();
	  }
	  return null;
  }
  
  public boolean edgeExists(T vertex1, T vertex2)
  // Preconditions:  vertex1 and vertex2 are in the set of vertices
  //
  // Return value = (vertex1, vertex2) is in the set of edges
  {
	  VertexNode<T> currNode;
	  EdgeNode<T> currEdge;

	  currNode = findVertex(vertex1);
	  if (currNode == null)
		  return false;

	  currEdge = currNode.getEdge();	
	  while (currEdge != null)
	  {
		 if (currEdge.getDestination().getValue().equals(vertex2))
			 return true;
		 currEdge = currEdge.getNext();
	  }
	  return false;
  }

  public boolean removeEdge(T vertex1, T vertex2)
  // Preconditions:  vertex1 and vertex2 are in the set of vertices
  //
  // Return value = true if edge was in the graph (and has been removed)
  //              = false if edge was not in the graph
  {    
	VertexNode<T> currNode;
	EdgeNode<T> currEdge, prevEdge;

	currNode = findVertex(vertex1);
	if (currNode == null)
	  return false;

	currEdge = currNode.getEdge();
	prevEdge = null;
	while (currEdge != null)
	{
		 if (currEdge.getDestination().getValue().equals(vertex2))
		 {
			 if (prevEdge == null)
			 {
				currNode.setEdge(currEdge.getNext()); 
			 }
			 else
			 {
				prevEdge.setNext(currEdge.getNext());
			 }
			 return true;
		 }
		 prevEdge = currEdge;
		 currEdge = currEdge.getNext();
	}
	return false;
    
  }
  
}
