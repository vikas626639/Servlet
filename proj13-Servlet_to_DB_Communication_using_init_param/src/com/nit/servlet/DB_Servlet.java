package com.nit.servlet;
//note:- servlet container cretes our servlet class object by using 0-param constructor
//if parameterixed constructor is placed in our servlet class. then 0-param cnstructor will not be generated as default
//constructor by java compiler,so servlet cntainer fails to instantiate our servlet class.this indicated we can't place only parameterized constructor in ourSrvlet class.

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DB_Servlet extends HttpServlet {
	//prepare query
	 static String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement ps;

	public DB_Servlet() {
		System.out.println("DB_Servlet--->0 param constructor");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init() method called");
		try {
			//call servletConfig object 
			ServletConfig cg=getServletConfig();
			String driver=cg.getInitParameter("driver");
			String url=cg.getInitParameter("url");
			String user=cg.getInitParameter("username");
			String pazzword=cg.getInitParameter("password");
			//load driverclass
			Class.forName(driver);
			//eastablish the connection between database
			con=DriverManager.getConnection(url,user,pazzword);
			//prepare statement
			ps=con.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("text/html");
		//get Writer
		PrintWriter pw=res.getWriter();
		//read form Date
		int no=Integer.parseInt(req.getParameter("no"));
		//set param
		try {
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				//EMPNO,ENAME,JOB,SAL
				pw.println("<b><center>");
				pw.println("<h1><font color=red>EMPLOYEE DETAILS</font></h1>");
				pw.println("<table border=1>");
				pw.println("<tr><td>NUMBER ::</td><td>"+rs.getInt(1)+"</td></tr>");
				pw.println("<tr><td>NAME ::</td><td>"+rs.getString(2)+"</td></tr>");
				pw.println("<tr><td>JOB ::</td><td>"+rs.getString(3)+"</td></tr>");
				pw.println("<tr><td>SAL ::</td><td>"+rs.getInt(4)+"</td></tr>");
				pw.println("</table>");
				pw.println("</b></center>");
				pw.println("<a href='input.html'>home page</a>");
			}else {
				pw.println("<b><center><font color=red>RECORD NOT FOUND</b></center>");		
				pw.println("<a href='input.html'>home page</a>");
			}
			pw.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	@Override
	public void destroy() {
		System.out.println("destroy method called");
		try {
			if (ps!=null) 
				ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (con!=null) 
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//destroy

}//class
