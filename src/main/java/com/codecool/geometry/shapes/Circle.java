package com.codecool.geometry.shapes;

public class Circle extends Shape {

    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
        this.PERIMETER_FORMULA = "2×π×r";
        this.AREA_FORMULA = "π×r×r";
        this.parameters = new Object[1][2];
        this.parameters[0][0] = "r";
        this.parameters[0][1] = radius;
//        super(); //super also redundant
//        this.AREA = calculateArea(); //instead of this super()
//        this.PERIMETER = calculatePerimeter();//instead of this super()
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return  2 * Math.PI *radius;
    }
}
