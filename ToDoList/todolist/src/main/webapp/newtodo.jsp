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
			<form action="" method="post">
				<div class="what">
					<div class="font">어떤일인가요?</div>
					<input class="what-text" type="text" placeholder="spring 공부하기(24자까지)" maxlength="24">
				</div>
				<div class="who">
					<div class="font">누가 할일인가요?</div>
					<input class="who-text" type="text" placeholder="홍길동">
				</div>
				<div class="priority">
					<div class="font">우선순위를 선택하세요</div>
					<div class="radio">
						<label> <input class="priority-radio" type="radio" name="priority" value="1순위" checked="checked"> 1순위&nbsp;&nbsp;&nbsp;
						</label> <label> <input class="priority-radio" type="radio" name="priority" value="2순위"> 2순위&nbsp;&nbsp;&nbsp;
						</label> <label> <input class="priority-radio" type="radio" name="priority" value="3순위"> 3순위&nbsp;&nbsp;&nbsp;
						</label>
					</div>

				</div>
			</form>
			<div class="button-container">
				<button class="before" onclick="location.href='main.jsp'">&lt; 이전</button>
				<div>
					<button class="update">제출</button>
					<button class="update erase">내용 지우기</button>
				</div>

			</div>
		</section>
	</div>
	<script src="newtodo.js"></script>
</body>
</html>