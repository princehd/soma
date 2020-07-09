package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO(id,pw,name);
		boolean isSuccess = dao.join(dto);
		
		if(isSuccess) {
			// ������
			response.sendRedirect("view/joinSuccess.html"); // �������̵�
		}else {
			// ���н�
			response.sendRedirect("view/joinFail.html"); // �������̵�
		}
	}
}





