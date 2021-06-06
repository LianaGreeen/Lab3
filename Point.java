package p.labs;
public class Point {
    private double x;
    private double y;


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point(" + x + "," + y + ')';
    }

    public double resultInPoint(){
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

}
