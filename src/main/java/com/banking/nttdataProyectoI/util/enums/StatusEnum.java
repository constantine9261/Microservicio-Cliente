package com.banking.nttdataProyectoI.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum StatusEnum {
  PENDING,
  IN_PROCESS,
  ERROR,
  DONE,
  DELETED
}
