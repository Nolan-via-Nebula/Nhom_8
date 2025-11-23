package model;

public abstract class Person {
    // Attribute
    private String id;
    private String name;
    private String phoneNumber;
	
    // Constructor 
    public Person() {
		super();
	}

	public Person(String id, String name, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	// Get/Set
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// Phương thức trừu tượng
    public abstract String getRole();
    
    @Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}
}
