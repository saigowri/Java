public class Enum_ExceptionHandling_Example {
	public enum TriangleType { EQUILATERAL, RIGHTANGLED, ISOSCELES, SCALENE }  
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int[] arr1 = {-1,-2,-3};
		int[] arr2 = {0,0,0};
		int[] arr3 = {1,2};
		int[] arr4 = {5,12,13};
		int[] arr5 = {6,6,6};
		int[] arr6 = {7,5,10};
		int[] arr7 = {7,7,2};
		int[] arr8 = {};
		execute(arr);
		execute(arr1);
		execute(arr2);
		execute(arr3);
		execute(arr4);
		execute(arr5);
		execute(arr6);
		execute(arr7);
		execute(arr8);
	}
	
	public static TriangleType findTriangleType(int[] sides) throws Exception, InvalidTriangleException, InvalidSidesException, EmptyArrayException{
		if(sides.length == 0){
			throw new EmptyArrayException();
		}
		if(sides.length < 3) {
			throw new InvalidTriangleException();
		}
		int a = sides[0];
		int b = sides[1];
		int c = sides[2];
		System.out.println(a+" "+b+" "+c);
		if(a<=0 || b<=0 || c<=0) {
			throw new InvalidSidesException();
		}
		if(!((a+b)>c && (a+c)>b && (b+c)>a)){
			throw new InvalidTriangleException();
		}
		if(a==b && b==c) {
			return TriangleType.EQUILATERAL;
		}
		if(a*a == (b*b + c*c) || b*b == (a*a + c*c) || c*c == (b*b + a*a)) {
			return TriangleType.RIGHTANGLED;
		}
		if(a==b || b==c || c==a) {
			return TriangleType.ISOSCELES;
		}
		if(a!=b && b!=c && c!=a) {
			return TriangleType.SCALENE;
		}
		throw new Exception("None of the conditions matched");
	}
	
	public static void execute(int[] arr){
		try {
			TriangleType key = findTriangleType(arr);
			System.out.println(key.name());
		}
		catch(EmptyArrayException e){
			System.out.println(e.getMessage());
		}
		catch(InvalidSidesException e){
			System.out.println(e.getMessage());
		}
		catch(InvalidTriangleException e){
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
	
class InvalidSidesException extends Exception {
	public InvalidSidesException(){
		super("Sides of triangle cannot be 0 or negative values");
	}
}

class EmptyArrayException extends Exception {
	public EmptyArrayException(){
		super("Empty array");
	}
}

class InvalidTriangleException extends Exception {
	public InvalidTriangleException(){
		super("Not a triangle");
	}
}
