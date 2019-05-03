<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,com.feemanagement.Bean.*,com.feemanagement.Service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  
  
StudentBean bean=new StudentBean();
String uid = request.getParameter("rollno");
int rollno=Integer.parseInt(uid);
//System.out.println(id);
StudentService accDao=new StudentServiceImpl();
bean=accDao.getRecordByRollNo(rollno);

%>  
<form action="EditStudent" method="post">
<table>
		<tr>
		<td><input type="hidden" name="rollno" value=<%=bean.getRollno() %> /></td>
		</tr>
	<tr>
	<td>Name:</td><td><input type="text" name="name" value=<%=bean.getName() %>></td>
	</tr>
		<tr>
		<td>Email:</td><td><input type="email" name="email" value=<%=bean.getEmail() %>></td>
		</tr>
		<tr>
		<td>Course:</td><td><input type="text" name="course" value=<%=bean.getCourse() %>></td>
		</tr>
		<tr>
		<td>Fee:</td><td><input type="text" name="fee" value=<%=bean.getFee() %>></td>
		</tr>
		<tr>
		<td>Paid:</td><td><input type="text" name="paid" value=<%=bean.getPaid() %>></td>
		</tr>
		<tr>
		<td>Due:</td><td><input type="text" name="due" value=<%=bean.getDue() %>></td>
		</tr>
		<tr>
		<td>Address:</td><td><textarea name="address" style="width:300px;height:100px"><%= bean.getAddress()%></textarea></td>
		</tr>
	<tr>
	<td>Contact No:</td><td><input type="text" name="contact" value=<%=bean.getContact() %>></td>
	</tr>
		<tr>
		<td colspan='2' align='center'><input type="submit" value="Update Accountant" class="btn btn-default"/></td>
		</tr>
		</table>
		</form>
</body>
</html>