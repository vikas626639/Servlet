package com.Servlet.Links;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Links_Url")
public class Links_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("text/html");
		//get printWriter
		PrintWriter pw = res.getWriter();
		//get all language work with Local
		Locale locale[]=Locale.getAvailableLocales();
		//read form data
		String link=req.getParameter("s1");
		String country="All COUNTRIES";
		int count=0;

		if(link.equalsIgnoreCase("link")) {
			pw.println("<center><table border=1>");
			pw.println("<tr><td colspan=2><font color=red><center>ALL LANGUAGES</center></font></td></tr>");
			for(Locale c:locale) {
				pw.println("<tr><td>"+(count+1)+"</td><td><center><font color=green>"+c.getDisplayLanguage()+"</td></tr>");
				count++;
			}
			pw.println("</table></center>");
			pw.println("<a href='index.html'>HOME PAGE</a>");

		}else if(link.equalsIgnoreCase("link2")){
			pw.println("<center><table border=1>");
			pw.println("<tr><td colspan=2><font color=red><center>"+country+"</center></font></td></tr>");
			for(Locale c:locale) {
				pw.println("<tr><td>"+(count+1)+"</td><td><center><font color=green>"+c.getDisplayCountry()+"</td></tr>");
				count++;
				}
			pw.println("</table></center>");
			pw.println("<a href='index.html'>HOME PAGE</a>");
		}else {
			pw.println("<b><center>Today Date and Time is = "+new Date()+"</center></b><br>");
			pw.println("<a href='index.html'>HOME PAGE</a>");
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);
	}

}
