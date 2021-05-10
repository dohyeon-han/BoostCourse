<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<head class="registTitle">할일 등록
</head>
<section>
	<form action="">
		<div class="what">
			어떤일인가요?
			<input type="text" placeholder="spring 공부하기(24자까지)" maxlength="24">
		</div>
		<div class="who">
			누가 할일인가요?
			<input type="text" placeholder="홍길동">
		</div>
		<div class="priority">
			우선순위를 선택하세요
			<input type="radio" name="priority">
			1순위
			<input type="radio" name="priority">
			2순위
			<input type="radio" name="priority">
			3순위
		</div>
	</form>
	<div class="buttonContainer">
		<button onclick="location.href='main.jsp'"> &lt; 이전</button>
		<button>제출</button>
		<button>내용 지우기</button>
	</div>
</section>
<footer> </footer>
</body>
</html>