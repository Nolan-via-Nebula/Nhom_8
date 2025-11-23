package service;

import model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {

    private List<Customer> customers = new ArrayList<>();

    // Thêm Customer 
    public void addCustomer(Customer customer) {
        if (findById(customer.getId()) != null) {
            System.out.println("Customer ID đã tồn tại!");
            return;
        }
        customers.add(customer);
    }

    // Xóa Customer theo ID
    public boolean removeCustomer(String id) {
        Customer c = findById(id);
        if (c != null) {
            customers.remove(c);
            return true;
        }
        return false;
    }

    // Cập nhật Customer 
    public boolean updateCustomer(String id, String name, String phone) {
        Customer c = findById(id);
        if (c == null) return false;

        c.setName(name);
        c.setPhoneNumber(phone);
        return true;
    }

    // Tìm theo ID 
    public Customer findById(String id) {
        for (Customer c : customers) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    // Tìm theo tên
    public List<Customer> findByName(String keyword) {
        List<Customer> result = new ArrayList<>();
        for (Customer c : customers) {
            if (c.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(c);
            }
        }
        return result;
    }

    // Lấy danh sách 
    public List<Customer> getAll() {
        return customers;
    }

    // In danh sách 
    public void printAll() {
        if (customers.isEmpty()) {
            System.out.println("Danh sách khách hàng trống!");
            return;
        }

        for (Customer c : customers) {
            System.out.println(c);
        }
    }
}
