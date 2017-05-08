package ca.ubc.cpsc210.trafficlightrobust.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TrafficLightGUI extends JPanel {
	private static final int WIDTH = 230;
	private static final int HEIGHT = 325;
	private String[] colours = { "red", "green", "yellow", "purple", "blue" };
	private JComboBox colourCombo;
	private IntersectionGUI intersectionGUI;
	private ImageIcon greenLightImage;
	private ImageIcon yellowLightImage;
	private ImageIcon redLightImage;
	private ImageIcon dohImage;
	private JPanel lightPanel;
	private JLabel imageAsLabel;
	private String lightDirection;

	public TrafficLightGUI(IntersectionGUI intersectGUI, String direction) {
		
		intersectionGUI = intersectGUI;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Add the title to the top of the light
		JLabel titleLabel = new JLabel(direction);
		lightDirection = direction;
		add(titleLabel);

		// Create the selection of light combo box
		colourCombo = new JComboBox(colours);
		colourCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String colourChoice = (String) colourCombo.getSelectedItem();
				intersectionGUI.setLight(lightDirection, colourChoice);
			}
		});
		
		add(colourCombo);

		lightPanel = new JPanel();
		lightPanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		add(lightPanel);

		loadImages();
		setRedLight();
	}

	public void setLight(String colour) {
		if (colour.equals("red"))
			setRedLight();
		else if (colour.equals("yellow"))
			setYellowLight();
		else if (colour.equals("green"))
			setGreenLight();
		else
			setDoh();
	}

	private void setRedLight() {
		removeExistingImage();
		imageAsLabel = new JLabel(redLightImage);
		lightPanel.add(imageAsLabel);
	}

	private void setGreenLight() {
		removeExistingImage();
		imageAsLabel = new JLabel(greenLightImage);
		lightPanel.add(imageAsLabel);
	}

	private void setYellowLight() {
		removeExistingImage();
		imageAsLabel = new JLabel(yellowLightImage);
		lightPanel.add(imageAsLabel);
	}

	private void setDoh() {
		removeExistingImage();
		imageAsLabel = new JLabel(dohImage);
		lightPanel.add(imageAsLabel);
	}

	private void loadImages() {
		String sep = System.getProperty("file.separator");
		greenLightImage = new ImageIcon(System.getProperty("user.dir") + sep
				+ "images" + sep + "green.png");
		redLightImage = new ImageIcon(System.getProperty("user.dir") + sep
				+ "images" + sep + "red.png");
		yellowLightImage = new ImageIcon(System.getProperty("user.dir") + sep
				+ "images" + sep + "yellow.png");
		dohImage = new ImageIcon(System.getProperty("user.dir") + sep
				+ "images" + sep + "doh.jpg");

	}

	private void removeExistingImage() {
		if (imageAsLabel != null)
			lightPanel.remove(imageAsLabel);
	}
}
