package service;

import model.Invoice;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
}
