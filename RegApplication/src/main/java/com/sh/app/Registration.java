package com.sh.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.app.bm.ManageUser;
import com.sh.app.dao.UserDetails;

/**
 * Servlet implementation class Registration
 */
@WebServlet(description = "Registraion Servlet", urlPatterns = { "/Registration" })
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @author SHavara1
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter  out = response.getWriter();
		out.print("<h1>Please execute the RegistrationForm.html for registration");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @author SHavara1
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("In do Post");
		String message = null;
		//spring framework can be used to handle to this 
		UserDetails userDetails = new UserDetails();
		ManageUser manageUser = new ManageUser();
			
		userDetails.setUsername(request.getParameter("username"));
		userDetails.setPassword(request.getParameter("password"));
		message = manageUser.saveUser(userDetails);
		
		PrintWriter out = response.getWriter();
		out.print(message);
		

		
	}

}
