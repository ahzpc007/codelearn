package com.study.atm.init;

import com.study.atm.publisher.OrderPublisher;
import com.study.atm.vo.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(InitData.class);

    @Autowired
    private OrderPublisher publisher;

    @Override
    public void run(String... strings) throws Exception {
        logger.info(">>>>>>>>>>>>>>>服务启动执行，执行数据初始化开始<<<<<<<<<<<<<");
        publishOrder();
        logger.info(">>>>>>>>>>>>>>>服务启动执行，执行数据初始化完毕<<<<<<<<<<<<<");
    }

    private void publishOrder(){
        OrderEvent event = new OrderEvent("10000");
        publisher.publishEvent(event);
    }
}
