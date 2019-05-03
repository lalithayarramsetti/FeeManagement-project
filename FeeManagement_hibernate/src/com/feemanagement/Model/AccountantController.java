package com.feemanagement.Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.feemanagement.Bean.AccountantBean;
import com.feemanagement.Service.AccountantService;
import com.feemanagement.Service.AccountantServiceImpl;
import com.feemanagement.dao.AccountantDao;
import com.feemanagement.dao.AccountantDaoImpl;

/**
 * Servlet implementation class AccountantController
 */

@SuppressWarnings("deprecation")
public class AccountantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AccountantService accountantDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountantController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(request, response);
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.getWriter().append("Served at: ").append(request.getContextPath());
	
	String text=request.getServletPath();
	System.out.println(text);
	if("/Add_Accountant".equalsIgnoreCase(text))
	{
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	out.println("<!DOCTYPE html>");
	out.println("<html>");
	out.println("<head>");
	out.println("<title>Accountant Added</title>");
	out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
	out.println("<link rel='stylesheet' href='style.css'/>");
	out.println("</head>");
	out.println("<body>");
	request.getRequestDispatcher("/navadmin.jsp").include(request, response);
	out.println("<div class='container'>");
	
	String name=request.getParameter("name");
 	String email=request.getParameter("email");
	String password=request.getParameter("password");
	String address=request.getParameter("address");
	String contact=request.getParameter("contact");
	System.out.println(name);
	XmlBeanFactory factory = new XmlBeanFactory (new ClassPathResource("/Beans.xml")); 
    AccountantBean obj = (AccountantBean) factory.getBean("accountant");  
    System.out.println(obj);
	
	
	//AccountantDao=accountantService;
	obj=new AccountantBean(name,email,password,address,contact);
	System.out.println(obj.getName());
	int status=accountantDao.save(obj);
	System.out.print(status);
	out.print("<h1>Add Accountant Form</h1>");
	out.println("<p>Accountant is added successfully!</p>");
	request.getRequestDispatcher("/Add_Accountant_Form.jsp").include(request, response);
	
	out.println("</div>");
	request.getRequestDispatcher("/footer.html").include(request, response);
	out.println("</body>");
	out.println("</html>");
	
	out.close();
	
	}
	if("/ViewAccountant".equalsIgnoreCase(text)) {
	System.out.println(text);
	//AccountantService accountantService=new AccountantServiceImpl();
	List<AccountantBean> list1=new ArrayList<AccountantBean>();
	list1= accountantDao.getAllRecords();
	request.setAttribute("data", list1);
	request.getRequestDispatcher("/ViewAccountant.jsp").include(request, response);
		}
	if("/EditAccountant".equalsIgnoreCase(text))
	{
		response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		//String name=request.getParameter("name");
	 	//String email=request.getParameter("email");
		//String password=request.getParameter("password");
		//System.out.println(password);
		//String address=request.getParameter("address");
		//System.out.println(address);
		//String contact=request.getParameter("contact");
		
		AccountantBean bean=new AccountantBean();
		bean.setId(id);
		bean.setName(request.getParameter("name"));
		bean.setEmail(request.getParameter("email"));
		bean.setPassword(request.getParameter("password"));
		bean.setAddress(request.getParameter("address"));
		bean.setContact(request.getParameter("contact"));
		//request.setAttribute("id", id);
		AccountantService accountantService=new AccountantServiceImpl();
		accountantService.update(bean);
		 request.setAttribute("user", bean);
		 response.sendRedirect("ViewAccountant");
		
		
	}
	if("/DeleteAccountant".equalsIgnoreCase(text))
	{
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		AccountantService accountantService=new AccountantServiceImpl();
				accountantService.delete(id);
		response.sendRedirect("ViewAccountant");
	}
	if("/changePassword".equalsIgnoreCase("text"))
	{
		
	}
	}
}

