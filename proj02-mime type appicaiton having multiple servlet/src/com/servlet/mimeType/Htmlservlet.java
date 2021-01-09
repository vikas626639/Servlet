package com.servlet.mimeType;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class Htmlservlet extends HttpServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//set content type
				PrintWriter pw=null;
				pw=res.getWriter();
				res.setContentType("text/html");
				LocalDate date=LocalDate.now();
				//get Writer 
				//writing business logic
				pw.println("<b><center><Font size=7 color=red>Date is="+date+"</b></font></center>");
				pw.println("<table border='1'>");
				pw.println("<tr>  <th>Player</th>  <th>Role</th> </tr>");
				pw.println("<tr>  <th>DHONI</th>  <th>CAPTION</th> </tr>");
				pw.println("<tr>  <th>SACHIN</th>  <th>CAPTIAN</th> </tr>");
				pw.println("<tr>  <th>VIRAT</th>  <th>CRICKET</th> </tr>");
				pw.println("</table>");
				pw.close();
	}
}
