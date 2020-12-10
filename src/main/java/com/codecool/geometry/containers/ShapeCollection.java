package com.codecool.geometry.containers;

import com.codecool.geometry.shapes.Shape;


import java.text.DecimalFormat;


public class ShapeCollection {
	Shape[] collection = new Shape[0];
	String[][] table;

	public ShapeCollection() {
		this.collection = new Shape[0];
	}
	public void addShape(Shape newShape){
		Shape[] newCollection = new Shape[collection.length+1];
		for (int i = 0; i < collection.length; i++) {
			newCollection[i] = collection[i];
		}
		newCollection[collection.length]= newShape;
		collection = newCollection;


	}
	public String[][] getShapesTable(){
		return this.table;
	}
	public Shape getLargestShapeByPerimeter(){
		Shape largestPerimeter = null;
		double perimeter = 0;
		for (Shape s: collection) {
			if (s.calculatePerimeter()>perimeter){
				perimeter = s.calculatePerimeter();
				largestPerimeter = s;
			}
		}
		return largestPerimeter;
	}
	public Shape getLargestShapeByArea(){
		Shape largestArea = null;
		double area = 0;
		for (Shape s: collection) {
			if (s.calculateArea()>area){
				area = s.calculatePerimeter();
				largestArea = s;
			}
		}
		return largestArea;
	}

	public String[][] generateLine(Shape input){
		String[][] lineTable = new String[3][7];
		lineTable[0] = new String[]{"ID","Class","toString","Perimeter","Formula","Area","Formula"};
		lineTable[1][0] = new DecimalFormat("00").format(00);
		lineTable[1][1] = input.getClass().getName().split("\\.")[4];
		lineTable[1][2] = ParametersToString(input);
		lineTable[1][3] = new DecimalFormat("0.00").format(input.calculatePerimeter());
		lineTable[1][4] = input.getPerimeterForShape();
		lineTable[1][5] = new DecimalFormat("0.00").format(input.calculateArea());
		lineTable[1][6] = input.getAreaForShape();
		for (int i = 0; i < 7; i++) {
			int maxWidth = 0;
			for (int j = 0; j < lineTable.length-1; j++) {
				maxWidth = Math.max(maxWidth, lineTable[j][i].length());
			}
			for (int j = 0; j < lineTable.length-1; j++) {
				lineTable[j][i] = " ".repeat(maxWidth - lineTable[j][i].length()+1) + lineTable[j][i] + " ";
			}
			lineTable[2][i] = "-".repeat(maxWidth+2);
		}
		return lineTable;
	}

	public void generateTable(){
		table = new String[collection.length+2][7];
		table[0] = new String[]{"ID","Class","toString","Perimeter","Formula","Area","Formula"};
		for (int i = 1; i <collection.length+1; i++) {
			table[i][0] = new DecimalFormat("00").format(i);
			table[i][1] = collection[i-1].getClass().getName().split("\\.")[4];
			table[i][2] = ParametersToString(collection[i-1]);
			table[i][3] = new DecimalFormat("0.00").format(collection[i-1].calculatePerimeter());
			table[i][4] = collection[i-1].getPerimeterForShape();
			table[i][5] = new DecimalFormat("0.00").format(collection[i-1].calculateArea());
			table[i][6] = collection[i-1].getAreaForShape();
		}
		for (int i = 0; i < 7; i++) {
			int maxWidth = 0;
			for (int j = 0; j < table.length-1; j++) {
				maxWidth = Math.max(maxWidth, table[j][i].length());
			}
			for (int j = 0; j < table.length-1; j++) {
				table[j][i] = " ".repeat(maxWidth - table[j][i].length()+1) + table[j][i] + " ";
			}
			table[collection.length + 1][i] = "-".repeat(maxWidth+2);
		}
	}

	public String ParametersToString(Shape shape){
		String result ="";
		Object[][] params = shape.getParameters();
		for (int i = 0; i < params.length; i++){
			result += ", " + params[i][0] + " = " + new DecimalFormat("0.00").format(params[i][1]);
		}
		return result.substring(2);

	}

	public void showTable(String[][] tableInput){
		for (int i = 0; i < tableInput.length - 1; i++) {
			for (int j = 0; j <7; j++) {
				System.out.print('+');
				System.out.print(tableInput[tableInput.length-1][j]);
			}
			System.out.print("+\n");
			for (int j = 0; j <7; j++) {
				System.out.print('|');
				System.out.print(tableInput[i][j]);
			}
			System.out.println('|');
		}
		for (int j = 0; j <7; j++) {
			System.out.print('+');
			System.out.print(tableInput[tableInput.length-1][j]);
		}
		System.out.print("+\n");
	}
}


