package com.misable.publisher.controller;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : wyc
 * @data : 2023/2/2 17:22
 * @description     向simple.queue发送消息
 */
@RestController
@RequestMapping("/publish")
public class SpringAmqpController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
//消息直接发送到队列
    @RequestMapping(value = "/getQueue", method = RequestMethod.GET)
    public void testSimpleQueue() {
        String queueName = "simple.Queue";
        String message = "hello,spring amqp";
        rabbitTemplate.convertAndSend(queueName, message);
    }
    //消息直接发送到交换机
    @RequestMapping(value = "/getExchange", method = RequestMethod.GET)
    public void testFanoutExchange() {
        String exchangeName = "miserable.fanout";
        String message = "hello,miserable";
        rabbitTemplate.convertAndSend(exchangeName,"", message);
    }

    //消息直接发送到交换机
    @RequestMapping(value = "/getExchangeDirect", method = RequestMethod.GET)
    public void testDirectExchange() {
        String exchangeName = "miserable.direct";
        String message = "hello,blue";
        rabbitTemplate.convertAndSend(exchangeName,"blue", message);
    }

    //消息直接发送到交换机
    @RequestMapping(value = "/getExchangeTopic", method = RequestMethod.GET)
    public void testTopicExchange() {
        String exchangeName = "miserable.topic";
        String message = "miserable,wow";
        rabbitTemplate.convertAndSend(exchangeName,"china.news", message);
    }

    //发送对象消息
    @RequestMapping(value = "/getExchangeObject", method = RequestMethod.GET)
    public void testObjectExchange() {
        System.out.println("111");
        String queueName = "object.queue";
        Map<String,Object> msg=new HashMap<>();
        msg.put("name","吴宇辰");
        msg.put("age","22");
        rabbitTemplate.convertAndSend(queueName, msg);

    }
}
