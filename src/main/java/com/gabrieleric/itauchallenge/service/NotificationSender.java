package com.gabrieleric.itauchallenge.service;

public interface NotificationSender {
    public void send(String message, String recipient);
    public String getChannel();
}
