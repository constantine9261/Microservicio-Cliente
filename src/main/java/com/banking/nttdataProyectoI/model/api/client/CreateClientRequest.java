package com.banking.nttdataProyectoI.model.api.client;

import com.banking.nttdataProyectoI.model.entity.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateClientRequest implements Serializable {

  private static final long serialVersionUID = 1L;


  private Long id;

  @NotBlank(message = "Nombre cannot be blank")
  @Size(max = 50, message = "Nombre cannot exceed 50 characters")
  private String nombre;

  @NotBlank(message = "Apellido cannot be blank")
  @Size(max = 50, message = "Apellido cannot exceed 50 characters")
  private String apellido;

  @NotBlank(message = "DNI cannot be blank")
  @Size(min = 8, max = 8, message = "DNI must be 8 characters")
  private String dni;

  @NotBlank(message = "Email cannot be blank")
  @Size(max = 100, message = "Email cannot exceed 100 characters")
  private String email;

  public ClientEntity buildClientEntity() {
    return ClientEntity.builder()
            .nombre(this.nombre)
            .apellido(this.apellido)
            .dni(this.dni)
            .email(this.email)
            .build();
  }


  public ClientDto buildClientDto(ClientEntity savedClient) {
    return ClientDto.builder()
            .id(savedClient.getId())
            .nombre(savedClient.getNombre())
            .apellido(savedClient.getApellido())
            .dni(savedClient.getDni())
            .email(savedClient.getEmail())
            .build();
  }


}
