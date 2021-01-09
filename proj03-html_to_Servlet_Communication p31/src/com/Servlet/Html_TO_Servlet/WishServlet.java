package com.Servlet.Html_TO_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {//2nd request bexouse of http in param
		//set content type
		PrintWriter pw=null;
		Calendar cal=null;
		int hour=0;
		Date date=new Date();
		
		pw=res.getWriter();
		res.setHeader("refresh", "5");						//refresh page in every one second
		cal=Calendar.getInstance();
		hour=cal.get(Calendar.HOUR_OF_DAY);
		String msg=null;
		String name="VIKAS";
		msg=(hour<=12)?"Good Morning":(hour<=15)?"Good Afternoon":(hour<=18)?"Good Evening":"Good Night";
		//print the msg
		pw.println("<h1 style='color:red'><center>Date : "+date+"</center></h>");
		pw.println("<h1 style='color:red'><center>"+msg+"</center></h>");
		//Generate the hyper link
		pw.println("<br>go to <a href='Page.html'>home page</a>");
		pw.close();
	}
}
