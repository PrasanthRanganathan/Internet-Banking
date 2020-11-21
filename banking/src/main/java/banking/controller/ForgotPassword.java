package banking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import banking.configure.BankingConfigure;
import banking.service.BankingService;

@WebServlet("/forgotpassword")
public class ForgotPassword extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("resource")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		String id = req.getParameter("id");
		String number = req.getParameter("number");
		
		HttpSession session = req.getSession();
		session.setAttribute("id", id);
		
		AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(BankingConfigure.class);

		BankingService bean = (BankingService) config.getBean("BankingService");
		
		String status = bean.resetvalidate(id, number);
		
		if(status.equals("success")) {
			resp.sendRedirect("reset.html");
		}
		else if(status.equals("failure")) {
			resp.sendRedirect("ForgotpassFail.html");
		}
	}

}
