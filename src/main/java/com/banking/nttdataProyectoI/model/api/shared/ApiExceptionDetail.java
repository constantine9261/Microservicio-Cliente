package com.banking.nttdataProyectoI.model.api.shared;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@lombok.Data
@Builder
public class ApiExceptionDetail {

  @Schema(name = "code",
          description = "Código de error del detalle.",
          type = "string",
          example = "MB0008")
  private String code;

  @Schema(name = "component",
          description = "Nombre del componente de falla.",
          type = "string",
          example = "business-lcom-resource-access-control-facility")
  private String component;

  @Schema(name = "description",
          description = "Descripción del detalle.",
          type = "string",
          example = "Código inválido para el canal")
  private String description;
}
