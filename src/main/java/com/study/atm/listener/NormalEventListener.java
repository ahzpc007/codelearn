package com.study.atm.listener;


import com.study.atm.vo.OrderEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class NormalEventListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
       if(applicationEvent instanceof OrderEvent){
          ((OrderEvent) applicationEvent).print();
       }
    }
}
