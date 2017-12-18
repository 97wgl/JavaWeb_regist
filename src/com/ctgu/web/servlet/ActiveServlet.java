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

/**
 * �û������Servlet
 */
@WebServlet("/ActiveServlet")
public class ActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// ���ռ�����
			String code = request.getParameter("code");
			// ���ݼ������ѯ�û�
			UserService userService = new UserServiceImpl();
			User user = userService.findByCode(code);
			if(user != null) {
				// �Ѿ���ѯ�����޸��û���״̬
				user.setStatus(1);
				user.setCode(null);
				userService.update(user);
				request.setAttribute("msg", "��ϲ������ɹ�������ȥ��½�ˣ�");
			} else {
				// ���ݼ�����û�в�ѯ�����û�
				request.setAttribute("msg", "���ļ��������������¼��");
			}
			//ҳ����ת
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
