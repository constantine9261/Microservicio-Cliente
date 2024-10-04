package com.banking.nttdataProyectoI.model.api.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListClientRequest implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer offset;

  private Integer pageSize;

  @JsonIgnore
  private String dummy;
}
