package TopKElements;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    };

    public int distFromOrigin(){
        return (x * x) + (y * y);
    }
}
