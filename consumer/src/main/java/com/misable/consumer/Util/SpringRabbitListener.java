package com.misable.consumer.Util;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author : wyc
 * @data : 2023/2/3 15:28
 * @description TODO
 */
@Component
public class SpringRabbitListener {

    @RabbitListener(queues = "simple.queue")
    public  void listenSimpleQueueMessage(String msg) throws InterruptedException{
        System.out.println("Spring 消费者接收到的消息:["+msg+"]");
    }
}
