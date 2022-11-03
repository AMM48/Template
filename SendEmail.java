package edu.kau.fcit.cpit252.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    public static void send(String subject, String body, String recipient) throws MissingRequiredPropertiesException {
        final String username = System.getenv("email");
        final String password = System.getenv("password");

        if (username == "" || password == "") {
            throw new MissingRequiredPropertiesException("Missing email username and/or password. You need to store two" +
                    " environment variables named: \"email\" and \"password\" for your email account."  +
                    " Please refer to the following link for more information on how to set environment variables:" +
                    " https://cpit252.gitlab.io/miscellaneous/#environment-variables");
        }

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipient)
            );
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
