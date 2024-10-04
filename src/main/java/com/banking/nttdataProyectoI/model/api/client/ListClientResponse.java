package com.banking.nttdataProyectoI.model.api.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;


@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListClientResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("clientes")
  @Valid
  private List<ClientListDto> products = null;

  @JsonIgnore
  private Long totalRecords;

  private String errorMessage;


  public void buildDtoList(List<ClientListDto> productDtoList) {
    this.products = productDtoList;
    this.totalRecords = productDtoList != null && productDtoList.size() > 0
            ? productDtoList.get(0).getTotalRecords() : 0;
  }


}

