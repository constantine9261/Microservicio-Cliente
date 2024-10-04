package com.banking.nttdataProyectoI.model.projection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountProjection {

    private Long cuentaId; // ID de la cuenta
    private String numeroCuenta; // Número de cuenta
    private Double saldo; // Saldo de la cuenta
    private String tipoCuenta; // Tipo de cuenta (e.g., ahorros, corriente, etc.)
}
