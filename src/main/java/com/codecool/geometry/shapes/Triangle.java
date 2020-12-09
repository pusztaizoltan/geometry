package com.codecool.geometry.shapes;

public class Triangle extends Shape {
    protected final static String PERIMETER_FORMULA = "a+b+c";
    protected final static String AREA_FORMULA = "(s×(s-a)×(s-b)×(s-c)^(1/2)";
    protected double aSide;
    protected double bSide;
    protected double cSide;

    public Triangle(double aSide, double bSide, double cSide) {
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
//        this.AREA = calculateArea();
//        this.PERIMETER = calculatePerimeter();
    }

    @Override
    public double calculateArea() {
        double s = calculatePerimeter()/2;
        return Math.sqrt(s*(s-aSide)*(s-bSide)*(s-cSide));
    }

    @Override
    public double calculatePerimeter() {
        return aSide + bSide + cSide;
    }
}
