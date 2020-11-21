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
<body style="background:url(home.jpg);background-position: center;background-size: cover;height: 101vh">

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
    <section style="padding-left: 10%; padding-right: 20%;color: black;">
        <h1>Account Summary</h1>
            <h2 style="padding-left: 5%;">Welcome <%=(session.getAttribute("name")) %></h2>
        <div style=" font-size: 20px;padding-left: 100px;"> Savings Account
        <span style="float: right;padding-right: 80px;">Account Balance : &#x20b9; <%= session.getAttribute("balance") %></span></div>
         
        
         <p style="padding-top:200px">         
         Note:	 <br><br>
	The Available Balance displayed includes the credit balance and overdraft limit (if any) in your account.<br>
   (i) It does not include Uncleared Funds.<br>
   (ii) It includes amount marked for hold.<br>
	The Hold Balance may also include pending service charges due to be recovered from your account.<br>
	Savings account customers can now receive their statements monthly, by email, for free.<br>
	What's New ! Now recharge your Prepaid Mobile and DTH connections through BillPay & Recharge!
         </p>
        
    </section>
</body>
</html>