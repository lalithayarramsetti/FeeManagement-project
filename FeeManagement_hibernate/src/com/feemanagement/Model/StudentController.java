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

import com.feemanagement.Bean.AccountantBean;
import com.feemanagement.Bean.StudentBean;
import com.feemanagement.Service.AccountantService;
import com.feemanagement.Service.AccountantServiceImpl;
import com.feemanagement.Service.StudentService;
import com.feemanagement.Service.StudentServiceImpl;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String text=request.getServletPath();
		System.out.println(text);
		if("/AddStudent".equalsIgnoreCase(text))
		{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			String name=request.getParameter("name");
			System.out.println(name);
		 	String email=request.getParameter("email");
			String sex=request.getParameter("sex");
			String course=request.getParameter("course");
			int fee=Integer.parseInt(request.getParameter("fee"));
			int paid=Integer.parseInt(request.getParameter("paid"));
			int due=Integer.parseInt(request.getParameter("due"));
			String address=request.getParameter("address");
			String contact=request.getParameter("contact");
			
			StudentBean bean=new StudentBean(name, email, sex, course, fee, paid, due, address, contact);
			StudentService sservice=new StudentServiceImpl();
			int status=sservice.save(bean);
			//int status=StudentDao.save(bean);
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Add Student</title>");
			out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
			out.println("<link rel='stylesheet' href='style.css'/>");
			out.println("</head>");
			out.println("<body>");
			request.getRequestDispatcher("navaccountant.jsp").include(request, response);
			out.println("<div class='container'>");
			
			out.println("Student is added successfully!");
			
			request.getRequestDispatcher("Add_Student_Form.jsp").include(request, response);
			out.println("</div>");
			request.getRequestDispatcher("footer.html").include(request, response);
			out.println("</body>");
			out.println("</html>");
			
			out.close();
	}
		if("/ViewStudent".equalsIgnoreCase(text)) {
			System.out.println(text);
			StudentService accountantService=new StudentServiceImpl();
			List<StudentBean> list1=new ArrayList<StudentBean>();
			list1= accountantService.getAllRecords();
			request.setAttribute("data", list1);
			request.getRequestDispatcher("/ViewStudent.jsp").include(request, response);
				}
		if("/EditStudent".equalsIgnoreCase(text))
		{
			response.setContentType("text/html");
			//PrintWriter out=response.getWriter();
			
			int rollno=Integer.parseInt(request.getParameter("rollno"));
			//String name=request.getParameter("name");
		 	//String email=request.getParameter("email");
			//String password=request.getParameter("password");
			//System.out.println(password);
			//String address=request.getParameter("address");
			//System.out.println(address);
			//String contact=request.getParameter("contact");
			
			StudentBean bean=new StudentBean();
			bean.setRollno(rollno);
			bean.setName(request.getParameter("name"));
			bean.setEmail(request.getParameter("email"));
			bean.setCourse(request.getParameter("course"));
			bean.setFee(Integer.parseInt(request.getParameter("fee")));
			bean.setPaid(Integer.parseInt(request.getParameter("paid")));
			bean.setDue(Integer.parseInt(request.getParameter("due")));
			bean.setAddress(request.getParameter("address"));
			bean.setContact(request.getParameter("contact"));
			//request.setAttribute("id", id);
			StudentService accountantService=new StudentServiceImpl();
			accountantService.update(bean);
			 request.setAttribute("user", bean);
			 response.sendRedirect("ViewStudent");
			
			
		}
		if("/DueFee".equalsIgnoreCase(text)) {
			System.out.println(text);
			StudentService accountantService=new StudentServiceImpl();
			List<StudentBean> list1=new ArrayList<StudentBean>();
			list1= accountantService.getDues();
			request.setAttribute("data", list1);
			request.getRequestDispatcher("/DueFee.jsp").include(request, response);
				}
		if("/DeleteStudent".equalsIgnoreCase(text))
		{
			String sid=request.getParameter("rollno");
			int id=Integer.parseInt(sid);
			StudentService accountantService=new StudentServiceImpl();
					accountantService.delete(id);
			response.sendRedirect("ViewAccountant");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
