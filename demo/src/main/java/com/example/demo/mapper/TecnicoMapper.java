package com.example.demo.mapper;

import com.example.demo.dto.TecnicoDTO;
import com.example.demo.entity.TbTecnico;
import org.springframework.stereotype.Component;

@Component
public class TecnicoMapper {
    public TecnicoDTO toDto(TbTecnico tecnico){
        TecnicoDTO dto = new TecnicoDTO(tecnico.getId(), tecnico.getName(), tecnico.getSurname());
        return dto;
    }

    public TbTecnico toEntity(TecnicoDTO tecnico){
        TbTecnico tbTecnico = new TbTecnico(tecnico.getId(), tecnico.getName(), tecnico.getSurname());
        return tbTecnico;
    }
}
