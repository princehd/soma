package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberDTO;

// URL Mapping : ������ ȣ���ϱ����� �ּ�
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO(id,pw);
		String name = dao.login(dto);
		
		if(name != null) {
			// ����
			// server���� ���¸� �����ϱ� ���� ����(��ü)
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", name);
			response.sendRedirect("view/loginSuccess.jsp"); // �������̵�
		}else {
			// ����
			response.sendRedirect("view/loginFail.html"); // �������̵�
		}
			
		
	}

}



