<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
pageContext.setAttribute("p1","page scope");
request.setAttribute("r1", "request scope");
session.setAttribute("s1", "session scope");
application.setAttribute("a1", "application scope");

request.setAttribute("k", 10);
request.setAttribute("l", 20);
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 변수명이 겹치지 않는다면 객체를 명시하지 않아도 된다. 가급적이면 객체(scope)를 명시해주자 -->
	pageContext.getAttribute("p1") : <%=pageContext.getAttribute("p1") %><br>
	pageContext.getAttribute("p1") : ${pageScope.p1 }<br>
	pageContext.getAttribute("p1") : ${p1 }<br>
	request.setAttribute("r1") : ${r1 }<br>
	session.setAttribute("s1") : ${s1 }<br>
	application.setAttribute("a1") : ${a1 }<br>
	k = ${k}, l = ${l}<br> 
	k + l : ${k+l }<br>
	k * l : ${k*l }<br>
	k == l : ${k==l }<br>
	k > l : ${k>l }<br>
	k <= l : ${k<=l }<br>
	k * m(null) : ${k*m }<br>
	
</body>
</html>