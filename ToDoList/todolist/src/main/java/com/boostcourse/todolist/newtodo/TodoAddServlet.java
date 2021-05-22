package com.boostcourse.todolist.newtodo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boostcourse.todolist.dao.TodoDao;
import com.boostcourse.todolist.dto.TodoDto;

@WebServlet("/todoadd")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF8");
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("priority"));
		
		TodoDao dao = new TodoDao();
		TodoDto dto = new TodoDto(title,name,sequence,"DOING");
		dao.addTodo(dto);
		response.sendRedirect("./main");
	}

}
