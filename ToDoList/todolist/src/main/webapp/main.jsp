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
				<ul class=todoList>
					<c:forEach items="${todo }" var="list">
						<li class="todo">
							<div class="text">
								<div class="what">
									<c:out value="${list.getTitle() }" />
								</div>
								<div class="date">
									등록날짜: ${list.getRegDate() }<br> ${list.getName() }<br> 우선순위 ${list.getSequence() }
								</div>
							</div>
							<button class="move-done-btn" onclick="moveTodo(${list})" }>→</button>
						</li>
					</c:forEach>
					<li class="todo">
						<div class="text">

							<div class="what">공부</div>
							<div class="date">등록날짜:</div>
						</div>
						<button class="move-done-btn">→</button>
					</li>
				</ul>
			</div>
			<div class="list-container">
				<div class="list-header">DOING</div>
				<ul class=doingList>
					<c:forEach items="${doing }" var="list">
						<li class="doing">
							<div class="text">
								<div class="what">
									<c:out value="${list.getTitle() }" />
								</div>
								<div class="date">
									등록날짜: ${list.getRegDate() }<br> ${list.getName() }<br> 우선순위 ${list.getSequence() }
								</div>
							</div>
							<form action="./todotype" action="post">
								<button class="move-done-btn" onclick="moveTodo(${list.getId()}) id=${list.getId()">→</button>
							</form>
						</li>
					</c:forEach>
					<li class="doing">
						<div class="text">
							<div class="what">공부</div>
							<div class="date">등록날짜:</div>
						</div>
						<button class="move-done-btn" name="${list}">→</button>
					</li>
				</ul>
			</div>
			<div class="list-container">
				<div class="list-header">DONE</div>
				<ul class="doneList">
					<c:forEach items="${done }" var="list">
						<li class="done">
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
					<li class="done">
						<div class="text">
							<div class="what">공부</div>
							<div class="date">등록날짜:</div>
						</div>
					</li>
				</ul>
			</div>
		</section>
	</div>
</body>
</html>