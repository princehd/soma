package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDAO;
import model.BoardDTO;

@WebServlet("/selectAllBoard")
public class SelectAllBoard extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dao���� ��û
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> boardList = dao.selectAllBoard();
		// ���� ��� ���� ���ǿ� ����
		HttpSession session = request.getSession();
		session.setAttribute("list", boardList);
		// View�� �̵�
		response.sendRedirect("view/board.jsp");
	}
}



