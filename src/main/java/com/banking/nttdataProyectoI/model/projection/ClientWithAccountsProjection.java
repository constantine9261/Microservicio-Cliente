package com.banking.nttdataProyectoI.model.projection;

import com.banking.nttdataProyectoI.model.api.client.ClientAccountDto;
import com.banking.nttdataProyectoI.model.api.client.ClientDto;
import com.banking.nttdataProyectoI.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.r2dbc.spi.Readable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientWithAccountsProjection {
    private Long clienteId;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private List<ClientAccountDto> cuentas; // Lista de cuentas
    private String errorMessage; // Para manejar mensajes de error


    private static final ObjectMapper objectMapper = new ObjectMapper();


    public void buildWithAccountsProjection(Readable row) {
        this.clienteId = row.get("cliente_id", Long.class);
        this.nombre = row.get("nombre", String.class);
        this.apellido = row.get("apellido", String.class);
        this.dni = row.get("dni", String.class);
        this.email = row.get("email", String.class);
        // Procesa el JSON de atributos
        String cuentasJson = row.get("cuentas", String.class);

        if (cuentasJson != null && !cuentasJson.trim().isEmpty()) {
            this.cuentas = JsonUtil.fromJsonToClientAccountList(cuentasJson);
        } else {
            this.cuentas = null;
        }
    }


        public ClientDto buildClientDto() {
            return ClientDto.builder()
                    .id(this.clienteId)
                    .nombre(this.nombre)
                    .apellido(this.apellido)
                    .dni(this.dni)
                    .email(this.email)
                    .cuentas(this.cuentas)
                    .build();
        }

}
