package shapes.square;

public class Square {
    private float length;
    public Square(float l){
        this.length = l;
    }
    public float area(){
        return length*length;
    }
}
