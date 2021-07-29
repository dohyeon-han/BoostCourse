<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h4>${msg }</h4>
	<c:if test="${randomNum!=null }">
		<form action="guess" method="get">
			<input type="text" name="number">
		</form>
	</c:if>
	<a href="guess">다시 시작하기</a>
	<a href="logout">로그아웃</a>
</body>
</html>