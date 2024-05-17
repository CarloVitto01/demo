package com.example.demo.mapper;

import com.example.demo.dto.TecnicoDTO;
import com.example.demo.entity.Tecnico;
import org.springframework.stereotype.Component;

@Component
public class TecnicoMapper {
    public TecnicoDTO toDto(Tecnico tecnico){
        TecnicoDTO dto = new TecnicoDTO(
                tecnico.getId(),
                tecnico.getName(),
                tecnico.getSurname()
        );
        return dto;
    }

    public Tecnico toEntity(TecnicoDTO tecnico){
        Tecnico tbTecnico = new Tecnico(
                tecnico.getId(),
                tecnico.getName(),
                tecnico.getSurname()
        );
        return tbTecnico;
    }
}
