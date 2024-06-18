package com.example.demo.servicesImpl;

import com.example.demo.entities.NotificationChannel;
import com.example.demo.services.NotificationsSendingService;
import com.example.demo.services.saving.NotificationSavingService;
import com.example.demo.services.sending.EmailNotificationsSendingService;
import com.example.demo.services.sending.PushNotificationsSendingService;
import com.example.demo.services.sending.SmsNotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class NotificationsSendingServiceImpl implements NotificationsSendingService
{

    private final EmailNotificationsSendingService emailNotificationsSendingService;

    private final PushNotificationsSendingService pushNotificationsSendingService;

    private final SmsNotificationsService smsNotificationsService;

    private final NotificationSavingService notificationSavingService;

    @Autowired
    public NotificationsSendingServiceImpl
            (
                    EmailNotificationsSendingService emailNotificationsSendingService,
                    PushNotificationsSendingService pushNotificationsSendingService,
                    SmsNotificationsService smsNotificationsService,
                    NotificationSavingService notificationSavingService
            )
    {
        this.emailNotificationsSendingService = emailNotificationsSendingService;
        this.pushNotificationsSendingService = pushNotificationsSendingService;
        this.smsNotificationsService = smsNotificationsService;
        this.notificationSavingService = notificationSavingService;
    }

    @Override
    public void send(String message, NotificationChannel channel)
    {
        switch (channel)
        {
            case EMAIL -> emailNotificationsSendingService.send(message);
            case SMS -> smsNotificationsService.send(message);
            case PUSH -> pushNotificationsSendingService.send(message);
            default -> throw new IllegalArgumentException("Invalid notification channel : " + channel);
        }
        notificationSavingService.save(message, channel);
    }
}
