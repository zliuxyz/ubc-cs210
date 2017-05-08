package ca.ubc.cpsc210.tpd.figures;

import java.awt.*;

/**
 * Created by HardingLiu on 2015-07-15.
 */
public interface Figure {
	int getX();

	int getY();

	int getWidth();

	int getHeight();

	// REQUIRES: w >= 0, h >= 0
	// MODIFIES: this
	// EFFECTS: sets width to w and height to h
	void setBounds(int w, int h);

	// REQUIRES: bottomRight.x >= getX(), bottomRight.y >= getY()
	// MODIFIES: this
	// EFFECTS: sets width to (bottomRight.x - getX())
	//          and height to (bottomRight.y - getY())
	void setBounds(Point bottomRight);

	// Translates figure
	// MODIFIES: this
	// EFFECTS: figure is shifted dx units horizontally and dy units vertically
	void translate(int dx, int dy);

	// Does figure contain a given point?
	// EFFECTS: returns true if the figure contains given point; false otherwise
	boolean contains(Point p);

	// Draw figure
	// MODIFIES: g
	// EFFECTS: draws the figure on the given graphics object
	void draw(Graphics g);
}
