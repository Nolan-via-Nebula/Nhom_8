package model;

import java.util.Objects;

public class Brand {
    // Attribute
    private String brandId;
    private String brandName;
    private String country;
    
    // Constructor
	public Brand() {
		super();
	}

	public Brand(String brandId, String brandName, String country) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
		this.country = country;
	}

	// Get/Set
	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
		
	@Override
	public int hashCode() {
		return Objects.hash(brandId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brand other = (Brand) obj;
		return Objects.equals(brandId, other.brandId);
	}

	@Override
	public String toString() {
	    return String.format("[%s] %s | %s", brandId, brandName, country);
	}


	    
}
