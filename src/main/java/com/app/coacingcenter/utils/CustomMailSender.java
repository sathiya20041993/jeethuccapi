package com.app.coacingcenter.utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CustomMailSender {

	private static final String SMTP_HOST_NAME = "sg3plcpnl0008.prod.sin3.secureserver.net"; // smtp URL
	private static final int SMTP_HOST_PORT = 465; // port number
	private static String SMTP_AUTH_USER = "Academics@digitech.academy"; // email_id of sender
	private static String SMTP_AUTH_PWD = "Abcd@12345"; // password of sender email_id

	public static void sendEmail(String toAddress, String subject, String content) {
		try {
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtps");
			props.put("mail.smtps.host", SMTP_HOST_NAME);
			props.put("mail.smtps.auth", "true");

			Session mailSession = Session.getDefaultInstance(props);
			mailSession.setDebug(true);
			Transport transport = mailSession.getTransport();
			MimeMessage message = new MimeMessage(mailSession);

			message.setSubject(subject);
			message.setContent(content, "text/html");
			Address[] from = InternetAddress.parse("Academics@digitech.academy");
			message.addFrom(from);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));

			transport.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER, SMTP_AUTH_PWD);
			transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
