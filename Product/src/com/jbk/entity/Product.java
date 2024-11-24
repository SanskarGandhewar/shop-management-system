package com.jbk.entity;

public class Product 
{
	private int proId;
	private String proName;
	private int proPrice;
	private int proQuantity;
	
	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public int getProPrice() {
		return proPrice;
	}

	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}

	public int getProQuantity() {
		return proQuantity;
	}

	public void setProQuantity(int proQuantity) {
		this.proQuantity = proQuantity;
	}

	public Product(String proName, int proPrice, int proQuantity) {
		super();
		this.proName = proName;
		this.proPrice = proPrice;
		this.proQuantity = proQuantity;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(int proId, String proName, int proPrice, int proQuantity) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.proPrice = proPrice;
		this.proQuantity = proQuantity;
	}
	@Override
	public String toString() {
		return "Product [proId=" + proId + ", proName=" + proName + ", proPrice=" + proPrice + ", proQuantity="
				+ proQuantity + "]";
	}
	
	
	
	
	
	
}
