package com.ctgu.service.impl;


import java.sql.SQLException;

import com.ctgu.dao.UserDao;
import com.ctgu.dao.impl.UserDaoImpl;
import com.ctgu.domain.User;
import com.ctgu.service.UserService;
import com.ctgu.utils.MailUtils;

public class UserServiceImpl implements UserService {

	@Override
	// ҵ����û�ע��ķ���
	public void regist(User user) throws Exception {
		// �����ݴ浽���ݿ�
		UserDao userDao = new UserDaoImpl();
		userDao.regist(user);
		// ����һ�⼤���ʼ�
		MailUtils.sendMail(user.getEmail(), user.getCode());
	}

	@Override
	//���ݼ������ѯ�û��ķ���
	public User findByCode(String code) throws Exception {
		UserDao userDao = new UserDaoImpl();
		return userDao.findByCode(code);
	}

	@Override
	// ҵ����޸��û��ķ���
	public void update(User user) throws SQLException {
		UserDao userDao = new UserDaoImpl();
		userDao.update(user);
	}

}
