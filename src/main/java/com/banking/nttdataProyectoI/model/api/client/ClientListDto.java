package com.banking.nttdataProyectoI.model.api.client;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientListDto implements Serializable {
    private Long clienteId;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;

    @Builder.Default
    private List<ClientAccountDto> cuentas = List.of();

    @JsonIgnore
    private Long totalRecords;
}
