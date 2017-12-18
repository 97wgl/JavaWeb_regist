package com.ctgu.service.impl;


import java.sql.SQLException;

import com.ctgu.dao.UserDao;
import com.ctgu.dao.impl.UserDaoImpl;
import com.ctgu.domain.User;
import com.ctgu.service.UserService;
import com.ctgu.utils.MailUtils;

public class UserServiceImpl implements UserService {

	@Override
	// 业务层用户注册的方法
	public void regist(User user) throws Exception {
		// 将数据存到数据库
		UserDao userDao = new UserDaoImpl();
		userDao.regist(user);
		// 发送一封激活邮件
		MailUtils.sendMail(user.getEmail(), user.getCode());
	}

	@Override
	//根据激活码查询用户的方法
	public User findByCode(String code) throws Exception {
		UserDao userDao = new UserDaoImpl();
		return userDao.findByCode(code);
	}

	@Override
	// 业务层修改用户的方法
	public void update(User user) throws SQLException {
		UserDao userDao = new UserDaoImpl();
		userDao.update(user);
	}

}
