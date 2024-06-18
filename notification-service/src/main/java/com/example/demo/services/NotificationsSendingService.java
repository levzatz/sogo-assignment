package com.example.demo.services;

import com.example.demo.entities.NotificationChannel;

public interface NotificationsSendingService
{

    void send(String message, NotificationChannel channel);


}
