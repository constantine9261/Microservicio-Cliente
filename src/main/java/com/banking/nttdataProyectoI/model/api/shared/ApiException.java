package com.banking.nttdataProyectoI.model.api.shared;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.List;

@lombok.Data
public class ApiException extends Exception implements Serializable {
  private static final long serialVersionUID = 1L;

  @Schema(name = "code",
          description = "Código de error de Sistema.",
          type = "string",
          example = "TL9999")
  private String code;

  @Schema(name = "description",
          description = "Descripción del error de Sistema.",
          type = "string",
          example = "Ocurrió un error inesperado. Por favor contactarse con el Soporte Técnico.")
  private String description;

  @Schema(name = "errorType",
          description = "Tipo de error de sistema.",
          type = "string",
          example = "TECHNICAL")
  private String errorType;

  @Schema(name = "category",
          description = "Categoria de error de sistema.",
          type = "string",
          example = "CRITICAL")
  private String category;

  @Schema(name = "exceptionDetails",
          description = "Lista de detalles del error.",
          type = "array")
  private List<ApiExceptionDetail> exceptionDetails;
}

