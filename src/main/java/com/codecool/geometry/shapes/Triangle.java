package com.codecool.geometry.shapes;



public class Triangle extends Shape {
    protected double aSide;
    protected double bSide;
    protected double cSide;

    public Triangle(double aSide, double bSide, double cSide) {
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
        this.PERIMETER_FORMULA = "a+b+c";
        this.AREA_FORMULA = "(s×(s-a)×(s-b)×(s-c)^(1/2)";
        this.parameters = new Object[3][2];
        this.parameters[0][0] = "a";
        this.parameters[0][1] = aSide;
        this.parameters[1][0] = "b";
        this.parameters[1][1] = bSide;
        this.parameters[2][0] = "c";
        this.parameters[2][1] = cSide;

//        this.AREA = calculateArea();
//        this.PERIMETER = calculatePerimeter();
    }

    @Override
    public double calculateArea() {
        double s = (aSide + bSide + cSide)/2;
        double ss = s*(s-aSide)*(s-bSide)*(s-cSide);
        return Math.sqrt(ss);

    }

    @Override
    public double calculatePerimeter() {
        return (aSide + bSide + cSide);
    }
}
