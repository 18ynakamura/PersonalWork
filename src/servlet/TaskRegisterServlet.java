package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.TaskService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/taskRegister")
public class TaskRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		String text =request.getParameter("task");

		if(text == null || text.equals("")) {
			//System.out.println("a");
		session.setAttribute("msg", "Taskを入力してください");
		request.getRequestDispatcher("taskRegister.jsp").forward(request, response);
		return;
		}else {
			//System.out.println("b");
		TaskService taskService = new TaskService();
		taskService.taskRegister(id,  text);
		request.getRequestDispatcher("taskRegisterResult.jsp").forward(request,  response);
		return;
		}
	}

}
