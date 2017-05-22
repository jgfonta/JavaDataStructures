package ch02.figures;

//Create Java classes that implement the FigureInterface interface:
//Square—constructor accepts a single argument of type double which indicates 
//the length of a side of the square

//RightTriangle—constructor accepts two arguments of type double that indicate 
//the lengths of the two legs

//IsoscelesTriangle—constructor accepts two arguments of type double that indicate 
//the height and the base

//Parallelogram—constructor accepts three arguments of type double that indicate
//the height, the base, and the angle between the nonbase side and the base
public class Square implements FigureInterface {

	protected double side;
	
	public Square (double side)
	{
		this.side = side;
	}
	
	public double perimeter()
	// Returns perimeter of this figure.
	{
		//length*4
		return (side*4);
	}
	   
	public double area()
	// Returns area of this figure.
	{
		//a*a
		return (side*side);
	}
	

}
