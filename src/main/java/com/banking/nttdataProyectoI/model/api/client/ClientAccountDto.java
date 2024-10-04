package com.banking.nttdataProyectoI.model.api.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientAccountDto implements Serializable {

    @JsonProperty("cuenta_id")
    private Long cuentaId;

    @JsonProperty("numero_cuenta")
    private String numeroCuenta;

    @JsonProperty("saldo")
    private Double saldo;

    @JsonProperty("tipo_cuenta")
    private String tipoCuenta;
}

