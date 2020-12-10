package com.codecool.geometry.shapes;

public class EquilateralTriangle extends Triangle {

	public EquilateralTriangle(double aSide) {
		super(aSide, aSide, aSide);
		this.PERIMETER_FORMULA = "3×a";
		this.AREA_FORMULA = "a×a×3^(1/3)/4";
		this.parameters = new Object[1][2];
		this.parameters[0][0] = "a";
		this.parameters[0][1] = aSide;

	}
}
