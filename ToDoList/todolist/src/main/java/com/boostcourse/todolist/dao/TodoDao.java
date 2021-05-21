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

	public List<TodoDto> getTodo(String state) {
		List<TodoDto> list = new ArrayList<TodoDto>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql = "select * from todo where type='"+state+"' order by regdate desc";
		try(Connection con = DriverManager.getConnection(url,id,pw);
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				ResultSet rs = pstmt.executeQuery();){
			
			while(rs.next()) {
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
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
