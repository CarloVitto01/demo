package com.example.demo.mapper;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public ClienteDTO toDto(Cliente clienteEntity){
        ClienteDTO clienteDTO = new ClienteDTO(
                clienteEntity.getId(),
                clienteEntity.getName(),
                clienteEntity.getSurname()
        );
        return clienteDTO;
    }
    public Cliente toEntity(ClienteDTO clienteDTO){
        Cliente clienteEntity = new Cliente(
                clienteDTO.getId(),
                clienteDTO.getName(),
                clienteDTO.getSurname()
        );
        return clienteEntity;
    }

}
