package model;

public class InvoiceItem {

    private Product product;
    private int quantity;

    public InvoiceItem() {
		super();
	}

	public InvoiceItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;

        // Trừ tồn kho
        if (product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);
        } else {
            throw new IllegalArgumentException("Không đủ số lượng trong kho!");
        }
    }

	// Get/Set 
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "InvoiceItem [product=" + product + ", quantity=" + quantity + "]";
	}
    
}
