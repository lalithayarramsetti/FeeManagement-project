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
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>address</th>
			<th>contact</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
			List list = (ArrayList) request.getAttribute("data");

			for (int i = 0; i < list.size(); i++) {
				AccountantBean bean = (AccountantBean) list.get(i);
		%>
		<tr class="even">
			<td><input type="text" name="id" value=<%=bean.getId() %> /></td>
			<td><input type="text" name="name" value=<%=bean.getName() %> /></td>
			<td><input type="text" name="email" value=<%=bean.getEmail() %> /></td>			
			<td><input type="text" name="password" value=<%=bean.getPassword()%> /></td>
			
			<td><input type="text" name="address" value=<%=bean.getAddress()%> /></td>
			<td><input type="text" name="contact" value=<%=bean.getContact()%> /></td>
			<td><a href=EditAccountantForm.jsp?id=<%=bean.getId() %>>Edit</a></td>
			<td><a href=DeleteAccountant?id=<%=bean.getId() %>>Delete</a> </td>



		</tr>
		<%
			}
		%>
	</table>
</body>
</html>