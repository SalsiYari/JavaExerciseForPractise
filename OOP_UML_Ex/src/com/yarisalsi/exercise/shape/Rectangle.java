package com.yarisalsi.exercise.shape;

import java.awt.*;

public class Rectangle extends AbstractShape{
    private Point bottomRight;
    private Point upperLeft;

    public Rectangle(String color, String id , Point bottomRight, Point upperLeft) {
        super(color, id);
        this.bottomRight=bottomRight;
        this.upperLeft=upperLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public Point getUpperLeft() {
        return upperLeft;
    }

    /*
    this is an important error

    public double getArea() {
        return super.getArea();
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public void move(Point point) {
        super.move(point);
    }

    @Override
    public void resize(double d) {
        super.resize(d);
    }
     */

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
