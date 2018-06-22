package servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.CharLvJoin2;
import entity.LevelInfo;
import entity.Task;
import service.CharacterService;
import service.LevelInfoService;
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
		LevelInfoService levelInfoService = new LevelInfoService() ;
		int id = (int)session.getAttribute("id");
		int level = (int)session.getAttribute("level");
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
			int maxExp = levelInfoService.getExp(characterService.getLevel(id));

			if((reExp - maxExp) >= 0) {
				reExp -= maxExp;

				LevelInfo levelInfo = levelInfoService.getAll(level + 1);
				characterService.setAll(levelInfo.getHp(),levelInfo.getLevel(),reExp, id);
				session.removeAttribute("level");
				session.removeAttribute("c_hp");
				session.removeAttribute("c_exp");
				session.removeAttribute("hp");
				session.removeAttribute("exp");
				session.setAttribute("level", levelInfo.getLevel());
				session.setAttribute("c_hp", levelInfo.getHp());
				session.setAttribute("c_exp", reExp);
				session.setAttribute("hp", levelInfo.getHp());
				session.setAttribute("exp", levelInfo.getExp());

			} else {
				//こなしたタスク数*4だけhp回復
				CharLvJoin2 ch = characterService.getJoinHp(id);
				int c_hp = ch.getC_hp();
				int hp = ch.getHp();
				if((hp - c_hp) >= (sList.length * 4)) {
					c_hp += (sList.length * 4);
				}else if(c_hp <= hp) {
					c_hp = hp;
				}
				characterService.setExp(reExp, id);
				characterService.setHp(c_hp, id);
				session.removeAttribute("c_exp");
				session.removeAttribute("c_hp");
				session.setAttribute("c_exp", reExp);
				session.setAttribute("c_hp", c_hp);
			}
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
