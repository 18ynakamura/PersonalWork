package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.CharLvJoin;
import entity.Monster;
import service.CharacterService;
import service.MonsterService;

/**
 * Servlet implementation class battleServlet
 */
@WebServlet("/battle")
public class battleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public battleServlet() {
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
		HttpSession session = request.getSession();
		MonsterService monsterService = new MonsterService();
		CharacterService characterService = new CharacterService();
		Monster m = monsterService.getAll(1);
		CharLvJoin join = characterService.getHpAttack((int)session.getAttribute("id"));
		int mAttack = m.getMonster_attack();
		int monster_hp = m.getMonster_hp();
		int cAttack = join.getAttack();
		int c_hp = join.getC_hp();
		int r;
		List<String> list = new ArrayList<String>();
		if (c_hp == 0) {
			list.add("戦う気力がありません");
		}
		while(monster_hp > 0 && c_hp > 0){
			r = new java.util.Random().nextInt(3);
			int random = cAttack + r;
			list.add("主人公の攻撃！　　　モンスターは" + random + "のダメージを受けた。");
			list.add("モンスターの攻撃！　主人公は" + mAttack + "のダメージを受けた。");
			monster_hp -= random;
			c_hp -= mAttack;

			if(monster_hp < 0) {
				monster_hp = 0;
			list.add("主人公の勝利！");
			}
			if(c_hp < 0) {
				c_hp = 0;
			list.add("モンスターの勝利！");
			}
		}
		//charactersテーブルのc_hpを更新、セッションに保存
		characterService.setHp(c_hp,(int)session.getAttribute("user_id"));
		session.removeAttribute("c_hp");
		session.setAttribute("c_hp", c_hp);

		request.setAttribute("battleLog", list);

		request.getRequestDispatcher("battleResult.jsp").forward(request,  response);
	}

}
