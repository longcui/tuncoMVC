package com.tunco.tool;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by dragon on 12-May-15.
 */
public class EmailUtil {

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public static void sendEmail(final String recipient, final String subject, final String content) {
        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        final String username = "longcuidev@gmail.com";
                        final String password = "clclzpzp";

                        Properties props = new Properties();
                        props.put("mail.smtp.auth", "true");
                        props.put("mail.smtp.starttls.enable", "true");
                        props.put("mail.smtp.host", "smtp.gmail.com");
                        props.put("mail.smtp.port", "587");

                        Session session = Session.getInstance(props,
                                new javax.mail.Authenticator() {
                                    protected PasswordAuthentication getPasswordAuthentication() {
                                        return new PasswordAuthentication(username, password);
                                    }
                                });

                        try {

                            Message message = new MimeMessage(session);
                            message.setFrom(new InternetAddress("longcuidev@gmail.com"));
                            message.setRecipients(Message.RecipientType.TO,
                                    InternetAddress.parse(recipient));
                            message.setSubject(subject);
                            message.setText(content);

                            Transport.send(message);

                            System.out.println("email sent");

                        } catch (MessagingException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        thread.start();
    }
}
