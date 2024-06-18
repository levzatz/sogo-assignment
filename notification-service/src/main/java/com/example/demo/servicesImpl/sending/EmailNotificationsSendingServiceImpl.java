package com.example.demo.servicesImpl.sending;

import com.example.demo.services.sending.EmailNotificationsSendingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
class EmailNotificationsSendingServiceImpl implements EmailNotificationsSendingService
{
    private final Logger logger = LoggerFactory.getLogger(EmailNotificationsSendingServiceImpl.class);

    @Override
    public void send(String message) {
        logger.info("Sending email notification");
    }
}
