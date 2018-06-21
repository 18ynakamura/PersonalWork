package servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Task;
import service.TaskService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/taskDelete")
public class TaskDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		TaskService taskService = new TaskService();
		HttpSession session = request.getSession();

		taskService.taskDelete();

		List<Task> list = taskService.selectUnfinishedTask((int)session.getAttribute("id"));
		List<Task> finishedList = taskService.selectFinishedTask((int)session.getAttribute("id"));
		if (list != null) {
			request.setAttribute("userList",list);
		}else {
			request.setAttribute("msg", "入力されたデータは存在しません");
		}
		if(finishedList != null) {
			request.setAttribute("finishedList", finishedList);
		}
		request.getRequestDispatcher("menu.jsp").forward(request,  response);

	}

}
