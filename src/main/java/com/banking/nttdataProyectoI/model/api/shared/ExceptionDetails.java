package com.banking.nttdataProyectoI.model.api.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@lombok.Data
public class ExceptionDetails implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("code")
  private String code;

  @JsonProperty("component")
  private String component;

  @JsonProperty("description")
  private String description;

  public ExceptionDetails code(String code) {
    this.code = code;
    return this;
  }



  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ExceptionDetails component(String component) {
    this.component = component;
    return this;
  }


  public String getComponent() {
    return component;
  }

  public void setComponent(String component) {
    this.component = component;
  }

  public ExceptionDetails description(String description) {
    this.description = description;
    return this;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}

