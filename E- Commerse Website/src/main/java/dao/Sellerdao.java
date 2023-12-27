package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Sellerdto;

public class Sellerdao 
{
	public int saveSeller(Sellerdto s) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sellerproduct","root","root");
		
		PreparedStatement pst=conn.prepareStatement("insert into seller values(?,?,?,?,?)");
		
		pst.setInt(1, s.getId());
		pst.setString(2, s.getName());
		pst.setLong(3, s.getContact());
		pst.setString(4, s.getEmail());
		pst.setString(5, s.getPass());
		
		int ans=pst.executeUpdate();
		conn.close();
		return ans;
	}


	public Sellerdto findByEmail(String email) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sellerproduct","root","root");
		
		PreparedStatement pst=conn.prepareStatement("select * from seller where email = ? ");
		pst.setString(1, email);
		ResultSet rs=pst.executeQuery();
		
		Sellerdto seller = new Sellerdto();
		
		if(rs.next())
		{
			seller.setId(rs.getInt(1));
			seller.setName(rs.getString(2));
			seller.setContact(rs.getLong(3));
			seller.setEmail(rs.getString(4));
			seller.setPass(rs.getString(5));
			conn.close();
			
			return seller;
		}
		else
		{
			return null;
		}
	}
}