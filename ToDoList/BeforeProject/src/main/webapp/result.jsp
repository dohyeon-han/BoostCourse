<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%
	int rand1 = (int)request.getAttribute("rand1");
	int rand2 = (int)request.getAttribute("rand2");
	int rst = (int)request.getAttribute("rst");
	%>
	<%=rand1 %> + <%=rand2 %> = <%=rst %> --%>
	${rand1 }+${rand2 }+${rst }<!-- el표기법 겁나 좋네!! -->
</body>
</html>