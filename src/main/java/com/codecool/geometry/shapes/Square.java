package com.codecool.geometry.shapes;

public class Square extends Rectangle {

	public Square(double side) {
		super(side, side);
		this.PERIMETER_FORMULA = "4×a";
		this.AREA_FORMULA = "a×a";
		this.parameters = new Object[1][2];
		this.parameters[0][0] = "a";
		this.parameters[0][1] = side;

	}
}
