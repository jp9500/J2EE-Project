package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Sellerdao;
import dto.Sellerdto;

@WebServlet("/signup")

public class SignUp extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		Long contact=Long.parseLong(req.getParameter("con"));
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		Sellerdto seller=new Sellerdto();
		seller.setId(id);
		seller.setName(name);
		seller.setContact(contact);
		seller.setEmail(email);
		seller.setPass(pass);
		
		Sellerdao dao=new Sellerdao();
		try {
			int res=dao.saveSeller(seller);
			if(res==1)
			{
				req.setAttribute("msg", "SignUp Success.......");
				RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
				rd.include(req, resp);
			}
			else 
			{
				req.setAttribute("msg", "SignUp Failed.......");
				RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
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