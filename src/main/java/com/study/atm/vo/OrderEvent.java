package com.study.atm.vo;

import org.springframework.context.ApplicationEvent;

public class OrderEvent extends ApplicationEvent{

    private long loanOrderCode;

    public OrderEvent(Object source) {
        super(source);
    }

    public OrderEvent(Object source,long loanOrderCode) {
        super(source);
        this.loanOrderCode = loanOrderCode;
    }

    public void print(){
        System.out.println("hello spring event!");
    }
}
