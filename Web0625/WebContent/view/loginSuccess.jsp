<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% String name = (String)session.getAttribute("loginUser"); %>
	<h1><%= name %>�� ȯ���մϴ�.</h1>
	<a href="../selectAllBoard">�Խ���</a>
</body>
</html>


