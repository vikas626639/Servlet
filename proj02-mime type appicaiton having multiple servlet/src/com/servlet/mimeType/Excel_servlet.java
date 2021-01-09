package com.servlet.mimeType;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Excel_servlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("application/vnd.ms-excel");
		//get Writer 
		PrintWriter pw=null;
		pw=res.getWriter();
		//writing business logic
		pw.println("<table border='1'>");
		pw.println("<tr>  <th>Player</th>  <th>Role</th> </tr>");
		pw.println("<tr>  <th>DHONI</th>  <th>CAPTION</th> </tr>");
		pw.println("<tr>  <th>SACHIN</th>  <th>CAPTIAN</th> </tr>");
		pw.println("<tr>  <th>VIRAT</th>  <th>CRICKET</th> </tr>");
		pw.println("</table>");
		pw.close();
	}
}
