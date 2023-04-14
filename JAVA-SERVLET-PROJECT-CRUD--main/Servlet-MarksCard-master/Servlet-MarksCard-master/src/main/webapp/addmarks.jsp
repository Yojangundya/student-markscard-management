<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>HEY THIS IS RESULT FETCHED FROM THE DATABASE!</h1>

	<table border="3">
		<tr>
			<th>id</th>
			<th>class</th>
			<th>English</th>
			<th>Maths</th>
			<th>Science</th>
			<th>Percent</th>
			<th>Result</th>
		</tr>

	<%-- 	<%
		for (User user : list) {
		%>
		<tr>
			<td><%=user.getName()%></td>
			<td><%=user.getMobile()%></td>
			<td><%=user.getEmail()%></td>
			<td><%=user.getDate()%></td>
			<td><%=user.getGender()%></td>
			<td><%=user.getPassword()%></td>
			<td><%=user.getAddress()%></td>

			<%-- <td><a href="delete"><button>Delete</button></a></td>--%>

		<%-- 	<td><a href="delete?emailll=<%=user.getEmail()%>"><button>Delete</button></a></td>
			<td><a href="Edit.jsp?emaill=<%=user.getEmail()%>"><button>Edit</button></a></td>

		</tr>

		<%
		}
		%>
	</table>
	<button onclick="window.print()">Print</button>
	<button onclick="export_data()">Export</button>
	<br>
	<%--<a href="login.html"><button>logout</button> </a>--%>
<%-- 	<a href="logout"><button>logout</button> </a>--%>
</table>
	
</body>
</html>