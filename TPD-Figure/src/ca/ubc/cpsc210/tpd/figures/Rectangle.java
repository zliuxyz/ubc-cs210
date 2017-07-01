package ca.ubc.cpsc210.tpd.figures;

import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends AbstractFigure {

	// Constructs a rectangle
	// EFFECTS: rectangle has zero width and height and is at position start
	public Rectangle(Point start) {
		super(start);
	}

	// Does rectangle contain a given point?
	// EFFECTS: returns true if rectangle contains given point; false otherwise
	@Override
	public boolean contains(Point p) {
		return x <= p.x && p.x <= x + width
					&& y <= p.y && p.y <= y + height;
	}
	
	// Draw rectangle
	// MODIFIES: g
	// EFFECTS: draws the rectangle on the given graphics object
	@Override
	public void draw(Graphics g) {
		g.drawRect(x, y, x + width, y + height);
	}
}
