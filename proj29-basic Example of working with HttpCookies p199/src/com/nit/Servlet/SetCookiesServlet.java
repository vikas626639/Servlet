package com.nit.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetCookiesServlet")
public class SetCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//creating Cookies
		Cookie cookie1,cookie2,cookie3,cookie4;
		//default max age is -1, indicating cookies
		//2 in-memory cookies applies only to current browing session
		cookie1=new Cookie("ap", "amaravathi");
		cookie2=new Cookie("ts", "hydrabad");
		res.addCookie(cookie1);
		res.addCookie(cookie2);
		
		//cookies is valid for an hour.regardless of wheather
		//user quits broser,reboots computer
		//2 persitent cookies
		cookie3=new Cookie("kr", "Banglore");
		cookie4=new Cookie("mh", "mumbai");
		cookie3.setMaxAge(60);
		cookie4.setMaxAge(60);
		
		res.addCookie(cookie3);
		res.addCookie(cookie4);
		//get Writer
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("Successful in setting cookies");
		System.out.println("Seccessful in setting cookies");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
