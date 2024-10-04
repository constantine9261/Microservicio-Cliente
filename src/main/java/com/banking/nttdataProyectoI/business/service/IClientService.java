package com.banking.nttdataProyectoI.business.service;


import com.banking.nttdataProyectoI.model.api.client.ClientDto;
import com.banking.nttdataProyectoI.model.api.client.CreateClientRequest;
import com.banking.nttdataProyectoI.model.api.client.ListClientRequest;
import com.banking.nttdataProyectoI.model.api.client.ListClientResponse;
import reactor.core.publisher.Mono;

public interface IClientService {

    Mono<ListClientResponse> listClientPaginated(
            ListClientRequest request);

    Mono<ClientDto> createClient(CreateClientRequest request);

    Mono<ClientDto> getClientById(Long clientId);

    Mono<ClientDto> replaceClient(Long clientId ,CreateClientRequest request);

    Mono<ClientDto> deleteClient(Long clientId);
}