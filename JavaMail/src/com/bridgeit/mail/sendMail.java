package com.bridgeit.mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendMail {

	public static void main(String[] args)
	{
		sendEmail("modugusrikanth1@gmail.com", "8985358626", "patil1yogesh21@gmail.com",
				"this the second mail", "all the best");
     }

	public static void sendEmail(String fromEmail, String password, String toEmail, String subject,
			String message)
	{

		try 
		{
			Properties props = System.getProperties();
			props.put("mail.stmp.host", "smtp.gmail.com");
			props.put("mail.stmp.auth", "true");
			props.put("mail.stmp.port", "465");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.stmp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.stmp.socketFactory.port", "465");
			props.put("mail.stmp.socketFactory.fallback", "false");

			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(true);

			Message mailMessage = new MimeMessage(mailSession);
			mailMessage.setFrom(new InternetAddress(fromEmail));
			mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			mailMessage.setText(message);
			mailMessage.setSubject(subject);

			Transport transport = mailSession.getTransport("smtp");
			transport.connect("smtp.gmail.com", fromEmail, password);

			transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
