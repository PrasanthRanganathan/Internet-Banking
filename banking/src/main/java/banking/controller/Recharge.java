package banking.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import banking.configure.BankingConfigure;
import banking.service.BankingService;

@WebServlet("/recharge")
public class Recharge extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("resource")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String operator = req.getParameter("operator");
		String number = req.getParameter("number");
		String password = req.getParameter("password");
		String amount = req.getParameter("amount");
		
		AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(BankingConfigure.class);

		BankingService bean = (BankingService) config.getBean("BankingService");
		HttpSession session = req.getSession();
		
		String id = (String) session.getAttribute("id");
		String status = bean.recharge(operator,amount, number,id, password);
	
		if(status.contains("success")) {
			String[] split = status.split("-");
			
			ArrayList<String> list = Login.statement();
			session.setAttribute("list", list);
			session.setAttribute("balance", split[1]);
			resp.sendRedirect("rechargeSuccess.html");
		}else if(status.equals("password incorrect")) {
			resp.sendRedirect("rechargePassIncorrect.html");
		}
		else if(status.equals("failure")) {
			resp.sendRedirect("rechargeFailure.html");
		}
	}
}
