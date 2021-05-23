package com.boostcourse.todolist.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.boostcourse.todolist.dto.TodoDto;

public class TodoDao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String id = "c##scott";
	private static String pw = "tiger";

	public void oracle() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<TodoDto> getTodo(String state) {
		List<TodoDto> list = new ArrayList<TodoDto>();

		oracle();

		String sql = "select * from todo where type='" + state + "' order by regdate";
		try (Connection con = DriverManager.getConnection(url, id, pw);
				PreparedStatement pstmt = con.prepareStatement(sql);

				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String name = rs.getString("name");
				String type = rs.getString("type");
				int seq = rs.getInt("sequence");
				Date date = rs.getDate("regdate");
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String date_str = transFormat.format(date);

				TodoDto data = new TodoDto(id, title, name, seq, type, date_str);
				list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addTodo(TodoDto dto) {
		oracle();

		String sql = "insert into todo(id,title,name,type,sequence) values(auto_inc.nextval,?,?,'TODO',?)";
		try (Connection con = DriverManager.getConnection(url, id, pw);
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getSequence());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String updateTodo(String type, int todoId) {
		oracle();

		if (type.equals("todo"))
			type = "DOING";
		else
			type = "DONE";

		String sql = "update todo set type='" + type + "' where id=" + todoId;
		int flag = 0;

		try (Connection con = DriverManager.getConnection(url, id, pw);
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			flag = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (flag == 1 ? "success" : "fali");
	}
}
