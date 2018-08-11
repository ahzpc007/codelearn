package thinking.innerclasses;

public class GreenhouseControls extends Controller{

    private boolean light = false;

    public class LightOn extends Event{

        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "Ligth is on";
        }
    }

    private boolean water = false;

    public class WaterOn extends Event{

        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "water is on";
        }
    }

    private String thermostat = "Day";

    public class ThermostatNight extends Event{

        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "thermostat on night setting";
        }
    }
    public class Bell extends Event{

        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bing";
        }
    }
    public class Restart extends Event{

        public Event[] eventList;
        public Restart(long delayTime,Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for (Event e : eventList){
                addEvent(e);
            }
        }

        @Override
        public void action() {
            for (Event e : eventList){
                addEvent(e);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restarting System";
        }
    }

    public static class Terminate extends Event{
        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            //
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }

    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(0),
                gc.new WaterOn(0)
        };
        gc.addEvent(gc.new Restart(2000,eventList));
        gc.addEvent(new GreenhouseControls.Terminate(0));

        for(Event e : gc.getEventList()){
            System.out.println(e);
        }
        System.out.println("--------");
        gc.run();
    }
}
