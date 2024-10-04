package com.banking.nttdataProyectoI.business.repository.custom.impl;

import com.banking.nttdataProyectoI.business.repository.custom.ICustomClientRepository;
import com.banking.nttdataProyectoI.model.api.client.ClientAccountDto;
import com.banking.nttdataProyectoI.model.api.client.ListClientRequest;
import com.banking.nttdataProyectoI.model.projection.AccountProjection;
import com.banking.nttdataProyectoI.model.projection.ClientProjection;
import com.banking.nttdataProyectoI.model.projection.ClientWithAccountsProjection;
import com.banking.nttdataProyectoI.util.JsonUtil;
import com.banking.nttdataProyectoI.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


public  class ICustomClientRepositoryImpl implements ICustomClientRepository {

    @Autowired
    private DatabaseClient client;

    @Override
    public Flux<ClientProjection> listClientPaginated(ListClientRequest request) {

        String query = "SELECT COUNT(*) OVER() AS totalRecords, " +
                "C.id AS cliente_id, " +
                "C.nombre, " +
                "C.apellido, " +
                "C.dni, " +
                "C.email, " +
                "COALESCE(CU.id, 0) AS cuenta_id, " +
                "COALESCE(CU.numero_cuenta, '') AS numero_cuenta, " +
                "COALESCE(CU.saldo, 0.0) AS saldo, " +
                "COALESCE(CU.tipo_cuenta, '') AS tipo_cuenta " +
                "FROM clientes C " +
                "LEFT JOIN cuentas CU ON C.id = CU.cliente_id " +
                "ORDER BY C.id " +
                "OFFSET :offset LIMIT :pageSize";

        return client.sql(query)
                .bind("offset", Util.avoidNulls(request.getOffset()))
                .bind("pageSize", Util.avoidNulls(request.getPageSize()))
                .map((row, metadata) -> {
                    ClientProjection projection = new ClientProjection();
                    projection.buildClientProjection(row);
                    return projection;
                })
                .all();
    }

    @Override
    public Mono<ClientWithAccountsProjection> findClientWithAccountsById(Long clientId) {
        String query = "SELECT " +
                "    c.id AS cliente_id, " +
                "    c.nombre, " +
                "    c.apellido, " +
                "    c.dni, " +
                "    c.email, " +
                "    json_agg(json_build_object( " +
                "        'cuenta_id', cu.id, " +
                "        'numero_cuenta', cu.numero_cuenta, " +
                "        'saldo', cu.saldo, " +
                "        'tipo_cuenta', cu.tipo_cuenta " +
                "    )) AS cuentas " +
                "FROM clientes c " +
                "LEFT JOIN cuentas cu ON cu.cliente_id = c.id " +
                "WHERE c.id = :clientId " +
                "GROUP BY c.id";

        return client.sql(query)
                .bind("clientId", clientId)
                .map(row -> {
                    ClientWithAccountsProjection projection = new ClientWithAccountsProjection();
                    projection.setClienteId(row.get("cliente_id", Long.class));
                    projection.setNombre(row.get("nombre", String.class));
                    projection.setApellido(row.get("apellido", String.class));
                    projection.setDni(row.get("dni", String.class));
                    projection.setEmail(row.get("email", String.class));

                    // Procesar las cuentas como JSON
                    List<ClientAccountDto> cuentas = JsonUtil.fromJsonToClientAccountList(row.get("cuentas", String.class));
                    projection.setCuentas(cuentas);

                    return projection;
                })
                .first().switchIfEmpty(Mono.error(new RuntimeException("Cliente no encontrado con ID: " + clientId)));

    }


}
