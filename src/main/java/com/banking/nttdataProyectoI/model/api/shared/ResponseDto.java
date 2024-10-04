package com.banking.nttdataProyectoI.model.api.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ResponseDto<T> {

  @JsonProperty("metadata")
  private Metadata metadata;

  @JsonProperty("data")
  private T data;
}

