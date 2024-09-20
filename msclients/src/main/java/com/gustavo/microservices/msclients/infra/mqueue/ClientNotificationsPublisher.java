package com.gustavo.microservices.msclients.infra.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gustavo.microservices.msclients.adapters.DTOs.PayloadQueueMessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientNotificationsPublisher {

  private final RabbitTemplate rabbitTemplate;
  private final Queue queue;

  public void sendMessage(PayloadQueueMessageDTO payload) {
    ObjectMapper mapper = new ObjectMapper();
    try{
      var json = mapper.writeValueAsString(payload);
      rabbitTemplate.convertAndSend(queue.getName(), json);
    }catch (JsonProcessingException e){
      throw new RuntimeException("Falha ao serializar JSON");
    }
  }
}
