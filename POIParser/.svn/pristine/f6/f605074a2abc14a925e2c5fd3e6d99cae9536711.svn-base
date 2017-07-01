package ca.ubc.cpsc210.sustainabilityapp.model;

/**
 * Enum encapsulating the different sustainability features displayed by the tour sites.
 */
public enum Feature {

	BIOFUEL("Biofuel"),
	GEOTHERMAL("Geothermal"),
	LEED_CERTIFICATION("LEED Certification"),
	LOW_IMPACT_MATERIALS("Low Impact Materials"),
	RAINWATER_RECOVERY("Rainwater Recovery"),
	SOLAR_ENERGY("Solar Energy"),
	SUSTAINABLE_AGRICULTURE("Sustainable Agriculture"),
	WASTEWATER_TREATMENT("Wastewater Treatment");

	private String displayName;

	public String getDisplayName() {
		return displayName;
	}

	@Override 
	public String toString() {
		return getDisplayName();
	}

	private  Feature(String displayName) {
		this.displayName = displayName;
	}
	
	public static Feature parseFeature(String displayName) {
		for (Feature f : Feature.values()) {
			if (f.getDisplayName().equals(displayName)) {
				return f;
			}
		}
		throw new IllegalArgumentException("No Feature with displayName: \"" + displayName + "\"");
	}
}
