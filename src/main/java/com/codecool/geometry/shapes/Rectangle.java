package com.codecool.geometry.shapes;

public class Rectangle extends Shape {
    protected double aSide;
    protected double bSide;

    public Rectangle(double aSide, double bSide) {
        this.aSide = aSide;
        this.bSide = bSide;
        this.PERIMETER_FORMULA = "2×a+2×b";
        this.AREA_FORMULA = "a×b";
        this.parameters = new Object[2][2];
        this.parameters[0][0] = "a";
        this.parameters[0][1] = aSide;
        this.parameters[1][0] = "b";
        this.parameters[1][1] = bSide;


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
