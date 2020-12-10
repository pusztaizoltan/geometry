package com.codecool.geometry;

import com.codecool.geometry.containers.ShapeCollection;
import com.codecool.geometry.shapes.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static ShapeCollection collection;
    static String menu =  "   - MENU:\n" +
                          "1. Add new shape\n" +
                          "2. Show all shapes\n" +
                          "3. Show shape with the largest perimeter\n" +
                          "4. Show shape with the largest area\n" +
                          "5. Show formulas\n" +
                          "Or type quit to exit\n";
    static String[] validShapes = {"circle",  "rectangle",
                                   "triangle", "square",
                                    "equilateralTriangle", "regularPentagon"};



    public static void main(String[] args) {
        collection = new ShapeCollection();
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(menu);
            int menuItem = selectMenuItem(); //final line
            executeSelection(menuItem); //final line

//            collection.addShape(new Circle(2));
//            collection.addShape(new Square(2));
//            collection.addShape(new Rectangle(2, 3));
//            collection.addShape(new Triangle(2, 3, 4));
//            collection.addShape(new RegularPentagon(5));
           // System.out.println(collection);

            //executeSelection(5); //testline
            //break;

        }

    }

    public static int selectMenuItem(){
        Scanner menuOptions = new Scanner(System.in);
        String selectedOption = "";
        do {
            System.out.println("Select option by number from the MENU");
            selectedOption = menuOptions.nextLine();
            if (selectedOption.equals("quit")) {
                System.out.println("Exit Application");
                System.exit(0);
            }
        }
        while ("12345".indexOf(selectedOption) == -1);
        return Integer.parseInt(selectedOption);
    }


    public static String selectShapeToAdd(){
        Scanner shapeOptions = new Scanner(System.in);
        String selectedOption = "";
        do {
            System.out.print("Select shape, which only can be:\n");
            Arrays.stream(validShapes).forEach(i -> System.out.print(i + " "));
            System.out.println();
            selectedOption = shapeOptions.nextLine();
        }
        while (!Arrays.asList(validShapes).contains(selectedOption));
        return selectedOption;
    }

    public static void executeSelection(int option){
        switch (option) {
            case 1:
                String selectedShape = selectShapeToAdd();
                collection.addShape(createShape(selectedShape)); ;
                break;
            case 2:
                collection.generateTable();
                collection.showTable(collection.getShapesTable());
                break;
            case 3:
                System.out.println("Shape with maximum perimeter");
                Shape maxByPerimeter = collection.getLargestShapeByPerimeter();
                String[][] displayLineP = collection.generateLine(maxByPerimeter);
                collection.showTable(displayLineP);
                break;
            case 4:
                System.out.println("Shape with maximum perimeter");
                Shape maxByArea = collection.getLargestShapeByArea();
                String[][] displayLineA = collection.generateLine(maxByArea);
                collection.showTable(displayLineA);
                break;
            case 5:
                String shapeToShowFormula = selectShapeToAdd();
                showFormula(shapeToShowFormula);
            case 0:
                // TODO Exit
                break;
        }
    }
    public static Shape createShape(String shapeType){
        Shape newShape;
        switch (shapeType){
            case "circle":
                double radius = askShapeParameter("add circle radius\n");
                newShape = new Circle(radius);
                System.out.println("\nNew circle added" +
                                   "\n-AREA: " + newShape.calculateArea()+
                                   "\n-PERIMETER: " + newShape.calculatePerimeter() +
                                   "\n");
                break;
            case "rectangle":
                double aSide = askShapeParameter("add A side of the rectangle\n");
                double bSide = askShapeParameter("add B side of the rectangle\n");
                newShape = new Rectangle(aSide, bSide);
                System.out.println("\nNew rectangle added" +
                                   "\n-AREA: " + newShape.calculateArea()+
                                   "\n-PERIMETER: " + newShape.calculatePerimeter() +
                                   "\n");
                break;
            case "triangle":
                double aaSide = askShapeParameter("add A side of the triangle\n");
                double bbSide = askShapeParameter("add B side of the triangle\n");
                double ccSide = 0;
                do {
                    System.out.println("Third side must be shorter than the sum of other two");
                    ccSide = askShapeParameter("add C side of the triangle\n");
                }
                while(!testTriangleValidity(aaSide, bbSide, ccSide) || ccSide == 0);
                newShape = new Triangle(aaSide, bbSide, ccSide);
                System.out.println("\nNew triangle added" +
                                   "\n-AREA: " + newShape.calculateArea()+
                                   "\n-PERIMETER: " + newShape.calculatePerimeter() +
                                   "\n");
                break;
            case "square":
                double side = askShapeParameter("add side of the square\n");
                newShape = new Square(side);
                System.out.println(newShape.calculateArea());
                System.out.println("\nNew square added" +
                                   "\n-AREA: " + newShape.calculateArea()+
                                   "\n-PERIMETER: " + newShape.calculatePerimeter() +
                                   "\n");
                break;
            case "equilateralTriangle":
                double sSide = askShapeParameter("add side of the equilateral triangle\n");
                newShape = new EquilateralTriangle(sSide);
                System.out.println("\nNew triangle added" +
                                   "\n-AREA: " + newShape.calculateArea()+
                                   "\n-PERIMETER: " + newShape.calculatePerimeter() +
                                   "\n");
                break;
            case "regularPentagon":
                double pSide = askShapeParameter("add side of the regular pentagon\n");
                newShape = new RegularPentagon(pSide);
                System.out.println("\nNew pentagon added" +
                                   "\n-AREA: " + newShape.calculateArea()+
                                   "\n-PERIMETER: " + newShape.calculatePerimeter() +
                                   "\n");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + shapeType);
        }
        return newShape;

    }
    public static double askShapeParameter(String parameterDescription){
        Scanner getParameter = new Scanner(System.in);
        String input = "";
        Double parameter = null;
        do {
            System.out.print(parameterDescription + "\n");
            input = getParameter.nextLine();
            try {
                parameter = Double.parseDouble(input);
            } catch (NumberFormatException nfe) {
                System.out.println("invalid input format");
            }
        }
        while (parameter == null || parameter == 0);
        return parameter;
    }

    public static boolean testTriangleValidity(double aaSide, double bbSide, double ccSide){
        double[] sides = new double[]{aaSide, bbSide, ccSide};
        Arrays.sort(sides);
        return sides[2] < sides[0] + sides[1];
    }

    public static void showFormula(String shapeType) {
        switch (shapeType) {
            case "circle":
                System.out.println("PERIMETER: " + new Circle(1).getAreaForShape());
                System.out.println("AREA: " + new Circle(1).getPerimeterForShape());
                break;
            case "rectangle":
                System.out.println("PERIMETER: " + new Rectangle(1, 1).getAreaForShape());
                System.out.println("AREA: " + new Rectangle(1, 1).getPerimeterForShape());
                break;
            case "triangle":
                System.out.println("PERIMETER: " + new Triangle(1, 1, 1).getAreaForShape());
                System.out.println("AREA: " + new Triangle(1, 1, 1).getPerimeterForShape());
                break;
            case "square":
                System.out.println("PERIMETER: " + new Square(1).getAreaForShape());
                System.out.println("AREA: " + new Square(1).getPerimeterForShape());
                break;
            case "equilateralTriangle":
                System.out.println("PERIMETER: " + new EquilateralTriangle(1).getAreaForShape());
                System.out.println("AREA: " + new EquilateralTriangle(1).getPerimeterForShape());
                break;
            case "regularPentagon":
                System.out.println("PERIMETER: " + new RegularPentagon(1).getAreaForShape());
                System.out.println("AREA: " + new RegularPentagon(1).getPerimeterForShape());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + shapeType);
        }
    }
}
