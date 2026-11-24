package com.gabrieleric.itauchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrieleric.itauchallenge.models.NotificationModel;

@Repository 
public interface NotificationRepository extends JpaRepository<NotificationModel, Long> {
    
}
