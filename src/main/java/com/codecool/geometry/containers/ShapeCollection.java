package com.codecool.geometry.containers;

import com.codecool.geometry.shapes.Shape;

public class ShapeCollection {
	Shape[] collection = new Shape[0];

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
	protected void getShapesTable(){
		String[] id = new String[collection.length];

	}

//Implement shapeCollection to manage a list of shapes.
    // The collection can consist of any subtype of Shape.
    //It is possible to add shapes to the collection via the addShape method.

    //Method getShapesTable() returns a printable table with all the shapes in the collection
    // and their parameter values.
    // The table looks like the example in example_table.txt.

    //Method getLargestShapeByPerimeter() returns the shape instance
    // with the largest perimeter in the collection

    //Method getLargestShapeByArea() returns the shape instance
    // with the largest area in the collection

}
