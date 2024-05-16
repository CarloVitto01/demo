package com.example.demo.mapper;

import com.example.demo.dto.SegnalazioneDTO;
import com.example.demo.entity.TbSegnalazione;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SegnalazioneMapper {
    ClienteMapper clienteMapper = new ClienteMapper();
    TecnicoMapper tecnicoMapper = new TecnicoMapper();

    public SegnalazioneDTO toDto(TbSegnalazione tbSegnalazione){
        SegnalazioneDTO dto = new SegnalazioneDTO(
                tbSegnalazione.getId(),
                tbSegnalazione.getDescription(),
                tbSegnalazione.getDate(),
                clienteMapper.toDto(tbSegnalazione.getTbCliente()),
                tecnicoMapper.toDto(tbSegnalazione.getTbTecnico())
        );
        return dto;
    }
    public TbSegnalazione toEntity(SegnalazioneDTO dto){
        TbSegnalazione entity = new TbSegnalazione(
                dto.getId(),
                dto.getDescription(),
                dto.getDate(),
                clienteMapper.toEntity(dto.getCliente()),
                tecnicoMapper.toEntity(dto.getTecnico())
        );
        return entity;
    }

    public List<SegnalazioneDTO> mapListToDTOs(List<TbSegnalazione> listEntities){
        return listEntities.stream().map(this::toDto).toList();
    }

    public List<TbSegnalazione> mapListToEntities(List<SegnalazioneDTO> listDTOs){
        return listDTOs.stream().map(this::toEntity).toList();
    }
}
