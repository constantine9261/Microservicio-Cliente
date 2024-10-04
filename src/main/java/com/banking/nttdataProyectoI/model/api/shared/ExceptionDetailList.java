package com.banking.nttdataProyectoI.model.api.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@lombok.Data
public class ExceptionDetailList implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("exceptionDetails")
  @Valid
  private List<ExceptionDetails> exceptionDetails = null;

  public ExceptionDetailList exceptionDetails(List<ExceptionDetails> exceptionDetails) {
    this.exceptionDetails = exceptionDetails;
    return this;
  }

  public ExceptionDetailList addExceptionDetailsItem(ExceptionDetails exceptionDetailsItem) {
    if (this.exceptionDetails == null) {
      this.exceptionDetails = new ArrayList<>();
    }
    this.exceptionDetails.add(exceptionDetailsItem);
    return this;
  }


  @Valid

  public List<ExceptionDetails> getExceptionDetails() {
    return exceptionDetails;
  }

  public void setExceptionDetails(List<ExceptionDetails> exceptionDetails) {
    this.exceptionDetails = exceptionDetails;
  }

}

