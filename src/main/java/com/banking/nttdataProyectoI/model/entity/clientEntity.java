package com.banking.nttdataProyectoI.model.entity;


import com.banking.nttdataProyectoI.model.api.client.ClientDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(value = "clientes")
public class ClientEntity implements Serializable {

    private static final long serialVersionUID = 7982069006616095393L;


    @Id
    @Column("id")
    private Long id;

    @Column("nombre")
    private String nombre;

    @Column("apellido")
    private String apellido;

    @Column("dni")
    private String dni;

    @Column("email")
    private String email;



    private ClientDto convertToDto(ClientEntity clientEntity) {
        return ClientDto.builder()
                .id(clientEntity.getId()) // Establece el ID del cliente
                .nombre(clientEntity.getNombre()) // Establece el nombre del cliente
                .apellido(clientEntity.getApellido()) // Establece el apellido del cliente
                .dni(clientEntity.getDni()) // Establece el DNI del cliente
                .email(clientEntity.getEmail()) // Establece el email del cliente
                .build(); // Construye el DTO
    }
}
