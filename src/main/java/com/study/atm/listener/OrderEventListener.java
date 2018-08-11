package com.study.atm.listener;

import com.study.atm.vo.OrderEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class OrderEventListener implements ApplicationListener<OrderEvent>{
    @Override
    public void onApplicationEvent(OrderEvent orderEvent) {
        orderEvent.print();
    }
}
