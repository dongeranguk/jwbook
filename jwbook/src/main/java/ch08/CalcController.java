package ch08;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcControl")
public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CalcController() {
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int n1 = Integer.parseInt(req.getParameter("n1"));
		int n2 = Integer.parseInt(req.getParameter("n2"));
		
		long result = 0;
		
		switch(req.getParameter("op")) {
			case "+" : result = n1 + n2; break;
			case "-" : result = n1 - n2; break;
			case "*" : result = n1 * n2; break;
			case "/" : result = n1 / n2; break;
		}
		
		req.setAttribute("result", result);
		getServletContext().getRequestDispatcher("/ch08/calResult.jsp").forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
