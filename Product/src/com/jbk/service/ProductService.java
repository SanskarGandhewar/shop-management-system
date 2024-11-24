package com.jbk.service;

import java.util.ArrayList;

import com.jbk.dao.ProductDao;
import com.jbk.entity.Product;

public class ProductService
{
	public static ArrayList<Product> loadAllProductDetails()
	{
		ArrayList<Product> listpro=ProductDao.fetchAllProductDetails();
		return listpro;	
	}
	
	public static Product loadProductDetailsById(int proId)
	{
		Product productNew=new Product();
		ArrayList<Product> listpro =ProductDao.fetchAllProductDetails();
		for (Product product : listpro) 
		{
			if(proId==product.getProId())
			{
				productNew.setProId(product.getProId());
				productNew.setProName(product.getProName());
				productNew.setProPrice(product.getProPrice());
				productNew.setProQuantity(product.getProQuantity());
			}
		}
		if(productNew.getProName()==null)
		{
		productNew.setProName("NOT EXITS please enter another product ID");
		}
		return productNew;
		
	}

	public static Product loadProductDetailsByName(String proName)
	{
		Product productNew=new Product();
		ArrayList<Product> listpro=ProductDao.fetchAllProductDetails();
		for (Product product : listpro) 
		{
			if(proName.equals(product.getProName()))
			{
				productNew.setProId(product.getProId());
				productNew.setProName(product.getProName());
				productNew.setProPrice(product.getProPrice());
				productNew.setProQuantity(product.getProQuantity());
			}
		}
		if(productNew.getProName()==null)
		{
			productNew.setProName("NOT EXITS please enter another product Name");
		}
		return productNew;
		
	}

	public static ArrayList<Product> identifyProductAbovePrice(int proPrice)
	{
		ArrayList<Product> listpro=ProductDao.fetchAllProductDetails();
		ArrayList<Product> abovePrice=new ArrayList<>();
		for (Product product : listpro) 
		{
			if(product.getProPrice() > proPrice)
			{
				abovePrice.add(product);
			}
		}
		if(abovePrice.isEmpty())
		{
			Product noMatch=new Product();
			noMatch.setProName("No product exists in the given price");
			abovePrice.add(noMatch);
		}
		return abovePrice;
		
	}
	
	public static ArrayList<Product> identifyProductBelowPrice(int proPrice)
	{
		ArrayList<Product> listpro=ProductDao.fetchAllProductDetails();
		ArrayList<Product> abovePrice=new ArrayList<>();
		for (Product product : listpro) 
		{
			if(product.getProPrice() < proPrice)
			{
				abovePrice.add(product);
			}
		}
		if(abovePrice.isEmpty())
		{
			Product noMatch=new Product();
			noMatch.setProName("No product exists in the given price");
			abovePrice.add(noMatch);
		}
		return abovePrice;
		
	}
	
	public static ArrayList<Product> loadAboveProductQuantity(int proQuantity)
	{
		ArrayList<Product> listpro=ProductDao.fetchAllProductDetails();
		ArrayList<Product> aboveQuantity=new ArrayList<>();
		for (Product product : listpro) 
		{
			if(product.getProQuantity() > proQuantity)
			{
				aboveQuantity.add(product);
			}
		}
		if(aboveQuantity.isEmpty())
		{
			Product noMatch=new Product();
			noMatch.setProName("No product exists in the given Quantity");
			aboveQuantity.add(noMatch);
		}
		return aboveQuantity;	
	}
	
	public static ArrayList<Product> loadBelowProductQuantity(int proQuantity)
	{
		ArrayList<Product> listpro=ProductDao.fetchAllProductDetails();
		ArrayList<Product> belowQuantity=new ArrayList<>();
		for (Product product : listpro) 
		{
			if(product.getProQuantity() < proQuantity)
			{
				belowQuantity.add(product);
			}
		}
		if(belowQuantity.isEmpty())
		{
			Product noMatch=new Product();
			noMatch.setProName("No product exists in the given Quantity");
			belowQuantity.add(noMatch);
		}
		return belowQuantity;	
	}
	
	public static ArrayList<Product> deleteProductDetailAboveQuantity(int proQuantity) 
	{
		ArrayList<Product> listpro=ProductDao.fetchAllProductDetails();
		ArrayList<Product> productTODelete=new ArrayList<Product>();
		for (Product product : listpro) 
		{
			if(product.getProQuantity()>proQuantity)
			{
				productTODelete.add(product);
			}
		}
		if(productTODelete.isEmpty())
		{
			System.out.println("No Product found with above Quantity"+proQuantity);
			return productTODelete;
		}
		ProductDao.deleteProduct(productTODelete);
		return productTODelete;
		
	}
}
