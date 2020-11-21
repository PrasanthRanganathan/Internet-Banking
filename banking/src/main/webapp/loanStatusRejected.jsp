<%@page import="banking.dto.Loan"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feather Bank - Home</title>
<link rel="stylesheet" type="text/css" href="loans.css">
</head>
<body>

	<header>
        <img class="img" src="logo1.jpg" alt="Logo of Feather Bank" width="60px" height="40px">
        <h1 class="name">Feather Bank</h1>
        <div class="link"> <img src="login.png" alt="Img" width="15px" height="15px"> <a class="a" href="login.html">SignOut</a></div>
    </header>
    <nav>
        <br>
        <a href="LoginHome.jsp">Home</a>
        <a href="statement">View Statement</a>
        <a href="moneyTransfer.html" >Money Transfer</a>
        <a href="recharge.html" >Recharge</a>
        <a href="cards.html" >Cards</a>
        <a href="loans.html" >Loans</a>
        
    </nav>
    <section>

        <h1>Loan Status :</h1><br>

            <h3 style="padding-left: 80px;">
                Your loan application has been rejected due to below reason <br><br>
                <%=session.getAttribute("loan-remarks") %>
            </h3>
        
        
    </section>
    
</body>
<script src="changePin.js"></script>
</html>