<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
					<li class="doing">
						<div class="text">
							<div class="what">공부</div>
							<div class="date">등록날짜:</div>
						</div>
						<button class="move-done-btn">→</button>
					</li>
				</ul>
			</div>
			<div class="list-container">
				<div class="list-header">DONE</div>
				<ul class="doneList">
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