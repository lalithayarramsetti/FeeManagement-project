package com.feemanagement.Model;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feemanagement.Service.AccountantService;
import com.feemanagement.Service.AccountantServiceImpl;


@WebServlet("/AccountantLogin")
public class AccountantLogin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Accountant Panel</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("/navaccountant.jsp").include(request, response);
		out.println("<div class='container'>");
		
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		AccountantService accountantService=new AccountantServiceImpl();
		boolean status=accountantService.validate(email, password);
 		System.out.println(status);
		if(status){
			HttpSession session=request.getSession();
			session.setAttribute("accountant","true");
			request.getRequestDispatcher("/accountanthome.jsp").include(request, response);
		}else{
			out.println("<h1>Accountant Login Form</h1>");
			out.println("<p>Sorry, username or password error!</p>");
			request.getRequestDispatcher("/Accountant_Login_Form.jsp").include(request, response);
		}
		out.println("</div>");
		request.getRequestDispatcher("/footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
