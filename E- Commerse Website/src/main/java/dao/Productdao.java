package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import dto.Productdto;
import dto.Sellerdto;

public class Productdao 
{
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sellerproduct","root","root");
	}
	
	public int saveProduct(Productdto product) throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("insert into product values(?,?,?,?,?,?)");
		pst.setInt(1, product.getId());
		pst.setString(2, product.getName());
		pst.setDouble(3, product.getPrice());
		pst.setString(4, product.getBrand());
		pst.setDouble(5, product.getDiscount());
		
		Blob image=new SerialBlob(product.getImg());
		pst.setBlob(6, image);
		
		return pst.executeUpdate();
	}
	
	public int updateProduct(Productdto product) throws SQLException, ClassNotFoundException
	{
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("update product set name=?, price=?, brand=?, discount=?, img=? where id=?");
		pst.setInt(6, product.getId());
		pst.setString(1, product.getName());
		pst.setDouble(2, product.getPrice());
		pst.setString(3, product.getBrand());
		pst.setDouble(4, product.getDiscount());
		
		Blob image=new SerialBlob(product.getImg());
		pst.setBlob(5, image);
		
		return pst.executeUpdate();
	}
	
	public Productdto findById(int id) throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("Select * from product where id = ? ");
		pst.setInt(1, id);
		
		ResultSet rs=pst.executeQuery();
		
		Productdto p =new Productdto();
		rs.next();

		p.setId(rs.getInt(1));
		p.setName(rs.getString(2));
		p.setPrice(rs.getDouble(3));
		p.setBrand(rs.getString(4));
		p.setDiscount(rs.getDouble(5));
		
		Blob imgblob =rs.getBlob(6);
		byte[] image =imgblob.getBytes(1, (int)imgblob.length());
		p.setImg(image);
		
		conn.close();
		
		return p;
	}
	
	public int deleteById(int id) throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("delete from product where id=?");
		pst.setInt(1, id);
		int ans=pst.executeUpdate();
		conn.close();
		
		return ans;
	}
	
	public List<Productdto> getAll() throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("select * from product");
		ResultSet rs=pst.executeQuery();
		
		List<Productdto> products=new ArrayList<Productdto>();
		while(rs.next())
		{
			Productdto p =new Productdto();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setPrice(rs.getDouble(3));
			p.setBrand(rs.getString(4));
			p.setDiscount(rs.getDouble(5));
			
			Blob imgblob =rs.getBlob(6);
			byte[] image =imgblob.getBytes(1, (int)imgblob.length());
			p.setImg(image);
			
			products.add(p);
			
		}
		return products;
	}
}