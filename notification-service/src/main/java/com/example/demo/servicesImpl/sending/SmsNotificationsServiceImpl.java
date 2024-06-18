package com.example.demo.servicesImpl.sending;

import com.example.demo.services.sending.SmsNotificationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
class SmsNotificationsServiceImpl implements SmsNotificationsService
{
    private final Logger logger = LoggerFactory.getLogger(SmsNotificationsServiceImpl.class);

    @Override
    public void send(String message) {
        logger.info("Sending SMS notification");
    }
}
