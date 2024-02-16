package com.example.kafkaclient;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class Hello {

  @Id
  private Long id;

  private String text;
}
