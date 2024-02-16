package com.example.kafkaclient;

import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class KafkaClient {

  private final HelloSpan helloSpan;

  @Bean
  public Function<Flux<Message<String>>, Flux<Message<String>>> helloReactive() {
    return flux -> flux.flatMap(message -> {
      log.info("Received message {}", message);
      return helloSpan.logHello(message);
    });
  }
}
