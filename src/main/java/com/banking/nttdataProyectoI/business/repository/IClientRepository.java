package com.banking.nttdataProyectoI.business.repository;

import com.banking.nttdataProyectoI.business.repository.custom.ICustomClientRepository;
import com.banking.nttdataProyectoI.model.entity.ClientEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface IClientRepository extends
        ReactiveCrudRepository<ClientEntity, Long>, ICustomClientRepository {

    @Query("SELECT * FROM clientes WHERE dni = :dni")
    Mono<ClientEntity> findByDni(String dni);
}
