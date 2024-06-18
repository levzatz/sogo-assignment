package com.example.demo.repositories;

import com.example.demo.entities.NotificationChannel;
import com.example.demo.entities.SentNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SentNotificationsRepository extends JpaRepository<SentNotification,Long>
{
    @Query("""
            SELECT COUNT(1)
            FROM SentNotification sn
            WHERE sn.channel =:channel
            """)
    Long countByChannel(@Param("channel")NotificationChannel channel);
}
