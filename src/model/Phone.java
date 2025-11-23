package model;

public class Phone extends Product {
    // Attribute
    private int ram;            // GB
    private int rom;            // GB
    private int battery;        // mAh
    private double screenSize;  // inch
    private String cpu;
    private String color;
    
    // Constructor
	public Phone() {
		super();
	}
	
	public Phone(int ram, int rom, int battery, double screenSize, String cpu, String color) {
		super();
		this.ram = ram;
		this.rom = rom;
		this.battery = battery;
		this.screenSize = screenSize;
		this.cpu = cpu;
		this.color = color;
	}

	public Phone(String productId, String productName, double price, int quantity, Brand brand, int ram, int rom,
			int battery, double screenSize, String cpu, String color) {
		super(productId, productName, price, quantity, brand);
		this.ram = ram;
		this.rom = rom;
		this.battery = battery;
		this.screenSize = screenSize;
		this.cpu = cpu;
		this.color = color;
	}

	// Get/Set 
		public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getRom() {
		return rom;
	}

	public void setRom(int rom) {
		this.rom = rom;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Phone [ram=" + ram + ", rom=" + rom + ", battery=" + battery + ", screenSize=" + screenSize + ", cpu="
				+ cpu + ", color=" + color + ", productName=" + productName + ", price=" + price + ", brand=" + brand
				+ "]";
	}
	

}
