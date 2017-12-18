package com.ctgu.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctgu.domain.User;
import com.ctgu.service.UserService;
import com.ctgu.service.impl.UserServiceImpl;
import com.ctgu.utils.UUIDUtils;


/**
 * 用户注册的Servlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 接收数据
			request.setCharacterEncoding("UTF-8");	//防止中文乱码
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String nickname = request.getParameter("nickname");
			String email = request.getParameter("email");
			// 封装数据
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setNickname(nickname);
			user.setEmail(email);
			user.setStatus(0);  // 0: 未激活  1: 已经激活
			String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();  //64位的随机字符串
			user.setCode(code);
			// 调用业务层处理数据
			UserService userService = new UserServiceImpl();
			userService.regist(user);
			// 页面跳转
			request.setAttribute("msg", "恭喜您注册成功！ 请去邮箱激活！");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
