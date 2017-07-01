package ca.ubc.cpsc210.tpd.figures;

import java.awt.*;
import java.io.File;

/**
 * Created by HardingLiu on 2015-07-15.
 */
public abstract class AbstractFigure implements Figure, Storable {
	protected int x;
	protected int y;
	protected int width;
	protected int height;

	public AbstractFigure(Point start) {
		width = 0;
		height = 0;
		x = start.x;
		y = start.y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	// REQUIRES: w >= 0, h >= 0
	// MODIFIES: this
	// EFFECTS: sets width to w and height to h
	public void setBounds(int w, int h) {
		width = w;
		height = h;
	}

	// REQUIRES: bottomRight.x >= getX(), bottomRight.y >= getY()
	// MODIFIES: this
	// EFFECTS: sets width to (bottomRight.x - getX())
	//          and height to (bottomRight.y - getY())
	public void setBounds(Point bottomRight) {
		width = bottomRight.x - x;
		height = bottomRight.y - y;
	}

	// Translates rectangle
	// MODIFIES: this
	// EFFECTS: rectangle is shifted dx units horizontally and dy units vertically
	public void translate(int dx, int dy) {
		x = x + dx;
		y = y + dy;
	}

	// Does rectangle contain a given point?
	// EFFECTS: returns true if rectangle contains given point; false otherwise
	public abstract boolean contains(Point p);

	// Draw rectangle
	// MODIFIES: g
	// EFFECTS: draws the rectangle on the given graphics object
	public abstract void draw(Graphics g);

	public void toFile(File f) {
		// ...
	}

	public void fromFile(File f) {
		// ...
	}
}
