package com.sp.producer;

import com.sp.model.Bildiri;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.UUID;

@Service
public class BildiriUretici {
    @Value("${sp.rabbit.routing.name}")
    private String routingName;
    @Value("${sp.rabbit.exchange.name}")
    private String exchangeName;

    @PostConstruct
    void init(){

        Bildiri bildiri = new Bildiri();
        bildiri.setBildiriId(UUID.randomUUID().toString());
        bildiri.setBildiriIcerik("Mesaj Gonderiyorum Abey");
        bildiri.setOlusturulmaTarihi(Calendar.getInstance().getTime());
        kuyrugaEkle(bildiri);
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void kuyrugaEkle(Bildiri bildiri){
        System.out.println("Bildiri Gonderildi "+bildiri.getBildiriId());
        rabbitTemplate.convertAndSend(exchangeName,routingName,bildiri);

    }
}
