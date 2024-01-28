package com.jsp.LoginAndRegistration1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/Login")
public class EmployeeLogin1 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginandregistrations","root","Soumya@123");
			PreparedStatement ps = con.prepareStatement("select * from employee where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				RequestDispatcher rd = req.getRequestDispatcher("Welcome.html");
				rd.forward(req, res);
			}
			else
			{
				PrintWriter pout = res.getWriter();
				pout.println("<h1 style = 'color:red'>invalid credential</h1>");
				RequestDispatcher rd = req.getRequestDispatcher("EmployeeLogin1html.html");
				rd.include(req, res);
				

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
