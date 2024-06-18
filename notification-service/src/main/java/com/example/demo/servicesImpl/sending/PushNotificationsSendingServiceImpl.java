package com.example.demo.servicesImpl.sending;

import com.example.demo.services.sending.PushNotificationsSendingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
class PushNotificationsSendingServiceImpl implements PushNotificationsSendingService
{
    private final Logger logger = LoggerFactory.getLogger(PushNotificationsSendingServiceImpl.class);
    @Override
    public void send(String message) {
        logger.info("Sending push notification");
    }
}
