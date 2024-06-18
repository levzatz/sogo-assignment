package com.example.demo.services.saving;

import com.example.demo.entities.NotificationChannel;

public interface NotificationSavingService
{
    void save(String message, NotificationChannel channel);
}
