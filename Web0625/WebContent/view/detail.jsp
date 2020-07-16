<%@page import="java.text.SimpleDateFormat"%>
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
			<td><%= dto.getBoard_num() %></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><%= dto.getBoard_title() %></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%= dto.getBoard_writer() %></td>
		</tr>
		<tr>
			<td>작성일자</td>
			<% SimpleDateFormat simformat =
			 new SimpleDateFormat("yyyy-MM-dd"); %>
			<td><%= simformat.format(dto.getBoard_date()) %></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><%= dto.getBoard_content() %></td>
		</tr>
	</table>

</body>
</html>



