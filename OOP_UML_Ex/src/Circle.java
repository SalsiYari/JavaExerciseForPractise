import java.awt.*;
import java.math.*;

public class Circle {

    Point center;
    int radius;
    public Circle(Point p,int radius){
        center=p;
        this.radius=radius;
    }

    public Point getP() {
        return center;
    }

    public void setP(Point p) {
        this.center = p;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    public double getPerimeter(){
        return radius*2*Math.PI;
    }
    public double getArea(){
        return Math.pow(radius,2) * Math.PI;
    }
    public boolean contains(Point point){
        return Math.hypot(point.x - center.x, point.y - center.y) < radius;
    }
    public void translate(int i, int k){

    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
