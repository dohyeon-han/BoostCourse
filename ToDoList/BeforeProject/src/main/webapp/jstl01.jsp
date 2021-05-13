<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- jstl을 사용하면 스크립트릿 사용울 줄여 가독성을 높일 수 있다 -->
<!-- scope를 명시하여 변수의 볌위를 결정한다 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%
request.setAttribute("n", 10);
%> --%>
<c:set var="value1" scope="request" value="han"></c:set>
<c:set var="n" scope="request" value="10"></c:set>
<c:set var="score" scope="request" value="89"></c:set>
<%
List<String> list = new ArrayList<>();
list.add("Hello");
list.add("World");
list.add("!!");
request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	성 : ${value1 }
	<br>
	<c:remove var="value1" scope="request"></c:remove>
	성 : ${value1 }<br>
	<c:if test="${n==0 }">
		n과 0은 같다
	</c:if>
	<c:if test="${n==10 }">
		n과 10은 같다
	</c:if>
	<c:remove var="n" scope="request"></c:remove>
	<br>
	<c:choose>
		<c:when test="${score>=90 }">1등급</c:when>
		<c:when test="${score>=80 }">2등급</c:when>
		<c:otherwise>3등급</c:otherwise>
	</c:choose>
	${score }<br>
	
	<c:forEach items="${list }" var="str" begin="1" end="2">
		${str }<br>
	</c:forEach>
	
	
	<c:set var="js" value="<script type='text/javascript'>alert('Wow');</script>"></c:set>
	<c:out value="${js }" escapeXml="false"></c:out>
</body>
</html>