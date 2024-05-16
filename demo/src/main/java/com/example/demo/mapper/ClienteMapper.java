package com.example.demo.mapper;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.entity.TbCliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public ClienteDTO toDto(TbCliente clienteEntity){
        ClienteDTO clienteDTO = new ClienteDTO(
                clienteEntity.getId(),
                clienteEntity.getName(),
                clienteEntity.getSurname()
        );
        return clienteDTO;
    }
    public TbCliente toEntity(ClienteDTO clienteDTO){
        TbCliente clienteEntity = new TbCliente(
                clienteDTO.getId(),
                clienteDTO.getName(),
                clienteDTO.getSurname()
        );
        return clienteEntity;
    }

}
