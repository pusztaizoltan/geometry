package com.codecool.geometry.shapes;

public class Square extends Rectangle {
	protected final static String PERIMETER_FORMULA = "4×a";
	protected final static String AREA_FORMULA = "a×a";

	public Square(double side) {
		super(side, side);
	}
}
