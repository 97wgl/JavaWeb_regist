package com.ctgu.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;


/**
 * 
 * @title MainUtils.java
 * @description 发送邮件的工具类
 * @author 王桂林
 * @date 2017年12月15日 下午11:07:02
 *
 */

public class MailUtils {
	/**
	 * 发送邮件的方法
	 * 
	 * @param to
	 *            ：收件人的地址
	 * @param code：邮件中注册用户的激活码
	 * @throws Exception
	 */
	public static void sendMail(String to, String code) throws Exception {

		// 1.创建连接对象，连接到邮箱服务器
		Properties props = new Properties();
		// 开启debug调试，以便在控制台查看
		props.setProperty("mail.debug", "true"); 
		// 设置邮件服务器主机名
		props.setProperty("mail.host", "smtp.qq.com");
		// 发送服务器需要身份验证
		props.setProperty("mail.smtp.auth", "true");
		// 发送邮件协议名称
		props.setProperty("mail.transport.protocol", "smtp");
		// 开启SSL加密，否则会失败
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("1475693887@qq.com", "这里填你自己的邮箱授权码就行了");// 用户名和授权码
			}
		});

		// 2.创建邮件对象
		Message message = new MimeMessage(session);
		// 2.1设置发件人:
		message.setFrom(new InternetAddress("1475693887@qq.com"));
		// 2.2设置收件人:
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		// 2.3设置邮件的主题:
		message.setSubject("来自xx网站的激活邮件");
		// 2.4设置邮件的正文:
		message.setContent(
				"<h1>来自xx网站的激活连接，激活请点击以下链接：<a href='http://localhost:8080/regist/ActiveServlet?code=" + code
						+ "'>http://localhost:8080/regist/ActiveServlet?code=" + code + "'</a></h1>",
				"text/html;charset=utf-8");

		// 3.发送一封激活邮件
		Transport.send(message);
	}
}
