package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/next")
public class NextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public NextServlet() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8" );
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>from</title></head>");
		out.print("<body>");
		int randNum = (Integer)request.getAttribute("randNum");
		out.print(randNum + "<br>");
		for (int i = 0; i < randNum; i++) {
			out.print("Hello<br>");
		}
		out.print("</body>");
		out.print("</html>");
	}

}
