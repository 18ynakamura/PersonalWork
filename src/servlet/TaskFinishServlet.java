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
import service.CharacterService;
import service.TaskService;

/**
 * Servlet implementation class TaskFinishServlet
 */
@WebServlet("/taskFinish")
public class TaskFinishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskFinishServlet() {
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
		CharacterService characterService = new CharacterService();
		int id = (int)session.getAttribute("id");
		String[] sList = request.getParameterValues("task");

		//taskIdがString配列に入っているのでIntegerに変換し、unfinished→finishedにupdateするメソッドに使用
		//拡張for文でチェックがついた全てのタスクのstatusをアップデート
		if (sList!=null) {
			for(String s : sList) {
				taskService.taskStatusUpdate(Integer.parseInt(s));
			}
			//こなしたタスク数だけ、expに追加
			int exp = characterService.getExp(id);
			int reExp = exp + sList.length;
			characterService.setExp(reExp, id);
			session.removeAttribute("c_exp");
			session.setAttribute("c_exp", characterService.getExp(id));
		}else {
		}
		List<Task> list = taskService.selectUnfinishedTask(id);
		List<Task> finishedList = taskService.selectFinishedTask(id);
		if (list != null) {
			request.setAttribute("userList",list);
		}
		if(finishedList != null) {
			request.setAttribute("finishedList", finishedList);
		}


		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}

}
