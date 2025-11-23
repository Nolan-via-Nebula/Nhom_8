package main;

import java.util.Scanner;
import java.time.LocalDate;

import model.*;
import service.*;

public class Main {

    public static void main(String[] args) {

        Store store = new Store();
        Scanner sc = new Scanner(System.in);

        store.loadAllFromFiles();

        int choice;

        do {
            System.out.println("\n===== MENU CHÍNH =====");
            System.out.println("1. Quản lý Điện thoại");
            System.out.println("2. Quản lý Thương hiệu");
            System.out.println("3. Quản lý Khách hàng");
            System.out.println("4. Quản lý Nhân viên");
            System.out.println("5. Tạo và quản lý Hóa đơn");
            System.out.println("6. Thống kê doanh thu");
            System.out.println("7. In toàn bộ dữ liệu");
            System.out.println("8. Lưu dữ liệu ra file");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:
                phoneMenu(store, sc);
                break;

            case 2:
                brandMenu(store, sc);
                break;

            case 3:
                customerMenu(store, sc);
                break;

            case 4:
                employeeMenu(store, sc);
                break;

            case 5:
                invoiceMenu(store, sc);
                break;

            case 6:
                System.out.println("Tổng doanh thu: " + store.getTotalRevenue());
                break;

            case 7:
                store.printAllData();
                break;

            case 8:
                store.saveAllToFiles();
                break;

            case 0:
                System.out.println("Thoát chương trình.");
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);

        sc.close();
    }

