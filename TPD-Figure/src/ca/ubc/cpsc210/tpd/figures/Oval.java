package ca.ubc.cpsc210.tpd.figures;

import java.awt.Graphics;
import java.awt.Point;

public class Oval extends AbstractFigure {


	// Constructs a oval
	// EFFECTS: oval has zero width and height and is at position start
	public Oval(Point start) {
		super(start);
	}



	// Does oval contain a given point?
	// EFFECTS: returns true if the oval contains given point; false otherwise
	@Override
	public boolean contains(Point p) {
		final double TOL = 1.0e-6;
		double halfWidth = width / 2.0;
		double halfHeight = height / 2.0;
		double diff = 0.0;

		//[NOTE TO CPSC 210 STUDENTS: don't spend ANY time worrying about
		// why this implementation looks the way it does.  The mathematical
		// details of how we determine if an oval contains a point are
		// not important in the context of this course!]

		if (halfWidth > 0.0)
			diff = diff + sqrDiff(x + halfWidth, p.x) / (halfWidth * halfWidth);
		else
			diff = diff + sqrDiff(x + halfWidth, p.x);

		if (halfHeight > 0.0)
			diff = diff + sqrDiff(y + halfHeight, p.y) / (halfHeight * halfHeight);
		else
			diff = diff + sqrDiff(y + halfHeight, p.y);

		return  diff <= 1.0 + TOL;
	}

	// Draw oval
	// MODIFIES: g
	// EFFECTS: draws the oval on the given graphics object
	@Override
	public void draw(Graphics g) {
		g.drawOval(x, y, x + width, y + height);
	}

	// Compute square of difference
	// EFFECTS: returns the square of the difference of num1 and num2
	private double sqrDiff(double num1, double num2) {
		return (num1 - num2) * (num1 - num2);
	}
}
