package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class SentNotification
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;
    private @Getter @Setter String message;
    @Enumerated(EnumType.STRING)
    private @Getter @Setter NotificationChannel channel;
}
