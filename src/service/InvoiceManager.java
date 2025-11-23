package service;

import model.Invoice;
import model.Customer;
import model.Employee;
import model.Product;
import model.Phone;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class InvoiceManager {

    private List<Invoice> invoices = new ArrayList<>();

    // Thêm hóa đơn 
    public void addInvoice(Invoice invoice) {
        if (findById(invoice.getInvoiceId()) != null) {
            System.out.println("Invoice ID đã tồn tại!");
            return;
        }
        invoices.add(invoice);
    }

    // Xóa hóa đơn theo ID
    public boolean removeInvoice(String id) {
        Invoice inv = findById(id);
        if (inv != null) {
            invoices.remove(inv);
            return true;
        }
        return false;
    }

    // Tìm hóa đơn theo ID 
    public Invoice findById(String id) {
        for (Invoice inv : invoices) {
            if (inv.getInvoiceId().equalsIgnoreCase(id)) {
                return inv;
            }
        }
        return null;
    }

    // Tìm hóa đơn theo Customer ID 
    public List<Invoice> findByCustomer(String customerId) {
        List<Invoice> result = new ArrayList<>();
        for (Invoice inv : invoices) {
            if (inv.getCustomer().getId().equalsIgnoreCase(customerId)) {
                result.add(inv);
            }
        }
        return result;
    }

    // Tìm theo ngày
    public List<Invoice> findByDate(LocalDate date) {
        List<Invoice> result = new ArrayList<>();
        for (Invoice inv : invoices) {
            if (inv.getDate().equals(date)) {
                result.add(inv);
            }
        }
        return result;
    }

    // Doanh thu theo ngày 
    public double getRevenueByDate(LocalDate date) {
        double sum = 0;
        for (Invoice inv : invoices) {
            if (inv.getDate().equals(date)) {
                sum += inv.getTotal();
            }
        }
        return sum;
    }

    // Tổng doanh thu 
    public double getTotalRevenue() {
        double sum = 0;
        for (Invoice inv : invoices) {
            sum += inv.getTotal();
        }
        return sum;
    }

    // Lấy hóa đơn 
    public List<Invoice> getAll() {
        return invoices;
    }

    // In hóa đơn 
    public void printAll() {
        if (invoices.isEmpty()) {
            System.out.println("Danh sách hóa đơn trống!");
            return;
        }

        for (Invoice inv : invoices) {
            System.out.println(inv);
        }
    }

    // Ghi 
    public void saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("data/invoice.txt"))) {
            for (Invoice inv : invoices) {

                pw.println(
                        "INV;" +
                        inv.getInvoiceId() + ";" +
                        inv.getCustomer().getId() + ";" +
                        inv.getEmployee().getId() + ";" +
                        inv.getDate()
                );

                inv.getItems().forEach(item -> {
                    Product p = item.getProduct();
                    pw.println("ITEM;" + p.getProductId() + ";" + item.getQuantity());
                });
            }
            System.out.println("Đã lưu Invoice vào file: data/invoice.txt");

        } catch (IOException e) {
            System.out.println("Lỗi ghi file Invoice: " + e.getMessage());
        }
    }

    // Đọc 
    public void loadFromFile(String filename,
                             CustomerManager customerManager,
                             EmployeeManager employeeManager,
                             PhoneManager phoneManager) {

        invoices.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("data/invoice.txt"))) {

            String line;
            Invoice currentInvoice = null;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] arr = line.split(";");
                if (arr.length == 0) continue;

                String type = arr[0];

                if ("INV".equalsIgnoreCase(type)) {
                    if (arr.length < 5) continue;

                    String invoiceId = arr[1];
                    String customerId = arr[2];
                    String employeeId = arr[3];
                    LocalDate date = LocalDate.parse(arr[4]);

                    Customer customer = customerManager.findById(customerId);
                    Employee employee = employeeManager.findById(employeeId);

                    if (customer == null || employee == null) {
                        System.out.println("Không tìm thấy Customer/Employee cho invoice " + invoiceId + " -> bỏ qua");
                        currentInvoice = null;
                        continue;
                    }

                    currentInvoice = new Invoice(invoiceId, customer, employee, date);
                    invoices.add(currentInvoice);
                }

                else if ("ITEM".equalsIgnoreCase(type)) {
                    if (currentInvoice == null) continue;
                    if (arr.length < 3) continue;

                    String productId = arr[1];
                    int quantity = Integer.parseInt(arr[2]);

                    Phone p = phoneManager.findById(productId);
                    if (p == null) {
                        System.out.println("Không tìm thấy Product " + productId +
                                           " cho invoice " + currentInvoice.getInvoiceId());
                        continue;
                    }

                    currentInvoice.addItem(p, quantity);
                }
            }

            System.out.println("Đã đọc Invoice từ file: data/invoice.txt");

        } catch (IOException e) {
            System.out.println("Lỗi đọc file Invoice: " + e.getMessage());
        }
    }
}
