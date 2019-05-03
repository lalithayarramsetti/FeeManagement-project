<%@page import="java.util.*,com.feemanagement.Bean.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table class='table table-bordered table-striped'>
		<tr>
			<th>Rollno</th>
			<th>Name</th>
			<th>Email</th>
			<th>Sex</th>
			<th>Course</th>
			<th>Fee</th>
			<th>Paid</th>
			<th>Due</th>
			<th>address</th>
			<th>contact</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
			List list = (ArrayList) request.getAttribute("data");

			for (int i = 0; i < list.size(); i++) {
				StudentBean bean = (StudentBean) list.get(i);
		%>
		<tr class="even">
			<td><input type="text" name="rollno" value=<%=bean.getRollno() %> /></td>
			<td><input type="text" name="name" value=<%=bean.getName() %> /></td>
			<td><input type="text" name="email" value=<%=bean.getEmail() %> /></td>			
			<td><input type="text" name="sex" value=<%=bean.getSex()%> /></td>
			<td><input type type="text" name="course" value=<%=bean.getCourse() %> /></td>
			<td><input type="text" name="fee" value=<%=bean.getFee() %>></td>
						<td><input type="text" name="paid" value=<%=bean.getPaid() %>></td>
			
						<td><input type="text" name="due" value=<%=bean.getDue() %>></td>
			
			<td><input type="text" name="address" value=<%=bean.getAddress()%> ></td>
			<td><input type="text" name="contact" value=<%=bean.getContact()%> ></td>
			<td><a href=EditStudentForm.jsp?rollno=<%=bean.getRollno() %>>Edit</a></td>
			<td><a href=DeleteStudent?rollno=<%=bean.getRollno() %>>Delete</a> </td>



		</tr>
		<%
			}
		%>
	</table>
</body>
</html>