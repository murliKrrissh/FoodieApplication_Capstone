package com.example.NotificationService.Controller;

import com.example.NotificationService.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {
    private NotificationService notificationService;
    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    @PostMapping("/email/{email}")
    public ResponseEntity sendMail(@PathVariable String email,String message){
        return new ResponseEntity<>(notificationService.sendEmail(email,message), HttpStatus.OK);
    }
}





