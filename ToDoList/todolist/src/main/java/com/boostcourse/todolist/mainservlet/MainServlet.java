package com.boostcourse.todolist.mainservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boostcourse.todolist.dao.TodoDao;
import com.boostcourse.todolist.dto.TodoDto;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8" );
		TodoDao dao = new TodoDao(); 
		List<TodoDto> todo = new ArrayList<TodoDto>();
		List<TodoDto> doing = new ArrayList<TodoDto>();
		List<TodoDto> done = new ArrayList<TodoDto>();
		todo = dao.getTodo("TODO");
		doing = dao.getTodo("DOING");
		done = dao.getTodo("DONE");
		request.setAttribute("todo", todo);
		request.setAttribute("doing", doing);
		request.setAttribute("done", done);
		
		RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
