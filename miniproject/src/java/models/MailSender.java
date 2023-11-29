/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.*;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class MailSender {

    public void sendMail(String emailto) {
        String from = "azmi965150@gmail.com";
        final String username = "azmi965150";
        final String password = "iivnljgzewjhgvhr";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailto));
            msg.setSubject("Welcome to my App");
            msg.setContent("<h1>Welcome to my App</h1>"
        + "<p>Please Verify by Clicking here: "
        + "<a href=\"http://localhost:8080/miniproject/fc/?type=model&page=EmailVerificationModel&email=" + emailto + "\">"
        + "Verify</a></p>", "text/html");

            Transport.send(msg);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

}
