package com.misable.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: webdkp
 * @Package: com.example.webdkp.MQ.SpringAMQP
 * @ClassName: FanoutExchanged
 * @Author: wyc
 * @Description:
 * @Date: 2023/2/7 16:10
 * @Version: 1.0
 */
@Configuration
public class FanoutConfig {
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("miserable.fanout");
    }

    @Bean
    public Queue fanoutQueue1() {
        return new Queue("miserable.queue1");
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue("miserable.queue2");
    }

    @Bean
    public Binding fanoutBinding1(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    @Bean
    public Binding fanoutBinding2(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }

    @Bean
    public Queue objectQueue(){
        return  new Queue("object.queue");
    }


}


