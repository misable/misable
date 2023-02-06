package com.misable.publisher.controller;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/getQueue", method = RequestMethod.GET)
    public void testSimpleQueue() {
        String queueName = "simple.Queue";
        String message = "hello,spring amqp";
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
