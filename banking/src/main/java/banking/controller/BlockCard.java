package banking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/blockCard")
public class BlockCard extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String password = req.getParameter("pwd");
		
		HttpSession session = req.getSession();
		Object pass = session.getAttribute("password");
		
		if(password.equals(pass)) {
			resp.sendRedirect("blockCardSuccess.html");
		}else {
			resp.sendRedirect("blockCardFailure.html");
		}
	}
}
