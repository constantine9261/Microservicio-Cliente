package com.banking.nttdataProyectoI.business.repository;

import com.banking.nttdataProyectoI.business.repository.custom.ICustomClientRepository;
import com.banking.nttdataProyectoI.model.api.client.ClientDto;
import com.banking.nttdataProyectoI.model.entity.clientEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface IClientRepository extends
        ReactiveCrudRepository<clientEntity, Long>, ICustomClientRepository {

    @Query("SELECT * FROM clientes WHERE dni = :dni")
    Mono<clientEntity> findByDni(String dni);
}
