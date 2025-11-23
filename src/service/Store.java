package service;

public class Store {
	// Attribute
    private PhoneManager phoneManager;
    private BrandManager brandManager;
    private CustomerManager customerManager;
    private EmployeeManager employeeManager;
    private InvoiceManager invoiceManager;
	
    // Constructor 
    public Store() {
    	super();
        this.phoneManager = new PhoneManager();
        this.brandManager = new BrandManager();
        this.customerManager = new CustomerManager();
        this.employeeManager = new EmployeeManager();
        this.invoiceManager = new InvoiceManager();
    }
    
    public Store(PhoneManager phoneManager, BrandManager brandManager, CustomerManager customerManager,
			EmployeeManager employeeManager, InvoiceManager invoiceManager) {
		super();
		this.phoneManager = phoneManager;
		this.brandManager = brandManager;
		this.customerManager = customerManager;
		this.employeeManager = employeeManager;
		this.invoiceManager = invoiceManager;
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

    // Thống kê doanh thu tổng 
    public double getTotalRevenue() {
        return invoiceManager.getTotalRevenue();
    }

    // In ra toàn bộ dữ liệu cửa hàng
    public void printAllData() {
        System.out.println("----- DANH SÁCH ĐIỆN THOẠI -----");
        phoneManager.printAll();

        System.out.println("\n----- DANH SÁCH THƯƠNG HIỆU -----");
        brandManager.printAll();

        System.out.println("\n----- DANH SÁCH KHÁCH HÀNG -----");
        customerManager.printAll();

        System.out.println("\n----- DANH SÁCH NHÂN VIÊN -----");
        employeeManager.printAll();

        System.out.println("\n----- DANH SÁCH HÓA ĐƠN -----");
        invoiceManager.printAll();
    }

    // Ghi tất cả dữ liệu ra file txt 
    public void saveAllToFiles() {
        brandManager.saveToFile("data/brand.txt");
        phoneManager.saveToFile("data/phone.txt");
        customerManager.saveToFile("data/customer.txt");
        employeeManager.saveToFile("data/employee.txt");
        invoiceManager.saveToFile("data/invoice.txt");
    }

    // Đọc tất cả dữ liệu từ file txt 
    public void loadAllFromFiles() {
        brandManager.loadFromFile("data/brand.txt");
        phoneManager.loadFromFile("data/phone.txt", brandManager);
        customerManager.loadFromFile("data/customer.txt");
        employeeManager.loadFromFile("data/employee.txt");
        invoiceManager.loadFromFile("data/invoice.txt", customerManager, employeeManager, phoneManager);
    }
}
