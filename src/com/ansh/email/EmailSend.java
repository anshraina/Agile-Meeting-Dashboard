package com.ansh.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSend {
	
	public void sendEmail(String toMail, String fromMail, String name, String issuedDate, String lastDate, String description) {
		
		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();
		
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(fromMail, "livelifelikeaqueen123");

            }

        });
        
        session.setDebug(true);

	      try {
	         
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(fromMail));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));

	         // Set Subject: header field
	         message.setSubject("Meeting Update");

	         // Now set the actual message
	         

	         // Send message
	         String messageContext = "Meeting Taks Name: " + name +"\r\n" + "Issued Date: " + issuedDate + "\r\n" 
	        		 				  + "Last Date: " + lastDate + "\r\n" + " Description: " + description ;
	        
	         message.setText(messageContext);
	         
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
		
	}
}
