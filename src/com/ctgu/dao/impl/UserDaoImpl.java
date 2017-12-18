package com.ctgu.dao.impl;


import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ctgu.dao.UserDao;
import com.ctgu.domain.User;
import com.ctgu.utils.JDBCUtils;


public class UserDaoImpl implements UserDao {

	@Override
	//DAO中保存用户的方法
	public void regist(User user) throws SQLException {
		QueryRunner queryRunner;
		try {
			queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			String sql = "insert into user values(?,?,?,?,?,?,?)";
			Object[] params = { user.getUid(), user.getUsername(), user.getPassword(), user.getNickname(), user.getEmail(),
					user.getStatus(), user.getCode() };
			queryRunner.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	//DAO中根据激活码查询用户的方法
	public User findByCode(String code) throws Exception {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from user where code = ?";
		return queryRunner.query(sql, new BeanHandler<User>(User.class), code);
	}

	@Override
	//DAO中修改用户的方法
	public void update(User user) throws SQLException {
		try {
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			String sql = "update user set username=?,password=?,nickname=?,email=?,status=?,code=? where uid=?";
			Object[] params = { user.getUsername(), user.getPassword(), user.getNickname(), user.getEmail(),
					user.getStatus(), user.getCode(), user.getUid()};
			queryRunner.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}	
	}
	
}
