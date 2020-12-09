package com.codecool.geometry.shapes;

public class RegularPentagon extends Shape {
    protected final static String PERIMETER_FORMULA = "5×a";
    protected final static String AREA_FORMULA = "a×a/4×(5×(5+2×5^(1/2)))^(1/2)";
    protected double side;

    public RegularPentagon(double side) {
        this.side = side;
//        this.AREA = calculateArea();
//        this.PERIMETER = calculatePerimeter();
//        super(perimeter);
    }

    @Override
    public double calculateArea() {
        return Math.sqrt((5+2*Math.sqrt(5))*5) * side * side / 4;
    }

    @Override
    public double calculatePerimeter() {
    return 5 * side;
    }
}
