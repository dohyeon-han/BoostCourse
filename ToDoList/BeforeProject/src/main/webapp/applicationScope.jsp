<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	try {
		int value = (int) application.getAttribute("value");
		value++;
		application.setAttribute("value", value);
	%>
	<h1><%=value%></h1>
	<%
	} catch (Exception e) {
	%>
	값이 없습니다.
	<%
	}
	%>
</body>
</html>