public class Computer {

    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;
    private String operatingSystem;
    private boolean bluetoothEnabled;
    private boolean wifiEnabled;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.operatingSystem = builder.operatingSystem;
        this.bluetoothEnabled = builder.bluetoothEnabled;
        this.wifiEnabled = builder.wifiEnabled;
    }

    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public String getGPU() { return GPU; }
    public String getOperatingSystem() { return operatingSystem; }
    public boolean isBluetoothEnabled() { return bluetoothEnabled; }
    public boolean isWifiEnabled() { return wifiEnabled; }

    public void displayConfig() {
        System.out.println("Computer Configuration:");
        System.out.println("  CPU              : " + CPU);
        System.out.println("  RAM              : " + RAM);
        System.out.println("  Storage          : " + storage);
        System.out.println("  GPU              : " + GPU);
        System.out.println("  Operating System : " + operatingSystem);
        System.out.println("  Bluetooth        : " + (bluetoothEnabled ? "Enabled" : "Disabled"));
        System.out.println("  WiFi             : " + (wifiEnabled ? "Enabled" : "Disabled"));
    }

    public static class Builder {

        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;
        private String operatingSystem;
        private boolean bluetoothEnabled;
        private boolean wifiEnabled;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        public Builder setBluetoothEnabled(boolean bluetoothEnabled) {
            this.bluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public Builder setWifiEnabled(boolean wifiEnabled) {
            this.wifiEnabled = wifiEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
