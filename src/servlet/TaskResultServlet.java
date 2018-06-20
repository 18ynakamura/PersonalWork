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
 * Servlet implementation class TaskFinishServlet
 */
@WebServlet("/taskResult")
public class TaskResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskResultServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//checkがついたタスクのtaskIdを配列で取得
		HttpSession session = request.getSession();
		TaskService taskService = new TaskService();

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
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}

}
