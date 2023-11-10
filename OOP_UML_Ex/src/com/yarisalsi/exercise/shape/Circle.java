package com.yarisalsi.exercise.shape;

import java.awt.*;

public class Circle extends AbstractShape{
    private Point center;
    private double radius;
    public Circle(String color, String id, Point center, double radius) {
        super(color, id);
        this.center=center;
        this.radius=radius;
    }

    @Override
    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2.0 * Math.PI * radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public void move(Point point) {
        center.translate(point.x, point.y);
    }

    @Override
    public void resize(double d) {
        radius *= d;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
