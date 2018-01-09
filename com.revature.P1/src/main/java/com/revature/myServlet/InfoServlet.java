package com.revature.myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import java.lang.Object;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.ErsUser;

//import com.revature.model.BankUser;
@WebServlet("/info")
public class InfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3307881590872764129L;
	public InfoServlet()
	{
		super();
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("infomationServlet -GET"); 
		HttpSession session = req.getSession();
		ErsUser user = new ErsUser();
		
		ErsUser sessionUser = (ErsUser) session.getAttribute("user");
		if (sessionUser != null) {
			sessionUser.setU_userName(sessionUser.getU_userName());
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(user);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
		}
		else{
			resp.setStatus(418);
		//req.getRequestDispatcher("src/main/webapp/resources/emp_info.html").forward(req, resp);
			
				
			}
	}
}
