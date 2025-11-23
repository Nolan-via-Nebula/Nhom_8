package model;

public abstract class Product {
    // Attribute
    protected String productId;
    protected String productName;
    protected double price;
    protected int quantity;
    protected Brand brand;

    // Constructor
	public Product() {
		super();
	}

	public Product(String productId, String productName, double price, int quantity, Brand brand) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
	}

	// Get/Set 
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
    
	// Các phương thức tiện ích 
	public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    public boolean decreaseQuantity(int amount) {
        if (amount > this.quantity) {
            return false; 
        }
        this.quantity -= amount;
        return true;
    }
	
    @Override
    public String toString() {
        return String.format(
            "Product {ID='%s', Name='%s', Price=%.0f, Qty=%d, Brand=%s}",
            productId, productName, price, quantity, brand.getBrandName()
        );
    }

        
}
