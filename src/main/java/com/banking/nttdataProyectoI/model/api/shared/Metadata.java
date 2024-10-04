package com.banking.nttdataProyectoI.model.api.shared;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Metadata  implements Serializable {
  private static final long serialVersionUID = 1L;
  @Schema(
          name = "success",
          description = "",
          type = "boolean")
  private Boolean success;

  @Schema(
          name = "status",
          description = "",
          type = "integer")
  private Integer status;

  @Schema(
          name = "businessId",
          description = "",
          type = "string")
  private String businessId;

  @Schema(
          name = "message",
          description = "",
          type = "string")
  private String message;

  @Schema(
          name = "totalRecords",
          description = "",
          type = "integer")
  private Long totalRecords;

  @Schema(
          name = "pageSize",
          description = "",
          type = "integer")
  private Integer pageSize;

  @Schema(
          name = "pageNumber",
          description = "",
          type = "integer")
  private Integer pageNumber;

  @Schema(
          name = "totalPages",
          description = "",
          type = "integer")
  private Integer totalPages;

}

