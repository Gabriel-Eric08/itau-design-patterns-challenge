package com.gabrieleric.itauchallenge.service;

import org.springframework.stereotype.Component;

@Component("email")
public class EmailNotficationSender implements NotificationSender{
    public void send(String message, String recipient){
        System.out.println("EMAIL SENDER ");  
        System.out.println("message: " + message + " recipient: " + recipient);
    } 
    public String getChannel(){
        return "email";
    }
}
