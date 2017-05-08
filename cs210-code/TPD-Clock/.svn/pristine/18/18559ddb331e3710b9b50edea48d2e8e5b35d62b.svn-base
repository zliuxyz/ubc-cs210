package ca.ubc.cpsc210.tpd.clock;

// Represents a clock that displays the time in hours, minutes and seconds
public class Clock {
	public static final int SECONDS_PER_MINUTE = 60;
	public static final int MINS_PER_HOUR = 60;
	public static final int HRS_PER_DAY = 24;
	
	private int hours;
	private int minutes;
	private int seconds;
	
	// Constructor
	// EFFECTS: time has been set to 0:00:00
	public Clock() {
		hours = 0;
		minutes = 0;
		seconds = 0;
	}

	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}
	
	// Tick the clock
	// MODIFIES: this
	// EFFECTS: time on clock is advanced by 1 second
	public void tick() {
		seconds++;
		if (seconds >= SECONDS_PER_MINUTE) {
			seconds = 0;
			minutes++;
			
			if (minutes >= MINS_PER_HOUR) {
				minutes = 0;
				hours++;
				
				if (hours >= HRS_PER_DAY) {
					hours = 0;
				}
			}
		}
	}
}
