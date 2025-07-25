public class Main {
    public static void main(String[] args) {
        Light bedroomLight = new Light();

        Command lightOn = new LightOnCommand(bedroomLight);
        Command lightOff = new LightOffCommand(bedroomLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton(); // Turns on

        remote.setCommand(lightOff);
        remote.pressButton(); // Turns off
    }
}
