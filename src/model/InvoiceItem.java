package model;

public class InvoiceItem {
    // Attribute
    private Product product;
    private int quantity;
    
    // Constructor
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
    
    public double getAmount() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format(
                "%d x (%s) %s : %,d VND",
                quantity,
                product.getProductId(),
                product.getProductName(),
                (long) getAmount()
        );
    }
}
