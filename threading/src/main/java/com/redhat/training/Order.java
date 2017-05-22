package com.redhat.training;

import java.math.BigDecimal;


public class Order {

    private Long orderId;
    private String productName;
    private BigDecimal price;
    private BigDecimal tax;
    
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getTax() {
		return tax;
	}
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productName=" + productName
				+ ", price=" + price + ", tax=" + tax + "]";
	}

    
}
