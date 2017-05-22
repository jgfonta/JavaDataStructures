package ch10.hw;


//Edge Nodes  (EdgeNode.java)
//-----------------------------------------------------------
//|  pointer to next |  Value of edge |  Destination Vertex |
//-----------------------------------------------------------


public class EdgeNode <T> 
{

	  private int value;
	  private VertexNode<T> destination;
	  private EdgeNode<T> next;
	  
	  public EdgeNode(int value, VertexNode<T> destination)
	  {
	    this.value = value;
	    this.destination = destination;
	    next = null;
	  }
	 
	  public void setValue(int value)
	  {
		  this.value = value;
	  }
	  
	  public int getValue()
	  {
		  return value;  
	  }
	  
	  public void setDestination(VertexNode<T> destination)
	  {
		  this.destination = destination;
	  }
	  
	  public VertexNode<T> getDestination()
	  {
		  return destination;  
	  }
	  
	  public void setNext(EdgeNode<T> next)
	  {
		  this.next = next;
	  }
	  
	  public boolean hasNext()
	  {
		  return (next != null);
	  }
	  
	  public EdgeNode<T> getNext()
	  {
		  return next;
	  }
}
