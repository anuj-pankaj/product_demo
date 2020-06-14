package com.demo.product.resources;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.demo.product.util.ProductType;
/**
 * 
 * @author Anuj Pankaj
 * 
 * Database entity to save and retrieval from  DB 
 *
 */
@Entity
public class Product {
	
	@Id
	@Column(name="product_Id")
	private int productId;
	@Column(name="product_Name")
	private String productName;
	@Enumerated(EnumType.STRING)
	@Column(name="product_type")
	private ProductType productType;
	@Column(name="manufacturing_Date")
	private Date manufacturingDate;
	@Column(name="expiry_date")
	private Date expiryDate;
	@Column(name="product_price")
	private long productPrice;
	@Column(name="is_sold")
	private boolean isSold;
	@Column(name="sold_to")
	private String soldTo;

	public Product()
	{
		super();
	}
	public Product(int productId, String productName,ProductType productType, Date manufacturingDate, Date expiryDate, long productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.manufacturingDate = manufacturingDate;
		this.expiryDate = expiryDate;
		this.productPrice = productPrice;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	public Date getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	public boolean isSold() {
		return isSold;
	}
	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}
	public String getSoldTo() {
		return soldTo;
	}
	public void setSoldTo(String soldTo) {
		this.soldTo = soldTo;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + (isSold ? 1231 : 1237);
		result = prime * result + ((manufacturingDate == null) ? 0 : manufacturingDate.hashCode());
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + (int) (productPrice ^ (productPrice >>> 32));
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((soldTo == null) ? 0 : soldTo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (isSold != other.isSold)
			return false;
		if (manufacturingDate == null) {
			if (other.manufacturingDate != null)
				return false;
		} else if (!manufacturingDate.equals(other.manufacturingDate))
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productPrice != other.productPrice)
			return false;
		if (productType != other.productType)
			return false;
		if (soldTo == null) {
			if (other.soldTo != null)
				return false;
		} else if (!soldTo.equals(other.soldTo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productType=" + productType
				+ ", productPrice=" + productPrice + ", isSold=" + isSold + ", soldTo=" + soldTo + "]";
	}
	
}
