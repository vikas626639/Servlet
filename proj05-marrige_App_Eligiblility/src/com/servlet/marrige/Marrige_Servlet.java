package com.servlet.marrige;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Marrige_Servlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		//set content type
		res.setContentType("text/html");
		//get Writer 
		pw=res.getWriter();
		//read form data
		String name=req.getParameter("name");
		Integer age=Integer.parseInt(req.getParameter("age"));
		if(age<18) {
			pw.println("<center>hey "+name.toUpperCase()+" you are not eligible for marrige</center>");
		}
		else if(age>=50) {
			pw.println("<center>hey "+name.toUpperCase()+" you are above 50 not eligible for marrige</center>");
		}else {
			pw.println("<center><b><color='red'>Hey "+name.toUpperCase()+" you are eligible for marrige</color></b></center><br>");			
		}
		//gethyper link
		pw.println("<a href='input.html'>home page</a>");
		pw.close();
	}
}
