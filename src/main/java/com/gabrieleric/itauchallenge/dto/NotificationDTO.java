package com.gabrieleric.itauchallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter 
@AllArgsConstructor@NoArgsConstructor

public class NotificationDTO {
    private Long id;
    private String message;
    private String recipient;
    private String channel;
}
