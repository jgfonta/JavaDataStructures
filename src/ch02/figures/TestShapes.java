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

public class TestShapes {


	public static void main(String[] args) {
		FigureInterface myShape;
		
		myShape = new Circle(5D);
		System.out.println(myShape.getClass() +".  Area=" + myShape.area() + " Perimeter=" + myShape.perimeter());
		
		myShape = new IsoscelesTriangle(5D,10D);
		System.out.println(myShape.getClass() +".  Area=" + myShape.area() + " Perimeter=" + myShape.perimeter());

		myShape = new Rectangle(5D,10D);
		System.out.println(myShape.getClass() +".  Area=" + myShape.area() + " Perimeter=" + myShape.perimeter());
		
		myShape = new RightTriangle(5D,10D);
		System.out.println(myShape.getClass() +".  Area=" + myShape.area() + " Perimeter=" + myShape.perimeter());

		myShape = new Square(5D);
		System.out.println(myShape.getClass() +".  Area=" + myShape.area() + " Perimeter=" + myShape.perimeter());

	}

}
