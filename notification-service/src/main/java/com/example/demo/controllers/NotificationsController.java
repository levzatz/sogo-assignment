package com.example.demo.controllers;

import com.example.demo.entities.NotificationChannel;
import com.example.demo.repositories.SentNotificationsRepository;
import com.example.demo.services.NotificationsSendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationsController
{

    private final NotificationsSendingService notificationsSendingService;

    private final SentNotificationsRepository sentNotificationsRepository;
    @Autowired
    public NotificationsController
            (
                    NotificationsSendingService notificationsSendingService,
                    SentNotificationsRepository sentNotificationsRepository
            )
    {
        this.notificationsSendingService = notificationsSendingService;
        this.sentNotificationsRepository = sentNotificationsRepository;
    }

    @GetMapping("/count-by-type")
    public ResponseEntity<Long> getNotificationsCount(@RequestParam NotificationChannel channel)
    {
        return ResponseEntity.ok(sentNotificationsRepository.countByChannel(channel));
    }

    @PostMapping("/send")
    public ResponseEntity<Void> sendNotification
            (
                    @RequestParam String message,
                    @RequestParam NotificationChannel channel
            )
    {
        notificationsSendingService.send(message, channel);
        return ResponseEntity.ok(null);
    }
}
