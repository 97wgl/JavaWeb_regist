package com.ctgu.domain;

/**
 * 
 * @title User.java
 * @description 
 * 	CREATE TABLE `user` (
 *		`uid` int(11) NOT NULL AUTO_INCREMENT,
 * 		`username` varchar(20) DEFAULT NULL,
 * 		`password` varchar(32) DEFAULT NULL,
 *		`nickname` varchar(20) DEFAULT NULL,
 * 		`email` varchar(30) NOT NULL,
 *		`status` int(11) DEFAULT NULL,
 * 		`code` varchar(64) DEFAULT NULL,
 *		PRIMARY KEY (`uid`)
 *	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * @author 王桂林
 * @date 2017年12月15日 下午10:06:28
 *
 */

public class User {
	private Integer uid;
	private String username;
	private String password;
	private String nickname;
	private String email;
	private Integer status;
	private String code;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
