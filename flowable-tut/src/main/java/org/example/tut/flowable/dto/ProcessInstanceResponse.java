package org.example.tut.flowable.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ProcessInstanceResponse {
  String processId;
  boolean isEnded;
}
