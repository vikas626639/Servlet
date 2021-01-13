package com.Servlet.Person_Details;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/person")
public class Person_Details_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("text/html");
		//get Writer
		PrintWriter pw=res.getWriter();
		//read form data
		String name=req.getParameter("name").toUpperCase();
		Integer age=Integer.parseInt(req.getParameter("age"));
		String gender=req.getParameter("gen");
		String address=req.getParameter("address");
		String ms=req.getParameter("ms");
		String qlfy=req.getParameter("qlfy");
		String course[]=req.getParameterValues("course");
		String hobbies[]=req.getParameterValues("hb");
		
		//generating number 
		Random ram=new Random();
		Long l=ram.nextLong()+1000000000;

		//writing business logic or request processing logic
		if(gender.equalsIgnoreCase("M")) {
			if(age<=5) {
				pw.println("<b> "+name+" YOU ARE A BEBY BOY</b>");
			}else if(age<=12)
				pw.println("<b> "+name+" YOU ARE A SMALL BOY</b>");
			else if(age<=19) 
				pw.println("<b> "+name+" YOU ARE A TEENAGE BOY</b>");
			else if(age<=35) 
				pw.println("<b> "+name+" YOU ARE A YOUNG MAN</b>");
			else if(age<=50) 
				pw.println("<b> "+name+" YOU ARE A MIDDLE AGE MAN</b>");
			else
				pw.println("<b> "+name+" YOU ARE A SENIER CITIGEN</b>");
		}else if(gender.equalsIgnoreCase("F")) {
			if(age<=5) 
				pw.println("<b> "+name+" YOU ARE A BEBY GIRL</b>");
			else if(age<=12) 
				pw.println("<b> "+name+" YOU ARE A SMALL GIRL</b>");
			else if(age<=19) 
				pw.println("<b> "+name+" YOU ARE A TEENAGE GIRL</b>");
			else if(age<=35) 
				pw.println("<b> "+name+" YOU ARE A YOUNG WOMAN</b>");
			else if(age<=50) 
				pw.println("<b> "+name+" YOU ARE A MIDDLE AGE WOMAN</b>");
			else
				pw.println("<b> "+name+" YOU ARE A SENIER CITIGEN</b>");
		}//else
		//display the response in the browser
		pw.println("<br>");
		pw.print("<b><font color=red>YOUR APPLICATION NUMBER IS="+l+"</font><b><br>");
		pw.println("<b>NAME="+name+"<br>");
		pw.println("<b>AGE ="+age+"<br>");
		pw.println("<b>GENDER ="+gender+"<br>");
		pw.println("<b>ADDRESS ="+address+"<br>");
		pw.println("<b>Marital Status :: ="+ms+"<br>");
		pw.println("<b>Qualification :: ="+qlfy+"<br>");
		pw.println("<b>Courses :: ="+course[0]+"<br>");
		pw.println("<b>Hobbies :: ="+Arrays.toString(hobbies)+"<br>");
		pw.println("<a href='index.html'>HOME PAGE</a>");
	}//get

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}//post
}//class
