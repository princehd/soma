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
			<td></td>
		</tr>
		<tr>
			<td>����</td>
			<td></td>
		</tr>
		<tr>
			<td>�ۼ���</td>
			<td></td>
		</tr>
		<tr>
			<td>�ۼ�����</td>
			<td></td>
		</tr>
		<tr>
			<td>����</td>
			<td></td>
		</tr>
	</table>

</body>
</html>



