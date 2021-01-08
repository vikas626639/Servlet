package com.Servlet.Date_App;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DateServlet extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//set responce content type
		res.setContentType("text/html");
		//get printWriter
		PrintWriter pw=res.getWriter();
		//write responce
		Date date=new Date();
		//LocalDateTime date=LocalDateTime.now();
		System.out.println(date);
		pw.println("<b><center><font size=7 color=red>Date and time is = "+date+"</font></center></b>");
		//close stream
		pw.close();
	}//method
}//class
