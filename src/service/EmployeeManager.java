package service;

import model.Employee;
import java.util.ArrayList;
import java.util.List;

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
}
