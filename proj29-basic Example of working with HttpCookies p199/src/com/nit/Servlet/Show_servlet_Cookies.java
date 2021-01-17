package com.nit.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(asyncSupported = true, urlPatterns = { "/Show_servlet_Cookies" })
public class Show_servlet_Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("text/html");
		//get Writer
		PrintWriter pw=res.getWriter();
		String Title="Active Cookies";
		pw.println("<html><head><title>"+Title+"</title></head>");
		pw.println("<body><table border='1' align='center'>");
		pw.println("<tr><td>Cookies name::-</td>");
		
		//get Cookies
		Cookie[]cks=req.getCookies();
		if(cks!=null) {
			for(Cookie c:cks) {
				pw.println("<tr><td>"+c.getValue()+"</td></tr>");
			}//for
			pw.println("</table></body></html>");
		}else {
			System.out.println("No Coockies present");
			pw.println("<br><b>No Coockies present");
		}//else
	}//doget
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}//dopost

}
