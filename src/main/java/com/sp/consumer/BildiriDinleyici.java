package com.sp.consumer;

import com.sp.model.Bildiri;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BildiriDinleyici {

    @RabbitListener(queues = "serkanp")
    public void kuyruguDinle(Bildiri bildiri){
        System.out.println(bildiri.toString());
    }
}
