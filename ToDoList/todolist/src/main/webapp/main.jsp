<%@page import="com.boostcourse.todolist.dto.TodoDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To Do List</title>
<link rel="stylesheet" href="index.css">
</head>
<body>
	<div class="section">
		<header>
			<span class="title">나의 해야할 일들</span>
			<button class="new-todo" onclick="location.href='todoform'">새로운 TODO등록</button>
		</header>
		<section>
			<div class="list-container">
				<div class="list-header">TODO</div>
				<ul class="todo">
					<c:forEach items="${todo }" var="list">
						<li>
							<div class="text">
								<div class="what">
									<c:out value="${list.getTitle() }" />
								</div>
								<div class="date">
									등록날짜: ${list.getRegDate() }<br> ${list.getName() }<br> 우선순위 ${list.getSequence() }
								</div>
							</div>
							<button class="move-done-btn" onclick="moveBtn(${list.getId()}, this)">→</button>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="list-container">
				<div class="list-header">DOING</div>
				<ul class="doing">
					<c:forEach items="${doing }" var="list">
						<li>
							<div class="text">
								<div class="what">
									<c:out value="${list.getTitle() }" />
								</div>
								<div class="date">
									등록날짜: ${list.getRegDate() }<br> ${list.getName() }<br> 우선순위 ${list.getSequence() }
								</div>
							</div>
							<button class="move-done-btn" onclick="moveBtn(${list.getId()}, this)">→</button>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="list-container">
				<div class="list-header">DONE</div>
				<ul class="done">
					<c:forEach items="${done }" var="list">
						<li>
							<div class="text">
								<div class="what">
									<c:out value="${list.getTitle() }" />
								</div>
								<div class="date">
									등록날짜: ${list.getRegDate() }<br> ${list.getName() }<br> 우선순위 ${list.getSequence() }
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</section>
	</div>
	<script type="text/javascript" src="main.js"></script>
</body>
</html>