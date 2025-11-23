package service;

import model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

    // Ghi 
    public void saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("data/customer.txt"))) {
            for (Customer c : customers) {
                pw.println(c.getId() + ";" + c.getName() + ";" + c.getPhoneNumber());
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file Customer: " + e.getMessage());
        }
    }

    // Đọc
    public void loadFromFile(String filename) {
        customers.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("data/customer.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(";");
                if (arr.length >= 3) {
                    customers.add(new Customer(arr[0], arr[1], arr[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file Customer: " + e.getMessage());
        }
    }

}
