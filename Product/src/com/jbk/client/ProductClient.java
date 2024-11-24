package com.jbk.client;

import java.util.ArrayList;

import com.jbk.controller.ProductController;
import com.jbk.entity.Product;

public class ProductClient
{
	public static void main(String[] args) 
	{
		System.out.println("Fetch All Product from the list");
		ArrayList<Product> listproAll=ProductController.loadAllProduct();
		for (Product product : listproAll) 
		{
			System.out.println(product);
		}
		System.out.println();
		
		System.out.println("Fetch Product by ID");
		Product productId=ProductController.loadProductById(106);
		System.out.println(productId);
		System.out.println();
		
		System.out.println("Fetch Product by Name");
		Product productName=ProductController.loadProductByName("laptop");
		System.out.println(productName);
		System.out.println();
		
		System.out.println("Fetch Product Above Price");
		ArrayList<Product> listproAbovePrice=ProductController.identifyProductabovePrice(100);
		for (Product product : listproAbovePrice)
		{
			System.out.println(product);
		}
		System.out.println();
		
		System.out.println("Fetch Product Below Price");
		ArrayList<Product> listproBelowPrice=ProductController.identifyProductBelowPrice(100);
		for (Product product : listproBelowPrice)
		{
			System.out.println(product);
		}
		System.out.println();
		
		System.out.println("Fetch Product Above Quantity");
		ArrayList<Product> listproAboveQuantity=ProductController.loadProductAboveQuantity(100);
		for (Product product : listproAboveQuantity)
		{
			System.out.println(product);
		}
		System.out.println();
		
		System.out.println("Fetch Product Below Quantity");
		ArrayList<Product> listproBelowQuantity=ProductController.loadProductBelowQuantity(6);
		for (Product product : listproBelowQuantity)
		{
			System.out.println(product);
		}
		System.out.println();
		
		
	}
		
}
