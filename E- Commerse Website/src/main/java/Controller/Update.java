package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Productdao;
import dto.Productdto;

@WebServlet("/update")
public class Update extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		HttpSession ses=req.getSession();
		String email=(String)ses.getAttribute("email");
		try {
			if(email != null) 
			{
			Productdao pdao=new Productdao();
			Productdto products=pdao.findById(id);
			req.setAttribute("products", products);
			RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
			rd.include(req, resp);
			}
			else 
			{
				req.setAttribute("msg", "login Required");
				RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
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