package com.example.demo.mapper;

import com.example.demo.dto.SegnalazioneDTO;
import com.example.demo.entity.Segnalazione;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SegnalazioneMapper {
    ClienteMapper clienteMapper = new ClienteMapper();
    TecnicoMapper tecnicoMapper = new TecnicoMapper();

    public SegnalazioneDTO toDto(Segnalazione segnalazione){
        SegnalazioneDTO dto = new SegnalazioneDTO(
                segnalazione.getId(),
                segnalazione.getDescription(),
                segnalazione.getDate(),
                clienteMapper.toDto(segnalazione.getTbCliente()),
                tecnicoMapper.toDto(segnalazione.getTbTecnico())
        );
        return dto;
    }
    public Segnalazione toEntity(SegnalazioneDTO dto){
        Segnalazione entity = new Segnalazione(
                dto.getId(),
                dto.getDescription(),
                dto.getDate(),
                clienteMapper.toEntity(dto.getCliente()),
                tecnicoMapper.toEntity(dto.getTecnico())
        );
        return entity;
    }

    public List<SegnalazioneDTO> mapListToDTOs(List<Segnalazione> listEntities){
        return listEntities.stream().map(this::toDto).toList();
    }

    public List<Segnalazione> mapListToEntities(List<SegnalazioneDTO> listDTOs){
        return listDTOs.stream().map(this::toEntity).toList();
    }
}
