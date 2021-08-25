<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Upload Form</h1>
	<br>
	<br>
	<form method="post" action="upload" enctype="multipart/form-data">

		file : <input type="file" name="file" accept="image/*"><br> <input
			type="submit">
	</form>
</body>
</html>