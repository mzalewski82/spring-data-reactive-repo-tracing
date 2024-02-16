package com.example.kafkaclient;

import io.micrometer.observation.annotation.Observed;
import io.micrometer.tracing.annotation.NewSpan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Observed
public class HelloSpan {

  public void logHelloBefore(Hello hello) {
    log.info("Received hello {}", hello);
  }

  public void logHelloAfter(Hello hello) {
    log.info("Received hello {}", hello);
  }
}
