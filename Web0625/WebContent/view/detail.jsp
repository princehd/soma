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
	<h1>�󼼳���</h1>
	<table border='solid'>
		<tr>
			<td>�۹�ȣ</td>
			<td><%= dto.getBoard_num() %></td>
		</tr>
		<tr>
			<td>����</td>
			<td><%= dto.getBoard_title() %></td>
		</tr>
		<tr>
			<td>�ۼ���</td>
			<td><%= dto.getBoard_writer() %></td>
		</tr>
		<tr>
			<td>�ۼ�����</td>
			<% SimpleDateFormat simformat =
			 new SimpleDateFormat("yyyy-MM-dd"); %>
			<td><%= simformat.format(dto.getBoard_date()) %></td>
		</tr>
		<tr>
			<td>����</td>
			<td><%= dto.getBoard_content() %></td>
		</tr>
	</table>

</body>
</html>



