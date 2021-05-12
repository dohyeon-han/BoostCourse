package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationScope02
 */
@WebServlet("/as02")
public class ApplicationScope02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		ServletContext application = getServletContext();//application scope
		
		try {
		int value = (int)application.getAttribute("value");
		value++;
		application.setAttribute("value", value);
		out.print("<h1>value : "+value+"</h>");
		}catch (Exception e) {
			out.print("값이 없음");
		}
		
	}
}
