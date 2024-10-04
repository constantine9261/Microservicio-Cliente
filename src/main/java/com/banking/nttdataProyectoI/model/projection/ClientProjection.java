package com.banking.nttdataProyectoI.model.projection;

import com.banking.nttdataProyectoI.model.api.client.ClientListDto;
import io.r2dbc.spi.Readable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientProjection implements Serializable {

    private Long clienteId;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private Long cuentaId;
    private String numeroCuenta;
    private Double saldo;
    private String tipoCuenta;


    public void buildClientProjection(Readable row) {
        this.clienteId = row.get("cliente_id", Long.class);
        this.nombre = row.get("nombre", String.class);
        this.apellido = row.get("apellido", String.class);
        this.dni = row.get("dni", String.class);
        this.email = row.get("email", String.class);
        this.cuentaId = row.get("cuenta_id", Long.class);
        this.numeroCuenta = row.get("numero_cuenta", String.class);
        this.saldo = row.get("saldo", Double.class);
        this.tipoCuenta = row.get("tipo_cuenta", String.class);
    }


    public ClientListDto buildClientListDto() {
        return ClientListDto.builder()
                .clienteId(this.clienteId)
                .nombre(this.nombre)
                .apellido(this.apellido)
                .dni(this.dni)
                .email(this.email)
                .build();
    }
}
