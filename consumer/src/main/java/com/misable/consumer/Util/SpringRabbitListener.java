package com.misable.consumer.Util;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author : wyc
 * @data : 2023/2/3 15:28
 * @description TODO
 */
@Component
public class SpringRabbitListener {

    @RabbitListener(queues = "miserable.queue1")
    public void listenSimpleQueueMessage(String msg) throws InterruptedException {
        System.out.println("Spring 消费者接收到的消息:[" + msg + "]");
    }

    @RabbitListener(queues = "miserable.queue1")
    public void listenFanoutQueue1Message(String msg) throws InterruptedException {
        System.out.println("FanoutQueue1消费者接收到的消息:[" + msg + "]");
    }

    @RabbitListener(queues = "miserable.queue2")
    public void listenFanoutQueue2Message(String msg) throws InterruptedException {
        System.out.println("FanoutQueue2消费者接收到的消息:[" + msg + "]");
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "miserable.direct",type = ExchangeTypes.DIRECT),
            key = {"red","blue"}))
    public void listenDirectQueueMessage(String msg) throws InterruptedException {
        System.out.println("DirectQueue1消费者接收到的消息:[" + msg + "]");
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(name = "direct.queue2"),
                    exchange = @Exchange(name = "miserable.direct",type = ExchangeTypes.DIRECT),
                    key = {"red","yellow"}))
    public void listenDirectQueue2Message(String msg) throws InterruptedException {
        System.out.println("DirectQueue2消费者接收到的消息:[" + msg + "]");
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(name = "topic.queue1"),
                    exchange = @Exchange(name = "miserable.topic",type = ExchangeTypes.TOPIC),
                    key = "china.#"))
    public void listenTopicQueue1Message(String msg) throws InterruptedException {
        System.out.println("TopicQueue1消费者接收到的消息:[" + msg + "]");
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(name = "topic.queue2"),
                    exchange = @Exchange(name = "miserable.topic",type = ExchangeTypes.TOPIC),
                    key = "#.news"))
    public void listenTopicQueue2Message(String msg) throws InterruptedException {
        System.out.println("TopicQueue2消费者接收到的消息:[" + msg + "]");
    }
}
