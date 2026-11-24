package com.gabrieleric.itauchallenge.service;

import org.springframework.stereotype.Component;

@Component("sms")
public class SMSNotificationSender implements  NotificationSender {
    public void send(String message, String recipient){
        System.out.println("SMS SENDER ");  
        System.out.println("message: " + message + " recipient: " + recipient);
    } 
    public String getChannel(){
        return "sms";
    }
}