    // Menu Phone 
    private static void phoneMenu(Store store, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- Quản lý Điện thoại ---");
            System.out.println("1. Thêm");
            System.out.println("2. Xóa");
            System.out.println("3. Tìm kiếm");
            System.out.println("4. In danh sách");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");

            c = sc.nextInt();
            sc.nextLine();

            switch (c) {
            case 1:
                System.out.print("ID: ");
                String id = sc.nextLine();
                System.out.print("Tên: ");
                String name = sc.nextLine();
                System.out.print("Giá: ");
                double price = sc.nextDouble();
                sc.nextLine();

                System.out.print("Số lượng: ");
                int quantity = sc.nextInt();
                sc.nextLine();

                System.out.print("RAM: ");
                int ram = sc.nextInt();
                System.out.print("ROM: ");
                int rom = sc.nextInt();
                System.out.print("Pin: ");
                int battery = sc.nextInt();
                System.out.print("Màn hình: ");
                double screen = sc.nextDouble();
                sc.nextLine();

                System.out.print("CPU: ");
                String cpu = sc.nextLine();
                System.out.print("Màu: ");
                String color = sc.nextLine();

                System.out.print("ID Brand: ");
                String bid = sc.nextLine();
                Brand b = store.getBrandManager().findById(bid);

                if (b == null) {
                    System.out.println("Brand không tồn tại!");
                    break;
                }

                Phone p = new Phone(id, name, price, quantity, b, ram, rom, battery, screen, cpu, color);
                store.getPhoneManager().addPhone(p);
                break;

            case 2:
                System.out.print("Nhập ID để xóa: ");
                store.getPhoneManager().removePhone(sc.nextLine());
                break;

            case 3:
                System.out.print("Nhập tên tìm kiếm: ");
                store.getPhoneManager().findByName(sc.nextLine()).forEach(System.out::println);
                break;

            case 4:
                store.getPhoneManager().printAll();
                break;
            }

        } while (c != 0);
    }

    // Menu Brand 
    private static void brandMenu(Store store, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- Quản lý Brand ---");
            System.out.println("1. Thêm");
            System.out.println("2. Xóa");
            System.out.println("3. Tìm kiếm");
            System.out.println("4. In danh sách");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");

            c = sc.nextInt();
            sc.nextLine();

            switch (c) {
            case 1:
                System.out.print("ID: ");
                String id = sc.nextLine();
                System.out.print("Tên hãng: ");
                String name = sc.nextLine();
                System.out.print("Quốc gia: ");
                String country = sc.nextLine();

                store.getBrandManager().addBrand(new Brand(id, name, country));
                break;

            case 2:
                System.out.print("Nhập ID để xóa: ");
                store.getBrandManager().removeBrand(sc.nextLine());
                break;

            case 3:
                System.out.print("Nhập tên tìm kiếm: ");
                store.getBrandManager().findByName(sc.nextLine()).forEach(System.out::println);
                break;

            case 4:
                store.getBrandManager().printAll();
                break;
            }

        } while (c != 0);
    }

    // Menu Customer 
    private static void customerMenu(Store store, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- Quản lý Khách hàng ---");
            System.out.println("1. Thêm");
            System.out.println("2. Xóa");
            System.out.println("3. Tìm kiếm");
            System.out.println("4. In danh sách");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            c = sc.nextInt();
            sc.nextLine();

            switch (c) {
            case 1:
                System.out.print("ID: ");
                String id = sc.nextLine();
                System.out.print("Tên: ");
                String name = sc.nextLine();
                System.out.print("SĐT: ");
                String phone = sc.nextLine();

                store.getCustomerManager().addCustomer(new Customer(id, name, phone));
                break;

            case 2:
                System.out.print("Nhập ID để xóa: ");
                store.getCustomerManager().removeCustomer(sc.nextLine());
                break;

            case 3:
                System.out.print("Nhập tên tìm kiếm: ");
                store.getCustomerManager().findByName(sc.nextLine()).forEach(System.out::println);
                break;

            case 4:
                store.getCustomerManager().printAll();
                break;
            }

        } while (c != 0);
    }

    // Menu Employee 
    private static void employeeMenu(Store store, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- Quản lý Nhân viên ---");
            System.out.println("1. Thêm");
            System.out.println("2. Xóa");
            System.out.println("3. Tìm kiếm");
            System.out.println("4. In danh sách");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            c = sc.nextInt();
            sc.nextLine();

            switch (c) {
            case 1:
                System.out.print("ID: ");
                String id = sc.nextLine();
                System.out.print("Tên: ");
                String name = sc.nextLine();
                System.out.print("SĐT: ");
                String phone = sc.nextLine();
                System.out.print("Chức vụ: ");
                String position = sc.nextLine();
                System.out.print("Lương: ");
                double salary = sc.nextDouble();
                sc.nextLine();

                store.getEmployeeManager().addEmployee(new Employee(id, name, phone, position, salary));
                break;

            case 2:
                System.out.print("Nhập ID để xóa: ");
                store.getEmployeeManager().removeEmployee(sc.nextLine());
                break;

            case 3:
                System.out.print("Nhập tên tìm kiếm: ");
                store.getEmployeeManager().findByName(sc.nextLine()).forEach(System.out::println);
                break;

            case 4:
                store.getEmployeeManager().printAll();
                break;
            }

        } while (c != 0);
    }

    // Menu Invoice  
    private static void invoiceMenu(Store store, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- Quản lý Hóa đơn ---");
            System.out.println("1. Tạo hóa đơn");
            System.out.println("2. Xóa hóa đơn");
            System.out.println("3. Tìm hóa đơn");
            System.out.println("4. In danh sách hóa đơn");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");

            c = sc.nextInt();
            sc.nextLine();

            switch (c) {
            case 1:
                System.out.print("ID hóa đơn: ");
                String invoiceId = sc.nextLine();

                System.out.print("ID khách hàng: ");
                String cid = sc.nextLine();
                Customer customer = store.getCustomerManager().findById(cid);

                System.out.print("ID nhân viên: ");
                String eid = sc.nextLine();
                Employee employee = store.getEmployeeManager().findById(eid);

                if (customer == null || employee == null) {
                    System.out.println("Sai thông tin!");
                    break;
                }

                Invoice inv = new Invoice(invoiceId, customer, employee, LocalDate.now());

                int addMore;
                do {
                    System.out.print("ID điện thoại: ");
                    String pid = sc.nextLine();
                    Product pr = store.getPhoneManager().findById(pid);

                    if (pr == null) {
                        System.out.println("Không có sản phẩm!");
                        break;
                    }

                    System.out.print("Số lượng: ");
                    int qty = sc.nextInt();
                    sc.nextLine();

                    inv.addItem(pr, qty);

                    System.out.print("Nhập thêm? (1=Yes, 0=No): ");
                    addMore = sc.nextInt();
                    sc.nextLine();

                } while (addMore != 0);

                store.getInvoiceManager().addInvoice(inv);
                break;

            case 2:
                System.out.print("Nhập ID để xóa: ");
                store.getInvoiceManager().removeInvoice(sc.nextLine());
                break;

            case 3:
                System.out.print("Nhập ID tìm kiếm: ");
                Invoice found = store.getInvoiceManager().findById(sc.nextLine());
                System.out.println(found != null ? found : "Không tìm thấy!");
                break;

            case 4:
                store.getInvoiceManager().printAll();
                break;
            }

        } while (c != 0);
    }
}
