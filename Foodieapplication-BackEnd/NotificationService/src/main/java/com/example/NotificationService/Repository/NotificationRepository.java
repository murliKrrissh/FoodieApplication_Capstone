package com.example.NotificationService.Repository;

import com.example.NotificationService.Domain.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification,String> {
}
