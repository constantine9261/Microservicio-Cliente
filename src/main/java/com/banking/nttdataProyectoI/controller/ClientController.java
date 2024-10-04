package com.banking.nttdataProyectoI.controller;

import com.banking.nttdataProyectoI.business.service.IClientService;
import com.banking.nttdataProyectoI.model.api.client.ClientDto;
import com.banking.nttdataProyectoI.model.api.client.CreateClientRequest;
import com.banking.nttdataProyectoI.model.api.client.ListClientRequest;
import com.banking.nttdataProyectoI.model.api.client.ListClientResponse;
import com.banking.nttdataProyectoI.model.api.shared.ApiException;
import com.banking.nttdataProyectoI.model.api.shared.ResponseDto;
import com.banking.nttdataProyectoI.util.ResponseUtil;
import com.banking.nttdataProyectoI.util.api.ApiConstants;
import com.banking.nttdataProyectoI.util.api.ApiHttpMethod;
import com.banking.nttdataProyectoI.util.api.ApiPath;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ApiPath.CLIENTS_ENDPOINT)
public class ClientController {

    @Autowired
    private IClientService clientService;


    @PostMapping(
            value = ApiPath.EMPTY_PATH,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            tags = ApiConstants.TAG_WORK_ORDER,
            summary = ApiConstants.POST_WORK_ORDER_SUMMARY,
           description = ApiConstants.POST_WORK_ORDER_DESC,
            method = ApiHttpMethod.POST_METHOD, responses = {
           @ApiResponse(responseCode = "200", description = "Operación exitosa."),
            @ApiResponse(responseCode = "400",
                   description = "Los datos proporcionados no son válidos.",
                   content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                   }),
           @ApiResponse(responseCode = "401",
                    description = "No esta autorizado correctamente para ejecutar esta operación.",
                   content = {
                           @Content(
                                  mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                           )
                   }),
           @ApiResponse(responseCode = "403",
                   description = "No tienes permiso para acceder al servidor.",
                   content = {
                           @Content(
                                   mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                           )
                    }),
           @ApiResponse(responseCode = "404",
                    description = "Recurso inválido.",
                    content = {
                           @Content(
                                   mediaType = "application/json",
                                   schema = @Schema(implementation = ApiException.class)
                           )
                   }),
            @ApiResponse(responseCode = "500",
                    description = "Ocurrio un error inesperado. "
                            + "Por favor contactarse con el Soporte Técnico.",
                    content = {
                           @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    }),
            @ApiResponse(responseCode = "503",
                    description = "Servicio no disponible.",
                   content = {
                           @Content(
                                    mediaType = "application/json",
                                   schema = @Schema(implementation = ApiException.class)
                           )
                   })
   })
    public Mono<ResponseDto<ClientDto>> createClient(
          @RequestBody CreateClientRequest request
       ) {
       return clientService.createClient(request)
               .map(ResponseUtil::getSuccessfulResponse);
   }


    @GetMapping(
            value = ApiPath.EMPTY_PATH,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(
            tags = ApiConstants.TAG_WORK_ORDER,
            summary = ApiConstants.GET_WORK_ORDER_LIST_SUMMARY,
            description = ApiConstants.GET_WORK_ORDER_LIST_DESC,
            method = ApiHttpMethod.GET_METHOD, responses = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa."),
            @ApiResponse(responseCode = "400",
                    description = "Los datos proporcionados no son válidos.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    }),
            @ApiResponse(responseCode = "401",
                    description = "No esta autorizado correctamente para ejecutar esta operación.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    }),
            @ApiResponse(responseCode = "403",
                    description = "No tienes permiso para acceder al servidor.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    }),
            @ApiResponse(responseCode = "404",
                    description = "Recurso inválido.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    }),
            @ApiResponse(responseCode = "500",
                    description = "Ocurrio un error inesperado. "
                            + "Por favor contactarse con el Soporte Técnico.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    }),
            @ApiResponse(responseCode = "503",
                    description = "Servicio no disponible.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    })
    })
    public Mono<ResponseDto<ListClientResponse>> listClients(
            @ParameterObject ListClientRequest request
    ){
        return clientService.listClientPaginated(request)
                .map(response -> ResponseUtil.getSuccessfulResponseWithPagination(response,response.getTotalRecords(),
                        request.getPageSize(), request.getOffset() /request.getPageSize() +1));
    }

    @GetMapping(
            value = ApiPath.GET_CLIENT_ID,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            tags = ApiConstants.TAG_WORK_ORDER,
            summary = ApiConstants.GET_CLIENT_ID_SUMMARY,
            description = ApiConstants.POST_WORK_ORDER_DESC,
            method = ApiHttpMethod.POST_METHOD, responses = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa."),
            @ApiResponse(responseCode = "400",
                    description = "Los datos proporcionados no son válidos.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    }),
            @ApiResponse(responseCode = "401",
                    description = "No esta autorizado correctamente para ejecutar esta operación.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    }),
            @ApiResponse(responseCode = "403",
                    description = "No tienes permiso para acceder al servidor.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    }),
            @ApiResponse(responseCode = "404",
                    description = "Recurso inválido.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    }),
            @ApiResponse(responseCode = "500",
                    description = "Ocurrio un error inesperado. "
                            + "Por favor contactarse con el Soporte Técnico.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    }),
            @ApiResponse(responseCode = "503",
                    description = "Servicio no disponible.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    })
    })
    public Mono<ResponseDto<ClientDto>> getClientById(
            @PathVariable Long clientId) {
        return clientService.getClientById(clientId)
                .map(ResponseUtil::getSuccessfulResponse);
    }



    @PutMapping(
            value = ApiPath.GET_CLIENT_ID,
            produces = {MediaType.APPLICATION_JSON_VALUE})
        @ResponseStatus(HttpStatus.OK)
     @Operation(
            tags = ApiConstants.TAG_WORK_ORDER,
            summary = ApiConstants.PUT_CLIENT_ID_SUMMARY,
            description = ApiConstants.POST_WORK_ORDER_DESC,
            method = ApiHttpMethod.POST_METHOD, responses = {
           @ApiResponse(responseCode = "200", description = "Operación exitosa."),
           @ApiResponse(responseCode = "400",
                   description = "Los datos proporcionados no son válidos.",
                   content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    }),
            @ApiResponse(responseCode = "401",
                    description = "No esta autorizado correctamente para ejecutar esta operación.",
                    content = {
                            @Content(
                                   mediaType = "application/json",
                                   schema = @Schema(implementation = ApiException.class)
                           )
                   }),
            @ApiResponse(responseCode = "403",
                    description = "No tienes permiso para acceder al servidor.",
                    content = {
                            @Content(
                                   mediaType = "application/json",
                                   schema = @Schema(implementation = ApiException.class)
                            )
                    }),
            @ApiResponse(responseCode = "404",
                    description = "Recurso inválido.",
                   content = {
                           @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    }),
            @ApiResponse(responseCode = "500",
                    description = "Ocurrio un error inesperado. "
                            + "Por favor contactarse con el Soporte Técnico.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    }),
            @ApiResponse(responseCode = "503",
                    description = "Servicio no disponible.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    })
    })
    public Mono<ResponseDto<ClientDto>> ReplaceClient(
            @PathVariable Long clientId,
            @RequestBody CreateClientRequest request) {

        return clientService.replaceClient(clientId,request)
                .map(ResponseUtil::getSuccessfulResponse);
    }


    @DeleteMapping(
            value = ApiPath.GET_CLIENT_ID,
           produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @Operation(
           tags = ApiConstants.TAG_WORK_ORDER,
           summary = ApiConstants.DELETE_CLIENT_ID_SUMMARY,
           description = ApiConstants.POST_WORK_ORDER_DESC,
           method = ApiHttpMethod.POST_METHOD, responses = {
           @ApiResponse(responseCode = "200", description = "Operación exitosa."),
           @ApiResponse(responseCode = "400",
                    description = "Los datos proporcionados no son válidos.",
                    content = {
                            @Content(
                                   mediaType = "application/json",
                                   schema = @Schema(implementation = ApiException.class)
                            )
                    }),
            @ApiResponse(responseCode = "401",
                    description = "No esta autorizado correctamente para ejecutar esta operación.",
                    content = {
                            @Content(
                                  mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    }),
            @ApiResponse(responseCode = "403",
                    description = "No tienes permiso para acceder al servidor.",
                   content = {
                           @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                            )
                    }),
           @ApiResponse(responseCode = "404",
                    description = "Recurso inválido.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                           )
                    }),
            @ApiResponse(responseCode = "500",
                    description = "Ocurrio un error inesperado. "
                            + "Por favor contactarse con el Soporte Técnico.",
                   content = {
                            @Content(
                                   mediaType = "application/json",
                                    schema = @Schema(implementation = ApiException.class)
                           )
                    }),
           @ApiResponse(responseCode = "503",
                   description = "Servicio no disponible.",
                    content = {
                           @Content(
                                    mediaType = "application/json",
                                   schema = @Schema(implementation = ApiException.class)
                            )
                    })
   })
    public Mono<ResponseDto<ClientDto>> DeleteClient(
           @PathVariable Long clientId) {

        return clientService.deleteClient(clientId)
               .map(ResponseUtil::getSuccessfulResponse);
    }
}
