package com.example.demo.mapper;

import com.example.demo.dto.OrdineDto;
import com.example.demo.entity.Ordine;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class OrdineMapper {
    ClienteMapper clienteMapper = new ClienteMapper();
    ProdottoMapper prodottoMapper = new ProdottoMapper();

    public OrdineDto toDto(Ordine ordine){
        OrdineDto dto = new OrdineDto(
                ordine.getId(),
                ordine.getDate(),
                clienteMapper.toDto(ordine.getCliente()),
                prodottoMapper.toDto(ordine.getProdotto())
        );
        return dto;
    }
    public Ordine toEntity(OrdineDto dto){
        Ordine entity = new Ordine(
                dto.getId(),
                dto.getDate(),
                clienteMapper.toEntity(dto.getCliente()),
                prodottoMapper.toEntity(dto.getProdotto())
        );
        return entity;
    }

    public List<OrdineDto> mapListToDTOs(List<Ordine> listEntities){
        return listEntities.stream().map(this::toDto).toList();
    }

    public List<Ordine> mapListToEntities(List<OrdineDto> listDTOs){
        return listDTOs.stream().map(this::toEntity).toList();
    }
}
