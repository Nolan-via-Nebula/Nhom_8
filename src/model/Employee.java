package model;

public class Employee extends Person {
    // Attribute
    private String position;
    private double salary;
    
    // Constructor
    public Employee() {
        super();
    }
        
    public Employee(String id, String name, String phoneNumber) {
        super(id, name, phoneNumber);
    }

    public Employee(String id, String name, String phoneNumber, String position, double salary) {
        super(id, name, phoneNumber);
        this.position = position;
        this.salary = salary;
    }

    // Get/Set
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override
    public String getRole() {
        return "Employee";
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s | %s | %s | %,d VND",
                getId(), getName(), position, getPhoneNumber(), (long) salary
        );
    }
}