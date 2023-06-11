package com.susie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 * @see HttpServlet#HttpServlet()
 * @author Susie
 */

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // set charset
		response.setContentType("text/html;charset=UTF-8");
        // use PrintWriter.write() method outputting to front end page
        PrintWriter writer = response.getWriter();
        writer.write("welcome to programming world!");
        writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getQueryString());
		// set charset
		response.setContentType("text/html;charset=UTF-8");
        // use PrintWriter.write() method outputting to front end page
        PrintWriter writer = response.getWriter();
        writer.write(request.getQueryString());
        //writer.close();
		doGet(request, response);
	}

}
