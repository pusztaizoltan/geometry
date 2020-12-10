package com.codecool.geometry.shapes;

public class RegularPentagon extends Shape {
    protected double side;

    public RegularPentagon(double side) {
        this.side = side;
        this.PERIMETER_FORMULA = "5×a";
        this.AREA_FORMULA = "a×a/4×(5×(5+2×5^(1/2)))^(1/2)";
        this.parameters = new Object[1][2];
        this.parameters[0][0] = "a";
        this.parameters[0][1] = side;

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
