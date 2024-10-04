package com.banking.nttdataProyectoI.business.service.impl;

import com.banking.nttdataProyectoI.business.repository.IClientRepository;
import com.banking.nttdataProyectoI.business.service.IClientService;
import com.banking.nttdataProyectoI.model.api.client.*;
import com.banking.nttdataProyectoI.model.projection.ClientProjection;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl  implements IClientService {

    @Autowired
    private final IClientRepository clientRepository;

    /**a
     * @param request
     * @return
     */
    @Override
    public Mono<ListClientResponse> listClientPaginated(ListClientRequest request) {
        return clientRepository.listClientPaginated(request)
                .collectList()
                .map(clientProjections -> {
                    Map<Long, List<ClientProjection>> groupedByClientId = clientProjections.stream()
                            .collect(Collectors.groupingBy(ClientProjection::getClienteId));

                    List<ClientListDto> clientListDtos = groupedByClientId.values().stream()
                            .map(clientGroup -> {
                                ClientProjection clientData = clientGroup.get(0); // Información del cliente
                                List<ClientAccountDto> cuentas = clientGroup.stream()
                                        .filter(client -> client.getCuentaId() != null)
                                        .map(client -> new ClientAccountDto(
                                                client.getCuentaId(),
                                                client.getNumeroCuenta(),
                                                client.getSaldo(),
                                                client.getTipoCuenta()))
                                        .collect(Collectors.toList());

                                return ClientListDto.builder()
                                        .clienteId(clientData.getClienteId())
                                        .nombre(clientData.getNombre())
                                        .apellido(clientData.getApellido())
                                        .dni(clientData.getDni())
                                        .email(clientData.getEmail())
                                        .cuentas(cuentas)
                                        .build();
                            })
                            .collect(Collectors.toList());

                    ListClientResponse response = new ListClientResponse();
                    if (clientListDtos.isEmpty()) {
                        response.setErrorMessage("No se encontraron clientes relacionados con los filtros.");
                    } else {
                        response.setProducts(clientListDtos);
                        response.setTotalRecords((long) clientListDtos.size()); // Aquí puedes poner el total real si lo obtienes de otro lado
                    }

                    return response;
                })
                .onErrorResume(e -> {
                    System.err.println("Error occurred: " + e.getMessage());

                    ListClientResponse errorResponse = new ListClientResponse();
                    errorResponse.setErrorMessage("Ocurrió un error al obtener los productos. Por favor, inténtelo de nuevo más tarde.");
                    return Mono.just(errorResponse);
                });
    }

    @Override
    public Mono<ClientDto> createClient(CreateClientRequest request) {
        return clientRepository.findByDni(request.getDni())
                .flatMap(existingClient -> {
                    ClientDto errorResponse = ClientDto.builder()
                            .errorMessage("Ya existe un cliente con el DNI: " + request.getDni())
                            .build();
                    return Mono.just(errorResponse);
                })
                .switchIfEmpty(
                        clientRepository.save(request.buildClientEntity())
                                .map(savedClient -> request.buildClientDto(savedClient))
                );
    }

    @Override
    public Mono<ClientDto> getClientById(Long clientId) {
        return clientRepository.findClientWithAccountsById(clientId)
                .map(clientWithAccountsProjection -> {
                    ClientDto clientDto = clientWithAccountsProjection.buildClientDto();

                    if (clientWithAccountsProjection.getCuentas() == null || clientWithAccountsProjection.getCuentas().isEmpty()) {
                        clientDto.setErrorMessage("No hay cuentas asociadas para este cliente.");
                    }

                    return clientDto;
                })
                .switchIfEmpty(Mono.error(new RuntimeException("Cliente no encontrado con ID: " + clientId)))
                .onErrorResume(e -> {
                    ClientDto errorResponse = ClientDto.builder()
                            .errorMessage(e.getMessage())
                            .build();
                    return Mono.just(errorResponse);
                });
    }

    @Override
    public Mono<ClientDto> replaceClient(Long id, CreateClientRequest request) {
        return clientRepository.findById(id)
                .flatMap(clientEntity -> {
                    clientEntity.setNombre(request.getNombre());
                    clientEntity.setApellido(request.getApellido());
                    clientEntity.setDni(request.getDni());
                    clientEntity.setEmail(request.getEmail());
                    return clientRepository.save(clientEntity);
                })
                .map(clientEntity -> request.buildClientDto(clientEntity));

    }

    @Override
    public Mono<ClientDto> deleteClient(Long clientId) {
        return clientRepository.findById(clientId)
                .flatMap(clientEntity -> clientRepository.delete(clientEntity)
                        .then(Mono.just(ClientDto.builder()
                                .id(clientEntity.getId())
                                .nombre(clientEntity.getNombre())
                                .apellido(clientEntity.getApellido())
                                .dni(clientEntity.getDni())
                                .email(clientEntity.getEmail())
                                .build()))
                )
                .switchIfEmpty(Mono.just(ClientDto.builder()
                        .errorMessage("Cliente no encontrado con ID: " + clientId)
                        .build()))
                .onErrorResume(e -> Mono.just(ClientDto.builder()
                        .errorMessage("Error al eliminar el cliente: " + e.getMessage())
                        .build()));
    }

}
