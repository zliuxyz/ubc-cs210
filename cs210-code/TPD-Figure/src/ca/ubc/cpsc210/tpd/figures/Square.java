package ca.ubc.cpsc210.tpd.figures;

import java.awt.*;

/**
 * WHAT NOT TO DO!!!!!!!!!!!!!!!!!!!!!!!!!
 */
public class Square extends Rectangle {

    public Square(Point start) {
        super(start);
    }

    @Override
    // REQUIRES: w >= 0, h >= 0, w == h
    // MODIFIES: this
    // EFFECTS: sets width to w and height to h
    public void setBounds(int w, int h){
        super.setBounds(w, h);
    }

}
