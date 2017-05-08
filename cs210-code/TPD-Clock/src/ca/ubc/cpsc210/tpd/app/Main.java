package ca.ubc.cpsc210.tpd.app;

import ca.ubc.cpsc210.tpd.clock.AlarmClock;
import ca.ubc.cpsc210.tpd.clock.Clock;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by HardingLiu on 2015-07-15.
 */
public class Main {
    public static void main(String[] args) {
//        Clock clk1 = new Clock();
//        Clock clk2 = new AlarmClock();
//        //Clock clk3 = new String("Clock");
//
//        clk1.tick();   // calls Clock.tick()
//        clk2.tick();   // calls AlarmClock.tick()}

        List<Clock> clocks = new LinkedList<Clock>();

        clocks.add(new Clock());
        clocks.add(new AlarmClock());

        for (Clock next: clocks){
            next.tick();
        }
  }
}
