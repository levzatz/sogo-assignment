package com.example.demo.servicesImpl.saving;

import com.example.demo.entities.NotificationChannel;
import com.example.demo.entities.SentNotification;
import com.example.demo.repositories.SentNotificationsRepository;
import com.example.demo.services.saving.NotificationSavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class NotificationSavingServiceImpl implements NotificationSavingService
{
    private final SentNotificationsRepository sentNotificationsRepository;

    @Autowired
    public NotificationSavingServiceImpl(SentNotificationsRepository sentNotificationsRepository)
    {
        this.sentNotificationsRepository = sentNotificationsRepository;
    }

    @Override
    public void save(String message, NotificationChannel channel) {
        SentNotification notification = new SentNotification();
        notification.setChannel(channel);
        notification.setMessage(message);
        sentNotificationsRepository.save(notification);
    }
}
