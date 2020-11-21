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

@WebServlet("/moneyTransfer")
public class transferMoney extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("resource")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fromAcc = req.getParameter("saccno");
		String toAcc = req.getParameter("caccno");
		String name = req.getParameter("name");
		String amount = req.getParameter("amt");
		String transferMode = req.getParameter("mode");
		String remark = req.getParameter("remark");

		AnnotationConfigApplicationContext conf = new AnnotationConfigApplicationContext(BankingConfigure.class);

		BankingService bean = (BankingService) conf.getBean("BankingService");
		String status = bean.transfer(fromAcc, toAcc, name, amount, transferMode, remark);

		if (status.equals("user account not exist")) {
			resp.sendRedirect("transferMoneyAccNotExist.html");
		}
		else if (status.equals("balance not avilable")) {
			resp.sendRedirect("transferMoneyBalLow.html");
		}
		else if (status.equals("failure")) {
			resp.sendRedirect("transferMoneyFailure.html");
		}
		else if (status.contains("success")) {
			ArrayList<String> list = Login.statement();
			String[] split = status.split("-");
			HttpSession session = req.getSession();
			session.setAttribute("list", list);
			session.setAttribute("balance", split[1]);
			resp.sendRedirect("transferMoneySuccess.html");
		}

	}

}
