package ca.ubc.cpsc210.tpd.clock;

// Represents an alarm clock with alarm with alarm time in hrs, mins
public class AlarmClock extends Clock {

    private int alarmHrs;
    private int alarmMins;
    private boolean alarmOn;
    private boolean isAlarmSounding;

    // Constructor
    // EFFECTS: time set to 00:00:00
    // alarm time set to 00:00, alarm is off and is not sounding
    public AlarmClock(){
        super();
        alarmHrs = 0;
        alarmMins = 0;
        alarmOn = false;
        isAlarmSounding = false;
    }


    public int getAlarmHours() {
        return alarmHrs;
    }

    public int getAlarmMins(){
        return alarmMins;
    }

    // Sets the alarm time
    // REQUIRES: 0 <= hrs < 24, 0 <= mins < 60
    // MODIFIES: this
    // EFFECTS: alarm has been set to given time and alarm is on
    public void setAlarmTime(int hrs, int mins){
        alarmHrs = hrs;
        alarmMins = mins;
        alarmOn = true;
    }

    // Turns alarm on or off
    // MODIFIES: this
    // EFFECTS: is ifOn is true, alarm is on, otherwise alarm is
    // off and alarm is not sounding
    public void setAlarm(boolean isOn) {
        alarmOn = isOn;

        if(!alarmOn) {
            isAlarmSounding = false;
        }

    }

    public boolean isAlarmOn(){
        return alarmOn;
    }


    // Is alarm sounding?

    public boolean isSounding(){
        return isAlarmSounding;
    }

    // Tick the clock
    // MODIFIES: this
    // EFFECTS: time on clock is advanced by 1 second; if alarm is set and
    // matches alarm time, alarm is turned on
    @Override
    public void tick() {
        super.tick();

       if (alarmOn && alarmHrs == getHours()
             && alarmMins == getMinutes()){
         isAlarmSounding = true;

       }
    }




}
