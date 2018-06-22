package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/registerConfirm")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		HttpSession session = request.getSession();

		if((pass==null||pass.equals(""))|| (name==null|| name.equals(""))) {
			session.setAttribute("msg", "全ての項目に入力してください");
		}else {
		session.setAttribute("rPass", pass);
		session.setAttribute("rName", name);

		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("registerResult.jsp").forward(request,  response);
		}
	}

}
