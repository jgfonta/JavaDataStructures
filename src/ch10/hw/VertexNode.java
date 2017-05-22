package ch10.hw;

//Vertex Nodes (VertexNode.java)
//----------------------------------------------------------
//|  pointer to next |  Value of vertix |  pointer to edge |
//----------------------------------------------------------

public class VertexNode <T> 
{

	  private T value;
	  private EdgeNode<T> edge;
	  private VertexNode<T> next;
	  private boolean mark;
	  
	  public VertexNode(T value, EdgeNode<T> edge)
	  {
	    this.value = value;
	    this.edge= edge;
	    next = null;
	    mark = false;
	  }
	  
	  public VertexNode(T value)
	  {
	    this.value = value;
	    this.edge= null;
	    next = null;
	    mark = false;
	  }
	 
	  public void setValue(T value)
	  {
		  this.value = value;
	  }
	  
	  public void setMark(boolean mark)
	  {
		  this.mark = mark;
	  }
	  
	  public boolean getMark()
	  {
		  return mark;
	  }
	  
	  public T getValue()
	  {
		  return value;  
	  }
	  
	  public void setEdge(EdgeNode<T> edge)
	  {
		  this.edge = edge;
	  }
	  
	  public EdgeNode<T> getEdge()
	  {
		  return edge;  
	  }
	  
	  public void setNext(VertexNode<T> next)
	  {
		  this.next = next;
	  }
	  
	  public boolean hasNext()
	  {
		  return (next != null);
	  }

	  public VertexNode<T> getnext()
	  {
		  return next;
	  }	
}
