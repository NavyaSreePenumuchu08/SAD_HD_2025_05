package SOLID;

//import SOLID.DIP_01.SwitchableDevice;

public class DIP_01 {

    /*
     * TASK:
     * The Switch is violating the DIP (Dependency Inversion Principle).
     * Please fix this!
     */
    //Define an abstraction
     public interface SwitchableDevice {
        void turnOn();
        void turnOff();
    }

    //LightBulb implements the interface
    public static class LightBulb implements SwitchableDevice {
        public void turnOn() {
            System.out.println("Light is ON!");
        }
        public void turnOff() {
            System.out.println("Light is OFF!");
        }
    }

    
    //Switch now depends on the interface
    public static class Switch {
        private SwitchableDevice device;

        // this is "Dependency Injection" (composition style)
        public Switch(SwitchableDevice device) {
            this.device = device;
        }

        public void turnOn() {
            device.turnOn();
        }

        public void turnOff() {
            device.turnOff();
        }
    }

    public static void main(String[] args) {
        LightBulb lightBulb = new LightBulb();
        Switch lightSwitch = new Switch(lightBulb);
        lightSwitch.turnOn();
        lightSwitch.turnOff();
    }
}
