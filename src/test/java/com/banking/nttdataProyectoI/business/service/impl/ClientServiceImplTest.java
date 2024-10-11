package com.banking.nttdataProyectoI.business.service.impl;

import com.banking.nttdataProyectoI.business.repository.IClientRepository;
import com.banking.nttdataProyectoI.model.api.client.ClientDto;
import com.banking.nttdataProyectoI.model.api.client.CreateClientRequest;
import com.banking.nttdataProyectoI.model.api.client.ListClientRequest;
import com.banking.nttdataProyectoI.model.api.client.ListClientResponse;
import com.banking.nttdataProyectoI.model.entity.ClientEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceImplTest {

    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private IClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Disabled
    @Test
    void testCreateClient_ClientAlreadyExists() {
        CreateClientRequest request = CreateClientRequest.builder()
                .dni("12345678")
                .nombre("Juan")
                .apellido("Pérez")
                .email("juan.perez@example.com")
                .build();

        when(clientRepository.findByDni(request.getDni())).thenReturn(Mono.just(new ClientEntity()));

        Mono<ClientDto> result = clientService.createClient(request);

        StepVerifier.create(result)
                .expectNextMatches(clientDto -> "Ya existe un cliente con el DNI: 12345678".equals(clientDto.getErrorMessage()))
                .verifyComplete();

        verify(clientRepository, times(1)).findByDni(request.getDni());
        verify(clientRepository, never()).save(any());
    }

    @Test
    void testCreateClient_Success() {
        CreateClientRequest request = CreateClientRequest.builder()
                .dni("12345678")
                .nombre("Juan")
                .apellido("Pérez")
                .email("juan.perez@example.com")
                .build();

        when(clientRepository.findByDni(request.getDni())).thenReturn(Mono.empty());
        when(clientRepository.save(any(ClientEntity.class))).thenReturn(Mono.just(new ClientEntity()));

        Mono<ClientDto> result = clientService.createClient(request);

        assertNotNull(result);
        assertNull(result.block().getErrorMessage());
        verify(clientRepository, times(1)).findByDni(request.getDni());
        verify(clientRepository, times(1)).save(any());
    }

    @Test
    void testListClientPaginated_NoClientsFound() {
        ListClientRequest request = new ListClientRequest();
        when(clientRepository.listClientPaginated(request)).thenReturn(Flux.empty());

        Mono<ListClientResponse> response = clientService.listClientPaginated(request);

        assertNotNull(response);
        assertEquals("No se encontraron clientes relacionados con los filtros.", response.block().getErrorMessage());
    }

    @Test
    void testGetClientById_ClientNotFound() {
        Long clientId = 1L;
        when(clientRepository.findClientWithAccountsById(clientId)).thenReturn(Mono.empty());

        Mono<ClientDto> result = clientService.getClientById(clientId);

        assertNotNull(result);
        assertEquals("Cliente no encontrado con ID: 1", result.block().getErrorMessage());
    }

    @Test
    void testDeleteClient_Success() {
        Long clientId = 1L;
        ClientEntity client = new ClientEntity();
        client.setId(clientId);
        client.setNombre("Juan");
        client.setApellido("Pérez");
        client.setDni("12345678");
        client.setEmail("juan.perez@example.com");

        when(clientRepository.findById(clientId)).thenReturn(Mono.just(client));
        when(clientRepository.delete(client)).thenReturn(Mono.empty());

        Mono<ClientDto> result = clientService.deleteClient(clientId);

        assertNotNull(result);
        assertEquals(clientId, result.block().getId());
        verify(clientRepository, times(1)).findById(clientId);
        verify(clientRepository, times(1)).delete(client);
    }
}