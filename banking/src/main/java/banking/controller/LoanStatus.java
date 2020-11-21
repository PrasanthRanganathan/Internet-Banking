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

@WebServlet("/status")
public class LoanStatus extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("resource")
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		
		AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(BankingConfigure.class);
		BankingService bean = (BankingService) config.getBean("BankingService");
		String status = bean.status(id);
		
		if(status.equals("null")) {
			resp.sendRedirect("laonStatusEmpty.html");
		}
		else if(status.contains("under process")) {
			resp.sendRedirect("loanStatusProcess.html");
		}
		else if(status.contains("rejected")) {
			String[] split = status.split("-");
			
			session.setAttribute("loan-remarks", split[1]);
			resp.sendRedirect("loanStatusRejected.jsp");
		}
	}
}
