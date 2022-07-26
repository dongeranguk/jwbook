package ch08;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/pcontrol")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ProductService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
    	service = new ProductService();
    	// TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
    	String action = request.getParameter("action");
    	String view = "";
    	
    	if(request.getParameter("action") == null) {
    		getServletContext().getRequestDispatcher("/pcontrol?action=list")
    		.forward(request, response);
    	} else {
    		switch(action) {
    			case "list" : view = list(request, response); break;
    			case "info" : view = info(request, response); break;
    		}
    		getServletContext().getRequestDispatcher("/ch08/" + view)
    		.forward(request, response);
    	}
	}
    
    private String list(HttpServletRequest req, HttpServletResponse res) { 
    	req.setAttribute("products", service.findAll());
    	return "productList.jsp";
    }
    
    private String info(HttpServletRequest req, HttpServletResponse res) {
    	req.setAttribute("p", service.find(req.getParameter("id")));
    	return "productInfo.jsp";
    }

}
