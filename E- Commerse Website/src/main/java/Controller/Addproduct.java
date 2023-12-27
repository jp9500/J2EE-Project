package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Productdao;
import dto.Productdto;

@WebServlet("/ap")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class Addproduct extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		double price=Double.parseDouble(req.getParameter("price"));
		String brand=req.getParameter("brand");
		double discount=Double.parseDouble(req.getParameter("dis"));
		Part img=req.getPart("img");
		
		Productdto p=new Productdto();
		p.setImg(img.getInputStream().readAllBytes());
		p.setId(id);
		p.setName(name);
		p.setPrice(price);
		p.setBrand(brand);
		p.setDiscount(discount);
		
		Productdao dao=new Productdao();
		try {
			int ans=dao.saveProduct(p);
			if(ans==1)
			{
				req.setAttribute("products", dao.getAll());
				RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
				rd.include(req, resp);
			}
			else
			{
				req.setAttribute("ans", "DATA NOT SAVED");
				RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
