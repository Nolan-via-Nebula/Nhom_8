package service;

import model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeManager {

    private List<Employee> employees = new ArrayList<>();

    // Thêm Employee 
    public void addEmployee(Employee employee) {
        if (findById(employee.getId()) != null) {
            System.out.println("Employee ID đã tồn tại!");
            return;
        }
        employees.add(employee);
    }

    // Xóa Employee 
    public boolean removeEmployee(String id) {
        Employee e = findById(id);
        if (e != null) {
            employees.remove(e);
            return true;
        }
        return false;
    }

    // Cập nhật Employee 
    public boolean updateEmployee(String id, String name, String phoneNumber,
                                  String position, double salary) {

        Employee e = findById(id);
        if (e == null) return false;

        e.setName(name);
        e.setPhoneNumber(phoneNumber);
        e.setPosition(position);
        e.setSalary(salary);

        return true;
    }

    // Tìm theo ID
    public Employee findById(String id) {
        for (Employee e : employees) {
            if (e.getId().equalsIgnoreCase(id)) {
                return e;
            }
        }
        return null;
    }

    // Tìm theo tên 
    public List<Employee> findByName(String keyword) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(e);
            }
        }
        return result;
    }

    // Lấy danh sách 
    public List<Employee> getAll() {
        return employees;
    }

    // In danh sách
    public void printAll() {
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống!");
            return;
        }
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    // Ghi 
    public void saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("data/employee.txt"))) {
            for (Employee e : employees) {
                pw.println(
                    e.getId() + ";" +
                    e.getName() + ";" +
                    e.getPhoneNumber() + ";" +
                    e.getPosition() + ";" +
                    e.getSalary()
                );
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file Employee: " + e.getMessage());
        }
    }

    // Đọc 
    public void loadFromFile(String filename) {
        employees.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("data/employee.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(";");
                if (arr.length >= 5) {
                    employees.add(
                        new Employee(arr[0], arr[1], arr[2], arr[3], Double.parseDouble(arr[4]))
                    );
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file Employee: " + e.getMessage());
        }
    }

}
