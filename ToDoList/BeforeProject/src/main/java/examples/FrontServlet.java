package examples;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//redirect와 foward의 차이
//redirect는 client -> server(redirect할 주소 response) -> client -> server -> client 순서  url이 바뀐다
//foward는 client -> server(request에 전달할 인자 담아서) -> server -> client 순서 url이 바뀌지 않는다

@WebServlet("/front")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int randNum = (int)(Math.random()+1)*6;
		request.setAttribute("randNum", randNum);//request에 값 저장
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/next");//이동할 서버, 서버 내에서만 이동 가능함
		requestDispatcher.forward(request, response);
		
	}

}
