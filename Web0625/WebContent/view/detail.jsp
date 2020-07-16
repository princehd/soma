<%@page import="model.BoardDTO"%>
<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String num = request.getParameter("num");
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.selectOneBoard(num);
	%>
	<h1>상세내용</h1>
	<table border='solid'>
		<tr>
			<td>글번호</td>
			<td></td>
		</tr>
		<tr>
			<td>제목</td>
			<td></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td></td>
		</tr>
		<tr>
			<td>작성일자</td>
			<td></td>
		</tr>
		<tr>
			<td>내용</td>
			<td></td>
		</tr>
	</table>

</body>
</html>



