package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.CharacterService;
import service.LevelInfoService;
import service.UserService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/register")
public class RegisterConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		UserService userService = new UserService();
		CharacterService characterService = new CharacterService();
		LevelInfoService levelInfoService = new LevelInfoService();

		userService.register(name, pass);
		User user = userService.authentication(name,  pass);
		characterService.chRegister(user.getUserId(),20);
		request.getRequestDispatcher("registerResult.jsp").forward(request,  response);

	}

}
