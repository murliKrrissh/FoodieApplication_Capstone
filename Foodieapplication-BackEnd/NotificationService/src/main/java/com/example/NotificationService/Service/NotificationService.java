package com.example.NotificationService.Service;

import com.example.NotificationService.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotificationService{

    private NotificationRepository notificationRepository;
    private JavaMailSender mailNotification;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository, JavaMailSender mailNotification) {
        this.notificationRepository = notificationRepository;
        this.mailNotification = mailNotification;
    }
    public boolean sendEmail(String email,String message){
        SimpleMailMessage notification=new SimpleMailMessage();
       notification.setFrom("foodapp@foodie.com");
       notification.setTo(email);
       notification.setText(message);
       mailNotification.send(notification);
        System.out.println(notification);
        System.out.println("Email sent successfully to "+email);
        return true;
    }
}
