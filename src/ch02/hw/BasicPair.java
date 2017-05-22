package ch02.hw;

//For this problem you must define a simple generic interface PairInterface, 
//and two implementations of the interface, BasicPair and ArrayPair.
//Define a Java interface named PairInterface. A class that implements this 
//interface allows creation of an object that holds a “pair” of objects of a 
//specified type—these are referred to as the “first” object and the “second” 
//object of the pair. We assume that classes implementing PairInterface provide 
//constructors that accept as arguments the values of the pair of objects. 
//The PairInterface interface should require both setters and getters for the 
//first and second objects. The actual type of the objects in the pair is specified 
//when the PairInterface object is instantiated. Therefore, both the PairInterface 
//interface and the classes that implement it should be generic. Suppose a class 
//named BasicPair implements the PairInterface interface. A simple sample 
//application that uses BasicPair is shown here. 
//Its output would be "apple orange."
//public class Sample{   
//   public static void main (String[] args)   
//   {      
//     PairInterface myPair<String> =  new BasicPair<String>("apple", "peach");
//     System.out.print(myPair.getFirst() + " ");      
//     myPair.setSecond("orange");     
//     System.out.println(myPair.getSecond());  
//   }
//}
//
//Create a class called BasicPair that implements the PairInterface interface. 
//This class should use two instance variables, first and second, to represent 
//the two objects of the pair. Create a test driver application that demonstrates 
//that the BasicPair class works correctly.
//
//Create a class called ArrayPair that implements the PairInterface interface. 
//This class should use an array10 of size 2 to represent the two objects of the pair. 
//Create a test driver application that demonstrates that the ArrayPair class works correctly.


public class BasicPair <JFGEN> implements PairInterface<JFGEN> {

	protected JFGEN t1;
	protected JFGEN t2;
	public BasicPair(JFGEN t1, JFGEN t2)
	{
		this.t1 = t1;
		this.t2 = t2;
	}
	
	public void setFirst(JFGEN t1)
	{
		this.t1 = t1;
	}
	
	public void setSecond(JFGEN t2)
	{
		this.t2 = t2;
	}
	
	public JFGEN getFirst()
	{
		return (t1);
	}
	
	public JFGEN getSecond()
	{
		return (t2);
	}
}
