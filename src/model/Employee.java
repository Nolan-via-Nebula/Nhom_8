package model;

public class Employee extends Person{
	// Thuộc tính 
	private String position;
    private double salary;
    // Constructor
    public Employee() {
		super();
	}
    
	public Employee(String id, String name, String phoneNumber, String address) {
		super(id, name, phoneNumber, address);
	}

	public Employee(String position, double salary) {
		super();
		this.position = position;
		this.salary = salary;
	}

	// Override 
	@Override
	public String getRole() {
		return "Employee";
	}
	@Override
	public String toString() {
		return "Employee " + super.toString();
	}

}
