package model;

public class Employee extends Person{
	
    // Constructor
    public Employee() {
		super();
	}

	public Employee(String id, String name, String phoneNumber, String address) {
		super(id, name, phoneNumber, address);
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
