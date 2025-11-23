package service;

import model.Phone;
import model.Brand;
import java.util.ArrayList;
import java.util.List;

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
}
