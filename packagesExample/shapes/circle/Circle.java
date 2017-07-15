package shapes.circle;

public class Circle {
    private float radius;
    private static final float PI = 3.141f;
    public Circle (float r) {
        radius = r;
    }
    public float area(){
        return PI*radius*radius;
    }
}
