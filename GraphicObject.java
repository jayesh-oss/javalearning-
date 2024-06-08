abstract class Shapes{
	abstract double circle(int radius);
	abstract void rectangle();
	void show()
	{
		System.out.println("This is program for Shapes");
	}
}
public class GraphicObject extends Shapes {

	double circle(int radius) {
		return 3.14*radius*radius;
	}

	void rectangle() {
		int height=10;
		int width=15;
		int area=height*width;
		System.out.println("Area of Rectangle:"+area);
		
	}
	
	public static void main(String args[]) {
		GraphicObject ob=new GraphicObject();
		ob.show();
		ob.rectangle();
		double circleArea=ob.circle(10);
		System.out.println("Area of Circle:"+circleArea);
	}

}
