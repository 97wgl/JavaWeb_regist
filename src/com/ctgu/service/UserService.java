package com.ctgu.service;

import java.sql.SQLException;

import com.ctgu.domain.User;

public interface UserService {

	void regist(User user) throws Exception;

	User findByCode(String code) throws SQLException, Exception;

	void update(User user) throws SQLException;

}
