package ch02.figures;

//Create Java classes that implement the FigureInterface interface:
//SquareŚconstructor accepts a single argument of type double which indicates 
//the length of a side of the square

//RightTriangleŚconstructor accepts two arguments of type double that indicate 
//the lengths of the two legs

//IsoscelesTriangleŚconstructor accepts two arguments of type double that indicate 
//the height and the base

//ParallelogramŚconstructor accepts three arguments of type double that indicate
//the height, the base, and the angle between the nonbase side and the base
public class IsoscelesTriangle implements FigureInterface {

	double base,height;

	public IsoscelesTriangle (double base, double height)
	{
		this.base = base;
		this.height = height;
	}
	
	public double perimeter()
	// Returns perimeter of this figure.
	{
		return (3 * base);
	}
	   
	public double area()
	// Returns area of this figure.
	{
		return ((base*height) / 2);
	}

}
