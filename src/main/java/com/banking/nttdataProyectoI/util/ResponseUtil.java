package com.banking.nttdataProyectoI.util;

import com.banking.nttdataProyectoI.model.api.shared.Metadata;
import com.banking.nttdataProyectoI.model.api.shared.ResponseDto;


public class ResponseUtil {

  public static ResponseDto getSuccessfulResponse(Object response) {
    return ResponseDto.builder()
            .metadata(Metadata.builder()
                    .success(true)
                    .status(200)
                    .businessId(Constants.SUCCESS_BUSINESS_ID)
                    .message(Constants.SUCCESS_MESSAGE)
                    .build())
            .data(response)
            .build();
  }

  public static ResponseDto getSuccessfulResponseWithPagination(
          Object response,
          Long totalRecords,
          Integer pageSize,
          Integer pageNumber) {
    return ResponseDto.builder()
            .metadata(Metadata.builder()
                    .success(true)
                    .status(200)
                    .businessId(Constants.SUCCESS_BUSINESS_ID)
                    .message(Constants.SUCCESS_MESSAGE)
                    .totalRecords(totalRecords)
                    .pageSize(pageSize)
                    .pageNumber(pageNumber)
                    .build())
            .data(response)
            .build();
  }
}
