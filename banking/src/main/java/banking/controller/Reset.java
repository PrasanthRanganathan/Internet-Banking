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

@WebServlet("/resetpassword")
public class Reset extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("resource")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cpass = req.getParameter("cpwd");
		
		AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(BankingConfigure.class);

		BankingService bean = (BankingService) config.getBean("BankingService");
		
		HttpSession session = req.getSession(false);
		
		String id = (String) session.getAttribute("id");
		
		String status = bean.reset(cpass,id);
		
		if(status.equals("success")) {
			resp.sendRedirect("loginResetSuccess.html");
		}
		else if(status.equals("failure")) {
			resp.sendRedirect("loginResetFailure.html");
		}
		else {
			resp.sendRedirect("loginResetFailure.html");
		}
	}
}
