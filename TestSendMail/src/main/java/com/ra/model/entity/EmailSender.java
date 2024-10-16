package com.ra.model.entity;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSender {

    public static void main(String[] args) {
        // Thiết lập các thuộc tính cho phiên
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Tạo một phiên
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("huongcaoha1994@gmail.com", "ktmu mqrt zutl oaie");
            }
        });

        try {
            // Tạo một email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("huongcaoha1994@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("huong.nc.2312@aptechlearning.edu.vn"));
            message.setSubject("Test Email");
            message.setText("Hello, this is a test email!");

            // Gửi email
            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

   
}