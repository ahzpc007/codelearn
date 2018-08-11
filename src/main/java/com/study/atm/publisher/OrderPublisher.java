package com.study.atm.publisher;

import com.study.atm.vo.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderPublisher{

    @Autowired
    private ApplicationEventPublisher publisher;


    public void publishEvent(OrderEvent event) {
        publisher.publishEvent(event);
    }


}
