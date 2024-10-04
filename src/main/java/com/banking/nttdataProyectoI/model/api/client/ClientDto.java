package com.banking.nttdataProyectoI.model.api.client;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {

    @Schema(
            description = "Identificador del cliente.",
            example = "1",
            type = "Long")
    private Long id;

    @Schema(
            description = "Nombre del cliente.",
            example = "Juan",
            type = "String")
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Schema(
            description = "Apellido del cliente.",
            example = "Pérez",
            type = "String")
    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @Schema(
            description = "DNI del cliente.",
            example = "12345678",
            type = "String")
    @NotBlank(message = "El DNI es obligatorio")
    private String dni;

    @Schema(
            description = "Email del cliente.",
            example = "juan.perez@example.com",
            type = "String")
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Formato de email inválido")
    private String email;


    private List<ClientAccountDto> cuentas;


    private String errorMessage;



}
