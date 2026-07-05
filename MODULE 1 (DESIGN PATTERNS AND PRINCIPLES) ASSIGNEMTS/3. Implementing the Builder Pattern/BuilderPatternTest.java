public class BuilderPatternTest {

    public static void main(String[] args) {

        System.out.println("=== Builder Pattern Test ===\n");

        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel Core i9-13900K")
                .setRAM("64GB DDR5")
                .setStorage("2TB NVMe SSD")
                .setGPU("NVIDIA RTX 4090")
                .setOperatingSystem("Windows 11")
                .setBluetoothEnabled(true)
                .setWifiEnabled(true)
                .build();

        System.out.println("--- Gaming PC ---");
        gamingPC.displayConfig();

        System.out.println();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel Core i5-12400")
                .setRAM("16GB DDR4")
                .setStorage("512GB SSD")
                .setGPU("Integrated Graphics")
                .setOperatingSystem("Windows 10")
                .setBluetoothEnabled(false)
                .setWifiEnabled(true)
                .build();

        System.out.println("--- Office PC ---");
        officePC.displayConfig();

        System.out.println();

        Computer serverPC = new Computer.Builder()
                .setCPU("AMD EPYC 9654")
                .setRAM("256GB DDR5 ECC")
                .setStorage("10TB HDD RAID")
                .setGPU("None")
                .setOperatingSystem("Ubuntu Server 22.04")
                .setBluetoothEnabled(false)
                .setWifiEnabled(false)
                .build();

        System.out.println("--- Server PC ---");
        serverPC.displayConfig();
    }
}
