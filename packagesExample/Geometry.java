import shapes.circle.Circle;
import shapes.square.Square;

public class Geometry {
    public static void main(String[] arg){
        Circle c = new Circle(10);
        Square s = new Square(20);
        System.out.println("Area of circle = "+c.area());
        System.out.println("Area of square = "+s.area());
    }
}
