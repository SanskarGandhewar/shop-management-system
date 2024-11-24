package com.jbk.controller;

import java.util.ArrayList;

import com.jbk.entity.Product;
import com.jbk.service.ProductService;

public class ProductController 
{
	public static ArrayList<Product> loadAllProduct() {
		return ProductService.loadAllProductDetails();	
	}
	
	public static Product loadProductById(int proId) {
		return ProductService.loadProductDetailsById(proId);
	}
	
	public static Product loadProductByName(String proName) {
		return ProductService.loadProductDetailsByName(proName);	
	}
	
	public static ArrayList<Product> identifyProductabovePrice(int proPrice){
		return ProductService.identifyProductAbovePrice(proPrice);
	}
	
	public static ArrayList<Product> identifyProductBelowPrice(int proPrice){
		return ProductService.identifyProductBelowPrice(proPrice);
	}
	
	public static ArrayList<Product> loadProductAboveQuantity(int proQuantity){
		return ProductService.loadAboveProductQuantity(proQuantity);
	}
	
	public static ArrayList<Product> loadProductBelowQuantity(int proQuantity){
		return ProductService.loadBelowProductQuantity(proQuantity);
	}
	
	public static ArrayList<Product> deleteProductAboveQuantity(int proQuantity){
		return ProductService.deleteProductDetailAboveQuantity(proQuantity);
	}

}
