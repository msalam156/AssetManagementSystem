package com.nissan.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.nissan.dto.LoginDTO;

@Service
public class EmailServiceImpl implements IEmailService {

	@Override
	public boolean sendSignUpMail(LoginDTO loginDTO) {

		boolean mailSent = true;

		// variable for gmail
		String host = "smtp.gmail.com";

		// get system properties
		Properties properties = System.getProperties();

		// Setting host
		properties.put("mail.smtp.host", host);

		// Setting port
		properties.put("mail.smtp.port", "465");

		// Enable SSL
		properties.put("mail.smtp.ssl.enable", "true");

		// Enable Authentication
		properties.put("mail.smtp.auth", "true");

		// Set sender's email address
		String from = "saikat22design@gmail.com";

		// Get session object
		Session session = Session.getInstance(properties, new Authenticator() {

			// Over ride Password authenticator and provide the sendor's login credentials
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, "fmhkonmvqlufwkbe");
			}

		});

		// Compose mail
		MimeMessage mimeMessage = new MimeMessage(session);

		try {

			// Set sender
			mimeMessage.setFrom(from);

			// Set recepient
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(loginDTO.getUsername()));

			// Set subject
			String subject = "Nissan Asset Management System: Login Creation Successfully";
			mimeMessage.setSubject(subject);

			// Set the message
			String message = "Thank you for registering with us!!! You Login credentials are: \n" + "Login ID: "
					+ loginDTO.getUsername() + "\n" + "Password: " + loginDTO.getPassword();
			mimeMessage.setText(message);
			
			// Send the message
			Transport.send(mimeMessage);
		} catch (Exception e) {
			mailSent = false;
			System.out.println(e.getMessage());
		}

		return mailSent;
	}

}
