package ca.ubc.cpsc210.tpd.app;

import ca.ubc.cpsc210.tpd.figures.*;
import ca.ubc.cpsc210.tpd.figures.Rectangle;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class FigureApp {

	public static void main(String[] args) {
		List<AbstractFigure> figures = new LinkedList<AbstractFigure>();

		figures.add(new Oval(new Point(2, 3)));
		figures.add(new Rectangle(new Point(12, 43)));

		drawFigure(figures.get(0));

		saveFigure(figures.get(0));

		Figure f = new Oval(new Point(4, 5));

		Rectangle r = new Square(new Point(4, 5));

		r.setBounds(300, 30);



	}

	public static void drawFigure(Figure f){
		f.getWidth();

	}

	public static void saveFigure(Storable f){
		f.toFile(null);
	}

}
