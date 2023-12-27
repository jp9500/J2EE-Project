package Controller;

import java.io.IOException;
import java.sql.SQLException;

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
@WebServlet("/update1")
@MultipartConfig(maxFileSize = 1024 * 1024*10)
public class Update1 extends HttpServlet
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
		
		Productdao pdao=new Productdao();
		try {
			
				if(img.getSize()>1) 
				{
					pdao.updateProduct(p);
					req.setAttribute("products", pdao.getAll());
					RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
					rd.include(req, resp);
				}
				else 
				{
					Productdto pdto=pdao.findById(id);
					p.setImg(pdto.getImg());
					pdao.updateProduct(p);
					req.setAttribute("products", pdao.getAll());
					RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
					rd.include(req, resp);
				}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}