package com.example.kafkaclient;

import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@Observed
public class HelloSpan {

  public Mono<Message<String>> logHello(Message<String> hello) {
    return Mono.just(hello)
        .doOnNext(it -> log.info("Received hello {}", it));
  }
}
