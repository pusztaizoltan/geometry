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
	public void getShapesTable(){
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

	public void showTable(){
		for (int i = 0; i < table.length - 1; i++) {
			for (int j = 0; j <7; j++) {
				System.out.print('+');
				System.out.print(table[table.length-1][j]);
			}
			System.out.print("+\n");
			for (int j = 0; j <7; j++) {
				System.out.print('|');
				System.out.print(table[i][j]);
			}
			System.out.println('|');
		}
		for (int j = 0; j <7; j++) {
			System.out.print('+');
			System.out.print(table[table.length-1][j]);
		}
		System.out.print("+\n");
	}
}


    //Method getLargestShapeByPerimeter() returns the shape instance
    // with the largest perimeter in the collection

    //Method getLargestShapeByArea() returns the shape instance
    // with the largest area in the collection


