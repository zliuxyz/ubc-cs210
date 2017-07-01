package ca.ubc.cpsc210.trafficlightrobust.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ca.ubc.cpsc210.trafficlightrobust.model.Intersection;
import ca.ubc.cpsc210.trafficlightrobust.model.exceptions.TrafficLightException;

@SuppressWarnings("serial")
public class IntersectionGUI extends JFrame {

	private Container content;
	private Intersection trafficIntersection;

	private static final String NS = "North-South";
	private static final String EW = "East-West";

	private TrafficLightGUI northSouthTrafficLightArea;
	private TrafficLightGUI eastWestTrafficLightArea;
	
	private JLabel messageArea;

	public IntersectionGUI() {
		super("Intersection User Interface");

		// Ensure X on window causes application to exit
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});

		content = getContentPane();
		// Create the intersection and GUI for intersection
		createIntersection();

		JButton advanceButton = new JButton("Advance");
		advanceButton.setActionCommand("advance");
		advanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					trafficIntersection.advanceLights();
					drawLights();
					messageArea.setText("All systems good to go!");
			}
		});
		
		add(advanceButton, BorderLayout.SOUTH);
		
		messageArea = new JLabel("All systems good to go!");
		add(messageArea, BorderLayout.NORTH);
		pack();
		setVisible(true);
	}

	public void setLight(String direction, String colour) { 
		try {
			if (direction.equals(NS))
				trafficIntersection.setNorthSouthLightColour(colour);
			else if (direction.equals(EW))
				trafficIntersection.setEastWestLightColour(colour);

			drawLights();
			messageArea.setText("All systems good to go!");
		} catch (TrafficLightException e) {
			messageArea.setText(e.getMessage());
		}
//		catch (ColourException e) {
//			messageArea.setText(e.getMessage());
//		} catch (SequenceException e) {
//			messageArea.setText(e.getMessage());
//		}
	}

	private void createIntersection() {
		trafficIntersection = new Intersection();

		northSouthTrafficLightArea = new TrafficLightGUI(this, NS);
		content.add(northSouthTrafficLightArea, BorderLayout.WEST);

		JPanel emptyArea = new JPanel();
		emptyArea.setPreferredSize(new Dimension(100, 100));
		add(emptyArea, BorderLayout.CENTER);

		eastWestTrafficLightArea = new TrafficLightGUI(this, EW);
		content.add(eastWestTrafficLightArea, BorderLayout.EAST);
	}

	private void drawLights() {
		northSouthTrafficLightArea.setLight(trafficIntersection
				.getNorthSouthLightColour());
		eastWestTrafficLightArea.setLight(trafficIntersection
				.getEastWestLightColour());
		validate();
		repaint();
	}

	public static void main(String[] args) {
		new IntersectionGUI();
	}
}
