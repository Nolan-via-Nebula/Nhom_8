package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Invoice {

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
        this.invoiceId = invoiceId;
        this.customer = customer;
        this.employee = employee;
        this.date = date;
        this.items = items;
    }

    public Invoice(String invoiceId, Customer customer, Employee employee, LocalDate date) {
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

    // Getter – Setter
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

        sb.append("\n------- INVOICE -------\n");
        sb.append(String.format("Invoice ID : %s\n", invoiceId));
        sb.append(String.format("Date       : %s\n", date));
        sb.append(String.format("Customer   : %s\n", customer.getName()));
        sb.append(String.format("Employee   : %s\n\n", employee.getName()));

        sb.append("Items:\n");
        for (InvoiceItem item : items) {
            sb.append(item).append("\n");
        }

        sb.append(String.format("\nTOTAL AMOUNT: %.0f VND\n", getTotal()));
        sb.append("===========================\n");

        return sb.toString();
    }

}
