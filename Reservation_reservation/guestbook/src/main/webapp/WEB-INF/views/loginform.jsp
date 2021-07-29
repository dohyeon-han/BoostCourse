<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h4>비밀번호를 입력해 주세요</h4>
	<h5>${errorMsg }</h5>
	<form action="login" method="post">
		<input type="password" name="password"> <input type="submit"
			value="전송">
	</form>
</body>
</html>