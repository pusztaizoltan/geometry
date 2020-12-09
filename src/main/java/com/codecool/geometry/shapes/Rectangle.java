package com.codecool.geometry.shapes;

public class Rectangle extends Shape {
    protected final static String PERIMETER_FORMULA = "2×a+2×b";
    protected final static String AREA_FORMULA = "a×b";
    protected double aSide;
    protected double bSide;

    public Rectangle(double aSide, double bSide) {
        this.aSide = aSide;
        this.bSide = bSide;
//        this.AREA = calculateArea(); //instead of this super()
//        this.PERIMETER = calculatePerimeter(); //instead of this super()
    }


    @Override
    public double calculateArea() {
        return aSide * bSide;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * aSide + 2 * bSide;
    }
}
