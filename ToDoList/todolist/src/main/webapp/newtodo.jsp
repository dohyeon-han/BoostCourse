<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="newtodo.css">
</head>
<body>
	<div class="frame">
		<header>할일 등록</header>
		<section>
			<form action="./todoadd" method="post" id="add">
				<div class="what">
					<div class="font">어떤일인가요?</div>
					<input class="what-text" type="text" placeholder="spring 공부하기(24자까지)" maxlength="24" name="title">
				</div>
				<div class="who">
					<div class="font">누가 할일인가요?</div>
					<input class="who-text" type="text" placeholder="홍길동" name="name">
				</div>
				<div class="priority">
					<div class="font">우선순위를 선택하세요</div>
					<div class="radio">
						<label> <input class="priority-radio" type="radio" name="priority" value="1" checked="checked"> 1순위&nbsp;&nbsp;&nbsp;
						</label> <label> <input class="priority-radio" type="radio" name="priority" value="2"> 2순위&nbsp;&nbsp;&nbsp;
						</label> <label> <input class="priority-radio" type="radio" name="priority" value="3"> 3순위&nbsp;&nbsp;&nbsp;
						</label>
					</div>
				</div>
			</form>
			<div class="button-container">
				<button class="before" onclick="location.href='main'">&lt; 이전</button>
				<div>
					<button class="update" type="submit" form="add">제출</button>
					<button class="update erase">내용 지우기</button>
				</div>

			</div>
		</section>
	</div>
	<script src="newtodo.js"></script>
</body>
</html>