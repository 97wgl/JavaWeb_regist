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
 * �û�ע���Servlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// ��������
			request.setCharacterEncoding("UTF-8");	//��ֹ��������
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String nickname = request.getParameter("nickname");
			String email = request.getParameter("email");
			// ��װ����
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setNickname(nickname);
			user.setEmail(email);
			user.setStatus(0);  // 0: δ����  1: �Ѿ�����
			String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();  //64λ������ַ���
			user.setCode(code);
			// ����ҵ��㴦������
			UserService userService = new UserServiceImpl();
			userService.regist(user);
			// ҳ����ת
			request.setAttribute("msg", "��ϲ��ע��ɹ��� ��ȥ���伤�");
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
