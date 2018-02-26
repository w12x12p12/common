package com.hongedu.honghr.util.mail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.hongedu.honghr.honghr.entity.Mail;
import com.hongedu.honghr.honghr.filter.ExceptionFilter;

public class MailCommon {

	private static String sendHost;// 发件人所用协议服务器
	private static String sendUser;// 发件人邮箱地址
	private static String password;// 发件人邮箱密码

	static {
		// 读取配置文件
		Properties properties = new Properties();
		InputStream input = ExceptionFilter.class.getResourceAsStream("/mail.properties");
		try {
			properties.load(input);
			sendHost = properties.getProperty("mail.sendHost");
			sendUser = properties.getProperty("mail.sendUser");
			password = properties.getProperty("mail.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void sendMail(Mail receiver) {
		Mail mail = new Mail();
		mail.setHost(sendHost);
		mail.setUsername(sendUser);
		mail.setPassword(password);
		mail.setMail_head_name("this is head of this mail");
		mail.setMail_head_value("this is head of this mail");
		mail.setMail_to(receiver.getMail_to());
		mail.setMail_from(sendUser);
		mail.setMail_subject(receiver.getMail_subject());// 设置邮件的标题
		mail.setMail_content(receiver.getMail_content());// 设置邮件的内容
		mail.setPersonalName(receiver.getPersonalName());// 设置邮件的发件人名称
		MailUtil.sendMail(mail);// 发送邮件
	}
}