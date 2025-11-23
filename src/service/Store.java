package service;

public class Store {

    private PhoneManager phoneManager;
    private BrandManager brandManager;
    private CustomerManager customerManager;
    private EmployeeManager employeeManager;
    private InvoiceManager invoiceManager;

    // Constructor 
    public Store() {
        this.phoneManager = new PhoneManager();
        this.brandManager = new BrandManager();
        this.customerManager = new CustomerManager();
        this.employeeManager = new EmployeeManager();
        this.invoiceManager = new InvoiceManager();
    }

    // Get
    public PhoneManager getPhoneManager() {
        return phoneManager;
    }

    public BrandManager getBrandManager() {
        return brandManager;
    }

    public CustomerManager getCustomerManager() {
        return customerManager;
    }

    public EmployeeManager getEmployeeManager() {
        return employeeManager;
    }

    public InvoiceManager getInvoiceManager() {
        return invoiceManager;
    }

    // Tiện ích: Thống kê doanh thu tổng 
    public double getTotalRevenue() {
        return invoiceManager.getTotalRevenue();
    }

    // In ra toàn bộ dữ liệu cửa hàng
    public void printAllData() {
        System.out.println("===== DANH SÁCH ĐIỆN THOẠI =====");
        phoneManager.printAll();

        System.out.println("\n===== DANH SÁCH THƯƠNG HIỆU =====");
        brandManager.printAll();

        System.out.println("\n===== DANH SÁCH KHÁCH HÀNG =====");
        customerManager.printAll();

        System.out.println("\n===== DANH SÁCH NHÂN VIÊN =====");
        employeeManager.printAll();

        System.out.println("\n===== DANH SÁCH HÓA ĐƠN =====");
        invoiceManager.printAll();
    }
}

