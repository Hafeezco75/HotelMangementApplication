package com.sevenStar.hotel.emails;

import com.sevenStar.hotel.exceptions.MessagingException;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class EmailSender {

    public static void main(String[] args) {

        String recipientEmail = "walex4657@gmail.com";

        String senderEmail = "hafeezco75@gmail.com";

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties);

        try {
             MimeMessage message = new MimeMessage(session);

             message.setFrom(new InternetAddress(senderEmail));

             message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));

             message.setSubject("This is the email Subject");

             message.setText("This is a test email");

             Transport.send(message);

             System.out.println("Email has been successfully sent to User email");
            }
            catch (MessagingException | javax.mail.MessagingException mex) {
                System.out.println("Error: " + mex.getMessage());
            }
        }
    }


