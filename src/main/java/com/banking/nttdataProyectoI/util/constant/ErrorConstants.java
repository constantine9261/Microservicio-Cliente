package com.banking.nttdataProyectoI.util.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorConstants {

  NOT_FOUND("TL0001", "BE1000", ErrorCategory.RESOURCE_NOT_FOUND, "LOGIC"),
  NOT_AVAILABLE("TL0001", "BE1002", ErrorCategory.RESOURCE_NOT_FOUND, "LOGIC"),
  NOT_DELETABLE("TL0001", "BE1004", ErrorCategory.RESOURCE_NOT_FOUND, "LOGIC"),
  BAD_REQUEST("TL0003", "BE1001", ErrorCategory.INVALID_REQUEST, "LOGIC"),
  RESOURCE_DUPLICATE("TL0003", "BE1005", ErrorCategory.CONFLICT, "LOGIC"),
  INVALID_STATUS_CODE("TL0003", "BE0142", ErrorCategory.INVALID_REQUEST, "LOGIC");

  private final String systemCode;
  private final String code;
  private final ErrorCategory codeStatus;
  private final String errorType;

}
