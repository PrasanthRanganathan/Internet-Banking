package banking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/statement")
public class Statement extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<String> list = Login.statement();
//		String account=list.get(0);
//		String name=list.get(1);
//		String mode=list.get(2);
//		String remark=list.get(3);
//		String amount=list.get(4);
		
		HttpSession session = req.getSession();
		session.setAttribute("list", list);
//		session.setAttribute("account", account);
//		session.setAttribute("name1", name);
//		session.setAttribute("mode", mode);
//		session.setAttribute("remarks", remark);
//		session.setAttribute("amount", amount);
		
		resp.sendRedirect("statement.jsp");
	}

	
}
