package com.banking.nttdataProyectoI.business.repository.custom;

import com.banking.nttdataProyectoI.model.api.client.ListClientRequest;
import com.banking.nttdataProyectoI.model.projection.ClientProjection;
import com.banking.nttdataProyectoI.model.projection.ClientWithAccountsProjection;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomClientRepository {

    Flux<ClientProjection> listClientPaginated(ListClientRequest request);

    Mono<ClientWithAccountsProjection> findClientWithAccountsById(Long clientId);

}
