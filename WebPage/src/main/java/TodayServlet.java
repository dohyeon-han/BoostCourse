

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodayServlet
 */
@WebServlet("/today")
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TodayServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		LocalDate currentDate = LocalDate.now();
		LocalDateTime currentDateTime = LocalDateTime.now();
		
		writer.print("<a href='http://localhost:8090/WebPage/index.html'>메인화면</a><br><br>");
		writer.print("<h1>현재시간 : "+ currentDate.getYear()+"/"+currentDate.getMonthValue()+"/"+currentDate.getDayOfMonth()+
				" "+(currentDateTime.getHour()<10?"0"+currentDateTime.getHour():currentDateTime.getHour())+
				":"+(currentDateTime.getMinute()<10?"0"+currentDateTime.getMinute():currentDateTime.getMinute())+"</h1>");
		
		response.addHeader("Refresh", "60;url=");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
