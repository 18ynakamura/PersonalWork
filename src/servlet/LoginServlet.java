package servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Characters;
import entity.LevelInfo;
import entity.Task;
import entity.User;
import service.CharacterService;
import service.LevelInfoService;
import service.TaskService;
import service.UserService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");


		if ((name == null || pass == null) || ("".equals(name)) || ("".equals(pass))) {
			// メッセージ設定
			request.setAttribute("msg", "入力項目は必須です");

			// 次画面指定
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		// ログインチェック
		UserService userService = new UserService();
		CharacterService characterService = new CharacterService();
		LevelInfoService levelInfoService = new LevelInfoService();
		User user = userService.authentication(name, pass);
		boolean isSuccess = user != null;


		// 表示メッセージの受け渡し
		if (isSuccess) {
			// メッセージ設定
			//SessionにNameとIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("name", user.getUserName());
			session.setAttribute("id", user.getUserId());
			//該当ユーザーのexpをset
			request.setAttribute("exp", characterService.getExp(user.getUserId()));

			//Character情報をセッションスコープに保存
			Characters c = characterService.getAll(user.getUserId());
			session.setAttribute("user_id", c.getUser_id());
			session.setAttribute("level", c.getLevel());
			session.setAttribute("c_exp", c.getC_exp());
			session.setAttribute("c_hp", c.getC_hp());

			//Levelに関連した情報をセッションスコープに保存
			LevelInfo l = levelInfoService.getAll(c.getLevel());
			session.setAttribute("exp", l.getExp());
			session.setAttribute("hp", l.getHp());

			//tasksのカラムuser_idがuser.getUserId() (ログインしたuser_id)と一致するTaskをDBから取得、Sessionに保存
			TaskService taskService = new TaskService();
			List<Task> list = taskService.selectUnfinishedTask(user.getUserId());
			List<Task> finishedList = taskService.selectFinishedTask(user.getUserId());
			if (list != null) {
				request.setAttribute("userList",list);
			}else {
				request.setAttribute("msg", "入力されたデータは存在しません");
			}
			if (finishedList != null) {
				request.setAttribute("finishedList",finishedList);
			}else {
				request.setAttribute("msg", "入力されたデータは存在しません");
			}
			// 次画面指定
			request.getRequestDispatcher("menu.jsp").forward(request, response);
			return;

		} else {
			// メッセージ設定
			request.setAttribute("msg", "IDまたはPASSが間違っています。");

			// 次画面指定
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

	}

}
