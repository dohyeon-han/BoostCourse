package com.boostcourse.todolist.dto;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet("/tododto")
public class TodoDto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int id, sequence;
	private String name, regDate, title, type;

	public TodoDto() {
		
	}
	public TodoDto(int id, String title, String name, int sequence,String type, String regDate) {
		super();
		this.id = id;
		this.name = name;
		this.regDate = regDate;
		this.title = title;
		this.type = type;
		this.sequence = sequence;
	}
	public TodoDto(String title, String name, int sequence) {
		super();
		this.name = name;
		this.title = title;
		this.sequence = sequence;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

}
