package com.codecool.geometry.shapes;

public class EquilateralTriangle extends Triangle {
	protected final static String PERIMETER_FORMULA = "3×a";
	protected final static String AREA_FORMULA = "a×a×3^(1/3)/4";

	public EquilateralTriangle(double aSide) {
		super(aSide, aSide, aSide);
	}
}
