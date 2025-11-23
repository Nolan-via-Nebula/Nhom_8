package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    // Attribute
    private String invoiceId;
    private Customer customer;
    private Employee employee;
    private LocalDate date;

    private List<InvoiceItem> items = new ArrayList<>();
    
    // Constructor
    public Invoice() {
		super();
	}

	public Invoice(String invoiceId, Customer customer, Employee employee, LocalDate date, List<InvoiceItem> items) {
		super();
		this.invoiceId = invoiceId;
		this.customer = customer;
		this.employee = employee;
		this.date = date;
		this.items = new ArrayList<>();
	}

	// Thêm item
    public void addItem(Product product, int quantity) {
        InvoiceItem item = new InvoiceItem(product, quantity);
        items.add(item);
    }

    // Tổng tiền
    public double getTotal() {
        double sum = 0;
        for (InvoiceItem item : items) {
            sum += item.getAmount();
        }
        return sum;
    }

    // Get/Set
    public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

    public List<InvoiceItem> getItems() {
		return items;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== INVOICE =====\n");
        sb.append("ID: ").append(invoiceId).append("\n");
        sb.append("Date: ").append(date).append("\n");
        sb.append("Customer: ").append(customer.getName()).append("\n");
        sb.append("Employee: ").append(employee.getName()).append("\n\n");

        sb.append("Items:\n");
        for (InvoiceItem item : items) {
            sb.append(item).append("\n");
        }

        sb.append("\nTOTAL: ").append(getTotal()).append(" VND\n");
        sb.append("===================\n");

        return sb.toString();
    }

}
