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

@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	static String id;
	AnnotationConfigApplicationContext config;
	static BankingService bean;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BankingConfigure.dataSource();
		 id = req.getParameter("id");
		String pass = req.getParameter("pass");

		 config = new AnnotationConfigApplicationContext(BankingConfigure.class);

		 bean = (BankingService) config.getBean("BankingService");
		
		String status = bean.validate(id,pass);
		
		if(status.contains("success")) {
			String bal = bean.checkBal(id);
			String[] split = status.split("-");
			String name= split[1].toUpperCase();
			
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			session.setAttribute("password", pass);
			session.setAttribute("balance", bal);
			session.setAttribute("name",name);
			resp.sendRedirect("LoginHome.jsp");
			
		}
		else if(status.equals("failure")) {
			resp.sendRedirect("LoginFail.html");
		}
	}
	
	public static ArrayList<String> statement(){
		
		ArrayList<String> list = bean.statment(id);
		return list;
		
	}

}
