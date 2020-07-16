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

// URL Mapping : 서블릿을 호출하기위한 주소
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO(id,pw);
		String name = dao.login(dto);
		
		if(name != null) {
			// 성공
			// server측에 상태를 저장하기 위한 공간(객체)
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", name);
			response.sendRedirect("view/loginSuccess.jsp"); // 페이지이동
		}else {
			// 실패
			response.sendRedirect("view/loginFail.html"); // 페이지이동
		}
			
		
	}

}



