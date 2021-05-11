package examples;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//redirect�� foward�� ����
//redirect�� client -> server(redirect�� �ּ� response) -> client -> server -> client ����  url�� �ٲ��
//foward�� client -> server(request�� ������ ���� ��Ƽ�) -> server -> client ���� url�� �ٲ��� �ʴ´�

@WebServlet("/front")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int randNum = (int)(Math.random()+1)*6;
		request.setAttribute("randNum", randNum);//request�� �� ����
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/next");//�̵��� ����, ���� �������� �̵� ������
		requestDispatcher.forward(request, response);
		
	}

}
