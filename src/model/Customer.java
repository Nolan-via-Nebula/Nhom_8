package model;

public class Customer extends Person {
    // Constructor
    public Customer() {
		super();
	}

	public Customer(String id, String name, String phoneNumber) {
		super(id, name, phoneNumber);
	}

	// Override 
	@Override
	public String getRole() {
		return "Customer";
	}
	@Override
	public String toString() {
		return "Customer " + super.toString();
	}
	
}
