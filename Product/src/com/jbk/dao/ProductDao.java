package com.jbk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jbk.entity.Product;

public class ProductDao 
{
	public static ArrayList<Product> fetchAllProductDetails()
	{
		ArrayList<Product> listpro =new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","root");
			String sql="Select * from Product";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) 
			{
				int id=resultSet.getInt(1);
				String name=resultSet.getString(2);
				int price=resultSet.getInt(3);
				int Quantity=resultSet.getInt(4);
				Product product = new Product();
				product.setProId(id);
				product.setProName(name);
				product.setProPrice(price);
				product.setProQuantity(Quantity);
				listpro.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listpro;	
	}

	public static void insertProduct(ArrayList<Product> listpro) 
	{
		for (Product product : listpro)
		{
			try {
				product.setProId(product.getProId());
				product.setProName(product.getProName());
				product.setProPrice(product.getProPrice());
				product.setProQuantity(product.getProQuantity());
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","root");
				String sql="insert into Product (proId,proName,proPrice,proQuantity) values ('"+product.getProId()+"','"+product.getProName()+"','"+product.getProPrice()+"','"+product.getProQuantity()+"')";
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				int result=preparedStatement.executeUpdate();
				System.out.println(result);
			
				}catch (Exception e)
				{
					e.printStackTrace();
				}		
		}
	}
	
	public static void deleteProduct(ArrayList<Product> listpro) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "DELETE FROM Product (proId,proName,proPrice,proQuantity) WHERE(?, ?, ?, ?)";		
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			for (Product product : listpro)
			{
				preparedStatement.setInt(1, product.getProId());
				preparedStatement.setString(2, product.getProName());
				preparedStatement.setInt(3, product.getProPrice());
				preparedStatement.setInt(4, product.getProQuantity());
				int result=preparedStatement.executeUpdate();
				if (result > 0) 
				{
					System.out.println("Product with ID " + product.getProId() + " deleted successfully.");
				} else
				{
					System.out.println("No product found with ID " + product.getProId());
				}
			}
				}catch (Exception e)
				{
					e.printStackTrace();
				}
		}
	
	
	public static void UpdateProduct(ArrayList<Product> listpro) 
	{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","root");
				String sql="update Product set proName= ? , proPrice= ? , proQuantity= ? where proId=?";
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				for (Product product : listpro)
				{
					preparedStatement.setInt(1, product.getProId());
					preparedStatement.setString(2, product.getProName());
					preparedStatement.setInt(3, product.getProPrice());
					preparedStatement.setInt(4, product.getProQuantity());
					
					int result=preparedStatement.executeUpdate();
					System.out.println(result);
					
					if (result > 0) {
		                System.out.println("Product with ID " + product.getProId() + " updated successfully.");
		            } else {
		                System.out.println("No product found with ID " + product.getProId());
		            }
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
	}
}
