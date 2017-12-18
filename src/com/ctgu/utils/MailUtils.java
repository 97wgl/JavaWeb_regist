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
 * @description �����ʼ��Ĺ�����
 * @author ������
 * @date 2017��12��15�� ����11:07:02
 *
 */

public class MailUtils {
	/**
	 * �����ʼ��ķ���
	 * 
	 * @param to
	 *            ���ռ��˵ĵ�ַ
	 * @param code���ʼ���ע���û��ļ�����
	 * @throws Exception
	 */
	public static void sendMail(String to, String code) throws Exception {

		// 1.�������Ӷ������ӵ����������
		Properties props = new Properties();
		// ����debug���ԣ��Ա��ڿ���̨�鿴
		props.setProperty("mail.debug", "true"); 
		// �����ʼ�������������
		props.setProperty("mail.host", "smtp.qq.com");
		// ���ͷ�������Ҫ�����֤
		props.setProperty("mail.smtp.auth", "true");
		// �����ʼ�Э������
		props.setProperty("mail.transport.protocol", "smtp");
		// ����SSL���ܣ������ʧ��
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("1475693887@qq.com", "���������Լ���������Ȩ�������");// �û�������Ȩ��
			}
		});

		// 2.�����ʼ�����
		Message message = new MimeMessage(session);
		// 2.1���÷�����:
		message.setFrom(new InternetAddress("1475693887@qq.com"));
		// 2.2�����ռ���:
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		// 2.3�����ʼ�������:
		message.setSubject("����xx��վ�ļ����ʼ�");
		// 2.4�����ʼ�������:
		message.setContent(
				"<h1>����xx��վ�ļ������ӣ����������������ӣ�<a href='http://localhost:8080/regist/ActiveServlet?code=" + code
						+ "'>http://localhost:8080/regist/ActiveServlet?code=" + code + "'</a></h1>",
				"text/html;charset=utf-8");

		// 3.����һ�⼤���ʼ�
		Transport.send(message);
	}
}
