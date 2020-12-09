package com.codecool.geometry.shapes;

public class Circle extends Shape {
    protected final static String PERIMETER_FORMULA = "2×π×r";
    protected final static String AREA_FORMULA = "π×r×r";
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
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
