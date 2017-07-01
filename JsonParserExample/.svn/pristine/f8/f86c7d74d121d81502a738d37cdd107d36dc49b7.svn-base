package ca.ubc.cpsc210.sustainabilityapp.model;

import java.util.Arrays;
import java.util.List;

public class PointOfInterest {
	private String displayName;
	private String id;
	private LatLong latLong;
	private String description;
	private String address;
	private List<Feature> features;

	public PointOfInterest(String id, String displayName) {
		this.id = id;
		this.displayName = displayName;
	}
	
	public void setFeatures(Feature[] features) {
		this.setFeatures(Arrays.asList(features));
	}

	public void setFeatures(List<Feature> featureList) {
		features = featureList;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getId() {
		return id;
	}
	
	public LatLong getLatLong() {
		return latLong;
	}
	
	public void setLatLong(LatLong latLong) {
		this.latLong = latLong;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
