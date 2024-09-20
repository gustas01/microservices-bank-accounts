package com.gustavo.microservices.msclients.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

  @Value("${mq.queues.client-notifications}")
  private String clientNotificationsQueueName;

  @Bean
  public Queue clientNotificationsQueue(){
    return new Queue(clientNotificationsQueueName, true);
  }
}
