package org.mymicroservice.msorder.integrations.notifier;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotifierIntegration {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendSMS(String dest,String message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setDest(dest);
        sendMessage.setMessage(message);
        rabbitTemplate.convertAndSend("notfication-exchange","sms-notification",sendMessage);
    }

    public void sendMail(String dest,String message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setDest(dest);
        sendMessage.setMessage(message);
        rabbitTemplate.convertAndSend("notfication-exchange","mail-notification",sendMessage);
    }

}
