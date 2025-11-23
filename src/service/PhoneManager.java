package service;

import model.Phone;
import model.Brand;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PhoneManager {

    private List<Phone> phones = new ArrayList<>();

    // Thêm Phone 
    public void addPhone(Phone phone) {
        if (findById(phone.getProductId()) != null) {
            System.out.println("ID Phone đã tồn tại!");
            return;
        }
        phones.add(phone);
    }

    // Xóa Phone theo ID 
    public boolean removePhone(String id) {
        Phone p = findById(id);
        if (p != null) {
            phones.remove(p);
            return true;
        }
        return false;
    }

    // Cập nhật Phone 
    public boolean updatePhone(String id, String name, double price, Brand brand,
                               int ram, int rom, int battery,
                               double screenSize, String cpu, String color) {

        Phone p = findById(id);
        if (p == null) return false;

        p.setProductName(name);
        p.setPrice(price);
        p.setBrand(brand);

        p.setRam(ram);
        p.setRom(rom);
        p.setBattery(battery);
        p.setScreenSize(screenSize);
        p.setCpu(cpu);
        p.setColor(color);

        return true;
    }

    // Tìm Phone theo ID
    public Phone findById(String id) {
        for (Phone p : phones) {
            if (p.getProductId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    // Tìm Phone theo tên 
    public List<Phone> findByName(String keyword) {
        List<Phone> result = new ArrayList<>();
        for (Phone p : phones) {
            if (p.getProductName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    // Lấy toàn bộ danh sách 
    public List<Phone> getAll() {
        return phones;
    }

    // In danh sách 
    public void printAll() {
        if (phones.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }

        for (Phone p : phones) {
            System.out.println(p);
        }
    }

    // Ghi
    public void saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("data/phone.txt"))) {
            for (Phone p : phones) {
                pw.println(
                    p.getProductId() + ";" +
                    p.getProductName() + ";" +
                    p.getPrice() + ";" +
                    p.getQuantity() + ";" +
                    p.getBrand().getBrandId() + ";" +
                    p.getRam() + ";" +
                    p.getRom() + ";" +
                    p.getBattery() + ";" +
                    p.getScreenSize() + ";" +
                    p.getCpu() + ";" +
                    p.getColor()
                );
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file Phone: " + e.getMessage());
        }
    }

    // Đọc 
    public void loadFromFile(String filename, BrandManager brandManager) {
        phones.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("data/phone.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(";");

                if (arr.length >= 11) {
                    Brand b = brandManager.findById(arr[4]);
                    if (b == null) continue;

                    phones.add(new Phone(
                        arr[0], arr[1], Double.parseDouble(arr[2]),
                        Integer.parseInt(arr[3]), b,
                        Integer.parseInt(arr[5]), Integer.parseInt(arr[6]),
                        Integer.parseInt(arr[7]), Double.parseDouble(arr[8]),
                        arr[9], arr[10]
                    ));
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file Phone: " + e.getMessage());
        }
    }

}
