package com.codecool.geometry.shapes;


/**
 * This is a abstract class representing geometrical shape.
 */
public abstract class Shape {

    protected static String PERIMETER_FORMULA;
    protected static String AREA_FORMULA;

    protected double AREA;
    protected double PERIMETER;

    protected Shape() {
        AREA = calculateArea();
        PERIMETER = calculatePerimeter();
    }

    public abstract double calculateArea(); //Calculates shape's area.

    public abstract double calculatePerimeter(); //Calculates shape's perimeter.

    public String getAreaForShape() { return PERIMETER_FORMULA;}

    public String getPerimeterForShape() {return AREA_FORMULA; }

    /**
     *
     * Throws IllegalArgumentException if any of the parameters is 0 or less.
     *
     * @param args
     * @return true if all of args are greater than 0
     */
    public static boolean checkIfArgsGreaterThanZero(float... args) {
        return false;
    }
}
