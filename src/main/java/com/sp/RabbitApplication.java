package com.sp;


import com.sp.model.Bildiri;
import com.sp.producer.BildiriUretici;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.UUID;

@SpringBootApplication
public class RabbitApplication {

    @Autowired
    BildiriUretici bildiriUretici;

    public static void main(String[] args){
        SpringApplication.run(RabbitApplication.class,args);
    }

}
