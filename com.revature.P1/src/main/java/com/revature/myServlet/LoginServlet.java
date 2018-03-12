package com.revature.myServlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.DAO.DaoUserDBConnection;
import com.revature.model.ErsUser;
//import com.revature.model.ErsUser;
import com.revature.service.EmployeeService;

//import com.revature.model.BankUser;
//import com.revature.service.AppService
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2905972211892626095L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet -GET"); 
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
	 
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("LoginServlet -POST");
		ErsUser clientUser =  new ErsUser();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//System.out.println("TESt User" + username);
		//System.out.println("Test Password" + password);
		
		EmployeeService empService = new EmployeeService();
		//clientUser =  new ErsUser();
		
		 if( clientUser != null){
			clientUser.setU_userName(username);
			clientUser.setU_password(password);
			
			
			if (empService.validateUser(clientUser)== true)
			{
				HttpSession session = req.getSession(); 
				
				session.setAttribute("user", clientUser);
				DaoUserDBConnection dao = new DaoUserDBConnection();
				if((dao.emp_status(clientUser.getU_userName()).equals("Manager")))
				{
					//req.getRequestDispatcher("resources/app.html").forward(req, resp);
					req.getRequestDispatcher("resources/test.html").forward(req, resp);
				}
				if((dao.emp_status(clientUser.getU_userName()).equals("employee")))
				{
					//req.getRequestDispatcher("resources/app.html").forward(req, resp);
					req.getRequestDispatcher("resources/test.html").forward(req, resp);
				}
				//req.getRequestDispatcher("resources/employee.html").forward(req, resp);
			
			
			}
			 else {
					System.err.println("invalid credentials -sending user back to login.html");
					resp.sendRedirect("resources/login.html");
			 }
			//HttpSession session = req.getSession(); 
			
			//session.setAttribute("user", clientUser);

			//req.getRequestDispatcher("resources/login.html").forward(req, resp);
		}
		 /*else {
			System.err.println("invalid credentials -sending user back to login.html");
			resp.sendRedirect("resources/login.html");*/
		 
	//}
	}
}
