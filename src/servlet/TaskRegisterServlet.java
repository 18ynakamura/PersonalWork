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
@WebServlet("/taskRegister")
public class TaskRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		TaskService taskService = new TaskService();
		int id = (int) session.getAttribute("id");
		String text =request.getParameter("task");

		if(text == null || text.equals("")) {
			session.setAttribute("msg", "Taskを入力してください");
			request.getRequestDispatcher("taskRegister.jsp").forward(request, response);
			return;

		}else {
			//Task登録
			taskService.taskRegister(id,  text);

			//unfinishedTaskListとfinishedTaskListをrequestにセット
			List<Task> list = taskService.selectUnfinishedTask(id);
			List<Task> finishedList = taskService.selectFinishedTask(id);
			if (list != null) {
				request.setAttribute("userList",list);
			}else {
				request.setAttribute("msg", "入力されたデータは存在しません");
			}
			if(finishedList != null) {
				request.setAttribute("finishedList", finishedList);
			}
			request.getRequestDispatcher("menu.jsp").forward(request, response);

			return;
		}
	}

}
