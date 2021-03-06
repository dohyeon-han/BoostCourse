package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//value는 application scope이므로 application이 끝날때까지 변수는 계속 유지, 공유
@WebServlet("/as01")
public class ApplicationScope01 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		ServletContext application = getServletContext();//application scope
		
		int value = 1;
		application.setAttribute("value", value);
		
		out.print("<h1>value : "+value+"</h>");
	}


}
