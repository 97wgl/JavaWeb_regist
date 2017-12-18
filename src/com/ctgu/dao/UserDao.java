package com.ctgu.dao;

import java.sql.SQLException;

import com.ctgu.domain.User;

public interface UserDao {

	void regist(User user) throws SQLException;

	User findByCode(String code) throws SQLException, Exception;

	void update(User user) throws SQLException;

}
