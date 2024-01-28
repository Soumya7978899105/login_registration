package com.jsp.LoginAndRegistration1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/Registration")
public class EmloyeeRegistration1  extends GenericServlet{
	

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String mobilenumber = req.getParameter("mobilenumber");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginandregistrations","root","Soumya@123");
			PreparedStatement ps = con.prepareStatement("insert into employee(id,name,age,email,password,mobilenumber) values(?,?,?,?,?,?)");
			ps.setInt(1, Integer.parseInt(id));
			ps.setString(2, name);
			ps.setInt(3,Integer.parseInt(age));
			ps.setString(4, email);
			ps.setString(5, password);
			ps.setLong(6, Long.parseLong(mobilenumber));
			
			ps.execute();
			
			PrintWriter pout = res.getWriter();
			pout.println("<h1>data saved successfully </h1>");
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
