package banking.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import banking.configure.BankingConfigure;
import banking.service.BankingService;


@WebServlet("/loan")
@MultipartConfig(maxFileSize = 16177215)
public class LoanApplication extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("resource")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String number = req.getParameter("number");
		String address = req.getParameter("address");
		Part statment1 = req.getPart("statement");
		Part photo1 = req.getPart("photo");
		Part sign1 = req.getPart("sign");
		
		InputStream statment = statment1.getInputStream();
		InputStream photo = photo1.getInputStream();
		InputStream sign = sign1.getInputStream();
		
		banking.dto.Loan l = new banking.dto.Loan();
		l.setName(name);
		l.setDob(dob);
		l.setNumber(number);
		l.setAddress(address);
		l.setStmt(statment);
		l.setPhoto(photo);
		l.setSign(sign);
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		
		AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(BankingConfigure.class);
		BankingService bean = (BankingService) config.getBean("BankingService");
		String status = bean.loan(l, id);
		
		if(status.equals("success")) {
			resp.sendRedirect("loanStatus.html");
		}else {
			resp.sendRedirect("applyLoanFailure.html");
		}
		
	}
}
