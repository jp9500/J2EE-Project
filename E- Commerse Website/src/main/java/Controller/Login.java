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
import dao.Sellerdao;
import dto.Sellerdto;

@WebServlet("/login")

public class Login extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		Sellerdao dao=new Sellerdao();
		Productdao pdao = new Productdao();
		try 
		{
			Sellerdto dto = dao.findByEmail(email);

			if(dto != null)
			{
				if(dto.getPass().equals(pass))
				{
					HttpSession ses=req.getSession();
					ses.setAttribute("email", email);
					
					req.setAttribute("products",pdao.getAll());
					RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
					rd.include(req, resp);
				}
				else
				{
					req.setAttribute("msg", "Invalid Password...");
					RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
					rd.include(req, resp);
				}
			}
			else
			{
				req.setAttribute("msg", "invalid e-mail");
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