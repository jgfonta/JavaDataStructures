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

public class RightTriangle implements FigureInterface {

	double leg1,leg2;

	public RightTriangle (double leg1, double leg2)
	{
		this.leg1 = leg1;
		this.leg2 = leg2;
	}
	
	public double perimeter()
	// Returns perimeter of this figure.
	{
		return (leg1 + leg2 + (Math.sqrt(((leg1*leg1)+(leg2*leg2)))));
	}
	   
	public double area()
	// Returns area of this figure.
	{
		return ((leg1*leg2) / 2);
	}
}
