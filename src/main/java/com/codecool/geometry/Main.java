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
            int menuItem = selectMenuItem();
            //System.out.println(menuItem);
            executeSelection(menuItem);


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
                // TODO Show all shapes
                //By choosing the "Show all shapes" option
                // the table view provided by the shape collection
                // is displayed to the user
                break;
            case 3:
                // TODO Show shape with the largest perimeter
                //By choosing the "Show shape with the largest perimeter"
                // option displays the shape with
                // largest perimeter in the collection
                break;
            case 4:
                // TODO Show shape with the largest area
                //By choosing the "Show shape with the largest area" option
                // displays the shape with largest area in the collection
                break;
            case 5:
                // TODO Show formulas
                //By choosing the "Show formulas" option
                // the user can select from a list of existing shapes
                // (like circle) and after that the stored formulas
                // for that shape class (like Circle area formula: π×r×r,
                // Circle perimeter formula: 2×π×r will be displayed.
                break;
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
            case "rectangle":
                double aSide = askShapeParameter("add A side of the rectangle\n");
                double bSide = askShapeParameter("add B side of the rectangle\n");
                newShape = new Rectangle(aSide, bSide);
                System.out.println("\nNew rectangle added" +
                                   "\n-AREA: " + newShape.calculateArea()+
                                   "\n-PERIMETER: " + newShape.calculatePerimeter() +
                                   "\n");
            case "triangle":
                double aaSide = askShapeParameter("add A side of the triangle\n");
                double bbSide = askShapeParameter("add B side of the triangle\n");
                double ccSide = askShapeParameter("add C side of the triangle\n");
                newShape = new Triangle(aaSide, bbSide, ccSide);
                System.out.println("\nNew triangle added" +
                                   "\n-AREA: " + newShape.calculateArea()+
                                   "\n-PERIMETER: " + newShape.calculatePerimeter() +
                                   "\n");
            case "square":
                double side = askShapeParameter("add side of the square\n");
                newShape = new Square(side);
                System.out.println(newShape.calculateArea());
                System.out.println("\nNew square added" +
                                   "\n-AREA: " + newShape.calculateArea()+
                                   "\n-PERIMETER: " + newShape.calculatePerimeter() +
                                   "\n");
            case "equilateralTriangle":
                double sSide = askShapeParameter("add side of the equilateral triangle\n");
                newShape = new EquilateralTriangle(sSide);
                System.out.println("\nNew triangle added" +
                                   "\n-AREA: " + newShape.calculateArea()+
                                   "\n-PERIMETER: " + newShape.calculatePerimeter() +
                                   "\n");
            case "regularPentagon":
                double pSide = askShapeParameter("add side of the regular pentagon\n");
                newShape = new EquilateralTriangle(pSide);
                System.out.println("\nNew pentagon added" +
                                   "\n-AREA: " + newShape.calculateArea()+
                                   "\n-PERIMETER: " + newShape.calculatePerimeter() +
                                   "\n");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + shapeType);
        }
        return newShape;
        // TODO Add new shape
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
        while (parameter == null);
        return parameter;
    }
}
