package com.codecool.geometry.shapes;

import static java.lang.Math.sqrt;

/**
 * This is a abstract class representing geometrical shape.
 */
public abstract class Shape {

    String PERIMETER_FORMULA;
    String AREA_FORMULA;
    Object[][] parameters;
    protected double AREA;
    protected double PERIMETER;


    protected Shape() {
        AREA = calculateArea();
        PERIMETER = calculatePerimeter();
    }

    public abstract double calculateArea(); //Calculates shape's area.

    public abstract double calculatePerimeter(); //Calculates shape's perimeter.


    public Object[][] getParameters(){ return this.parameters;}

    public String getAreaForShape() {return this.AREA_FORMULA;}

    public String getPerimeterForShape() {return this.PERIMETER_FORMULA; }

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
