package com.example.kafkaclient;

import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class KafkaClient {

  private final HelloReactiveRepo helloReactiveRepo;
  private final HelloSpan helloSpan;

  @Bean
  public Function<Flux<Message<String>>, Mono<Void>> helloReactive() {
    return flux -> flux
        .map(message -> {
          log.info("Received message {}", message);
          Hello hello = new Hello();
          hello.setText(message.getPayload());
          return hello;
        })
        .flatMap(helloSpan::logHelloBefore)
        .flatMap(helloReactiveRepo::save)
        .flatMap(helloSpan::logHelloAfter)
        .doOnNext(message -> log.info("Saved message {}", message))
        .then();
  }
}
