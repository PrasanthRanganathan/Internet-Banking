<%@page import="java.util.List"%>
<%@page import="banking.dto.Loan"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feather Bank - Home</title>
<link rel="stylesheet" type="text/css" href="LoginHome.css">
</head>
<body style="background: url(statement.jpg);background-position: center;background-size: cover;height: 101vh">

	<header>
		<img class="img" src="logo1.jpg" alt="Logo of Feather Bank"
			width="60px" height="40px">
		<h1 class="name">Feather Bank</h1>
		<div class="link">
			<img src="login.png" alt="Img" width="15px" height="15px"> <a
				class="a" href="login.html">SignOut</a>
		</div>
	</header>
	<nav>
		<br> <a href="LoginHome.jsp">Home</a>
			 <a href="statement">View Statement</a> 
			 <a href="moneyTransfer.html">Money Transfer</a>
			  <a href="recharge.html">Recharge</a> 
			  <a href="cards.html">Cards</a> 
			  <a href="loans.html">Loans</a>
	</nav>
	<section style="padding-left: 10%; padding-right: 20%;color: black;">
		<h1>Statement</h1>
		<br>
		<table border="2px" style="border-collapse: collapse;text-align: center;">
			<tr>

				<th style="padding: 10px; width: 200px;">Account Number</th>
				<th style="padding: 10px; width: 200px;">Name</th>
				<th style="padding: 10px; width: 200px;">Payment Mode</th>
				<th style="padding: 10px; width: 200px;">Remarks</th>
				<th style="padding: 10px; width: 200px;">Amount</th>
			</tr>

			<%
				List<String> list = (List<String>) request.getSession().getAttribute("list");
				int k = 0;
				for (int i = 0; i < list.size() / 5; i++) {
			%>
			<tr>
				<%
					for (int j = 5; j > 0; j--) {
				%>
				<td style="padding: 10px; width: 200px;"><%=list.get(k++)%></td>

				<%
					}
				%>
			</tr>
			<%
				}
			%>

		</table>
	</section>
</body>
</html>