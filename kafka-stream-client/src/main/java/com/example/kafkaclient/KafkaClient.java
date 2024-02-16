package com.example.kafkaclient;

import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class KafkaClient {

  private final HelloRepo helloRepo;
  private final HelloSpan helloSpan;

  @Bean
  public Consumer<Message<String>> hello() {
    return message -> {
      log.info("Received message {}", message);
      Hello hello = new Hello();
      hello.setText(message.getPayload());
      helloSpan.logHelloBefore(hello);
      helloRepo.save(hello);
      helloSpan.logHelloAfter(hello);
    };
  }
}
