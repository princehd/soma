<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
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
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> boardList = dao.selectAllBoard();
	%>
	<h1>�Խ���</h1>
	<table border="solid">
		<tr>
			<td>��ȣ</td>
			<td>����</td>
			<td>�ۼ���</td>
			<td>��¥</td>
		</tr>
	<% for(int i=0;i<boardList.size();i++){ 
		BoardDTO dto = boardList.get(i);
		SimpleDateFormat simformat 
				= new SimpleDateFormat("yyyy-MM-dd");
	%>
		<tr>
			<td><%= dto.getBoard_num() %></td>
			<td><a href="detail.jsp?num=<%=dto.getBoard_num()%>"><%= dto.getBoard_title() %></a></td>
			<td><%= dto.getBoard_writer() %></td>
			<td><%= simformat.format(dto.getBoard_date()) %></td>
		</tr>
	<% } %>
	</table>
</body>
</html>




