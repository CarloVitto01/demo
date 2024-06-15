package com.example.demo.mapper;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.OrdineDto;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Ordine;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteMapper {
    public ClienteDTO toDto(Cliente clienteEntity){
        ClienteDTO clienteDTO = new ClienteDTO(
                clienteEntity.getId(),
                clienteEntity.getName()
        );
        return clienteDTO;
    }
    public Cliente toEntity(ClienteDTO clienteDTO){
        Cliente clienteEntity = new Cliente(
                clienteDTO.getId(),
                clienteDTO.getName()
        );
        return clienteEntity;
    }

    public List<ClienteDTO> mapListToDTOs(List<Cliente> listEntities){
        return listEntities.stream().map(this::toDto).toList();
    }

}
