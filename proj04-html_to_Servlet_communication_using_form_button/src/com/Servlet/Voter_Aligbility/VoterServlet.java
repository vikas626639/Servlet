package com.Servlet.Voter_Aligbility;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("text/html");
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//read form data
		String name=req.getParameter("name");
		Integer age=Integer.parseInt(req.getParameter("age"));
		if(age<=18) {
			pw.println("<b><center>sorry "+name+" you are not eligble for voting</center></b>");
		}
		else {
			pw.println("<b><center>mr/mrs "+name+" you are eligble for voting</center></b>");
		}
		//close stram
		pw.println("<a href='input.html'>go to homepage</a>");
		pw.close();
		//hyperlink of home page
	}
}
