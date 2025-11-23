package service;

import model.Brand;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BrandManager {

    private List<Brand> brands = new ArrayList<>();

    // Thêm Brand 
    public void addBrand(Brand brand) {
        if (findById(brand.getBrandId()) != null) {
            System.out.println("Brand ID đã tồn tại!");
            return;
        }
        brands.add(brand);
    }

    // Xóa Brand theo ID 
    public boolean removeBrand(String id) {
        Brand b = findById(id);
        if (b != null) {
            brands.remove(b);
            return true;
        }
        return false;
    }

    // Sửa thông tin Brand
    public boolean updateBrand(String id, String newName, String newCountry) {
        Brand b = findById(id);
        if (b == null) {
            return false;
        }

        b.setBrandName(newName);
        b.setCountry(newCountry);
        return true;
    }

    // Tìm Brand theo ID 
    public Brand findById(String id) {
        for (Brand b : brands) {
            if (b.getBrandId().equalsIgnoreCase(id)) {
                return b;
            }
        }
        return null;
    }

    // Tìm Brand theo tên 
    public List<Brand> findByName(String keyword) {
        List<Brand> result = new ArrayList<>();
        for (Brand b : brands) {
            if (b.getBrandName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }

    // Lấy danh sách
    public List<Brand> getAll() {
        return brands;
    }

    // In danh sách 
    public void printAll() {
        if (brands.isEmpty()) {
            System.out.println("Danh sách brand trống!");
            return;
        }

        for (Brand b : brands) {
            System.out.println(b);
        }
    }

    // Ghi danh sách Brand ra file txt
    public void saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("data/brand.txt"))) {
            for (Brand b : brands) {
                pw.println(b.getBrandId() + ";" + b.getBrandName() + ";" + b.getCountry());
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file Brand: " + e.getMessage());
        }
    }
    
    // Đọc danh sách Brand từ file txt
    public void loadFromFile(String filename) {
        brands.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("data/brand.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(";");
                if (arr.length >= 3) {
                    brands.add(new Brand(arr[0], arr[1], arr[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file Brand: " + e.getMessage());
        }
    }

}
