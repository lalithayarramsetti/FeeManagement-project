<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,com.feemanagement.Bean.AccountantBean,com.feemanagement.Service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  
  
AccountantBean bean=new AccountantBean();
String uid = request.getParameter("id");
int id=Integer.parseInt(uid);
System.out.println(id);
AccountantService accDao=new AccountantServiceImpl();
bean=accDao.getRecordById(id);

%>  
<form action="EditAccountant" method="post">
<table>
		<tr>
		<td><input type="hidden" name="id" value=<%=bean.getId() %> /></td>
		</tr>
	<tr>
	<td>Name:</td><td><input type="text" name="name" value=<%=bean.getName() %>/></td>
	</tr>
		<tr>
		<td>Email:</td><td><input type="email" name="email" value=<%=bean.getEmail() %>/></td>
		</tr>
		<tr>
		<td>Password:</td><td><input type="text" name="password" value=<%=bean.getPassword() %>/></td>
		</tr>
		<tr>
		<td>Address:</td><td><textarea name="address" style="width:300px;height:100px"><%= bean.getAddress()%></textarea></td>
		</tr>
	<tr>
	<td>Contact No:</td><td><input type="text" name="contact" value=<%=bean.getContact() %>/></td>
	</tr>
		<tr>
		<td colspan='2' align='center'><input type="submit" value="Update Accountant" class="btn btn-default"/></td>
		</tr>
		</table>
		</form>
</body>
</html>