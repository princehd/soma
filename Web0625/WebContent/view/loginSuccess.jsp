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
	<h1><%= name %>님 환영합니다.</h1>
	<a href="board.jsp">게시판</a>
</body>
</html>


