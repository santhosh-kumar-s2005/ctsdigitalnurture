public class HomeAutomationTest {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room");
        Light bedroomLight = new Light("Bedroom");

        Command livingRoomOn = new LightOnCommand(livingRoomLight);
        Command livingRoomOff = new LightOffCommand(livingRoomLight);
        Command bedroomOn = new LightOnCommand(bedroomLight);
        Command bedroomOff = new LightOffCommand(bedroomLight);

        RemoteControl remote = new RemoteControl();

        System.out.println("--- Living Room ---");
        remote.setCommand(livingRoomOn);
        remote.pressButton();

        remote.setCommand(livingRoomOff);
        remote.pressButton();

        System.out.println("\n--- Bedroom ---");
        remote.setCommand(bedroomOn);
        remote.pressButton();

        remote.setCommand(bedroomOff);
        remote.pressButton();
    }
}
