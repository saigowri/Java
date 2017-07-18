public class Q1 {
	public static void main(String[] arg){
		Rectangle r1 = new Rectangle(10,20);
		Circle c1 = new Circle(10);
		Rectangle r2 = new Rectangle(30,40);
		Circle c2 = new Circle(20);
		Shape[] sh = {r1, r2, c1, c2};
		for(Shape s : sh){
			System.out.println(s.area());
		}
	}
}

interface Shape {
	public abstract float area();
}

class Rectangle implements Shape {
	private float breadth;
	private float length;
	
	public Rectangle(float l, float b){
		this.length = l;
		this.breadth = b;
	}
	
	public float area(){
		System.out.println("Area of rectangle = ");
		return length*breadth;
	}
}

class Circle implements Shape {
	private float radius;
	private final static float PI = 3.14f;
	
	public Circle(float rad){
		this.radius = rad;
	}
	
	public float area(){
		System.out.println("Area of circle = ");
		return PI*radius*radius;
	}
}
