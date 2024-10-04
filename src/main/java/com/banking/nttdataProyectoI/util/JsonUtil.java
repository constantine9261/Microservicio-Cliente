package com.banking.nttdataProyectoI.util;

import com.banking.nttdataProyectoI.model.api.client.ClientAccountDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Método para convertir JSON a una lista de ClientAccountDto
    public static List<ClientAccountDto> fromJsonToClientAccountList(String json) {
        try {
            return objectMapper.readValue(json, new TypeReference<List<ClientAccountDto>>() {});
        } catch (IOException e) {
            // Manejo de excepciones si la conversión falla
            e.printStackTrace();
            return null; // o lanzar una excepción personalizada
        }
    }
}
