package service;

import model.Brand;
import java.util.ArrayList;
import java.util.List;

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
}
